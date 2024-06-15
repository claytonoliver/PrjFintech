package fintech.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fintech.dao.OracleUsuarioDao;
import fintech.interfaces.IUsuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IUsuario usuarioDAO;

    public LoginServlet() {
        super();
        usuarioDAO = new OracleUsuarioDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        boolean usuario = usuarioDAO.findByEmailAndPassword(email, senha);
        
        if(usuario) 
        {
            HttpSession session = request.getSession();
            session.setAttribute("user", email);

            response.sendRedirect("index.jsp");
        }
        else 
        {
            request.setAttribute("erro", "Usuário e/ou senha inválidos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("home.jsp");
    }
}
