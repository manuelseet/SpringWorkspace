package sg.edu.iss.controller;

import java.util.ArrayList;

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
		ArrayList<Facility> flist = (ArrayList<Facility>) frepo.findAll();
		model.addAttribute("flist", flist);
		return "facilities";
	}
	
	@GetMapping("/add")
	public String addForm(Model model)
	{
		Facility f0 = new Facility();
		model.addAttribute("facility", f0);
		return "facilities-form";
	}
	
	@RequestMapping(value = "/save")
	public String saveFacility(@ModelAttribute("facility") @Valid Facility f1, 
			BindingResult bindingResult,  Model model) {
		if (bindingResult.hasErrors()) {
			return "facility-form";
		}
		frepo.saveAndFlush(f1);
		return "forward:/facility/list";
	}
	
	
	@RequestMapping("/delete/{id}")
	public String deleteFacility(@PathVariable("id") Integer id)
	{
		frepo.delete(frepo.findById(id).get());
		return "forward:/facility/list";
	}
	
}
