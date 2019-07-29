package co.grandcircus.mileagelab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MileageLabController {
	
	@RequestMapping("/") //index to homepage.
	public ModelAndView showIndex() {
		return new ModelAndView("index");
		
	}
	
	
	@RequestMapping("/mileage-form") // url path
	public ModelAndView showMileageForm() {
		return new ModelAndView("mileage-form");
	}
	
	@RequestMapping("/mileage-result")
	public ModelAndView showMileageResult(@RequestParam("mpg") double mpg, @RequestParam("gallons") double gallons) {
		
		double result = mpg * gallons;
		
		ModelAndView mv = new ModelAndView("mileage-result"); //non-url path
//		mav.setViewName("addition-result"); - or can do it this way
		mv.addObject("mpg", mpg);
		mv.addObject("gallons", gallons);
		mv.addObject("result", result);
		return mv;
	}
}