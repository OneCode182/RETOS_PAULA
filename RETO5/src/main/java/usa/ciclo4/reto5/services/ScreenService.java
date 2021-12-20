
package usa.ciclo4.reto5.services;

import java.util.ArrayList;
import usa.ciclo4.reto5.models.Screen;
import usa.ciclo4.reto5.repositories.ScreenRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ScreenService {
    
    @Autowired
    private ScreenRepo repository;
    
    
    public Screen save(Screen product) {
        if (product.getBrand() == null || product.getCategory()== null ||
        product.getInches()== null || product.getResolution()== null ||
        product.getAspectRatio()== null || product.getDescription()== null || 
        product.getPrice()== 0.0 || product.getQuantity() == 0) {
            return product;
            
        } else {
            Optional<Screen> exist = repository.getByID(product.getId());
            
            if (exist.isEmpty()) {
                return repository.save(product);
                
            } return product;
            
        }
        
    }
    
    private boolean checkStrings(String string1, String string2) {
        return string1.indexOf(string2)>=0;
    }
    
    public List<Screen> findByDescription(String description2){
        List <Screen> items = repository.getAll();
        ArrayList<Screen> items2 = new ArrayList();
        for(Screen item: items){
            String descripcion1 = item.getDescription();
            
            if (checkStrings(descripcion1, description2)) {
                items2.add(item);
            }
            
        }
        
        return (List<Screen>) items2;
    }
    
    public List<Screen> findByPrice(double price){
        return  repository.findByPrice(price);
    }
    
    
    
    
    public List<Screen> getAll() {
        return repository.getAll();
    }
    
    public Screen getByID(Integer id) {
        Optional<Screen> exists = repository.getByID(id);
        if (exists.isPresent()) {
            return exists.get();
            
        } return new Screen();
    }
    
    public Screen update(Screen product){
        if(product.getId() != null){
            Optional<Screen> productExists = repository.getByID(product.getId());
            if(productExists.isPresent()){
                if(product.getBrand() != null){
                    productExists.get().setBrand(product.getBrand());
                }
                if(product.getCategory()!= null){
                    productExists.get().setCategory(product.getCategory());
                }
                if(product.getInches()!= null){
                    productExists.get().setInches(product.getInches());
                }
                if(product.getResolution()!= null){
                    productExists.get().setResolution(product.getResolution());
                }
                if(product.getAspectRatio()!= null){
                    productExists.get().setAspectRatio(product.getAspectRatio());
                }
                if(product.getDescription()!= null){
                    productExists.get().setDescription(product.getDescription());
                }
                if(true){
                    productExists.get().setAvailability(product.getAvailability());
                }
                if(true){
                    productExists.get().setPrice(product.getPrice());
                }
                if(true){
                    productExists.get().setQuantity(product.getQuantity());
                }
                if(product.getPhotography()!= null){
                    productExists.get().setPhotography(product.getPhotography());
                }
                
                return repository.save(productExists.get());
                
            } return product;
            
        } return product;
        
    }
    
    
    
    public void deleteById(Integer id) {
        Optional<Screen> exists = repository.getByID(id);
        if (exists.isPresent()) {
            repository.deleteById(id);
            
        }
        
    }
    
    
    
}


