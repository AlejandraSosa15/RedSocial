package model;

import entidades.Etiqueta;
import util.Conexion;

public class EtiquetaDao 
	extends Conexion<Etiqueta> 
	implements GenericDao<Etiqueta> {

	public EtiquetaDao() {
		super(Etiqueta.class);
		// TODO Auto-generated constructor stub
	}
	
}
