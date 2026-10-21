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
import org.springframework.web.bind.annotation.RequestParam;

import com.transportmgt.dto.BookingDTO;
import com.transportmgt.dto.TransportDTO;
import com.transportmgt.dto.UserDTO;
import com.transportmgt.form.BookingForm;
import com.transportmgt.service.BookingService;
import com.transportmgt.service.TransportService;
import com.transportmgt.service.UserService;
import com.transportmgt.utility.DataUtility;

@Controller
public class BookingCtl {

	@Autowired
	private BookingService service;

	@Autowired
	private TransportService transportService;

	@Autowired
	private UserService userService;

	@GetMapping("/booking")
	public String paymentpage(@ModelAttribute("form") BookingForm form, Model model, HttpSession session,
			@RequestParam("id") long id) {

		UserDTO user = (UserDTO) session.getAttribute("user");
		TransportDTO transport = transportService.findById(id);

		model.addAttribute("user", user);
		model.addAttribute("transport", transport);

		return "booking";
	}

	@PostMapping("/addBooking")
	public String add(@Valid @ModelAttribute("form") BookingForm form, BindingResult bindingResult, Model model,
			HttpSession session) {

		if (bindingResult.hasErrors()) {
			return "booking";
		} else {
			BookingDTO dto = form.getDTO();
			TransportDTO transport = transportService.findById(dto.getTransportId());
			long totalPrice = DataUtility.getLong(dto.getNumberOfHours()) * transport.getPrice();
			model.addAttribute("totalPrice", totalPrice);
			dto.setTotalPrice(totalPrice);
			dto.setStatus("Booked");
			if (!transport.isBookingStatus()) {
				service.Add(dto);
				transport.setBookingStatus(true);
				transportService.update(transport);
				model.addAttribute("success", "Booking Added successfully");
			} else {
				model.addAttribute("error", "This Transport is already booked.");
				return "booking";
			}

		}
		return "redirect:/payment";
	}

	@GetMapping("/bookinglist")
	public String list(@ModelAttribute("form") BookingForm form, Model model, HttpSession session) {
        UserDTO uDto = (UserDTO)session.getAttribute("user");
        
		List<BookingDTO> list = null;
		if(uDto ==null) {
			return "rediect:/home";
		}else {
				
        if(uDto.getUserRole().equals("Admin")) {
        	list = service.list();
        }else if(uDto.getUserRole().equals("Customer")) {
        	list = service.list().stream().filter(u -> u.getUserId() == uDto.getId()).collect(Collectors.toList());
        }
		model.addAttribute("list", list);
		}
		return "bookinglist";
		
	}
	
	
	
	@GetMapping("/cancelBooking")
	public String cancelBooking(@ModelAttribute("form") BookingForm form, Model model, HttpSession session, @RequestParam("id") long id) {
         BookingDTO bDto = service.findById(id);     
         bDto.setStatus("Canceled");
         service.update(bDto);
		List<BookingDTO> list = null;

		list = service.list();

		model.addAttribute("list", list);
		return "bookinglist";
	}

}
