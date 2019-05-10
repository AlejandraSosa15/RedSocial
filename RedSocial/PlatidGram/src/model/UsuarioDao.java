package model;

import entidades.Usuario;
import util.Conexion;

public class UsuarioDao 
	extends Conexion<Usuario> 
	implements GenericDao<Usuario> {

	public UsuarioDao() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}
	
	public Usuario buscarPorUsuario(String usuario){
		
		Usuario u = (Usuario) this.getEm().
				createQuery("select u from Usuario u where u.usuario = '" + usuario + "'").getSingleResult();

		return u;
		
	}
	
public Usuario buscarPorEmail(String email){
		
		Usuario u = (Usuario) this.getEm().
				createQuery("select u from Usuario u where u.email = '" + email + "'").getSingleResult();

		return u;
		
	}
	

}
