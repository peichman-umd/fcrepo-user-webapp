<html>
  <head>
    <title>Login - ${pageContext.request.serverName}</title>
  </head>
  <body>
    <form method="POST" action="j_security_check">
      <table>
        <tr>
          <td colspan="2">Login to the Fedora 4 Repository application:</td>
        </tr>
        <tr>
          <td><label for="username">Username:</label></td>
          <td><input id="username" type="text" name="j_username"/></td>
        </tr>
        <tr>
          <td><label for="password">Password:</label></td>
          <td><input id="password" type="password" name="j_password"/></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" value="Log In"/></td>
        </tr>
      </table>
    </form>
    <script>
    document.getElementById("username").focus();
    </script>
  </body>
</html>
