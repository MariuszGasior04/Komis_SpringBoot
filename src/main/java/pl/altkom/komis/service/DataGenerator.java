
package pl.altkom.komis.service;

import java.time.LocalDate;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.altkom.komis.entity.Car;
import pl.altkom.komis.entity.Client;
import pl.altkom.komis.entity.Trip;
import pl.altkom.komis.repository.CarRepository;
import pl.altkom.komis.repository.ClientRepository;
import pl.altkom.komis.repository.TripRepository;

/**
 *
 * @author mgasior
 */
@Service
public class DataGenerator {

    @Autowired
    private final TripRepository repoTrip;

    @Autowired
    private final CarRepository repoCar;
    
    @Autowired
    private final ClientRepository repoClient;

    @Autowired
    public DataGenerator(TripRepository repoTrip, CarRepository repoCar, ClientRepository repoClient) {
        this.repoTrip = repoTrip;
        this.repoCar = repoCar;
        this.repoClient = repoClient;
    }

    @PostConstruct
    public void createSomeData(){
        Car car1= new Car();
        Car car2= new Car();
        Car car3= new Car();
        car1.setId(1);
        car1.setBrand("Opel");
        car1.setType("Insignia");
        car1.setRegNumber("KR8M321");
        car1.setYear(2018);
        car1.setDistance(50000);
        car2.setId(2);
        car2.setBrand("Skoda");
        car2.setType("Rapid");
        car2.setRegNumber("KT2M000");
        car2.setYear(2020);
        car2.setDistance(100);
        car3.setId(3);
        car3.setBrand("Honda");
        car3.setType("Civic");
        car3.setRegNumber("KT4K012");
        car3.setYear(2015);
        car3.setDistance(200000);
       repoCar.save(car1);
       repoCar.save(car2);
       repoCar.save(car3);
       Client client1 = new Client();
       Client client2 = new Client();
       client1.setId(1);
       client1.setName("Jan Kowalski");
       client1.setMail("jk@gmail.com");
       client1.setPhoneNumber(123456789);
       client2.setId(2);
       client2.setName("Anna Nowak");
       client2.setMail("an@gmail.com");
       client2.setPhoneNumber(660660660);
       repoClient.save(client1);
       repoClient.save(client2);
       
//       Trip trip1 = new Trip();
//       trip1.setId(1);
//       trip1.setCar(car3);
//       trip1.setClient(client2);
//       trip1.setDestination("Kraków-Tarnów-Kraków");
//       trip1.setDistance(205);
//       trip1.setStartDate(LocalDate.of(2020,2,2));
//       trip1.setEndDate(LocalDate.of(2020,2,2));
//       trip1.setRefuel(0.0);
//       repoTrip.save(trip1);
       
    }
}
