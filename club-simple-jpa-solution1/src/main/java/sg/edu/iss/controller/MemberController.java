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

import sg.edu.iss.domain.Member;
import sg.edu.iss.repo.MemberRepository;

@Controller
@RequestMapping("/member")
public class MemberController {

	
	@Autowired
	MemberRepository mrepo;
	
	@GetMapping("/list")
	public String list(Model model) {
		return "members";
	}
	
	@GetMapping("/add")
	public String addForm(Model model)
	{
		return "member-form";
	}
	
	@PostMapping("/save")
	public String saveFacility(@ModelAttribute("member") @Valid Member m1, BindingResult bindingresult)
	{
		if (bindingresult.hasErrors())
			return "member-form";
		
		mrepo.saveAndFlush(m1);
		return "forward:/member/list";
	}
	
	@PostMapping("/delete")
	public String deleteMember(@PathVariable("id") Integer id, BindingResult bindingresult)
	{
		if (bindingresult.hasErrors())
			return "member-form";
		
		mrepo.delete(mrepo.findById(id).get());
		return "forward:/member/list";
		
		
	}
	
}
