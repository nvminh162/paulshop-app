<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@taglib
uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>@nvminh162</title>
    <!-- Latest compiled and minified CSS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- bootstrap - jquery -->
    <!-- Latest compiled and minified CSS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <!-- my file -->
    <link rel="stylesheet" href="/css/demo.css" />
  </head>
  <body>
    <div class="container mt-5">
      <div class="d-flex justify-content-between">
        <h1>@nvminh162 - Table Users</h1>
        <form action="/admin/user/create" method="get">
          <button type="submit" class="btn btn-primary">Create New User</button>
        </form>
      </div>
      <div class="row">
        <table class="table table-hover">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Email</th>
              <th scope="col">Full Name</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            <!-- <tr>
              <th scope="row">1</th>
              <td>Mark</td>
              <td>Otto</td>
              <td>
                <button class="btn btn-success">View</button>
                <button class="btn btn-warning">Update</button>
                <button class="btn btn-danger">Delete</button>
              </td>
            </tr> -->
            <c:forEach var="user" items="${users}">
              <tr>
                <th scope="row">${user.id}</th>
                <td>${user.email}</td>
                <td>${user.fullName}</td>
                <td>
                  <a href="/admin/user/${user.id}" class="btn btn-success">View</a>
                  <a href="/admin/user/update/${user.id}" class="btn btn-warning">Update</a>
                  <a href="/admin/user/delete/${user.id}" class="btn btn-danger">Delete</a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </body>
</html>
