package org.serratec.ecomerce.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Endereco {

	public Endereco() {		
	}
	
	public Endereco(
			@NotBlank String rua, 			
			@NotBlank String bairro,
			@NotBlank String cidade, 
			@NotBlank String estado, 
			@NotBlank String pais, 
			@NotBlank String cEP) {
		super();
		this.rua = rua;		
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		CEP = cEP;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	
	@NotBlank
	private String rua;
	@NotBlank
	private String numero;
	
	private String complemento;
	@NotBlank
	private String bairro;
	@NotBlank
	private String cidade;
	@NotBlank
	private String estado;
	@NotBlank
	private String pais;
	@NotBlank
	private String CEP;	
	@OneToOne(mappedBy = "endereco")
	private Cliente cliente;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}
		
}