package org.serratec.ecomerce.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDateTime dataPedido;
	
	private BigDecimal valorFinal;
	
	private long quantidade;
	
	private LocalDateTime dataEnvio;
	
	private LocalDateTime dataEntrega;
	
	
	/*Aqui o relacionamento é de 1 para muitos one to many(Um produto tem vários pedidos)*/
	private List<Produto> produtos;
	
	
	/*Aqui o relacionamento de 1 paa 1 one to one*/
	private Cliente cliente;

}
