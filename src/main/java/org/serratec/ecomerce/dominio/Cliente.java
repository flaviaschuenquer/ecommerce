package org.serratec.ecomerce.dominio;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

//TODO: @Embedded e @Embeddable
@Entity
public class Cliente {

	//TODO: Criar um construtor com tudo que seja necesário para o um cliente existir
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Nome não pode ser vazio.")	
	private String nome;
	
	@NotBlank(message = "Sobrenome não pode ser vazio.")	
	private String sobrenome;
	
	//TODO: Validação de maior de 18
	private LocalDate dataNascimento;

	@Email(message = "Verifique o campo e-mail.")
	private String email;
	
	@CPF
	private String cpf;
	
	@NotBlank
	private String senha;	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_endereco")
	private Endereco endereco;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	//Pode ser @OneToOne, 
	//pois uma pessoa tem um endereço e um endereço pertence a uma pessoa.
	//@Embedded
	

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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
}