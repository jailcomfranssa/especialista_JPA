package github.com.jailcomfranssa.model.entities;

import github.com.jailcomfranssa.model.EnderecoEntregaPedido;
import github.com.jailcomfranssa.model.enums.StatusPedido;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pedido")
public class Pedido {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itemPedidos = new ArrayList<>();

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_ultima_atualizacao")
    private LocalDateTime dataUltimaAtualizacao;

    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;

    @Column(name = "nota_fiscal_id")
    private Integer notaFiscalId;
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @OneToOne(mappedBy = "pedido")
    private PagamentoCartao pagamentoCartao;

    @OneToOne(mappedBy = "pedido")
    private NotaFiscal notaFiscal;

    @Embedded
    private EnderecoEntregaPedido enderecoEntregaPedido;

//    @PrePersist
//    @PreUpdate
    public void calcularToral(){
        if(itemPedidos !=null){
            total = itemPedidos.stream().map(ItemPedido::getPrecoProduto)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }

    @PrePersist
    public void aoPersistir(){
        dataCriacao = LocalDateTime.now();
        calcularToral();
    }

    @PreUpdate
    public void aoAtualizar(){
        dataUltimaAtualizacao = LocalDateTime.now();
        calcularToral();
    }

    @PostPersist
    public void aposPersistir(){
        System.out.println("Apos persistir Pedido");
    }

    @PostUpdate
    public void aposAtualizar(){
        System.out.println("Apos atualizar Pedido");
    }

    @PreRemove
    public void aoRemover(){
        System.out.println("Antes de remover Pedido");
    }

    @PostRemove
    public void aposRemover(){
        System.out.println("Apos remover Pedido");
    }

    @PostLoad
    public void aoCarregar(){
        System.out.println("Apos carregar o Pedido");
    }
}
