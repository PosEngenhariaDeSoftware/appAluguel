package br.edu.infnet.appaluguel.modelo.persistencia;

import br.edu.infnet.appaluguel.modelo.entidade.Aluguel;
import br.edu.infnet.appaluguel.modelo.entidade.Cliente;
import br.edu.infnet.appaluguel.modelo.entidade.enums.StatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AluguelRepositoryTest {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void saveDeveriaSalvarAluguel() {
        LocalDateTime dataInicio = LocalDateTime.of(2022, Month.NOVEMBER, 24, 16, 30, 00);
        Aluguel aluguel = new Aluguel();
        aluguel.setLocalizacao("Guará");
        aluguel.setPeriodoDias(40);
        aluguel.setValorAluguel(new BigDecimal(2000.0));
        aluguel.setStatus(StatusEnum.EM_ANDAMENTO);
        aluguel.setDataInicio(dataInicio);

        Aluguel aluguelSalvo = aluguelRepository.save(aluguel);

        assertEquals(aluguel.getDataInicio(), aluguelSalvo.getDataInicio());
    }

    @Test
    public void saveDeveriaSalvarAluguelComCliente() {
        Cliente cliente = clienteRepository.findByCpf("06698878963");

        LocalDateTime dataInicio = LocalDateTime.of(2022, Month.NOVEMBER, 27, 14, 00, 00);
        Aluguel aluguel = new Aluguel();
        aluguel.setLocalizacao("Samambaia");
        aluguel.setPeriodoDias(10);
        aluguel.setValorAluguel(new BigDecimal(200.0));
        aluguel.setStatus(StatusEnum.EM_ANDAMENTO);
        aluguel.setDataInicio(dataInicio);
        aluguel.setCliente(cliente);

        Aluguel aluguelSalvo = aluguelRepository.save(aluguel);

        assertEquals("06698878963", aluguelSalvo.getCliente().getCpf());
        assertEquals("Samambaia", aluguelSalvo.getLocalizacao());
        assertEquals(aluguel.getPeriodoDias(), aluguelSalvo.getPeriodoDias());
    }

    @Test
    public void saveDeveriaSalvarAlugueisNoClienteEncontradoPorCpf() {
        Cliente clienteEncontrado = clienteRepository.findByCpf("06698875421");

        LocalDateTime dataInicio_1 = LocalDateTime.of(2022, Month.NOVEMBER, 24, 16, 30, 00);
        Aluguel aluguel_1 = new Aluguel();
        aluguel_1.setLocalizacao("Guará");
        aluguel_1.setPeriodoDias(40);
        aluguel_1.setValorAluguel(new BigDecimal(3000.0));
        aluguel_1.setStatus(StatusEnum.EM_ANDAMENTO);
        aluguel_1.setDataInicio(dataInicio_1);
        aluguel_1.setCliente(clienteEncontrado);

        Aluguel aluguelSalvo_1 = aluguelRepository.save(aluguel_1);

        LocalDateTime dataInicio_2 = LocalDateTime.of(2022, Month.DECEMBER, 01, 10, 00, 00);
        Aluguel aluguel_2 = new Aluguel();
        aluguel_2.setLocalizacao("Guará");
        aluguel_2.setPeriodoDias(50);
        aluguel_2.setValorAluguel(new BigDecimal(5000.0));
        aluguel_2.setStatus(StatusEnum.EM_APROVACAO);
        aluguel_2.setDataInicio(dataInicio_2);
        aluguel_2.setCliente(clienteEncontrado);

        Aluguel aluguelSalvo_2 = aluguelRepository.save(aluguel_2);

        List<Aluguel> alugueis = new ArrayList<>();
        alugueis.add(aluguelSalvo_1);
        alugueis.add(aluguelSalvo_2);

        clienteEncontrado.setAlugueis(alugueis);

        Cliente clienteSalvoComAlugueis = clienteRepository.saveAndFlush(clienteEncontrado);

        assertEquals(clienteEncontrado.getId(), clienteSalvoComAlugueis.getId());
        assertEquals(alugueis.size(), clienteSalvoComAlugueis.getAlugueis().size());
    }

    @Test
    public void deleteDeveriaDeletarOAluguelDoClientePesquisadoPorCpf() {
        Cliente clienteEncontrado = clienteRepository.findByCpf("06698875421");
        Aluguel aluguelCancelado = clienteEncontrado.getAlugueis().get(0);
        aluguelRepository.deleteById(aluguelCancelado.getId());
        Cliente clienteAtualizado = clienteRepository.findByCpf("06698875421");

        assertEquals(1, clienteAtualizado.getAlugueis().size());
    }
}
