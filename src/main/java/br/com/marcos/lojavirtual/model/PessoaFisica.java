package br.com.marcos.lojavirtual.model;

import java.util.Date; // Alteração na importação

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaFisica extends Pessoa {

    @Column(nullable = false)
    private String cpf;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
}
