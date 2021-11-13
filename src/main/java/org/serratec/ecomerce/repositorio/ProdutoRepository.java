package org.serratec.ecomerce.repositorio;


import org.serratec.ecomerce.dominio.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
