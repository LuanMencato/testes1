package app.entregafinal.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vendas")
public class VendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String status;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoEntity> produtos = new ArrayList<>();

    @Column(nullable = false)
    private BigDecimal valorTotal;


    public void addProduto(ProdutoEntity produto) {
        produto.setVenda(this);
        this.produtos.add(produto);
    }

    public void removeProduto(ProdutoEntity produto) {
        produto.setVenda(null);
        this.produtos.remove(produto);
    }

    public BigDecimal calcularValorTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ProdutoEntity produto : produtos) {
            total = total.add(produto.getPreco().multiply(BigDecimal.valueOf(produto.getQuantidade())));
        }
        return total;
    }

}