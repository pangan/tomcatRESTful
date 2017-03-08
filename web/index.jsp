<%@ page import="com.mofakhar.info.HelpAPI" %><%--
  Created by IntelliJ IDEA.
  User: pangan
  Date: 08/03/2017
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title><%=HelpAPI.getHelpTitle()%></title>
  </head>
  <body>
  <%=HelpAPI.getHelp()%>


  </body>
</html>
