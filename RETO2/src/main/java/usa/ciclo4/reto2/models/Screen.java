
package usa.ciclo4.reto2.models;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "screens")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Screen {
    @Id
    private Integer id;
    private String brand;
    private String category;
    private String inches;
    private String resolution;
    private String aspectRatio;
    private String description;
    private boolean availability = true;
    private double price;
    private int quantity;
    private String photography;
    
    public boolean getAvailability() {
        return this.availability;
    }
    
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

}