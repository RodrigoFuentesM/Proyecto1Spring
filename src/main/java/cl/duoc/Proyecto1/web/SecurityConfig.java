package cl.duoc.Proyecto1.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    /*
    Agrgar y personalizar usuarios en la aplicación
    y también vamos a restringir usuarios dependiendo de un rol
    */
    
    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        // voy a crear usuaruos en memoria para probar
        // (noop) - dice que no es necesario encriptar la contraseña
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123456")
                .roles("ADMIN","USER")
                .and()
                .withUser("usuario")
                .password("{noop}123456")
                .roles("USER");
    }
    //Restriccio de accesos dependiendo del rol del usuario
    
    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.authorizeRequests()
                /**
                 * cualquer cosa que sea igual en terminos de nombre,
                 * lo reconocera como ruta de la app
                 */
                .antMatchers("/editar/**", "/agregar/**", "/eliminar")
                /**
                 * Cuando ponemos doble asterisco dice que cualquier
                 * cosa dentro de ese path no permita que ingrese a esa ruta
                 */
                .hasRole("ADMIN")
                .antMatchers("/")
                .hasAnyRole("USER","ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403")
                ;
    }
}
