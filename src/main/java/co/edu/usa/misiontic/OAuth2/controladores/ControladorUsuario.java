
package co.edu.usa.misiontic.OAuth2.controladores;

import java.util.Collections;
import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jarri
 */
@RestController

public class ControladorUsuario {

     @GetMapping("/")
    public String helloWorld() {
        return "no es necesario estar conectado";
    }

    @GetMapping("/sin-restriccion")
    public String notRestricted() {
       return "no es necesario estar conectado";
    }
    
    @GetMapping("/saludo")
    public String saludar() {
       return "hola te saludo sin iniciar sesion";
    }
    
    @GetMapping("/saludo-seguro")
    public String saludar2(@AuthenticationPrincipal OAuth2User principal) {
       return "hola "+principal.getAttribute("name");
    }

    @GetMapping("/restringido")
    public Map<String, Object> restricted(@AuthenticationPrincipal OAuth2User principal) {
        // return principal.getAttributes(); 
        return  principal.getAttributes();
    }

}
