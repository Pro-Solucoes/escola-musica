/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pro.escolamusica.bean;

import br.com.pro.escolamusica.dao.CursoDAO;
import br.com.pro.escolamusica.modelo.Curso;
import br.com.pro.escolamusica.modelo.TipoCurso;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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
public class CursoBean implements Serializable {

    private static final long serialVersionUID = 0L;

    private Curso curso;
    private List<TipoCurso> tipos = Arrays.asList(TipoCurso.values());
    private List<Curso> cursos = new ArrayList<Curso>();
    private List<Curso> cursosAccordion = new ArrayList<Curso>();

    public CursoBean() {
        cursosAccordion = popularCurso();

        //  cursos = new CursoDAO().listarTodos();
        curso = new Curso();
    }

    public String salvar() {

        new CursoDAO().salvar(curso);
        cursos = new CursoDAO().listarTodos();
        curso = new Curso();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Curso Salvo com Sucesso!"));
        return "curso_lista?faces-redirect=true";
    }

    public String editar(Curso curso) {
        this.curso = curso;
        return "curso_formulario?faces-redirect=true";
    }

    public void prepararExclusao(Curso curso) {
        this.curso = curso;
    }

    public void excluir() {
        new CursoDAO().excluir(curso);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Curso excluido com Sucesso!"));
        cursos = new CursoDAO().listarTodos();
    }

    public List popularCurso() {
        List<Curso> cursosList = new ArrayList<Curso>();
        Curso violino = geraCurso("Violino", getDescricao(), "01/01/2014", 4, TipoCurso.CORDAS);
        Curso viola = geraCurso("Viola", getDescricao(), "01/01/2014", 4, TipoCurso.CORDAS);
        Curso violoncello = geraCurso("Violoncello", getDescricao(), "01/01/2014", 4, TipoCurso.CORDAS);
        Curso contrabaixo = geraCurso("Contrabaixo", getDescricao(), "01/01/2014", 4, TipoCurso.CORDAS);
        Curso violao = geraCurso("Violão", getDescricao(), "01/01/2014", 4, TipoCurso.CORDAS);
        Curso guitarra = geraCurso("Guitarra", getDescricao(), "01/01/2014", 4, TipoCurso.CORDAS);
        Curso flauta = geraCurso("Flauta", getDescricao(), "01/02/2014", 4, TipoCurso.MADEIRAS);
        Curso clarinete = geraCurso("Clarinete", getDescricao(), "01/02/2014", 4, TipoCurso.MADEIRAS);
        Curso oboe = geraCurso("Oboé", getDescricao(), "01/02/2014", 5, TipoCurso.MADEIRAS);
        Curso fagote = geraCurso("Fagote", getDescricao(), "01/02/2014", 5, TipoCurso.MADEIRAS);
        Curso saxofone = geraCurso("Saxofone", getDescricao(), "01/02/2014", 5, TipoCurso.MADEIRAS);
        Curso clarone = geraCurso("Clarone", getDescricao(), "01/02/2014", 5, TipoCurso.MADEIRAS);
        Curso trompete = geraCurso("Trompete", getDescricao(), "04/02/2014", 6, TipoCurso.METAIS);
        Curso trompa = geraCurso("Trompa", getDescricao(), "04/01/2014", 6, TipoCurso.METAIS);
        Curso trombone = geraCurso("Trobone", getDescricao(), "04/01/2014", 6, TipoCurso.METAIS);
        Curso tuba = geraCurso("Tuba", getDescricao(), "04/01/2014", 6, TipoCurso.METAIS);
        Curso bateria = geraCurso("Bateria", getDescricao(), "22/01/2014", 3, TipoCurso.PERCUSSAO);
        Curso xilofone = geraCurso("Xilofone", getDescricao(), "22/01/2014", 3, TipoCurso.PERCUSSAO);
        Curso caixa = geraCurso("Caixa", getDescricao(), "22/01/2014", 3, TipoCurso.PERCUSSAO);
        Curso bumbo = geraCurso("Bumbo", getDescricao(), "22/01/2014", 3, TipoCurso.PERCUSSAO);
        cursosList.add(violino);
        cursosList.add(viola);
        cursosList.add(violoncello);
        cursosList.add(contrabaixo);
        cursosList.add(guitarra);
        cursosList.add(flauta);
        cursosList.add(clarinete);
        cursosList.add(oboe);
        cursosList.add(fagote);
        cursosList.add(saxofone);
        cursosList.add(clarone);
        cursosList.add(trompete);
        cursosList.add(trompa);
        cursosList.add(trombone);
        cursosList.add(tuba);
        cursosList.add(bateria);
        cursosList.add(xilofone);
        cursosList.add(caixa);
        cursosList.add(bumbo);
        return cursosList;

    }

    private static String getDescricao() {
        return "Lorem Ipsum é simplesmente uma simulação "
                + "de texto da indústria tipográfica e de impressos, "
                + "e vem sendo utilizado desde o século XVI, quando "
                + "um impressor desconhecido pegou uma bandeja de "
                + "tipos e os embaralhou para fazer um livro de "
                + "modelos de tipos.";
    }

    public static Curso geraCurso(String nome, String descricao, String data, double duracao, TipoCurso tipo) {
        Curso curso = new Curso();
        curso.setNome(nome);
        curso.setDescricao(descricao);
        curso.setDuracao(duracao);
        curso.setDataCriacao(parseData(data));
        curso.setTipo(tipo);
        return curso;
    }

    private static Date parseData(String data) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyy").parse(data);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.getTime();
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
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

    public List<Curso> getCursosAccordion() {
        return cursosAccordion;
    }

    public void setCursosAccordion(List<Curso> cursosAccordion) {
        this.cursosAccordion = cursosAccordion;
    }

}
