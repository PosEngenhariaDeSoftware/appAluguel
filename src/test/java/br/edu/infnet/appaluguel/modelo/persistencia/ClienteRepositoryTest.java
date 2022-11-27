package br.edu.infnet.appaluguel.modelo.persistencia;

import br.edu.infnet.appaluguel.modelo.entidade.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void saveDeveriaSalvarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Junia");
        cliente.setCpf("65478932145");
        cliente.setTelefone("61998978263");
        cliente.setWhatsapp(true);

        Cliente clienteSalvo = clienteRepository.save(cliente);

        assertEquals("Junia", clienteSalvo.getNome());
    }

    @Test
    public void saveAndFlushDeveriaAtualizarCliente() {
        Cliente clienteEncontrado = clienteRepository.findById(1L).get();
        clienteEncontrado.setTelefone("61887475263");
        Cliente clienteAlterado = clienteRepository.saveAndFlush(clienteEncontrado);

        assertEquals("61887475263", clienteAlterado.getTelefone());
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
