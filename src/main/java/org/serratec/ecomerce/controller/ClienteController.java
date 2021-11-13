package org.serratec.ecomerce.controller;

import java.net.URI;

import javax.validation.Valid;

import org.serratec.ecomerce.dto.ClienteDTO;
import org.serratec.ecomerce.exception.CEPInvalidoException;
import org.serratec.ecomerce.servico.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Object> criar(@Valid @RequestBody ClienteDTO clienteDto) {
		try {
			ClienteDTO cliente = clienteService.criar(clienteDto);
			
			URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}").buildAndExpand(cliente.getId())
					.toUri();
			
			return ResponseEntity.created(uri).body(cliente);	
		} catch(CEPInvalidoException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}					
	}

}
