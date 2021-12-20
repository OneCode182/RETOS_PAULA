

package usa.ciclo4.reto5.controller;

import usa.ciclo4.reto5.models.Order;
import usa.ciclo4.reto5.services.OrderService;


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
@RequestMapping("/order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class OrderWeb {
    
    @Autowired
    private OrderService services;
    
    // -< 2 >-
    
    // -< 3 >-
    
    @GetMapping("/zona/{zone}")
    public List<Order> getByUserZone(@PathVariable("zone") String zone) {
        return services.getUsersByZone(zone);
    }
    
    
     // -< 4 >-
    
    @GetMapping("/salesman/{id}")
    public List<Order> getByUserId(@PathVariable("id") Integer id) {
        return services.getUsersById(id);
    }
    
    @GetMapping("/state/{status}/{id}")
    public List<Order> getByStatusAndUserId(@PathVariable("status") String status,@PathVariable("id") Integer id) {
        return services.getByStatusAndByUserId(status, id);
    }
    
    @GetMapping("/date/{date}/{id}")
    public List<Order> getByDateAndUserId(@PathVariable("date") String date, @PathVariable("id") Integer id) {
        return services.ordersSalesManByDate(date, id);
    }
    
     // -< 5 >-
    
    // -< X >-
    

    

    
    
    @GetMapping("/getByStatus/{status}")
    public List<Order> getByStatus(@PathVariable("status") String status) {
        return services.getOrderByStatus(status);
    }

    
    
    @GetMapping("/getByDate/{date}")
    public List<Order> getByDate(@PathVariable("date") String date) {
        return services.getByDate(date);
    }
    
    
    // -< Z >-
    
    @GetMapping("/all")
    public List<Order> getAll() {
        return services.getAll();
    }
    
    @GetMapping("/{id}")
    public Order getById(@PathVariable("id") Integer id) {
        return services.getByID(id);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order) {
        return services.save(order);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order) {
        return services.update(order);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") int id) {
        services.deleteById(id);
    } 
    



}

