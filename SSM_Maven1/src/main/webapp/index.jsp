
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
%>
<jsp:forward page="/emps"></jsp:forward>
<%--引入JQuery--%>
<script src="<%=path %>/static/js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap -->
<link href="<%=path %>/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="<%=path %>/static/bootstrap/js/bootstrap.min.js"></script>

<head>
    <title>Title</title>
</head>
<body>
<button  class="btn btn-primary">按钮</button>
</body>
</html>
