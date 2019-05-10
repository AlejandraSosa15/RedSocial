package model;

import entidades.Comentario;
import util.Conexion;

public class ComentarioDao 
	extends Conexion<Comentario> 
	implements GenericDao<Comentario> {

	public ComentarioDao() {
		super(Comentario.class);
		// TODO Auto-generated constructor stub
	}
	
}
