package org.serratec.ecomerce.controller;

import javax.validation.Valid;

import org.serratec.ecomerce.dominio.Categoria;
import org.serratec.ecomerce.repositorio.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//Dentro do endereco http://localhost:8080/api/categoria
//terei todos os métodos disponíveis (GET, POST, PUT, etc...)
@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	@ResponseStatus(code= HttpStatus.CREATED)
	@ApiOperation(value="Criar uma nova categoria", notes="Será criada uma nova categoria.")
	@ApiResponses(value= {
			@ApiResponse(code = 201, message = "Categoriga criada com suceeso"),
			@ApiResponse(code = 400, message = "Ocorreu um erro no request "),
	})
	public Categoria criar(@Valid @RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
		
	}
	
	//Implementar os métodos GET, PUT, DELETE... Seguindo a regra do exercício

}
