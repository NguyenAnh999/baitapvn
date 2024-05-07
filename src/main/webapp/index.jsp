<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="/AdminServlet">Home</a>
<a href="hello-servlet">Hello Servlet</a>
<a href="/public.jsp">Public page</a>
<a href="/test.jsp">Public page</a>
<a href="/form.jsp">up img</a>
<br><a href="/EmployeeServlet?action=LIST">Danh sach nhan vien</a>
<br><a href="/Studentseverlet">Danh sach hoc sinh</a>
<br><a href="student.jsp">Danh sach học sinh</a>
<br>
<form action="/HomeServlet" method="post" enctype="multipart/form-data">
  <input type="text" name="username" placeholder="username"><br>
  <input type="password" name="password" placeholder="password"><br>
  <input type="file" name="file"><br>
  <input type="submit" value="Gửi">
</form>
</body>
</html>