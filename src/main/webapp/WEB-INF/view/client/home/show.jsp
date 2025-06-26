<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home - @nvminh162</title>

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap"
      rel="stylesheet"
    />

    <!-- Icon Font Stylesheet -->
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
      rel="stylesheet"
    />

    <!-- Libraries Stylesheet -->
    <link href="/client/lib/lightbox/css/lightbox.min.css" rel="stylesheet" />
    <link
      href="/client/lib/owlcarousel/assets/owl.carousel.min.css"
      rel="stylesheet"
    />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/client/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Template Stylesheet -->
    <link href="/client/css/style.css" rel="stylesheet" />
  </head>

  <body>
    <!-- Header -->
    <jsp:include page="../layout/header.jsp" />

    <div class="py-5"></div>
    <!-- main -->
    <div class="container-fluid fruite py-5">
      <div class="container py-5">
        <div class="tab-class text-center">
          <div class="row g-4">
            <div class="col-lg-4 text-start my-5">
              <h1>Feature our product</h1>
            </div>
          </div>
          <div class="tab-content">
            <div id="tab-1" class="tab-pane fade show p-0 active">
              <div class="row g-4">
                <div class="col-lg-12">
                  <div class="row g-4">
                    <!-- Product Item Here -->
                    <c:forEach var="product" items="${products}">
                      <div class="col-md-6 col-lg-4 col-xl-3">
                        <div class="rounded position-relative fruite-item">
                          <div class="fruite-img">
                            <img
                              src="/images/product/${product.image}"
                              class="img-fluid w-100 rounded-top"
                              alt=""
                            />
                          </div>
                          <div
                            class="text-white bg-secondary px-3 py-1 rounded position-absolute"
                            style="top: 10px; left: 10px"
                          >
                            Laptop
                          </div>
                          <div
                            class="p-4 border border-secondary border-top-0 rounded-bottom"
                          >
                            <h4 style="min-height: 65px">
                              <a href="/product/${product.id}"
                                >${product.name}</a
                              >
                            </h4>
                            <p>${product.shortDesc}</p>
                            <div
                              class="d-flex justify-content-center flex-lg-wrap my-3"
                            >
                              <p class="text-dark fs-5 fw-bold mb-0">
                                <fmt:formatNumber
                                  type="number"
                                  value="${product.price}"
                                />
                                đ
                              </p>
                            </div>
                            <div
                              class="d-flex justify-content-center flex-lg-wrap"
                            >
                              <form action="/add-product-to-cart/${product.id}" method="post">
                                <button
                                  class="btn border border-secondary rounded-pill px-3 text-primary"
                                >
                                  <i
                                    class="fa fa-shopping-bag me-2 text-primary"
                                  ></i>
                                  Add to cart
                                </button>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                              </form>
                            </div>
                          </div>
                        </div>
                      </div>
                    </c:forEach>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- main -->

    <!-- Footer start -->
    <jsp:include page="../layout/footer.jsp" />
    <!-- Footer end -->

    <!-- JavaScript Libraries -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/client/lib/easing/easing.min.js"></script>
    <script src="/client/lib/waypoints/waypoints.min.js"></script>
    <script src="/client/lib/lightbox/js/lightbox.min.js"></script>
    <script src="/client/lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="/client/js/main.js"></script>
  </body>
</html>
