package edu.umd.lib.fcrepo.users;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
    try {
      URI refererURI = new URI(storedReferer);
      request.setAttribute("uri", refererURI);
      session.setAttribute("referer", null); // Prevents repeat behavior
      response.sendRedirect(storedReferer);
    } catch (URISyntaxException e) {
      // stored referer was not a syntactically valid URI
      // go to the profile page instead
      dispatcher.forward(request, response);
    } catch (NullPointerException e) {
      // And here, the URI was null.
      // go to the profile page instead
      dispatcher.forward(request, response);
    }
  }
}