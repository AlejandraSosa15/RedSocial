package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entidades.Usuario;
import util.ConexionAll;

public class UsuarioAllDao {
	
	public EntityManager em;

	public UsuarioAllDao() {
		// TODO Auto-generated constructor stub
		this.em = ConexionAll.getEm();
	}
	
	public void insertar(Usuario usuario) {
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
	}
	
	public void actualizar(Usuario usuario) {
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
	}
	
	public void eliminar(Usuario usuario) {
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();
	}
	
	public Usuario buscar(Integer usuarioIn) {
		return em.find(Usuario.class, usuarioIn);
	}
	
	public List<Usuario> listar() {
		TypedQuery<Usuario> consulta= em.createNamedQuery("Usuario.findAll", Usuario.class);
		List<Usuario> lista = (List<Usuario>) consulta.getResultList();
		return lista;
	}


}
