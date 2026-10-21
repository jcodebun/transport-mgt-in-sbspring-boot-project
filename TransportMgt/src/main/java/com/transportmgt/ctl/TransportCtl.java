package com.transportmgt.ctl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.transportmgt.dto.TransportDTO;
import com.transportmgt.exception.RecordNotFoundException;
import com.transportmgt.form.TransportForm;
import com.transportmgt.service.TransportService;



@Controller
public class TransportCtl {
	
	@Autowired
	public  TransportService service;
	
	@GetMapping("/transport")
	public String transport(@ModelAttribute("form")TransportForm form, Model model) {

		return "transport";
	}

	@PostMapping("/addTransport")
	public String Add(@RequestParam(value = "image") MultipartFile image, @Valid @ModelAttribute("form")TransportForm form,  BindingResult bindingResult, Model model) throws IOException {

		System.out.println("form: "+form);
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "transport";
		}else {
			TransportDTO bean = form.getDTO();			
			bean.setImage(image.getBytes());
			
			if(form.getId()>0) {
				service.update(bean);
				model.addAttribute("success", "Transport Updated successfully");
			}else {
			bean.setAssignStatus(false);
			bean.setBookingStatus(false);
			service.Add(bean);
			model.addAttribute("success", "Transport Added successfully");
			}
			
			return "transport";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "transport";
		}
	}
	
	@GetMapping("/transportList")
	public String list(@ModelAttribute("form")TransportForm form, Model model){
	List<TransportDTO> list = service.list();
	model.addAttribute("list", list);
	return "transportlist";
		
	}
	
	@GetMapping("/markAvailable")
	public String list(@ModelAttribute("form")TransportForm form, Model model, @RequestParam("id") long id){
     TransportDTO tDto = service.findById(id);
     tDto.setBookingStatus(false);
     service.update(tDto);
	List<TransportDTO> list = service.list();
	model.addAttribute("list", list);
	return "transportlist";
		
	}
	
	
	
	
	@GetMapping("/transportEdit")	
	public String update(@ModelAttribute("form")TransportForm form, Model model, @RequestParam("id") long id ){
		TransportDTO bean = service.findById(id);
		form.populate(bean);
		model.addAttribute("bean",bean);	
		return "transport";
	}
	
	@GetMapping("/transportDelete")	
	public String delete(@ModelAttribute("form")TransportForm form, Model model, @RequestParam("id") long id ) throws Exception{
		service.delete(id);	
		
		List<TransportDTO> list =	service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "Transport Deleted successfully");
		return "transportlist";
	}
	
	
	

	@GetMapping("/getTransportImage/{id}")
	public void getNewsImage(HttpServletResponse response, @PathVariable("id") long id) throws Exception {
		response.setContentType("image/jpeg");		
		Blob blb=service.getImageById(id);				
		byte[] bytes = blb.getBytes(1, (int) blb.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	
	}
	

}
