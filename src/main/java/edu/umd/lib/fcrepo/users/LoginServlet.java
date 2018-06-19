package edu.umd.lib.fcrepo.users;

import java.io.IOException;

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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher dispatcher;
    String redirect = request.getParameter("redirect");
    String referer = request.getHeader("referer");

    HttpSession session = request.getSession();
    String storedReferer = (String) session.getAttribute("referer");

    if (request.getRemoteUser() == null) {
      log.info("User is not logged in");
      // Check for referrer and redirect. Store referrer into session.
      // URL validation is done by IndexServlet
      if (redirect != null &&
          redirect.equals("true") &&
          referer != null &&
          !referer.isEmpty() &&
          (storedReferer == null || storedReferer.isEmpty())) {
        session.setAttribute("referer", referer);
      }
      // display the login form
      dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
    } else {
      log.info("User {} is logged in", request.getRemoteUser());
      // user is already logged in, so forward to index controller
      // redirection happens in IndexServlet
      dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
    }
    dispatcher.forward(request, response);
  }
}