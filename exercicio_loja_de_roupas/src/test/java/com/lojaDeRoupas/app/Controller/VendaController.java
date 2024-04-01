package app.entregafinal.controller;

import app.entregafinal.dto.VendaDtoEntrada;
import app.entregafinal.dto.VendaDtoSaida;
import app.entregafinal.entity.Venda;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private app.entregafinal.service.VendaService vendaServiceTest;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<VendaDtoSaida> register(@RequestBody VendaDtoEntrada vendaDtoEntrada) {
        Venda venda = modelMapper.map(vendaDtoEntrada, Venda.class);
        venda = vendaServiceTest.save(venda);

        return new ResponseEntity<>(modelMapper.map(venda, VendaDtoSaida.class), HttpStatus.CREATED);
    }

    @GetMapping
    public List<VendaDtoSaida> listAllVendas() {
        return vendaServiceTest.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaDtoSaida> findById(@PathVariable Long id) {
        Venda venda = vendaServiceTest.findById(id);

        if (venda == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(modelMapper.map(venda, VendaDtoSaida.class), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendaDtoSaida> updateVenda(@PathVariable Long id,
                                                     @RequestBody VendaDtoEntrada vendaDtoEntrada) {
        Venda venda = vendaServiceTest.findById(id);

        if (venda == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        venda.setProdutos(vendaDtoEntrada.getProdutos());
        venda.setStatus(vendaDtoEntrada.getStatus());

        venda = vendaServiceTest.update(venda);

        return new ResponseEntity<>(modelMapper.map(venda, VendaDtoSaida.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenda(@PathVariable Long id) {
        Venda venda = vendaServiceTest.findById(id);

        if (venda == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        vendaServiceTest.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/valor-total")
    public ResponseEntity<List<VendaDtoSaida>> findByValorTotal(@RequestParam BigDecimal valorTotal) {
        List<Venda> vendas = vendaServiceTest.findByValorTotal(valorTotal);

        if (vendas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(vendas.stream().map(venda -> modelMapper.map(venda, VendaDtoSaida.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<List<VendaDtoSaida>> findByStatus(@RequestParam String status) {
        List<Venda> vendas = vendaServiceTest.findByStatus(status);

        if (vendas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(vendas.stream().map(venda -> modelMapper.map(venda, VendaDtoSaida);

    }
}