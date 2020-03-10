/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom.komis.report;

import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import pl.altkom.komis.entity.Car;
import pl.altkom.komis.entity.Trip;

/**
 *
 * @author mgasior
 */
public class CarReport {
    
    private Car car;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;
    private List<Trip> reportData;
    private Long sumDistance;
    private double sumRefuel;

    public CarReport() {
    }

    public CarReport(List<Trip> reportData, Car car, LocalDate date) {
        this.reportData = reportData;
        this.car = car;
        this.date = date;
        
        this.sumDistance = reportData
                .stream()
                .mapToLong(t->t.getDistance())
                .sum();
        
        this.sumRefuel = reportData
                .stream()
                .mapToDouble(t->t.getRefuel())
                .sum();
    }          

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Trip> getReportData() {
        return reportData;
    }

    public void setReportData(List<Trip> reportData) {
        this.reportData = reportData;
    }

    public Long getSumDistance() {
        return sumDistance;
    }

    public void setSumDistance(Long sumDistance) {
        this.sumDistance = sumDistance;
    }

    public double getSumRefuel() {
        return sumRefuel;
    }

    public void setSumRefuel(double sumRefuel) {
        this.sumRefuel = sumRefuel;
    }
  
    

}
