package sg.edu.iss.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.domain.Facility;
import sg.edu.iss.repo.FacilityRepository;

@Controller
@RequestMapping("/facility")
public class FacilityController {

	@Autowired
	FacilityRepository frepo;
	
	@GetMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("flist", frepo.findAll());
		return "facilities";
	}
	
	@GetMapping("/add")
	public String addForm(Model model)
	{
		Facility f0 = new Facility();
		model.addAttribute("facility", f0);
		return "facilities-form";
	}
	
	@PostMapping("/save")
	public String saveFacility(@ModelAttribute ("facility") @Valid Facility f1, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
			return "facility-form";
		}
		frepo.saveAndFlush(f1);
		return "forward:/facility/list";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteFacility(@PathVariable("id") Integer id, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
			return "facility-form";
		
		Facility f0 = frepo.findById(id).get();
		frepo.delete(f0);
		return "forward:/facility/list";
	}
	
}
