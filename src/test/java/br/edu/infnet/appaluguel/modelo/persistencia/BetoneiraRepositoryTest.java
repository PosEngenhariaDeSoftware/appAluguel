package br.edu.infnet.appaluguel.modelo.persistencia;

import br.edu.infnet.appaluguel.modelo.entidade.Betoneira;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class BetoneiraRepositoryTest {

    @Autowired
    private BetoneiraRepository betoneiraRepository;

    @Test
    void adicionarBetoneira() {
        Betoneira betoneiraEquipamento = new Betoneira("CSM", LocalDateTime.now(), "Usada");

        betoneiraEquipamento.setValorCompra(new BigDecimal("2500.00"));

        betoneiraEquipamento.setQuantidade(2);

        betoneiraEquipamento.setValorUnitarioAluguel(new BigDecimal("250.00"));


        Betoneira objBetoneiraSalvo = betoneiraRepository.save(betoneiraEquipamento);

        assertEquals(betoneiraEquipamento, objBetoneiraSalvo);
    }

    @Test
    void buscarBetoneiraPorId() {
        Betoneira betoneira = betoneiraRepository.findById(1L).get();

        System.out.println(betoneira);

        assertEquals(betoneira.getCdEquipamento(), 1L);
    }

    @Test
    void atualizarBetoneira() {
        Betoneira betoneira = betoneiraRepository.findById(1L).get();

        betoneira.setValorUnitarioAluguel(new BigDecimal("300.00"));

        Betoneira betoneiraAtualizada = betoneiraRepository.saveAndFlush(betoneira);

        assertEquals(betoneira.toString(), betoneiraAtualizada.toString());
    }

    @Test
    void excluirBetoneira() {
        Betoneira betoneira = betoneiraRepository.findById(1L).get();

        betoneiraRepository.delete(betoneira);

        assertFalse(betoneiraRepository.existsById(1L));
    }
}
