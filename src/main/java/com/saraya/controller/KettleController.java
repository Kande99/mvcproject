package com.saraya.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.saraya.model.Kettle;
import com.saraya.service.KettleService;


@Controller
public class KettleController {

	@Autowired
	KettleService ks;
	//@Autowired
	//UserValidation uv;
	@RequestMapping(value="/list-kettle", method=RequestMethod.GET)
	public String ShowList(ModelMap model) {
		model.addAttribute("kettles", ks.getAllKettles());
		return "kettleList";
	}
	
	//------------------ADDING METHOD----------------------------
	
	@RequestMapping(value="/add-kettle", method=RequestMethod.GET)
			public String addKettleForm(ModelMap model) {
		model.addAttribute("ket", new Kettle());
		return "addKettle";
	}
	
	@RequestMapping(value="/add-kettle", method=RequestMethod.POST)
	public String kettleAdded(ModelMap model, @Valid @ModelAttribute("ket") Kettle k, BindingResult result) {
		if(result.hasErrors()) {
			return "addKettle";
		}
		ks.addKettle(k.getYear(), k.getMake(), k.getModel(), k.getImage());
		model.clear();
		return "redirect:/list-kettle";
	}
	
	//----------------------------------------------------------------
	
	
	
	//--------------UPDATE METHOD-----------------------------
	
	@RequestMapping(value="/update-kettle", method=RequestMethod.GET)
	public String updateKettleForm(ModelMap model, @RequestParam int id) {
		model.addAttribute("ket", ks.findById(id));
		return "addKettle";
	}
	//-------------------------------------------------
	@RequestMapping(value="/update-kettle", method=RequestMethod.POST)
	public String kettleListUpdate(ModelMap model, @Valid @ModelAttribute("ket") Kettle k,
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "addKettle";
		}
		
		ks.updateByKettle(k);
		model.clear();
		return "redirect:/list-kettle";
	}
	//-----------------------------------------------------
	
	@RequestMapping(value="/delete-kettle", method=RequestMethod.GET)
	public String deleteList(ModelMap model, @RequestParam int id ) {
		ks.deleteKettle(id);
		model.clear();
		return "redirect:/list-kettle";
		
	}
}