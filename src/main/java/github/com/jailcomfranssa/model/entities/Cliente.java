package github.com.jailcomfranssa.model.entities;

import github.com.jailcomfranssa.model.enums.SexoCliente;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    private String nome;
    private SexoCliente sexo;

}
