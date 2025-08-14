package com.nvminh162.paulshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.session.security.web.authentication.SpringSessionRememberMeServices;

import jakarta.servlet.DispatcherType;

import com.nvminh162.paulshop.service.UserService;

/* NOTE
 * Vì sao lại thêm @Bean kết hợp @Configuration:
 * Nói với Spring rằng: tao muốn ghi đè cấu hình mặc định
 */
@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {

    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        return new CustomUserDetailsService(userService);
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    /*
     * Step 0
     * Sử dụng thuật toán BCrypt
     * Ghi đè cấu hình mặc định đối tượng PasswordEncoder
     * => Mã hoá mật khẩu người dùng bằng thuật toán BCrypt =))
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
     * Step 1
     * Filter Chain => UsernamePasswordAuthenticationFilter
     */
    /*
     * @nvminh162
     * HOW TO CONFIG SPRING SECURITY?
     *
     * MỘT SỐ SECURITY DEFAULT
     * [
     *      security.web.session.DisableEncodeUrlFilter@629984eb,
     *      security.web.context.request.async.WebAsyncManagerIntegrationFilter@7b1e5e55,
     *      security.web.context.SecurityContextHolderFilter@69aa7d76,
     *      org.springframework.security.web.header.HeaderWriterFilter@5b5b59,
     *      org.springframework.web.filter.CorsFilter@4c1d59cd,
     *      org.springframework.security.web.csrf.CsrfFilter@318c68d5,
     *      org.springframework.security.web.authentication.logout.LogoutFilter@4733f6f5,
     *      security.web.authentication.UsernamePasswordAuthenticationFilter@56cc9f29,
     *      security.web.authentication.ui.DefaultLoginPageGeneratingFilter@41ccb3b9,
     *      security.web.authentication.ui.DefaultLogoutPageGeneratingFilter@76cf841,
     *      security.web.authentication.www.BasicAuthenticationFilter@661fe025,
     *      security.web.savedrequest.RequestCacheAwareFilter@f1266c6,
     *      security.web.servletapi.SecurityContextHolderAwareRequestFilter@3913f206,
     *      security.web.authentication.AnonymousAuthenticationFilter@297c9a9b,
     *      org.springframework.security.web.access.ExceptionTranslationFilter@6baf25d7,
     *      org.springframework.security.web.access.intercept.AuthorizationFilter@
     * ]
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // v6. lamda
        http
                .authorizeHttpRequests(authorize -> authorize
                        // fix redirected you too many times - unlock prevent forward default of spring security
                        .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.INCLUDE).permitAll()
                        // Với URL /** thì không cần login
                        .requestMatchers(
                                "/", "/login", "/product/**", "/register",
                                "/products/**", "/client/**", "/css/**",
                                "/js/**", "/images/**"
                        ).permitAll()
                        //Chỉ có người có quyền hạn là admin thì mới có quyền truy cập
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .sessionManagement((sessionManagement) -> sessionManagement
                        // Nếu ng dùng chưa có session thì tạo mới
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                        // Hết hạn session thì sẽ tự động logout
                        .invalidSessionUrl("/logout?expired")
                        // Tại một thời điểm có bao nhiêu tài khoản đăng nhập
                        .maximumSessions(1)

                        .maxSessionsPreventsLogin(false)
                )
                .logout(logout -> logout.deleteCookies("JSESSIONID").invalidateHttpSession(true))
                // Fix cơ chế mặc định của Spring
                // Khi tắt trình duyệt thì session sẽ bị xoá giống app Banking
                // sau khi config thì thời gian session là 30 ngày
                .rememberMe(r -> r.rememberMeServices(rememberMeServices()))
                .formLogin(formLogin -> formLogin
                        // Không cần cấu hình controller postMapping vì spring đã làm sẵn
                        .loginPage("/login")
                        .failureUrl("/login?error")
                        .successHandler(authenticationSuccessHandler())
                        .permitAll()
                )
                // Handle Access Denied - 403
                .exceptionHandling(ex -> ex.accessDeniedPage("/access-deny"));
        return http.build();
    }

    /*
     * Step 1.5 (Bước trung gian giữa 1 và 2)
     * ProviderManager (Người quản lý):
     *      Gồm:
     *      + DaoAuthenticationProvider (Lưu trữ UserName, Password)
     *      + LdapAuthenticationProvider
     *      + OpenIdAuthenticationProvider
     *      + JwtAuthenticationProvider
     *      + etc...
     *
     * Dùng để biết bạn đang dùng phương thức nào?
     * Lặp và kiểm tra cung cấp cấu hình gì để Authentication
     */

    /*
     * Step 2:
     * Authentication Provider (Nhà cung cấp) => DaoAuthenticationProvider
     *
     * Làm thế nào để lấy được data?
     * (Spring không quan tâm mày đang lưu User ở database hay bên dịch vụ thứ 3)
    */

    /*
     * Step 3:
     * Spring cung cấp cho mày 1 cái là UserDetailsService (interface)
     * (Mày hãy cung cấp đầy đủ thông tin dựa vào UserDetailsService)
     *      UserDetailsService (interface) gồm:
     *      + InMemoryUserDetailsManager
     *      + LdapUserDetailsManager
     *      + etc...
     *      + Your Custom Logic => Dùng extends: UserDetailsService (interface)
     *          implement method: loadUserByUsername()
     *              input: Username
     *              output: UserDetails Object
     *              -> return data cho Provider
     *                 (cung cấp ngược lại cho DaoAuthenticationProvider (Step 2))
     */

    /*
     * Step 4: đã có config hình thức mã hoá mật khẩu (Step 0)
     * Trong quá trình return (output: UserDetails Object ở bước 3)
     * Spring đã thực hiện Hash mật khẩu ở config PasswordEncoder và so sánh mật khẩu trùng
     *
     * Input: Password ban đầu từ FORM và UserDetail Object (với hashpassword from database storage)
     * Output: `Authentication Object` để return dữ liệu người dùng cho Filter (step 1)
     */
    @Bean
    public DaoAuthenticationProvider authProvider( //fix loop app if incorrect input
            PasswordEncoder passwordEncoder,
            UserDetailsService userDetailsService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        // authProvider.setHideUserNotFoundExceptions(false);
        return authProvider;
    }

    /*
     * Step 5 (Từ bước 1 sau khi nhận được return từ bước 4)
     * Lưu vào SecurityContextHolder => SecurityContext => Authentication (User data, username, permission)
     */

    // TRƯỜNG HỢP KHÁC__________________________________________________________________________________
    /*
    *  Có 2 filter:
     * Nếu F5 sau khi login Spring Security xử lý như thế nào?
     * SecurityContextHolderFilter
     *      Check SecurityContextHolder có thông tin user lưu không
     *      Nếu có người dùng đã đăng nhập thành công
     *      Nếu không có quay về bước 1
     *
     * Nếu login có lỗi Spring Security xử lý như thế nào?
     * + ExceptionTranslationFilter (Chịu trách nhiệm báo lỗi)
     */

    @Bean
    public SpringSessionRememberMeServices rememberMeServices() {
        SpringSessionRememberMeServices rememberMeServices = new SpringSessionRememberMeServices();
        // optionally customize
        rememberMeServices.setAlwaysRemember(true);
        // Đặt thời gian session là 1 ngày (86400 giây)
        rememberMeServices.setValiditySeconds(86400); // 24 * 60 * 60 = 86400 giây
        return rememberMeServices;
    }
}

/*
 * Debug xem quá trình hoạt động của Spring Security
 * UsernamePasswordAuthenticationFilter
 * AuthenticationManager
 * ProviderManager
 * DaoAuthenticationProvider
 * InMemoryUserDetailsManager
 * SecurityContextHolderFilter
 */