package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the etiqueta database table.
 * 
 */
@Entity
@Table(name="etiqueta")
@NamedQuery(name="Etiqueta.findAll", query="SELECT e FROM Etiqueta e")
public class Etiqueta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Lob
	private String mensaje;

	//bi-directional many-to-one association to Publicacion
	@ManyToOne
	@JoinColumn(name="publicacion")
	private Publicacion publicacionBean;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuarioBean;

	public Etiqueta() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Publicacion getPublicacionBean() {
		return this.publicacionBean;
	}

	public void setPublicacionBean(Publicacion publicacionBean) {
		this.publicacionBean = publicacionBean;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}