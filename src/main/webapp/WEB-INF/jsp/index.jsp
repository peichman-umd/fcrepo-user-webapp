<html>
<head>
<title>User Session</title>
</head>
<body>
  <p><strong><%=request.getRemoteUser()%></strong> is logged in.</p>
  <p><a href="/fcrepo/rest">Fedora 4 Repository REST endpoint</a></p>
  <p><a href="logout">Log Out</a></p>
</body>
</html>
