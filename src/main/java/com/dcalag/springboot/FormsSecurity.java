/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcalag.springboot;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author dchavez
 */
@Configuration
@EnableWebSecurity
public class FormsSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource datasource;
    
    @Autowired
    private AppProperties appProperties;

    // Habilitar la seguridad del sitio:
    // Habilitar 'forms authentication'.
    // - Forms auth (para las páginas de la aplicación):
    // El cliente accede a la página de login (GET a /login) y recibe
    // una forma para introducir sus credenciales. La forma es enviada
    // (POST a /login) para verificar sus credenciales y darle una cookie
    // de sesión con la que Spring Security puede determinar 
    // que el cliente está autentificado.
    // Se puede terminar la sesión del usuario haciendo un GET a /logout.
    // Nota: los endpoints (/login - POST) y (/logout - GET) son provistos por Spring Security,
    // no es necesario crearlos en algún controlador. Sólo se crea un
    // endpoint /login para GET para proporcionar una forma de login
    // personalizada (login.ftl) ya que la forma de login de SpringSecurity
    // está muy básica.
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/", true)
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().permitAll().logoutSuccessUrl("/");
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/webjars/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // autentificación contra la base de datos:  
        auth.jdbcAuthentication().dataSource(datasource).
                usersByUsernameQuery(
                        "select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select a.username, b.role "
                        + "from users a "
                        + "left join user_roles b "
                        + "on a.id = b.id_user "
                        + "where a.username = ?");

    }
}
