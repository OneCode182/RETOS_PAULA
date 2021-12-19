/** < - - - - - - - - {  } - - - - - - - - > */


package usa.ciclo4.reto1.repositories.crud;


import org.springframework.data.repository.CrudRepository;
import usa.ciclo4.reto1.models.User;




public interface UserInterface extends CrudRepository<User, Integer> {
    
    
}


