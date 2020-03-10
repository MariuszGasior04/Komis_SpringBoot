package pl.altkom.komis.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.altkom.komis.entity.Car;
import pl.altkom.komis.entity.Trip;
import pl.altkom.komis.report.CarReport;
import pl.altkom.komis.repository.TripRepository;

/**
 *
 * @author mgasior
 */
@Service
public class CarReportFactory {

    @Autowired
    private final TripRepository repoTrip;
  
    @Autowired
    public CarReportFactory(TripRepository repoTrip) {
        this.repoTrip = repoTrip;
    }

    public CarReport createMonthReport(Car car, LocalDate date) {
        List<Trip> reportData = repoTrip.findAll()
                .stream()
                .filter(t -> t.getCar().equals(car) && t.getEndDate().getMonth().equals(date.getMonth()))
                .collect(Collectors.toList());
        CarReport report = new CarReport(reportData, car, date);
        return report;
    }
}
