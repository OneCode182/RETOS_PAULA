

package usa.ciclo4.reto5.repositories.crud;

import usa.ciclo4.reto5.models.User;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserInterface extends MongoRepository<User, Integer> {
    
    public List<User> findByNameOrEmail(String name, String email);
    
    public Optional<User> findByEmail(String email);
    
    public Optional<User> findByEmailAndPassword(String email, String password);
    
    public List <User> findByMonthBirthtDay (String birthday);
    
}


