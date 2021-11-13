package org.serratec.ecomerce.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Categoria {
	
	
	public Categoria(@NotBlank @Size(max = 200, min = 4) String nome) {
		super();
		this.nome = nome;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size(max = 200, min = 4)
	private String nome;
	
	
	@OneToMany(mappedBy = "categoria")	
	private List<Produto> produtos;
}


//1 - Eletrodomesticos (liquidificador (1), espremedor(1), microondas(1))
//2 - Televisor
//3 - Celular