package com.example.democrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.democrud.model.Factura;
import com.example.democrud.service.api.FacturaServiceAPI;

@Controller
@RequestMapping("/home")
public class FacturaController {

	@Autowired
	private FacturaServiceAPI facturaServiceAPI;

	@RequestMapping("/factura")
	public String index(Model model) {
		model.addAttribute("list", facturaServiceAPI.getAll());
		return "index";
	}

	@GetMapping("/createFactura")
	public String create(Model model) {
		model.addAttribute("factura", new Factura());
		return "save";
	}

	@GetMapping("/save/{num_factura}")
	public String showSave(@PathVariable("num_factura") Long num_factura, Model model) {
		if (num_factura != null && num_factura != 0) {
			model.addAttribute("factura", facturaServiceAPI.get(num_factura));
		} else {
			model.addAttribute("factura", new Factura());
		}
		return "save";
	}

	@PostMapping("/saveFactura")
	public String save(Factura factura, Model model) {
		facturaServiceAPI.save(factura);
		return "redirect:/home/";
	}

	@GetMapping("/delete/{num_factura}")
	public String delete(@PathVariable Long num_factura, Model model) {
		facturaServiceAPI.delete(num_factura);

		return "redirect:/home/";
	}

}
