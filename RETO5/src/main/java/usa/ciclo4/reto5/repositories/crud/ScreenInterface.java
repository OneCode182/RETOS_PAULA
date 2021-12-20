

package usa.ciclo4.reto5.repositories.crud;

import java.util.List;
import usa.ciclo4.reto5.models.Screen;
import org.springframework.data.mongodb.repository.MongoRepository;





public interface ScreenInterface extends MongoRepository<Screen, Integer> {
    
    public List<Screen> findByPrice(double price);
    
}


