package edu.umd.lib.fcrepo.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
@WebServlet("/login-error")
public class LoginErrorServlet extends HttpServlet {
  private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);

  // method must be POST to match the login form POST to j_security_check
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    log.warn("Login error");
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login-error.jsp");
    dispatcher.forward(request, response);
  }
}
