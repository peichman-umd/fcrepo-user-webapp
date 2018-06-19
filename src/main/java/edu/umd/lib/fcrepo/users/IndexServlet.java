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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
@WebServlet("/")
public class IndexServlet extends HttpServlet {
  private static final Logger log = LoggerFactory.getLogger(IndexServlet.class);

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    log.info("User {} is logged in", request.getRemoteUser());

    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");

    HttpSession session = request.getSession();
    String storedReferer = (String) session.getAttribute("referer");

    // Verify our session referrer and validate the URL
    // Either redirect to that URL or forward to the generic index page
    if (storedReferer != null) {
      try {
        URI refererURI = new URI(storedReferer);
        request.setAttribute("uri", refererURI);
        session.setAttribute("referer", null); // Prevents repeat behavior
        // In this case, we redirect to the stored referrer
        log.info("Redirecting to {}", storedReferer);
        response.sendRedirect(storedReferer);
      } catch (URISyntaxException e) {
        // stored referer was not a syntactically valid URI
        // go to the profile page instead
        dispatcher.forward(request, response);
      }
    } else {
      dispatcher.forward(request, response);
    }
  }
}