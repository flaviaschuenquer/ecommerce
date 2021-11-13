package org.serratec.ecomerce.dominio;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
    @Column
    
    private String nome;
    
    @Column
    private String descricao;
    
    @Column(name = "valor unitário")
    private BigDecimal valorUnitario;
    
	
	private Categoria categoria;
	
	/* Se fosse um relacinamento de 1 para muitos, ou seja
	 * um prodito pudesse ter várias categorias
	 * esta propriedade ficaria assim:
	 * private List<Categoria> categoria; Como é de 1 para 1 fica como acima.
	 */
}
