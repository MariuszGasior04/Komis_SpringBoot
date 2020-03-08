
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
import pl.altkom.komis.repository.CarRepository;

/**
 *
 * @author mgasior
 */
@Controller
@RequestMapping("/cars/")
public class CarController {

    @Autowired
    private final CarRepository repo;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.repo = carRepository;
    }

    @RequestMapping("list")
    public String viewCar(Model model) {
        List<Car> listCars = repo.findAll();
        model.addAttribute("listCars", listCars);
        return "cars";
    }
    
    @GetMapping("new")
    public String showAddNewCarPage(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "new_car";
    }
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveCar(@ModelAttribute("car") Car car) {
        repo.save(car);
        return "redirect:/cars/list";
    }
    
    @RequestMapping("edit/{id}")
    public ModelAndView showEditCarPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("edit_car");
        Car car = repo.findById(id).get();
        mav.addObject("car", car);
        return mav;
    }

    @RequestMapping("delete/{id}")
    public String deleteCar(@PathVariable(name = "id") long id) {
        repo.deleteById(id);
        return "redirect:/cars/list";
    }
}
