package org.serratec.ecomerce.dominio;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	
	@NotBlank(message = "Nome não pode ser vazio")
	private String nome;
	
	@NotBlank(message = "Sobrenome não pode ser vazio")
	private String sobrenome;
	
	private LocalDate dataNascimento;
	
	@Email(message = "Verificar email")
	private String email;
	
	@CPF
	private String cpf;
	
	private Endereco endereco;

}
