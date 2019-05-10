package model;

import entidades.Amistad;
import util.Conexion;

public class AmistadDao 
	extends Conexion<Amistad> 
	implements GenericDao<Amistad> {

	public AmistadDao() {
		super(Amistad.class);
		// TODO Auto-generated constructor stub
	}
	
}
