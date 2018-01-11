/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pro.escolamusica.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Curso implements Serializable {

    private static final long serialVersionUID = -2562315443536852787L;

    private Integer id;
    private String nome;
    private String descricao;
    private double duracao = 1;
    private TipoCurso tipo;
    private Date dataCriacao;

    public Curso() {
    }

    public Curso(Integer id, String nome, String descricao, TipoCurso tipo, Date dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.dataCriacao = dataCriacao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotEmpty(message = "Você deve informar o Usuario")
    @Length(min = 4,max = 50,message = "O nome docurso deve ter entre 3 e 20 caracter")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotEmpty(message = "Você deve informar Descrição")
    @Length(max = 255,message = "O campo descrição do pode ter 255 caracteres")
    public String getDescricao() {
        return descricao;
    }

    @Min(value = 1)
    @Max(value = 10)
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    @NotNull
    public TipoCurso getTipo() {
        return tipo;
    }

    public void setTipo(TipoCurso tipo) {
        this.tipo = tipo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 89 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 89 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.duracao) ^ (Double.doubleToLongBits(this.duracao) >>> 32));
        hash = 89 * hash + (this.tipo != null ? this.tipo.hashCode() : 0);
        hash = 89 * hash + (this.dataCriacao != null ? this.dataCriacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        if (Double.doubleToLongBits(this.duracao) != Double.doubleToLongBits(other.duracao)) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (this.dataCriacao != other.dataCriacao && (this.dataCriacao == null || !this.dataCriacao.equals(other.dataCriacao))) {
            return false;
        }
        return true;
    }

}
