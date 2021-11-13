package org.serratec.ecomerce.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity // TODO: Verificar os relacionamentos e Mapeamentos de Colunas
public class Pedido {

	public Pedido() {
	}

	public Pedido(Produto produto, Cliente cliente) {
		this.produtos = new ArrayList<Produto>();
		this.produtos.add(produto);
		this.cliente = cliente;
		this.dataPedido = LocalDateTime.now();
		this.valorFinal = produto.getValorUnitario();
	}
	
	public Pedido(List<Produto> produtos, Cliente cliente) {
		this.produtos = produtos;
		this.cliente = cliente;
		this.dataPedido = LocalDateTime.now();
				
		for(Produto produto: produtos) {
			this.valorFinal = this.valorFinal.add(produto.getValorUnitario());
		}				 
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private LocalDateTime dataPedido;

	@Column
	private BigDecimal valorFinal;

	private boolean finalizado;

	//Usuário administrador 
	//Teriamos que ter uma área administrativa, que o usuário responsável
	//pelo ecommerce, conseguria consultar uma lista, separando os produtos os enviando.
	//Sempre que finalizar o pedido, 
	private LocalDateTime dataEnvio;

	private LocalDateTime dataEntrega;

	// 1 pedido vai ter muitos produtos
	// Ter uma classe intermediária entre Produto e pedido.

	@ManyToMany
	@JoinTable(name = "produto_pedido", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<Produto> produtos;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	// Quantidade de produtos
	public int getTotalProdutos() {
		return produtos.size();
	}

	public void setProduto(Produto produto) {
		this.valorFinal = valorFinal.add(produto.getValorUnitario());
		this.produtos.add(produto);
	}

	public BigDecimal getTotalValor() {
		BigDecimal valorTotal = BigDecimal.ZERO;
		for (Produto produto : this.produtos) {
			valorTotal = valorTotal.add(produto.getValorUnitario());
		}
		return valorTotal;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	public List<Produto> getProdutos(){
		return this.produtos;
	}

}
