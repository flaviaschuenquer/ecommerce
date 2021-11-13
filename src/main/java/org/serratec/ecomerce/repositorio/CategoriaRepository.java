package org.serratec.ecomerce.repositorio;

import org.serratec.ecomerce.dominio.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
