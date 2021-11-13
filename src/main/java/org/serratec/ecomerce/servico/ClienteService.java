package org.serratec.ecomerce.servico;

import org.serratec.ecomerce.dominio.Cliente;
import org.serratec.ecomerce.dominio.Endereco;
import org.serratec.ecomerce.dto.ClienteDTO;
import org.serratec.ecomerce.dto.EnderecoDTO;
import org.serratec.ecomerce.exception.CEPInvalidoException;
import org.serratec.ecomerce.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BuscarEnderecoPorCEPService bepcs;
	
	public ClienteDTO criar(ClienteDTO clienteDTO) throws CEPInvalidoException {
		String cep = clienteDTO.getCep();
		ResponseEntity<EnderecoDTO> enderecoDto = bepcs.getEndereco(cep);
		if(enderecoDto.getStatusCode() == HttpStatus.OK) {
			EnderecoDTO endereco = enderecoDto.getBody();
			if(endereco.obteveErro()) {
				throw new CEPInvalidoException("CEP inválido");
			}
			
			Endereco endDominio = endereco.generateEndereco();
			endDominio.setNumero(clienteDTO.getNumero());
			endDominio.setComplemento(clienteDTO.getComplemento());
			
			
			Cliente cliente = new Cliente();
			cliente.setCpf(clienteDTO.getCpf());
			cliente.setEmail(clienteDTO.getEmail());
			cliente.setNome(clienteDTO.getNome());
			cliente.setSenha(clienteDTO.getSenha());
			cliente.setSobrenome(clienteDTO.getNome());	
			
			
			cliente.setEndereco(endDominio);
			
			Cliente clienteSalvo = clienteRepository.save(cliente);
			
			return new ClienteDTO(clienteSalvo);
						
		}else {
			throw new CEPInvalidoException("CEP não foi localizado.");
		}
		
		//Implemetação da busca do endereço através do VIACEP.
	}
	

}
