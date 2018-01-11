/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pro.escolamusica.dao;

import br.com.pro.escolamusica.modelo.Curso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author paulo
 */
public class CursoDAO {

    public void salvar(Curso curso) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(curso);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public List<Curso> listarTodos() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        Query query = entityManager.createNamedQuery("from Curso");

        return query.getResultList();
    }

    public void excluir(Curso curso) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        curso = entityManager.merge(curso);
        entityManager.remove(curso);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
