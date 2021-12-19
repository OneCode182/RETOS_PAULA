/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo4.reto1.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import usa.ciclo4.reto1.services.UserService;
import usa.ciclo4.reto1.models.User;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class UserWeb {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private UserService servicios;
    
    /** < - - - - - - - - { Metodos } - - - - - - - - >
     * @param usuario
     * @return  */
    
    // POST NEW USER
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User usuario) {
        return servicios.save(usuario);
    }
    
    // GET JSON USERS
    @GetMapping("/all")
    public List<User> getUsers() {
        return servicios.getAll();
    }
    
    // GET BOOLEAN USER
    @GetMapping("/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return servicios.emailExists(email);
    }
    
    // < DELETE - ALL >
    @DeleteMapping("/deleteAll")
    public boolean deleteAll() {
        return servicios.deleteAll();
    } 
    
    // GET JSON USER
    @GetMapping("/{email}/{password}")
    public User emailExists(@PathVariable("email") String email,
    @PathVariable("password") String password) {
        String[] data = new String[] {
            email,
            password
        };
        return servicios.getUser(data);
    }
    
}

