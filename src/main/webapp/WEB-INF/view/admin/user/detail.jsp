<%@page contentType="text/html" pageEncoding="UTF-8"%> 
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
          <link href="/css/styles.css" rel="stylesheet" />

          <script
            src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
            crossorigin="anonymous"
          ></script>
        </head>
        <body>
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
                  <div class="container mt-5">
                    <div class="row">
                      <div class="col-12 mx-auto">
                        <div class="card" style="width: 100%">
                          <div class="card-header text-center">User information</div>
                          <ul class="list-group list-group-flush">
                            <li class="list-group-item">ID: ${user.id}</li>
                            <li class="list-group-item">Email: ${user.email}</li>
                            <li class="list-group-item">
                              FullName: ${user.fullName}
                            </li>
                            <li class="list-group-item">Address: ${user.address}</li>
                          </ul>
                        </div>
                        <a href="/admin/user" class="btn btn-success mt-3">Back</a>
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
