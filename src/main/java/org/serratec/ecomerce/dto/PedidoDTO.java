package org.serratec.ecomerce.dto;

import java.util.ArrayList;
import java.util.List;

import org.serratec.ecomerce.dominio.Pedido;
import org.serratec.ecomerce.dominio.Produto;

public class PedidoDTO {
	
	private long id;
	private List<Long> produtos;
	
	public PedidoDTO() {		
	}
	
	public PedidoDTO(Pedido pedidoSalvo) {
		this.produtos = new ArrayList<>();
		List<Produto> produtos = pedidoSalvo.getProdutos();
		for(Produto produto: produtos) {
			this.produtos.add(produto.getId());			
		}
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Long> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Long> produtos) {
		this.produtos = produtos;
	}

}
