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
    public void createSomeData() {
        Car car1 = new Car("Opel", "Insignia", "KR8M321", 2018, 50000);
        Car car2 = new Car("Skoda", "Rapid", "KT2M000", 2020, 100);
        Car car3 = new Car("Honda", "Civic", "KT4K012", 2015, 20000);
        repoCar.save(car1);
        repoCar.save(car2);
        repoCar.save(car3);
        Client client1 = new Client("Jan Kowalski", "jk@gmail.com", 123456789);
        Client client2 = new Client("Anna Nowak", "an@gmail.com", 660660660);
        Client client3 = new Client("Adam Pan", "ap@gmail.com", 800800800);
        Client client4 = new Client("Tom Jerry", "tr@gmail.com", 663663663);
        repoClient.save(client1);
        repoClient.save(client2);
        repoClient.save(client3);
        repoClient.save(client4);
        Trip trip = new Trip(car3, client2, LocalDate.of(2020, 2, 20), LocalDate.of(2020, 2, 20), "Kraków-Tarnów-Kraków", 200, 0);
        Trip trip1 = new Trip(car1, client1, LocalDate.of(2020, 2, 21), LocalDate.of(2020, 2, 21), "Kraków-Wrocław-Kraków", 535, 0);
        Trip trip2 = new Trip(car3, client3, LocalDate.of(2020, 2, 23), LocalDate.of(2020, 2, 23), "Kraków-Tarnów-Kraków", 200, 0);
        Trip trip3 = new Trip(car2, client1, LocalDate.of(2020, 2, 24), LocalDate.of(2020, 2, 24), "Tarnów-Kraków", 90, 0);
        Trip trip4 = new Trip(car3, client2, LocalDate.of(2020, 2, 26), LocalDate.of(2020, 2, 26), "Kraków-Tarnów-Kraków", 200, 0);
        Trip trip5 = new Trip(car1, client2, LocalDate.of(2020, 2, 28), LocalDate.of(2020, 2, 28), "Kraków-Sanok-Kraków", 500, 40);
        Trip trip6 = new Trip(car3, client4, LocalDate.of(2020, 3, 2), LocalDate.of(2020, 3, 3), "Kraków-Warszawa-Kraków", 600, 40);
        Trip trip7 = new Trip(car1, client1, LocalDate.of(2020, 3, 4), LocalDate.of(2020, 3, 4), "Kraków-Poznań-Kraków", 920, 30);
        Trip trip8 = new Trip(car3, client2, LocalDate.of(2020, 3, 7), LocalDate.of(2020, 3, 7), "Kraków-Lublin-Kraków", 620, 0);
        Trip trip9 = new Trip(car1, client3, LocalDate.of(2020, 3, 8), LocalDate.of(2020, 3, 8), "Kraków-Warszawa-Kraków", 600, 0);
        Trip trip10 = new Trip(car3, client3, LocalDate.of(2020, 3, 9), LocalDate.of(2020, 3, 10), "Kraków-Rzeszów-Kraków", 335, 40);
        repoTrip.save(trip);
        repoTrip.save(trip1);
        repoTrip.save(trip2);
        repoTrip.save(trip3);
        repoTrip.save(trip4);
        repoTrip.save(trip5);
        repoTrip.save(trip6);
        repoTrip.save(trip7);
        repoTrip.save(trip8);
        repoTrip.save(trip9);
        repoTrip.save(trip10);
    }
}
