package com.apap.tutorial3.controller;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial3.model.PilotModel;
import com.apap.tutorial3.service.PilotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/pilot/add")
	public String add(@RequestParam(value = "id", required = true) String id,
				@RequestParam(value = "licenseNumber", required = true) String licenseNumber,
				@RequestParam(value = "name", required = true) String name,
				@RequestParam(value = "flyHour", required = true) int flyHour) 
	{
		PilotModel pilot = new PilotModel(id, licenseNumber, name, flyHour);
		pilotService.addPilot(pilot);
		return "add";
	}
	
	@RequestMapping("/pilot/view")
	public String view(@RequestParam("licenseNumber") String licenseNumber, Model model) {
		PilotModel archive = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		
		model.addAttribute("pilot", archive);
		return "view-pilot";
	}
	
	@RequestMapping("/pilot/viewall")
	public String viewall(Model model) {
		List<PilotModel> archive = pilotService.getPilotList();
		model.addAttribute("listPilot", archive);
		
		return "viewall-pilot";
	}
	
	@RequestMapping("/pilot/view/license-number/{licenseNumber}")
	public String viewByPath(@PathVariable String licenseNumber, Model model) {
		PilotModel archive = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		if (archive == null) {
			return "error";
		}
		model.addAttribute("pilot", archive);
		return "view-pilot";
	}
	
	@RequestMapping("/pilot/error")
	public String error(){
		return "error";
	}
	
	@RequestMapping("/pilot/update/license-number/{licenseNumber}/fly-hour/{flyHour}")
	public String updateHour(@PathVariable String licenseNumber, @PathVariable int flyHour, Model model) {
		PilotModel archive = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		if (archive == null) {
			return "redirect/error";
		}
		archive.setFlyHour(flyHour);
		model.addAttribute("pilot", archive);
		return "update";
	}
	
	@RequestMapping("/pilot/delete/id/{id}")
	public String delete(@PathVariable String id, Model model) {
		if (pilotService.getPilotDetailByID(id) == null) {
			return "redirect/error";
		}
		pilotService.deletePilot(pilotService.getPilotDetailByID(id));
		return "delete";
	}
}
