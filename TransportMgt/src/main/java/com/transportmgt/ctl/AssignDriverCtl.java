package com.transportmgt.ctl;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.transportmgt.dto.AssignDriverDTO;
import com.transportmgt.dto.TransportDTO;
import com.transportmgt.dto.UserDTO;
import com.transportmgt.form.AssignDriverForm;
import com.transportmgt.service.AssignDriverService;
import com.transportmgt.service.TransportService;
import com.transportmgt.service.UserService;


@Controller
public class AssignDriverCtl {
	
	
	@Autowired
	private AssignDriverService service;
	
	@Autowired
	private TransportService transportService;
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/assigndriver")
	public String paymentpage(@ModelAttribute("form")AssignDriverForm form, Model model) {
		
		List<TransportDTO> transportList = transportService.list();
		List<UserDTO> driverList = userService.list().stream().filter(uDto -> uDto.getUserRole().equals("Driver")).collect(Collectors.toList());
		
		model.addAttribute("transportList", transportList);
		model.addAttribute("driverList", driverList);
		return "assigndriver";
	}
	
	@PostMapping("/addAssigndriver")
	public String add(@Valid @ModelAttribute("form")AssignDriverForm form, BindingResult bindingResult, Model model, HttpSession session ) {

		
		if(bindingResult.hasErrors()) {
			return "assigndriver";
		}else {
			AssignDriverDTO dto = form.getDTO();
			
		long transportId = dto.getTransportId();
		TransportDTO tDto = transportService.findById(transportId);
		dto.setTransportNumber(tDto.getNumber());
		
		long driverId = dto.getDriverId();
		UserDTO uDto = userService.findUserById(driverId);
		dto.setDriverName(uDto.getFirstName());
			
		if(!uDto.isAssignStatus() && !tDto.isAssignStatus()) {
			service.Add(dto);
			uDto.setAssignStatus(true);
			userService.update(uDto);
			
			tDto.setAssignStatus(true);
			transportService.update(tDto);
			
			model.addAttribute("success", "Driver Assigned Successfully!");
		}else {
			model.addAttribute("error", "Select Driver or Truck is already Assigned..");
		}
		List<TransportDTO> transportList = transportService.list();
		List<UserDTO> driverList = userService.list().stream().filter(u -> u.getUserRole().equals("Driver")).collect(Collectors.toList());
		
		model.addAttribute("transportList", transportList);
		model.addAttribute("driverList", driverList);
			
		}
		return "assigndriver";
	}
	
	@GetMapping("/assigndriverlist")
	public String list(@ModelAttribute("form")AssignDriverForm form, Model model, HttpSession session) {
	
		UserDTO uDto = (UserDTO)session.getAttribute("user");
		
		List<AssignDriverDTO> list =null;
		if(uDto == null) {
			return "redirect:/home";
		}
	     if(uDto.getUserRole().equals("Admin")) {
			list = service.list();
	     }else {
	    	 list = service.list().stream().filter(a->a.getDriverId() == uDto.getId()).collect(Collectors.toList());
	     }
				 
        model.addAttribute("list", list);
		return "assigndriverlist";
	}


}
