package com.algalog.api.domain;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Cliente {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
}
