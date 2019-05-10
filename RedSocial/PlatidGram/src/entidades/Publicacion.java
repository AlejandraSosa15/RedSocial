package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the publicacion database table.
 * 
 */
@Entity
@Table(name="publicacion")
@NamedQuery(name="Publicacion.findAll", query="SELECT p FROM Publicacion p")
public class Publicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	private int acceso;

	@Lob
	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fechapublicacion;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="publicacionBean")
	private List<Comentario> comentarios;

	//bi-directional many-to-one association to Etiqueta
	@OneToMany(mappedBy="publicacionBean")
	private List<Etiqueta> etiquetas;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuarioBean;

	public Publicacion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAcceso() {
		return this.acceso;
	}

	public void setAcceso(int acceso) {
		this.acceso = acceso;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechapublicacion() {
		return this.fechapublicacion;
	}

	public void setFechapublicacion(Date fechapublicacion) {
		this.fechapublicacion = fechapublicacion;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setPublicacionBean(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setPublicacionBean(null);

		return comentario;
	}

	public List<Etiqueta> getEtiquetas() {
		return this.etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public Etiqueta addEtiqueta(Etiqueta etiqueta) {
		getEtiquetas().add(etiqueta);
		etiqueta.setPublicacionBean(this);

		return etiqueta;
	}

	public Etiqueta removeEtiqueta(Etiqueta etiqueta) {
		getEtiquetas().remove(etiqueta);
		etiqueta.setPublicacionBean(null);

		return etiqueta;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public long getFecha() {
		// TODO Auto-generated method stub
		return 0;
	}

}