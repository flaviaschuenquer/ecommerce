package org.serratec.ecomerce.servico;

import java.util.List;
import java.util.Optional;

import org.serratec.ecomerce.dominio.Cliente;
import org.serratec.ecomerce.dominio.Pedido;
import org.serratec.ecomerce.dominio.Produto;
import org.serratec.ecomerce.dto.PedidoDTO;
import org.serratec.ecomerce.exception.PedidoNaoExisteException;
import org.serratec.ecomerce.repositorio.ClienteRepository;
import org.serratec.ecomerce.repositorio.PedidoRepository;
import org.serratec.ecomerce.repositorio.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public PedidoDTO criar(PedidoDTO pedidoDTO, UserDetails user) {
		
		Cliente cliente = clienteRepository.findByNome(user.getUsername());
		List<Produto> produtos = produtoRepository.findAllById(pedidoDTO.getProdutos());
		
		Pedido pedido = new Pedido(produtos, cliente);
		
		Pedido pedidoSalvo = pedidoRepository.save(pedido);
		
		return new PedidoDTO(pedidoSalvo);							
		
	}

	
	public void finalizar(long id) throws PedidoNaoExisteException {
		Optional<Pedido> pedidoDoBanco = pedidoRepository.findById(id);
		if(pedidoDoBanco.isPresent())
		{			
			Pedido pedido = pedidoDoBanco.get();
			if(pedido.isFinalizado()) {
				return;
			}
			pedido.setFinalizado(true);
			pedidoRepository.save(pedido);
		}
		
		throw new PedidoNaoExisteException("Pedido " + id + " não encontrado no banco");		
	}
}
