
package cl.duoc.Proyecto1.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data // para poder Generar los Getter y Setter
@Entity
@Table(name="persona")
public class Persona implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idPersona; //idPersona es la identidad de la tabla/entidad de persona en la base de datos
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    
}
