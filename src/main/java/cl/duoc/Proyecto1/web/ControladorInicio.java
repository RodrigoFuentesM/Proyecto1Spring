
package cl.duoc.Proyecto1.web;




import cl.duoc.Proyecto1.service.PersonaService;
import cl.duoc.Proyecto1.service.PersonaServiceImplementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j // Proviene de Lombok, nos permite agregar anotaciones de info y debug


public class ControladorInicio {
    
    @Autowired
    private PersonaService personaService; // Se llama a la interfaz pero en segundo plano trabaja el PersonaServiceImplementation
    /**
     * 
     * @param modelo es un objeto de tipo Model, que es muy similar 
     * a trbajar con HttpServeltRequest y HttpServletResponse, pero
     * es una dependencia de Spring que permite codificar menos
     * @return 
     */
    @GetMapping("/")
    public String inicio (Model modelo) {
        
        var personas = personaService.listarPersonas();
        modelo.addAttribute("personas", personas);
        return "index";
    }
    
}
