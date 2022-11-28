package br.edu.infnet.appaluguel.modelo.persistencia;

import br.edu.infnet.appaluguel.modelo.entidade.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class ClienteRepositoryTest {

    @Autowired
    private AluguelRepository aluguelRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void saveDeveriaSalvarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Stu");
        cliente.setCpf("06698875421");
        cliente.setTelefone("61818278543");
        cliente.setWhatsapp(true);

        Cliente clienteSalvo = clienteRepository.save(cliente);

        assertEquals("Stu", clienteSalvo.getNome());
    }

    @Test
    public void saveAndFlushDeveriaAtualizarCliente() {
        Cliente clienteEncontrado = clienteRepository.findById(6L).get();
        clienteEncontrado.setTelefone("61887895263");
        clienteEncontrado.setNome("Elena");
        Cliente clienteAlterado = clienteRepository.saveAndFlush(clienteEncontrado);

        assertEquals("61887895263", clienteAlterado.getTelefone());
        assertEquals(clienteEncontrado.getNome(), clienteAlterado.getNome());
    }

    @Test
    public void findByCpfDeveriaEncontrarClientePorCpf() {
        Cliente clienteEncontrado = clienteRepository.findByCpf("12245578469");

        assertEquals("12245578469", clienteEncontrado.getCpf());
    }

    @Test
    public void deleteByCpfDeveriaDeletarOClientePorCpf() {
        Cliente clienteEncontrado = clienteRepository.findByCpf("12245578469");
        clienteRepository.deleteById(clienteEncontrado.getId());

        assertFalse(clienteRepository.existsById(clienteEncontrado.getId()));
    }

}
