<%@page contentType="text/html" pageEncoding="UTF-8"%> 
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
          <script
            src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
            crossorigin="anonymous"
          ></script>
          <!-- my file -->
          <link href="/css/styles.css" rel="stylesheet" />
        </head>
        <body class="sb-nav-fixed">
          <!-- <div class="container mt-5">
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
                </div> -->
          <jsp:include page="../layout/header.jsp" />
          <div id="layoutSidenav">
            <jsp:include page="../layout/sideBar.jsp" />
            <div id="layoutSidenav_content">
              <main>
                <div class="container-fluid px-4">
                  <h1 class="mt-4">Manage Users</h1>
                  <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                    <li class="breadcrumb-item active">Users</li>
                  </ol>
                  <div class="mt-5">
                    <div class="row">
                      <div class="col-12 mx-auto">
                        <div class="d-flex justify-content-between">
                          <h3>Table users</h3>
                          <a href="/admin/user/create" class="btn btn-primary"
                            >Create a user</a
                          >
                        </div>

                        <hr />
                        <table class="table table-bordered table-hover">
                          <thead>
                            <tr>
                              <th>ID</th>
                              <th>Email</th>
                              <th>Full Name</th>
                              <th>Action</th>
                            </tr>
                          </thead>
                          <tbody>
                            <c:forEach var="user" items="${users}">
                              <tr>
                                <th>${user.id}</th>
                                <td>${user.email}</td>
                                <td>${user.fullName}</td>
                                <td>
                                  <a
                                    href="/admin/user/${user.id}"
                                    class="btn btn-success"
                                    >View</a
                                  >
                                  <a
                                    href="/admin/user/update/${user.id}"
                                    class="btn btn-warning mx-2"
                                    >Update</a
                                  >
                                  <a
                                    href="/admin/user/delete/${user.id}"
                                    class="btn btn-danger"
                                    >Delete</a
                                  >
                                </td>
                              </tr>
                            </c:forEach>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                </div>
              </main>
              <jsp:include page="../layout/footer.jsp" />
            </div>
          </div>
          <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"
          ></script>
          <script src="/js/scripts.js"></script>
        </body>
      </html>
