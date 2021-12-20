
package usa.ciclo4.reto5.controller;

import usa.ciclo4.reto5.models.Screen;
import usa.ciclo4.reto5.services.ScreenService;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/screen")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ScreenWeb {
    
    @Autowired
    private ScreenService services;
    
    // -< 2 >-
    
    // -< 3 >-
    
    // -< 4 >-
    
    // -< 5 >-
    
    @GetMapping("/price/{price}")
    public List<Screen> findByPrice(@PathVariable("price") double price) {
        return services.findByPrice(price);
    }
    
    @GetMapping("/description/{description}")
    public List<Screen> findByDescription(@PathVariable("description") String description) {
        return services.findByDescription(description);
    }  
    
    
    // -< X >-
    
    
    
    
    
    
    // -< Z >-
    
    
    @GetMapping("/all")
    public List<Screen> getAll() {
        return services.getAll();
    }
    
    @GetMapping("/{id}")
    public Screen getUserByID(@PathVariable("id") Integer id) {
        return services.getByID(id);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Screen save(@RequestBody Screen clone) {
        return services.save(clone);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Screen update(@RequestBody Screen clone) {
        return services.update(clone);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") int id) {
        services.deleteById(id);
    } 
    
    
}

