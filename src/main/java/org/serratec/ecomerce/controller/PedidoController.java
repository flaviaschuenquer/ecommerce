package org.serratec.ecomerce.controller;

import java.net.URI;

import org.serratec.ecomerce.dto.PedidoDTO;
import org.serratec.ecomerce.exception.PedidoNaoExisteException;
import org.serratec.ecomerce.servico.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@PostMapping
	public ResponseEntity<?> criar(@RequestBody PedidoDTO pedidoDTO, 
			@AuthenticationPrincipal UserDetails user) {
		
		PedidoDTO pedido = pedidoService.criar(pedidoDTO, user);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}").buildAndExpand(pedido.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(pedido);	
	}

//	@PutMapping("{id}")
//	public ResponseEntity<?> atualizar(PedidoDTO pedidoDTO, long id) {
//		// Caso queira incluir mais um produto, vou atualizar o pedido atual,
//		// incluindo mais um produto.
//	}

	@PostMapping("/finalizar/{id}")
	public ResponseEntity<?> finalizarPedido(long id) {
		try {
			pedidoService.finalizar(id);
			return ResponseEntity.ok().build();
		} catch (PedidoNaoExisteException pnee) {
			return ResponseEntity.badRequest().body(pnee.getMessage());
		}
	}
}
