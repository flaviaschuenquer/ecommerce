package org.serratec.ecomerce.servico;

import org.serratec.ecomerce.dto.EnderecoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BuscarEnderecoPorCEPService {
	
public ResponseEntity<EnderecoDTO> getEndereco(String cep) {
		
		WebClient wc = WebClient.create("https://viacep.com.br/");
		
		ResponseEntity<EnderecoDTO> endereco = wc
		.get()  //Este método é o HTTP Request
		.uri(b -> b.path("/ws/{cep}/{formato}/").build(cep, "json"))
		.retrieve()
		.toEntity(EnderecoDTO.class)
		.block();
		
		return endereco;
		
		//https://viacep.com.br/ws/01001000/json/
		
	}
}
