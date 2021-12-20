
package usa.ciclo4.reto2.services;

import usa.ciclo4.reto2.models.User;
import usa.ciclo4.reto2.repositories.UserRepo;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    
    @Autowired
    private UserRepo repository;
    
    
    
    
    public User save(User user) {
        if (user.getIdentification() == null || user.getName()== null || 
        user.getAddress()== null || user.getType()== null ||
        user.getCellPhone()== null || user.getEmail()== null ||
        user.getPassword()== null || user.getZone()== null) {
            return user;
            
        } else {
            Optional<User> exist = repository.getById(user.getId());
            if (exist.isEmpty()) {
                return repository.save(user);
                
            } return new User();
            
        }
        
    }
    
    
    public List<User> getAll() {
        return repository.getAll();
    }
    
    // < GET - BY ID >
    public User getById(Integer id) {
        Optional<User> user = repository.getById(id);
        if (user.isPresent()) {
            return user.get();
            
        } return new User();
    }
    
    
    public boolean getEmailExists(String email) {
        return repository.getByEmail(email).isPresent();
    }
    
    public User getUserByEmail(String email) {
        Optional<User> exists = repository.getByEmail(email);
        
        if (exists.isPresent()) {
            return exists.get();
            
        } return new User();
        
    }
    
    public boolean getEmailAndPasswordExists(String email, String password) {
        return repository.getByEmailAndPassword(email, password).isPresent();   
    }
    
    public User getUserByEmailAndPassword(String email, String password) {
        Optional<User> user = repository.getByEmailAndPassword(email, password);
        
        if (user.isPresent()) {
            return user.get();
            
        } return new User();
        
    }
    
    
    
    public User update(User user){
        if(user.getId()!=null){
            Optional<User> userExist = repository.getById(user.getId());
            if(userExist.isPresent()){
                if(user.getIdentification()!=null){
                    userExist.get().setIdentification(user.getIdentification());
                }
                if(user.getName()!=null){
                    userExist.get().setName(user.getName());
                }
                if(user.getAddress()!=null){
                    userExist.get().setAddress(user.getAddress());
                }
                if(user.getCellPhone()!=null){
                    userExist.get().setCellPhone(user.getCellPhone());
                }
                if(user.getEmail()!=null){
                    userExist.get().setEmail(user.getEmail());
                }
                if(user.getPassword()!=null){
                    userExist.get().setPassword(user.getPassword());
                }
                if(user.getZone()!=null){
                    userExist.get().setZone(user.getZone());
                }
                if(user.getType()!=null){
                    userExist.get().setType(user.getType());
                }
                return repository.save(userExist.get());
                
            } return user;
            
        } return user;
        
    }
    
    
    public void deleteById(Integer id) {
        Optional<User> user = repository.getById(id);
        if (user.isPresent()) {
            repository.deleteById(id);
        }
        
    }
    
    
}


