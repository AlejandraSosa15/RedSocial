package entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class Publicacion2 implements Comparable<Publicacion>{

	private Usuario usuario;
	private String texto;
	private String privacidad;
	private long fecha;
	private String id;
	final DateFormat formato=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	private ArrayList<String> megustaUsuarios;	
	//private List<BsonValue> compartidopor;
	
	public Publicacion2(Usuario usuario, String texto) {
		this.usuario=usuario;
		this.texto=texto;
		this.privacidad="Publica";
		this.fecha=new Date().getTime();		
		this.megustaUsuarios=null;
		//this.compartidopor=null;
	}
	public Publicacion2(Usuario usuario, String texto, String privacidad) {
		this.usuario = usuario;
		this.texto = texto;
		this.privacidad=privacidad;
		this.fecha=new Date().getTime();
		this.megustaUsuarios=null;
		//this.compartidopor=null;
	}	
	public Publicacion2(Usuario usuario, String texto, String privacidad, long fecha) {
		this.usuario = usuario;
		this.texto = texto;
		this.privacidad=privacidad;
		this.fecha=fecha;	
		//this.compartidopor=null;
		
	}
	public Publicacion2() {
		super();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getPrivacidad() {
		return privacidad;
	}
	public void setPrivacidad(String privacidad) {
		this.privacidad = privacidad;
	}
	public long getFecha() {
		return fecha;
	}
	public void setFecha(long fecha) {
		this.fecha = fecha;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public ArrayList<String> getMegustaUsuarios() {
		return megustaUsuarios;
	}
	
	@Override
	public int compareTo (Publicacion p2) {
		if(this.getFecha()>p2.getFecha())
			return -1;
		if(this.getFecha()<p2.getFecha())
			return 1;
		return 0;
	}
	
	public String toString() {
		return "<b>"+usuario.getNombre()+" </b>: <br>"+ this.texto+ " id:"+this.id; 
	}
	/*public List<BsonValue> getCompartidopor() {
		return compartidopor;
	}
	public void setCompartidopor(List<BsonValue> compartidopor) {
		this.compartidopor = compartidopor;
	}
	public String textoCompartido() {
		try {
			if(compartidopor.equals(null)) return "No est&aacute; compartido por nadie";
		}catch(Exception e) {
			return "No esta compartido por nadie";
		}
		Iterator <BsonValue> it=compartidopor.iterator();
		String texto="";
		while(it.hasNext()) {
			texto+=it.next().asString().getValue()+" ";
		}
		return texto;
	}*/
	public String textoMeGusta() {
		try {
			if(megustaUsuarios.equals(null)) return "No le gusta a nadie";
		}catch(Exception e) {
			return "No le gusta a nadie";
		}
		Iterator <String> it=megustaUsuarios.iterator();
		String texto="";
		while(it.hasNext()) {
			texto+=it.next()+" ";
		}
		return texto;
	}
	public void setMegustaUsuarios(ArrayList<String> megustaUsuarios) {
		this.megustaUsuarios = megustaUsuarios;
	}
}
