/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pro.escolamusica.dao;

import br.com.pro.escolamusica.modelo.Curso;
import javax.persistence.EntityManager;

/**
 *
 * @author paulo
 */
public class CursoDAO {
    public void salvar(Curso curso){
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(curso);
        entityManager.getTransaction().commit();
        entityManager.close();
        
        
    }
    
}
