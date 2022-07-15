//package com.minu.blog.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter{

//    @Autowired
//    private PrincipalDetailService principalDetailService;

    // 회원수정하고 나면 세션이 안 바뀌고 로그아웃 돼서 사용함
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception{
//        return super.authenticationManagerBean();
//    }

//    @Bean // IoC 시킴
//    public BCryptPasswordEncoder encodePWD(){
//        return new BCryptPasswordEncoder();
//    }

    // 시큐리티가 대신 로그인 해주는데, password를 가로채기 하는데
    // 해당 Password가 뭘로 해쉬가 되어 회원가입이 되었는지 알아야
    // 같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수 있다.
//    @Override
//    protected void configure( AuthenticationManagerBuilder auth ) throws Exception{
//        auth.userDetailsService( principalDetailService ).passwordEncoder( encodePWD() );
//    }

//    @Override
//    protected void configure( HttpSecurity http ) throws Exception{
//        http.csrf().disable() // csrf토큰 비활성화 (테스트시에 걸어두는게 좋음)
//                .authorizeRequests()
//                .antMatchers( "/" , "/auth/**" , "/js/**" , "/css/**" , "/image/**" )
//                .permitAll()    // 위에 접근은 누구나 허용
//                .anyRequest()   // 위에가 아닌 모든 요청은 아래로
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage( "/auth/loginForm" )
//                .loginProcessingUrl( "/auth/loginProc" )
//                .defaultSuccessUrl( "/" ); // 로그인 시 이 url로 이동
//    }
//
//}
