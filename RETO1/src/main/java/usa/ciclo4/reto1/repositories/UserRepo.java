/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo4.reto1.repositories;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo4.reto1.models.User;
import usa.ciclo4.reto1.repositories.crud.UserInterface;


@Repository
public class UserRepo {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private UserInterface crud;
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    // GET ALL USERS
    public List<User> getAll() {
        return (List<User>) crud.findAll();
    }
    
    // GET BOOLEAN IF USER EXISTS
    public Iterable<User> exists() {
        return (Iterable<User>) getAll();
    }
    
    // POST NEW USER
    public User save(User user) {
        return crud.save(user);
    }
    
    // DELETE USER BY ID
    public void delete(User user) {
        crud.delete(user);
    }
    
    // DELETE ALL
    public void deleteAll() {
        crud.deleteAll();
    }
    
    
}


