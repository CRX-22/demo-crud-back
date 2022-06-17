package com.example.democrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.democrud.model.Detalle;
import com.example.democrud.service.api.DetalleServiceAPI;

@Controller
@RequestMapping("/home")
public class DetalleController {

	@Autowired
	private DetalleServiceAPI detalleServiceAPI;

	@RequestMapping("/detalle")
	public String index(Model model) {
		model.addAttribute("list", detalleServiceAPI.getAll());
		return "index";
	}

	@GetMapping("/createDetalle")
	public String create(Model model) {
		model.addAttribute("detalle", new Detalle());
		return "save";
	}

	@GetMapping("/save/{num_detalle}")
	public String showSave(@PathVariable("num_detalle") Long num_detalle, Model model) {
		if (num_detalle != null && num_detalle != 0) {
			model.addAttribute("detalle", detalleServiceAPI.get(num_detalle));
		} else {
			model.addAttribute("detalle", new Detalle());
		}
		return "save";
	}

	@PostMapping("/saveDetalle")
	public String save(Detalle detalle, Model model) {
		detalleServiceAPI.save(detalle);
		return "redirect:/home/";
	}

	@GetMapping("/delete/{num_detalle}")
	public String delete(@PathVariable Long num_detalle, Model model) {
		detalleServiceAPI.delete(num_detalle);

		return "redirect:/home/";
	}

}
