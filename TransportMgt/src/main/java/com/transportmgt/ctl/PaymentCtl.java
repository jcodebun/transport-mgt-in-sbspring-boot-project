package com.transportmgt.ctl;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.transportmgt.dto.PaymentDTO;
import com.transportmgt.dto.UserDTO;
import com.transportmgt.form.PaymentForm;

import com.transportmgt.service.PaymentService;





@Controller
public class PaymentCtl {
	
	@Autowired
	private PaymentService service;
	
	@GetMapping("/payment")
	public String paymentpage(@ModelAttribute("form")PaymentForm form, Model model) {
		
		return "payment";
	}
	
	@PostMapping("/addPayment")
	public String add(@Valid @ModelAttribute("form")PaymentForm form, BindingResult bindingResult, Model model, HttpSession session ) {

		
		if(bindingResult.hasErrors()) {
			return "payment";
		}else {
			PaymentDTO dto = form.getDTO();
			
			UserDTO user = (UserDTO)session.getAttribute("user");
			dto.setEmail(user.getEmail());
			service.Add(dto);
			model.addAttribute("success", "Payment Done!");
		}
		return "payment";
	}
	
	@GetMapping("/paymentlist")
	public String list(@ModelAttribute("form")PaymentForm form, Model model, HttpSession session) {
		
		UserDTO user = (UserDTO) session.getAttribute("user");
		List<PaymentDTO> list =null;
		if(user.getUserRole().equals("User")) {
			list = service.list(user.getEmail());
		}else {
			list = service.list();
		}
		 
        model.addAttribute("list", list);
		return "paymentlist";
	}

}
