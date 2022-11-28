package br.edu.infnet.appaluguel.modelo.persistencia;

import br.edu.infnet.appaluguel.modelo.entidade.Andaime;
import br.edu.infnet.appaluguel.modelo.entidade.Cliente;
import br.edu.infnet.appaluguel.modelo.entidade.enums.TipoEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class AndaimeRepositoryTest {

    @Autowired
    private AndaimeRepository andaimeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    void adicionarAndaime() {
        Andaime andaime = new Andaime(TipoEnum.UM_POR_UM);

        andaime.setValorCompra(new BigDecimal("100.00"));

        andaime.setQuantidade(40);

        andaime.setValorUnitarioAluguel(new BigDecimal("13.00"));


        Andaime objAndaimeSalvo = andaimeRepository.save(andaime);

        assertEquals(andaime, objAndaimeSalvo);
    }

    @Test
    void buscarAndaimePorId() {
        Andaime andaime = andaimeRepository.findById(1L).get();

        System.out.println(andaime);

        assertEquals(andaime.getCdEquipamento(), 1L);
    }

    @Test
    void atualizarAndaime() {
        Andaime andaime = andaimeRepository.findById(1L).get();

        andaime.setValorUnitarioAluguel(new BigDecimal("150.00"));

        Andaime andaimeAtualizado = andaimeRepository.saveAndFlush(andaime);

        assertEquals(andaime.toString(), andaimeAtualizado.toString());
    }

    @Test
    void excluirAndaime() {
        Andaime andaime = andaimeRepository.findById(1L).get();

        andaimeRepository.delete(andaime);

        assertFalse(andaimeRepository.existsById(1L));
    }

    @Test
    void relacionarAndaimeComAluguel() {
        Cliente cliente = clienteRepository.findByCpf("06698875421");

        Andaime andaime = andaimeRepository.findById(3L).get();

        andaime.setAluguel(cliente.getAlugueis().get(0));

        Andaime andaimeRelacionado = andaimeRepository.saveAndFlush(andaime);

        assertEquals(andaime.toString(), andaimeRelacionado.toString());
    }
}