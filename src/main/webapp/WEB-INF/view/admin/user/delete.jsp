<%@page contentType="text/html" pageEncoding="UTF-8"%> 
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <html lang="en">
        <head>
          <meta charset="UTF-8" />
          <meta name="viewport" content="width=device-width, initial-scale=1.0" />
          <title>Delete - @nvminh162 - ${id}</title>
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
        <body class="sb-nav-fixed">
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
                          <h3>Delete the user with id = ${id}</h3>
                        </div>

                        <hr />
                        <div class="alert alert-danger">
                          Are you sure to delete this user ?
                        </div>
                        <form:form
                          method="post"
                          action="/admin/user/delete"
                          modelAttribute="deleteUser"
                        >
                          <div class="mb-3" style="display: none">
                            <label class="form-label">Id:</label>
                            <form:input
                              value="${id}"
                              type="text"
                              class="form-control"
                              path="id"
                            />
                          </div>
                          <button class="btn btn-danger">Confirm</button>
                        </form:form>
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
