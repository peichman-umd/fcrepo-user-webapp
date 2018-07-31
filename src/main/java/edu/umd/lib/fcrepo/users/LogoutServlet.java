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
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
  private static final Logger log = LoggerFactory.getLogger(LogoutServlet.class);

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    log.info("Logging out user {}", request.getRemoteUser());
    // invalidate the session to log out the user
    HttpSession session = request.getSession();
    session.invalidate();

    // show the logged out confirmation page
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/logout.jsp");
    dispatcher.forward(request, response);
  }
}
