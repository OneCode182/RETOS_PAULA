
package usa.ciclo4.reto5.repositories;

import usa.ciclo4.reto5.models.Order;
import usa.ciclo4.reto5.repositories.crud.OrderInterface;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class OrderRepo {
    
    @Autowired
    private OrderInterface crudRepo;
    
    
    public Order save(Order order) {
        return crudRepo.save(order);
    }
    
    public List<Order> getAll() {
        return crudRepo.findAll();
    }
    
    public Optional<Order> getById(Integer id) {
        return crudRepo.findById(id);
    }
    
    public List<Order> getUserByZone(String zone) {
        return crudRepo.findByUserZone(zone);
    }

    public List<Order> getByUserId(Integer id) { 
        return crudRepo.findByUserId(id);
    }
    
    public List<Order> getByStatus(String status) {
        return crudRepo.findByStatus(status);
    }
    
    public void deleteById(Integer id) {
        crudRepo.deleteById(id);
    }
    




}


