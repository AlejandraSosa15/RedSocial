package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Usuario;
import model.UsuarioDao;
import util.Utilidad;

/**
 * Servlet implementation class RegistroController
 */
@WebServlet("/RegistroController")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Servicio de: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String usuario = request.getParameter("usuario");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
	
			Usuario u = new Usuario();
			u.setEmail(email);
			u.setApellido(apellido);
			u.setNombre(nombre);
			u.setUsuario(usuario);
			u.setPass(pass);
			
			UsuarioDao  uDao = new UsuarioDao();
			uDao.insert(u);
			
			System.out.println("El usuario es " + usuario);
			request.setAttribute("nombrecompleto", nombre + " " + apellido);
			request.setAttribute("mensaje", "Bienvenido");
			Utilidad util = new Utilidad();
			util.enviarCorreo(u);
			request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
