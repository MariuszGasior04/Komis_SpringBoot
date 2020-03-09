
package pl.altkom.komis.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author mgasior
 */
@Entity
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "Brand is mandatory")
    @Column(name = "brand")
    private String brand;
    
    @NotBlank(message = "Type is mandatory")
    @Column(name = "type")
    private String type;
    
    @NotBlank(message = "Registration number is mandatory")
    @Column(name = "reg_nr")
    private String regNumber;
    
    @Column(name = "producion_year")
    private int year;
    
    @Column(name = "distance")
    private long distance;
    

    public Car() {
    }

    public Car(String brand, String type, String regNumber, int year, long distance) {
        this.brand = brand;
        this.type = type;
        this.regNumber = regNumber;
        this.year = year;
        this.distance = distance;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    
    @Override
    public String toString() {
        return regNumber + " - " + brand + " " + type;
    }
    
}
