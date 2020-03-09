package pl.altkom.komis.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
@Controller
@RequestMapping("/trips/")
public class TripController {

    @Autowired
    private final TripRepository repoTrip;

    @Autowired
    private final CarRepository repoCar;
    
    @Autowired
    private final ClientRepository repoClient;

    @Autowired
    public TripController(TripRepository repoTrip, CarRepository repoCar, ClientRepository repoClient) {
        this.repoTrip = repoTrip;
        this.repoCar = repoCar;
        this.repoClient = repoClient;
    }

    @RequestMapping("list")
    public String viewTrips(Model model) {
        List<Trip> listTrip = repoTrip.findAll();
        model.addAttribute("listTrips", listTrip);
        return "trips";
    }

    @GetMapping("new")
    public String showAddNewTripPage(Model model) {
        Trip trip = new Trip();
        List<Client> listClient = repoClient.findAll();
        List<Car> listCar = repoCar.findAll();
        model.addAttribute("trip", trip);
        model.addAttribute("listCar", listCar);
        model.addAttribute("listClient", listClient);
        return "new_trip";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveTrip(@ModelAttribute("trip") Trip trip) {
        Car tripCar = trip.getCar();
        tripCar.setDistance(tripCar.getDistance() + trip.getDistance());
        repoCar.save(tripCar);
        repoTrip.save(trip);
        return "redirect:/trips/list";
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateTrip(@ModelAttribute("trip") Trip trip) {
        Car tripCar = trip.getCar();
        Trip updatedTrip = repoTrip.getOne(trip.getId());
        tripCar.setDistance(tripCar.getDistance() + trip.getDistance() - updatedTrip.getDistance());
        
        repoCar.save(tripCar);
        repoTrip.save(trip);
        return "redirect:/trips/list";
    }


    @RequestMapping("edit/{id}")
    public ModelAndView showEditTripPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("edit_trip");
        Trip trip = repoTrip.findById(id).get();
        List<Client> listClient = repoClient.findAll();
        List<Car> listCar = repoCar.findAll();
        mav.addObject("listClient",listClient);
        mav.addObject("listCar", listCar);       
        mav.addObject("trip", trip);
        
        return mav;
    }

    @RequestMapping("delete/{id}")
    public String deleteTrip(@PathVariable(name = "id") long id) {
        repoTrip.deleteById(id);
        return "redirect:/trips/list";
    }

}
