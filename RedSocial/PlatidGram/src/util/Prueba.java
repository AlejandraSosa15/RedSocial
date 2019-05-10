package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Usuario;
import model.UsuarioAllDao;
import model.UsuarioDao;

public class Prueba {

	public Prueba() {
		// TODO Auto-generated constructor stub
	}
	
	public static EntityManager getEm() {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("platidgram");
		EntityManager em = emf.createEntityManager();
		return em;
		
	}
	
	public static void main(String[] args) {

		//EntityManager em = Prueba.getEm();	
		
		
		
		
		Usuario usuario = new Usuario();
		/*
		usuario.setEmail("crangarita@gmail.com");
		usuario.setNombre("Carlos");
		usuario.setApellido("Angarita");
		usuario.setPass("1234");
		usuario.setUsuario("crangarita");
		*/
		UsuarioDao uDao = new UsuarioDao();
		
		usuario = uDao.findByField("usuario", "crangarita");
		
		/*
		uDao.insertar(usuario);
		*/
		//usuario = uDao.find(3);
		
		System.out.println(usuario.getNombre());
		
		/*
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
		*/

	}

}
