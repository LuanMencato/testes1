package app.entregafinal.repository;

import app.entregafinal.entity.Venda;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VendaRepository {

    @Mock
    private app.entregafinal.repository.VendaRepository vendaRepositoryTest;

    @InjectMocks
    private VendaServiceTest vendaService;

    @Test
    public void testFindByValorTotal() {
        BigDecimal valorTotal = BigDecimal.valueOf(100);

        Venda venda1 = new Venda();
        venda1.setId(1L);
        venda1.setValorTotal(valorTotal);

        Venda venda2 = new Venda();
        venda2.setId(2L);
        venda2.setValorTotal(valorTotal);

        when(vendaRepository.findByValorTotal(valorTotal)).thenReturn(Arrays.asList(venda1, venda2));

        List<Venda> vendas = vendaService.findByValorTotal(valorTotal);

        assertThat(vendas).hasSize(2).contains(venda1, venda2);
    }

    @Test
    public void testFindByStatusCancelled() {
        Venda venda1 = new Venda();
        venda1.setId(1L);
        venda1.setStatus("CANCELADO");

        Venda venda2 = new Venda();
        venda2.setId(2L);
        venda2.setStatus("CANCELADO");

        when(vendaRepository.findByStatusCancelled()).thenReturn(Arrays.asList(venda1, venda2));

        List<Venda> vendas = vendaService.findByStatusCancelled();

        assertThat(vendas).hasSize(2).contains(venda1, venda2);
    }

    @Test
    public void testFindByStatus() {
        String status = "STATUS";

        Venda venda1 = new Venda();
        venda1.setId(1L);
        venda1.setStatus(status);

        Venda venda2 = new Venda();
        venda2.setId(2L);
        venda2.setStatus(status);

        when(vendaRepository.findByStatus(status)).thenReturn(Arrays.asList(venda1, venda2));

        List<Venda> vendas = vendaService.findByStatus(status);

        assertThat(vendas).hasSize(2).contains(venda1, venda2);
    }

    @Test
    public void testFindByValorTotalBetween() {
        BigDecimal minValue = BigDecimal.valueOf(100);
        BigDecimal maxValue = BigDecimal.valueOf(200);

        Venda venda1 = new Venda();
        venda1.setId(1L);
        venda1.setValorTotal(BigDecimal.valueOf(150));

        Venda venda2 = new Venda();
        venda2.setId(2L);
        venda2.setValorTotal(BigDecimal.valueOf(175));

        when(vendaRepository.findByValorTotalBetween(minValue, maxValue)).thenReturn(Arrays.asList(venda1, venda2));

        List<Venda> vendas = vendaService.findByValorTotalBetween(minValue, maxValue);

        assertThat(vendas).hasSize(2).contains(venda1, venda2);
    }
}