<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="com.kmowers.lab24.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete User</title>
<%-- <c:set var="id" value="${param.id}"/> --%>
</head>
<body>

User Deleted
<%
int i = Integer.parseInt(request.getParameter("id"));
DAO.deleteUser(i);
%>

<div style="text-align:center">
<a href="newuser.html">Add New User</a> |
<a href="listusers.jsp">Show All Users</a> |
<a href="updateUser.html">Update User</a> |
<a href="deleteUser.html">Delete User</a> |
<!-- <a href="clearall.jsp">Clear Session</a> -->
</div>
</body>
</html>