<%@ page import="phoneBook.DB" %><%--
  Created by IntelliJ IDEA.
  User: reza
  Date: 6/24/19
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PhoneBook</title>
</head>
<body>
<%
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");

    DB db = new DB();
    int state = db.check(userName, password);
    if(state == 200)
        request.getRequestDispatcher("panel.jsp").forward(request, response);
    if (state == 404)
    {
        request.getRequestDispatcher("index.jsp").include(request, response);
        out.print("no such user");
    }

    if (state == 403)
    {
        request.getRequestDispatcher("index.jsp").include(request, response);
        out.print("wrong password");
    }


%>

</body>
</html>
