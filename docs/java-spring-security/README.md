## Required Library @nvminh162 for Spring Security

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
