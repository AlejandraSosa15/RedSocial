package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Usuario;
import util.ConexionJDBC;

public class UsuarioJDBCDao {
	
	ConexionJDBC con = null;

	public UsuarioJDBCDao() {

		this.con = ConexionJDBC.getConexion();
	}
	
	public Boolean validarLogin(Usuario usuario){
		Usuario u = this.buscar(usuario.getUsuario());
		if(u.getPass().contentEquals(usuario.getPass())){
			return true;
		}
		return false;
	}
	
	public void insertar(Usuario usuario) {
		String sql = "INSERT INTO usuario "
				+ "(usuario, nombre, apellido, email, pass) "
				+ "VALUES ('"+usuario.getUsuario()+"', "
						+ "'"+usuario.getNombre()+"', "
						+ "'"+usuario.getApellido()+"', "
						+ "'"+usuario.getEmail()+"', "
						+ "'"+usuario.getPass()+"');";
		
		try {
			this.con.insert(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void actualizar(Usuario usuario) {
		String sql = "UPDATE usuario SET "
					+ "nombre = '"+usuario.getNombre()+"', "
					+ "apellido = '"+usuario.getApellido()+"', "
					+ "email = '"+usuario.getEmail()+"', "
					+ "pass = '"+usuario.getPass()+"' "
					
					+ "WHERE usuario = '"+usuario.getUsuario()+"';";
		try {
			this.con.insert(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminar(Usuario usuario) {
		String sql = "DELETE FROM usuario "
				+ "WHERE usuario = '"+usuario.getUsuario()+"';";
		try {
			this.con.insert(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Usuario buscar(String usuarioIn) {
		Usuario usuario = null;
		
		String sql = "SELECT * FROM usuario "
				+ "WHERE usuario = '" + usuarioIn +"';";
			
		ResultSet res;
		try {
			res = con.query(sql);
	  	   	while(res.next()){
		        	    usuario = new Usuario();
		        	    usuario.setUsuario(res.getString("usuario"));
		        	    usuario.setNombre(res.getString("nombre"));
		        	    usuario.setApellido(res.getString("apellido"));
		        	    usuario.setPass(res.getString("pass"));
		        	    usuario.setEmail(res.getString("email")); 
		        	    
	  	   	}
	  	   	res.close();
  	   	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	public List<Usuario> listar() {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		String sql = "SELECT * FROM usuario;";
			
		ResultSet res;
		try {
			res = con.query(sql);
	  	   	while(res.next()){
	  	   				Usuario usuario = new Usuario();
		        	    usuario.setUsuario(res.getString("usuario"));
		        	    usuario.setNombre(res.getString("nombre"));
		        	    usuario.setApellido(res.getString("apellido"));
		        	    usuario.setPass(res.getString("pass"));
		        	    usuario.setEmail(res.getString("email")); 
		        	    
		        	    usuarios.add(usuario);
	  	   	}
	  	   	res.close();
  	   	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}

}
