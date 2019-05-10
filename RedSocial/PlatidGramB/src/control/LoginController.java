package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entidades.Usuario;
import model.UsuarioDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuarioTxt = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario();
		usuario.setUsuario(usuarioTxt);
		usuario.setPass(password);
		
		HttpSession session = request.getSession(true);
		
		Usuario user = this.validarLogin(usuario);
		
		if(user!=null) {
			RequestDispatcher rd = request
					.getRequestDispatcher("Home2.jsp");
			
			
			session.setAttribute("usuario", user);
			session.setAttribute("usuarioName", usuario.getUsuario());
			
			rd.forward(request, response);
		}else{
			request.setAttribute("mensaje", ":( Error de acceso");
			request.getRequestDispatcher("error.jsp")
				.forward(request, response);
		}
	}
	
	
	public Usuario validarLogin(Usuario usuario){
		UsuarioDao uDao = new UsuarioDao();
		Usuario u = uDao.findByField("usuario", usuario.getUsuario());
		if(u.getPass().contentEquals(usuario.getPass())){
			return u;
		}
		return null;
	}

}