package userValid;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class userValidation
 */
@WebServlet("/userValidation")

public class userValidation extends  HttpServlet{
	private static final long serialVersionUID = 1L ;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userValidation() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
//		Check whether the session already exists
		if ((session.getAttribute("userName") != null) && (session.getAttribute("userPassword") != null))  {
			out.println("<h3>Welcome " + session.getAttribute("userName"));
			out.println("<br> You are now logged in...</h3>");
			out.println("<p><h4><a href='userValid2'>LOGOUT</a></h4>");
		}
		else {
			response.sendRedirect("user.html");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
