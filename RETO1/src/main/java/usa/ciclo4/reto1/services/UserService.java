/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo4.reto1.services;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo4.reto1.models.User;
import usa.ciclo4.reto1.repositories.UserRepo;



@Service
public class UserService {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    @Autowired
    private UserRepo metodosCrud;
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    
    // < SAVE JSON USER >
    public User save(User user) {
        return metodosCrud.save(user);
    }
    
    // < GET COMPLETO >
    public List<User> getAll() {
        return deleteNoDefined();
    }
    
    // < DELETE - ALL >
    public boolean deleteAll() {
        try {
            metodosCrud.deleteAll();
            return true;
            
        } catch (Exception e) {
            return false;
            
        }
        
    }
    
    // < GET BOOL EMAIL >
    public boolean emailExists(String email) {
        Iterable<User> repo = deleteNoDefined();
        
        for (User usuario : repo) {
            if (usuario.getEmail().equals(email)) {
                return true;
                
            }
            
        } return false;
        
    }
    
    
    // < GET JSON USER >
    public User getUser(String[] datos) {
        Iterable<User> repo = deleteNoDefined();
        
        for (User usuario : repo) {
            if (usuario.getEmail().equals(datos[0]) &&
            usuario.getPassword().equals(datos[1])) {
                return usuario;
                
            } 
            
        } 
        
        return new User(
            null,
            datos[0],
            datos[1],
            "NO DEFINIDO"
        );
        
    }
    
    // < DELETE NO DEFINED USERS >
    public List<User> deleteNoDefined() {
        Iterable<User> repo = metodosCrud.exists();
        
        for (User usuario : repo) {
            Integer idUser = usuario.getId();
            String nameUser = usuario.getName();
            
            if (idUser == null && nameUser.equals("NO DEFINIDO")) {
                metodosCrud.delete(usuario);
            } 
            
        }  return metodosCrud.getAll();
        
    }
    
    
    
    
    
    
}


/**
    public boolean userExists(String[] datos) {
        Iterable<User> usuarios = metodosCrud.exists();
        
        for (User usuario : usuarios) {
            if (usuario.getEmail().equals(datos[0]) &&
            usuario.getPassword().equals(datos[1])) {
                return true;
                
            }
            
        } return false;
        
    }
    */


