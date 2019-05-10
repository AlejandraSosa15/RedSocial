package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Usuario;
import util.Utilidad;

/**
 * Servlet implementation class Correo
 */
@WebServlet("/index.jsp")
public class CorreoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorreoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		
		Utilidad u = new Utilidad();
		Boolean resultado = u.enviarCorreo(usuario);
		
		request.setAttribute("usuario", usuario); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
		
		
		if(resultado){
			request.setAttribute("info", "El mensaje se ha enviado correctamente");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			request.setAttribute("info", "Se ha presentado un error en el envio del formulario");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}

