package github.com.jailcomfranssa.model.entities;

import github.com.jailcomfranssa.model.enums.SexoCliente;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cliente")
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private SexoCliente sexo;

}
