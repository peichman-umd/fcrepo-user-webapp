<%@ page session="true"%>

User <strong><%=request.getRemoteUser()%></strong> has been logged out.

<% session.invalidate(); %>

<br/><br/>
<a href="./">Click here to log in again</a>