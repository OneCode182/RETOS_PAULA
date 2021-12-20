
package usa.ciclo4.reto2.repositories;

import usa.ciclo4.reto2.models.User;
import usa.ciclo4.reto2.repositories.crud.UserInterface;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {
    
    @Autowired
    private UserInterface crudRepo;
    
    
    public User save(User user) {
        return crudRepo.save(user);
    }
    
    public List<User> getAll() {
        return (List<User>) crudRepo.findAll();
    }
    
    public Optional<User> getById(Integer id) {
        return crudRepo.findById(id);
    }
    
    public Optional<User> getByEmail(String email) {
        return crudRepo.findByEmail(email);
    }
    
    
    public Optional<User> getByEmailAndPassword(String email, String password) {
        return crudRepo.findByEmailAndPassword(email, password);
    }
    
    public List<User> getByNameOrEmail(String name, String email) {
        return crudRepo.findByNameOrEmail(name, email);
    }
    
    
    public void deleteById(Integer id) {
        crudRepo.deleteById(id);
    }
    
    
    
    
}


