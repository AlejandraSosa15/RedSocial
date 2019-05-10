package model;

import entidades.Publicacion;
import util.Conexion;

public class PublicacionDao 
	extends Conexion<Publicacion> 
	implements GenericDao<Publicacion> {

	public PublicacionDao() {
		super(Publicacion.class);
		// TODO Auto-generated constructor stub
	}
	
}
