package edu.umd.lib.fcrepo.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher dispatcher;
    String redirect = request.getParameter("redirect");
    String referer = request.getHeader("referer");

    HttpSession session = request.getSession();
    String storedReferer = (String) session.getAttribute("referer");

    if (request.getRemoteUser() == null) {

      /**
       * Check for referrer and redirect. Store referrer into session.
       *
       * @note URL validation included elsewhere
       * @see IndexServlet.java
       */
      if (redirect != null &&
          redirect.equals("true") &&
          !referer.isEmpty() &&
          (storedReferer == null || storedReferer.isEmpty())) {
        session.setAttribute("referer", referer);
      }
      // display the login form
      dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
    } else {
      /**
       * Or forward to index controller
       *
       * @note Redirection happens on IndexServlet.java
       */
      dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
    }
    dispatcher.forward(request, response);
  }
}