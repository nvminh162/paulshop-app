## Required Library @nvminh162 for Spring MVC

To use Spring Boot's web features, add the following dependency to your `pom.xml`:

```xml
<!-- spring-boot-starter-web: Thư viện cốt lõi để xây dựng ứng dụng web và RESTful API
    - Tự động cấu hình Spring MVC và máy chủ Tomcat nhúng
    - Hỗ trợ xử lý HTTP request/response và chuyển đổi JSON
    - Sử dụng: Thêm @Controller/@RestController và các annotation như @GetMapping, @PostMapping
    - Không cần cấu hình thêm, hoạt động ngay sau khi thêm vào pom.xml -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

```xml
<!-- spring-boot-devtools: Công cụ hỗ trợ phát triển, tăng hiệu quả coding
    - Tự động khởi động lại ứng dụng khi code thay đổi
    - Live reload: Tự động làm mới trình duyệt khi resources/templates thay đổi
    - Vô hiệu hóa cache trong quá trình phát triển
    - Thuộc tính optional=true đảm bảo devtools không được đưa vào môi trường production
    - Sử dụng: Không cần cấu hình gì thêm, đặt breakpoints trong IDE để debug -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
```
```xml
<!-- spring-boot-starter-data-jpa: Thư viện hỗ trợ thao tác với cơ sở dữ liệu qua JPA/Hibernate
    - Tự động cấu hình JPA, DataSource, Transaction
    - Hỗ trợ các annotation như @Entity, @Repository, @Transactional
    - Sử dụng để thao tác CRUD với database một cách dễ dàng -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
```xml
<!-- mysql-connector-j: Driver JDBC để kết nối ứng dụng với MySQL Database
    - Cần thiết khi sử dụng MySQL làm hệ quản trị cơ sở dữ liệu
    - Không cần cấu hình gì thêm ngoài khai báo trong pom.xml -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
</dependency>
```
```xml
<!-- spring-boot-starter-security: Thư viện cốt lõi để bảo mật ứng dụng Spring Boot
    - Cung cấp các tính năng xác thực, phân quyền, mã hóa mật khẩu
    - Hỗ trợ cấu hình bảo mật qua Java Config hoặc annotation
    - Sử dụng để bảo vệ các endpoint, quản lý user, role -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

```xml
<!-- tomcat-embed-jasper: Hỗ trợ JSP trong ứng dụng Spring Boot
    - Cho phép sử dụng JSP làm view technology trong Spring MVC
    - Thêm khả năng biên dịch các file JSP thành servlet
    - Cần thiết khi muốn phát triển ứng dụng web sử dụng JSP views
    - Hoạt động với máy chủ Tomcat nhúng của Spring Boot -->
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
```
```xml
<!-- jakarta.servlet.jsp.jstl-api: API cho JSTL (JavaServer Pages Standard Tag Library)
    - Cung cấp các interface và annotation cho JSTL
    - Hỗ trợ phát triển JSP với các tag chuẩn (core, fmt, sql, xml, functions)
    - Đây là phiên bản Jakarta EE mới thay thế cho javax.servlet.jsp.jstl
    - Sử dụng kết hợp với implementation như Glassfish JSTL -->
<dependency>
    <groupId>jakarta.servlet.jsp.jstl</groupId>
    <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
</dependency>
```

```xml
<!-- jakarta.servlet.jsp.jstl: Implementation của JSTL cho Jakarta EE
    - Cung cấp triển khai cụ thể của các JSTL tags từ Glassfish
    - Làm việc với Jakarta EE 9+ và Jakarta Servlet 5.0+
    - Cho phép sử dụng các thẻ như <c:if>, <c:forEach>, <fmt:formatDate> trong JSP
    - Cần kết hợp với jakarta.servlet.jsp.jstl-api để hoạt động đầy đủ -->
<dependency>
    <groupId>org.glassfish.web</groupId>
    <artifactId>jakarta.servlet.jsp.jstl</artifactId>
</dependency>
```