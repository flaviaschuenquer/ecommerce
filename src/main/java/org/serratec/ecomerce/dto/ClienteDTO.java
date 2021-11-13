package org.serratec.ecomerce.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.serratec.ecomerce.dominio.Cliente;

public class ClienteDTO {
	
	public ClienteDTO() {		
	}
	
	public ClienteDTO(Cliente cliente) {
		setCep(cliente.getEndereco().getCEP());
		setComplemento(cliente.getEndereco().getComplemento());
		setCpf(cliente.getCpf());
		setEmail(cliente.getEmail());
		setId(cliente.getId());
		setNome(cliente.getNome());
		setNumero(cliente.getEndereco().getNumero());
		setSobrenome(cliente.getSobrenome());
		//Como a senha é sensivel, eu não vou retornar a senha no DTO.
	}	
	
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@CPF	
	private String cpf;
	@Size(min = 3, max = 200)
	private String nome;
	@Size(min = 3, max = 200)
	private String sobrenome;
	@Email
	private String email;
	@Size(min = 5, max = 200)
	private String senha;
	
	@Pattern(regexp = "\\d{8}")
	private String cep;
	
	private String numero;
	
	private String complemento;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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


}
