package cartaoOuro.crudCliente.infra;

import cartaoOuro.crudCliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface ClienteRepository extends JpaRepository <Cliente,Long> {

    void deleteByCpf(String cpf);

    Cliente findByCpf(String cpf);

    Cliente getReferenceByCpf(String cpf);
}
