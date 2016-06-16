package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {


    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        // Login e senha corretos

          if (autenticar(login, senha)) {
           HttpSession sessao = request.getSession();
           sessao.setAttribute(login, senha);

           request.getRequestDispatcher("Tela2.jsp").forward(request, response);
         } else {
             request.getRequestDispatcher("Tela3.jsp").forward(request, response);
               }


    }

    private boolean autenticar(String login, String senha) {
        // TODO Auto-generated method stub
        return false;
    }
}