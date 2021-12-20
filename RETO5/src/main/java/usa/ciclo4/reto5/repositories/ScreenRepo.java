
package usa.ciclo4.reto5.repositories;

import usa.ciclo4.reto5.models.Screen;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo4.reto5.repositories.crud.ScreenInterface;


@Repository
public class ScreenRepo {
    
    @Autowired
    private ScreenInterface crudRepo;
    
    
    public Screen save(Screen product) {
        return crudRepo.save(product);
    }
    
    public List <Screen> findByPrice (double price){
        return  crudRepo.findByPrice(price);
    }
    
    public List<Screen> getAll() {
        return (List<Screen>) crudRepo.findAll();
    }
    
    
    public Optional<Screen> getByID(Integer id) {
        return crudRepo.findById(id);
    }
    
    
    public void deleteById(Integer id) {
        crudRepo.deleteById(id);
    }
    
    
    
    
}


