package app.entregafinal.service;

import app.entregafinal.entity.Produto;
import app.entregafinal.entity.Venda;
import app.entregafinal.exception.VendaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VendaService {

    @Mock
    private VendaRepository vendaRepository;

    @InjectMocks
    private com.lojaDeRoupas.app.service.VendaService vendaService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalcularValorTotalSucesso() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Produto 1", BigDecimal.valueOf(10.0)));
        produtos.add(new Produto("Produto 2", BigDecimal.valueOf(20.0)));

        double result = vendaService.calcularValorTotal(produtos);

        assertEquals(30.0, result, 0.001);
    }

    @Test
    public void testCalcularValorTotalException() {
        List<Produto> produtos = null;

        assertThrows(NullPointerException.class, () -> {
            vendaService.calcularValorTotal(produtos);
        });
    }

    @Test
    public void testVerificarStatusSucesso() {
        Venda venda = new Venda();
        venda.setStatus("CANCELADO");

        vendaService.verificarStatus(venda);

        assertEquals(0.0, venda.getValorTotal().doubleValue(), 0.001);
        assertEquals(null, venda.getProdutos());
    }

    @Test
    public void testVerificarStatusException() {
        Venda venda = new Venda();
        venda.setStatus("INVALIDO");

        assertThrows(VendaException.class, () -> {
            vendaService.verificarStatus(venda);
        });
    }

    @Test
    public void testSaveVenda() {
        Venda venda = new Venda();
        venda.setId(1L);
        venda.setProdutos(new ArrayList<>());
        venda.setValorTotal(BigDecimal.ZERO);

        when(vendaRepository