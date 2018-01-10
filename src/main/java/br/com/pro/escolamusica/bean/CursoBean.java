/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pro.escolamusica.bean;


import br.com.pro.escolamusica.dao.CursoDAO;
import br.com.pro.escolamusica.dao.GenericDAO;
import br.com.pro.escolamusica.modelo.Curso;
import br.com.pro.escolamusica.modelo.TipoCurso;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author paulo
 */
@ManagedBean
@SessionScoped
public class CursoBean implements Serializable{

    private static final long serialVersionUID = 0L;
 
    
    private Curso curso = new Curso();
    private List<TipoCurso> tipos = Arrays.asList(TipoCurso.values());
    private List<Curso> cursos = new ArrayList<Curso>();

    public CursoBean() {
        System.out.print("appppaispaispa");
    }

    public String salvar() {

        new CursoDAO().salvar(curso);
        
        cursos.add(curso);
        curso = new Curso();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Curso Salvo com Sucesso!"));
        return "curso_lista?faces-redirect=true";
    }

    public String getDataAtual() {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<TipoCurso> getTipos() {
        return tipos;
    }

    public void setTipos(List<TipoCurso> tipos) {
        this.tipos = tipos;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

}
