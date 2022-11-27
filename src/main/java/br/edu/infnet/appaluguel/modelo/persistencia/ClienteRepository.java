package br.edu.infnet.appaluguel.modelo.persistencia;

import br.edu.infnet.appaluguel.modelo.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

   // @Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf")
   // Cliente findByCpf(@Param("cpf") String cpf);
   Cliente findByCpf(String cpf);

}
