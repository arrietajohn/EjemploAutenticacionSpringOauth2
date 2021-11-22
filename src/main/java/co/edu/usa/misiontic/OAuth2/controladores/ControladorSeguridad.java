package co.edu.usa.misiontic.OAuth2.controladores;

//import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jarri
 */
@RestController
public class ControladorSeguridad extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // /gastos
        http.antMatcher("/**").authorizeRequests()
                .antMatchers(new String[]{"/", "/sin-restriccion", "/saludo"}).permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
        http.cors().and().csrf().disable();

    }
}
