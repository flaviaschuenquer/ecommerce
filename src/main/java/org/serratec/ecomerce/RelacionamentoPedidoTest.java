package org.serratec.ecomerce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.serratec.ecomerce.dominio.Categoria;
import org.serratec.ecomerce.dominio.Cliente;
import org.serratec.ecomerce.dominio.Pedido;
import org.serratec.ecomerce.dominio.Produto;

public class RelacionamentoPedidoTest {

	@Test
	public void testarRelacionamento() {

		Categoria eletro = new Categoria("Eletrodomestico");
		Categoria roupa = new Categoria("Eletrodomestico");

		Produto microondas = new Produto("Microondas Brastemp", "lindo microondas", BigDecimal.valueOf(500), eletro);

		Produto camisa = new Produto("Camisa Polo", "Camisa azul", BigDecimal.valueOf(50), roupa);

		Produto liquidificador = new Produto("Liquidificador Mondial", "Liqui vermelho", BigDecimal.valueOf(99),
				eletro);

		Cliente cliente1 = new Cliente();
		cliente1.setNome("Flávia");
		cliente1.setCpf("04482398784");

		Pedido pedido1 = new Pedido(microondas, cliente1);
		pedido1.setProduto(liquidificador);
		pedido1.setProduto(camisa);

		Assertions.assertEquals(3, pedido1.getTotalProdutos());		

	}

	@Test
	public void testeTotalValor() {
		Categoria eletro = new Categoria("Eletrodomestico");
		Categoria roupa = new Categoria("Eletrodomestico");

		Produto microondas = new Produto("Microondas Brastemp", "lindo microondas", BigDecimal.valueOf(500), eletro);

		Produto camisa = new Produto("Camisa Polo", "Camisa azul", BigDecimal.valueOf(50), roupa);

		Produto liquidificador = new Produto("Liquidificador Mondial", "Liqui vermelho", BigDecimal.valueOf(99),
				eletro);

		Cliente cliente1 = new Cliente();
		cliente1.setNome("Raphael");
		cliente1.setCpf("98391283891");

		Pedido pedido1 = new Pedido(microondas, cliente1);
		pedido1.setProduto(liquidificador);
		pedido1.setProduto(camisa);

		//Pode fazer testes por aqui. Individualmente. Teste unitário
		Assertions.assertEquals(pedido1.getTotalValor(), BigDecimal.valueOf(649));
	}
}
