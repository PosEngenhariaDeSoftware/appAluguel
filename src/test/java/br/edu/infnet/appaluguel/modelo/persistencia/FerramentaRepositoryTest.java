package br.edu.infnet.appaluguel.modelo.persistencia;

import br.edu.infnet.appaluguel.modelo.entidade.Ferramenta;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class FerramentaRepositoryTest {

    @Autowired
    private FerramentaRepository ferramentaRepository;

    @Test
    void adicionarFerramenta() {
        Ferramenta ferramenta = new Ferramenta("Furadeira", true);

        ferramenta.setValorCompra(new BigDecimal("200.00"));

        ferramenta.setQuantidade(9);

        ferramenta.setValorUnitarioAluguel(new BigDecimal("50.00"));


        Ferramenta objFerramentaSalvo = ferramentaRepository.save(ferramenta);

        assertEquals(ferramenta, objFerramentaSalvo);
    }

    @Test
    void buscarFerramentaPorId() {
        Ferramenta ferramenta = ferramentaRepository.findById(1L).get();

        System.out.println(ferramenta);

        assertEquals(ferramenta.getCdEquipamento(), 1L);
    }

    @Test
    void atualizarAndaime() {
        Ferramenta ferramenta = ferramentaRepository.findById(1L).get();

        ferramenta.setValorUnitarioAluguel(new BigDecimal("60.00"));

        Ferramenta ferramentaAtualizado = ferramentaRepository.saveAndFlush(ferramenta);

        assertEquals(ferramenta.toString(), ferramentaAtualizado.toString());
    }

    @Test
    void excluirAndaime() {
        Ferramenta ferramenta = ferramentaRepository.findById(1L).get();

        ferramentaRepository.delete(ferramenta);

        assertFalse(ferramentaRepository.existsById(1L));
    }
}