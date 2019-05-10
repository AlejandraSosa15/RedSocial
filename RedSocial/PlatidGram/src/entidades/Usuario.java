package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=50)
	private String apellido;

	@Column(nullable=false, length=100)
	private String email;

	@Temporal(TemporalType.DATE)
	private Date fechanacimiento;

	@Temporal(TemporalType.DATE)
	private Date fecharegistro;

	@Column(length=50)
	private String nombre;

	private int pais;

	@Column(nullable=false, length=100)
	private String pass;

	@Column(nullable=false, length=50)
	private String usuario;

	//bi-directional many-to-one association to Amistad
	@OneToMany(mappedBy="usuario1")
	private List<Amistad> amistads1;

	//bi-directional many-to-one association to Amistad
	@OneToMany(mappedBy="usuario2")
	private List<Amistad> amistads2;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="usuarioBean")
	private List<Comentario> comentarios;

	//bi-directional many-to-one association to Etiqueta
	@OneToMany(mappedBy="usuarioBean")
	private List<Etiqueta> etiquetas;

	//bi-directional many-to-one association to Mensaje
	@OneToMany(mappedBy="usuario1")
	private List<Mensaje> mensajes1;

	//bi-directional many-to-one association to Mensaje
	@OneToMany(mappedBy="usuario2")
	private List<Mensaje> mensajes2;

	//bi-directional many-to-one association to Publicacion
	@OneToMany(mappedBy="usuarioBean")
	private List<Publicacion> publicacions;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public Date getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPais() {
		return this.pais;
	}

	public void setPais(int pais) {
		this.pais = pais;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Amistad> getAmistads1() {
		return this.amistads1;
	}

	public void setAmistads1(List<Amistad> amistads1) {
		this.amistads1 = amistads1;
	}

	public Amistad addAmistads1(Amistad amistads1) {
		getAmistads1().add(amistads1);
		amistads1.setUsuario1(this);

		return amistads1;
	}

	public Amistad removeAmistads1(Amistad amistads1) {
		getAmistads1().remove(amistads1);
		amistads1.setUsuario1(null);

		return amistads1;
	}

	public List<Amistad> getAmistads2() {
		return this.amistads2;
	}

	public void setAmistads2(List<Amistad> amistads2) {
		this.amistads2 = amistads2;
	}

	public Amistad addAmistads2(Amistad amistads2) {
		getAmistads2().add(amistads2);
		amistads2.setUsuario2(this);

		return amistads2;
	}

	public Amistad removeAmistads2(Amistad amistads2) {
		getAmistads2().remove(amistads2);
		amistads2.setUsuario2(null);

		return amistads2;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setUsuarioBean(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setUsuarioBean(null);

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
		etiqueta.setUsuarioBean(this);

		return etiqueta;
	}

	public Etiqueta removeEtiqueta(Etiqueta etiqueta) {
		getEtiquetas().remove(etiqueta);
		etiqueta.setUsuarioBean(null);

		return etiqueta;
	}

	public List<Mensaje> getMensajes1() {
		return this.mensajes1;
	}

	public void setMensajes1(List<Mensaje> mensajes1) {
		this.mensajes1 = mensajes1;
	}

	public Mensaje addMensajes1(Mensaje mensajes1) {
		getMensajes1().add(mensajes1);
		mensajes1.setUsuario1(this);

		return mensajes1;
	}

	public Mensaje removeMensajes1(Mensaje mensajes1) {
		getMensajes1().remove(mensajes1);
		mensajes1.setUsuario1(null);

		return mensajes1;
	}

	public List<Mensaje> getMensajes2() {
		return this.mensajes2;
	}

	public void setMensajes2(List<Mensaje> mensajes2) {
		this.mensajes2 = mensajes2;
	}

	public Mensaje addMensajes2(Mensaje mensajes2) {
		getMensajes2().add(mensajes2);
		mensajes2.setUsuario2(this);

		return mensajes2;
	}

	public Mensaje removeMensajes2(Mensaje mensajes2) {
		getMensajes2().remove(mensajes2);
		mensajes2.setUsuario2(null);

		return mensajes2;
	}

	public List<Publicacion> getPublicacions() {
		return this.publicacions;
	}

	public void setPublicacions(List<Publicacion> publicacions) {
		this.publicacions = publicacions;
	}

	public Publicacion addPublicacion(Publicacion publicacion) {
		getPublicacions().add(publicacion);
		publicacion.setUsuarioBean(this);

		return publicacion;
	}

	public Publicacion removePublicacion(Publicacion publicacion) {
		getPublicacions().remove(publicacion);
		publicacion.setUsuarioBean(null);

		return publicacion;
	}

}