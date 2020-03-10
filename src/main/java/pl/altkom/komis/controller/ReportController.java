/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom.komis.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.altkom.komis.entity.Car;
import pl.altkom.komis.report.CarReport;
import pl.altkom.komis.repository.CarRepository;
import pl.altkom.komis.service.CarReportFactory;

/**
 *
 * @author mgasior
 */
@Controller
@RequestMapping("/reports/")
public class ReportController {

    @Autowired
    private final CarReportFactory carReportFactory;

    @Autowired
    private final CarRepository repoCar;
    
    @Autowired
    public ReportController(CarReportFactory carReportFactory, CarRepository repoCar) {
        this.carReportFactory = carReportFactory;     
        this.repoCar = repoCar;
    }

    @RequestMapping("car_month")
    public String reportParams(Model model) {
        List<Car> listCar = repoCar.findAll();
        CarReport report = new CarReport();
        model.addAttribute("listCar", listCar);
        model.addAttribute("report", report);
        return "chose_report_params";
    }

    @RequestMapping(value = "car_month_report_params", method = RequestMethod.POST)
    public ModelAndView showMonthReport(@ModelAttribute("report") CarReport report) {
        ModelAndView mav = new ModelAndView("car_month_report");
        CarReport carReport = carReportFactory.createMonthReport(report.getCar(), report.getDate());
        mav.addObject("carReport", carReport);
        mav.addObject("car", report.getCar());
        mav.addObject("month", report.getDate().getMonth().toString());
        mav.addObject("year", String.valueOf(report.getDate().getYear()));
        return mav;
    }

}
