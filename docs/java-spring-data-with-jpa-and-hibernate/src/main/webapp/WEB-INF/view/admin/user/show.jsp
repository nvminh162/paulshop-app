<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@taglib
uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>@nvminh162 - ${id}</title>
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
        <h1>@nvminh162 - User Detail - ${id}</h1>
      </div>
      <div class="row">
        <h1>ID: ${user.id}</h1>
        <h1>Email: ${user.email}</h1>
        <h1>FullName: ${user.fullName}</h1>
        <h1>Address: ${user.address}</h1>
      </div>
      <div class="d-flex justify-content-between">
        <a href="/admin/user" class="btn btn-success">Back</a>
      </div>
    </div>
  </body>
</html>
