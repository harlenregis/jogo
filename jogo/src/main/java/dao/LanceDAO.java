package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import domain.Lance;
import util.JPAUtil;

public class LanceDAO {
	
	public static void salvar(Lance c) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}

	public static void editar(Lance c) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void excluir(Lance c) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		c = em.find(Lance.class, c.getId());
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Lance> listar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select c from Lance c");
		@SuppressWarnings("unchecked")
		List<Lance> lista = q.getResultList();
		em.close();
		return lista;
	}

}