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
          <link rel="stylesheet" href="/css/styles.css" />
          <script
            src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
            crossorigin="anonymous"
          ></script>
        </head>
        <!-- <body>
          <div class="container mt-5">
            <div class="row">
              <form:form
                action="/admin/user/update"
                method="post"
                modelAttribute="updateUser"
              >
                <div class="mb-3" style="display: none">
                  <label class="form-label">ID</label>
                  <form:input
                    path="id"
                    type="text"
                    class="form-control"
                    readonly="true"
                  />
                </div>
                <div class="mb-3">
                  <label class="form-label">Email</label>
                  <form:input
                    path="email"
                    type="email"
                    class="form-control"
                    disabled="true"
                  />
                </div>
                <div class="mb-3">
                  <label class="form-label">Password</label>
                  <form:input path="password" type="password" class="form-control" />
                </div>
                <div class="mb-3">
                  <label class="form-label">FullName</label>
                  <form:input path="fullName" type="text" class="form-control" />
                </div>
                <div class="mb-3">
                  <label class="form-label">Address</label>
                  <form:input path="address" type="text" class="form-control" />
                </div>
                <div class="mb-3">
                  <label class="form-label">Phone</label>
                  <form:input path="phone" type="text" class="form-control" />
                </div>
                <button type="submit" class="btn btn-success">Update</button>
              </form:form>
            </div>
          </div>
        </body> -->
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
                      <div class="col-md-6 col-12 mx-auto">
                        <h3>Update a user</h3>
                        <hr />
                        <form:form
                          method="post"
                          action="/admin/user/update"
                          modelAttribute="updateUser"
                        >
                          <div class="mb-3" style="display: none">
                            <label class="form-label">Id:</label>
                            <form:input type="text" class="form-control" path="id" />
                          </div>
                          <!-- Hidden fields để tránh validation error -->
                          <form:input type="hidden" path="email" />
                          <form:input type="hidden" path="password" />
                          
                          <div class="mb-3">
                            <label class="form-label">Email:</label>
                            <input
                              type="email"
                              class="form-control"
                              value="${updateUser.email}"
                              disabled="true"
                            />
                          </div>
                          <div class="mb-3">
                            <c:set var="errorPhone">
                              <form:errors path="phone" cssClass="invalid-feedback" />
                            </c:set>
                            <label class="form-label">Phone number:</label>
                            <form:input
                              type="text"
                              class="form-control ${not empty errorPhone ? 'is-invalid' : ''}"
                              path="phone"
                            />
                            ${errorPhone}
                          </div>
                          <div class="mb-3">
                            <c:set var="errorFullName">
                              <form:errors path="fullName" cssClass="invalid-feedback" />
                            </c:set>
                            <label class="form-label">Full Name:</label>
                            <form:input
                              type="text"
                              class="form-control ${not empty errorFullName ? 'is-invalid' : ''}"
                              path="fullName"
                            />
                            ${errorFullName}
                          </div>
                          <div class="mb-3">
                            <c:set var="errorAddress">
                              <form:errors path="address" cssClass="invalid-feedback" />
                            </c:set>
                            <label class="form-label">Address:</label>
                            <form:input
                              type="text"
                              class="form-control ${not empty errorAddress ? 'is-invalid' : ''}"
                              path="address"
                            />
                            ${errorAddress}
                          </div>
                          <button type="submit" class="btn btn-warning">
                            Update
                          </button>
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
