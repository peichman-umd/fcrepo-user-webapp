package edu.umd.lib.fcrepo.users;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");

    HttpSession session = request.getSession();
    String storedReferer = (String) session.getAttribute("referer");

    /**
     * Verify our session referrer and validate the URL Either redirect or
     * forward
     */
    Pattern p = Pattern.compile("^(http://|https://)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$");
    if (storedReferer != null &&
        p.matcher(storedReferer).matches()) {
      // In this case, we redirect
      session.setAttribute("referer", null); // Prevents repeat behavior
      response.sendRedirect(storedReferer);
    } else {
      // Otherwise, display the profile page
      dispatcher.forward(request, response);
    }
  }
}