package org.serratec.ecomerce.repositorio;

import org.serratec.ecomerce.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findByEmail(String email);

	Cliente findByNome(String nome);

}
