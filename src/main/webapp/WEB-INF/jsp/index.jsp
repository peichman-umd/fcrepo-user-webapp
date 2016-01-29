<html>
  <head>
    <title>User Session - ${pageContext.request.remoteUser}@${pageContext.request.serverName}</title>
  </head>
  <body>
    <p><strong>${pageContext.request.remoteUser}</strong> is logged in.</p>
    <p><a href="/fcrepo/rest">Fedora 4 Repository REST endpoint</a></p>
    <form method="post" action="${pageContext.request.contextPath}/logout">
      <p><input type="submit" value="Log Out"/></p>
    </form>
  </body>
</html>
