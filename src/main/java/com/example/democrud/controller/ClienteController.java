package com.example.democrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.democrud.model.Cliente;
import com.example.democrud.service.api.ClienteServiceAPI;

@Controller
@RequestMapping("/home")
public class ClienteController {

	@Autowired
	private ClienteServiceAPI clienteServiceAPI;

	@RequestMapping("/cliente")
	public String index(Model model) {
		model.addAttribute("list", clienteServiceAPI.getAll());
		return "index";
	}

	@GetMapping("/createCliente")
	public String create(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "save";
	}

	@GetMapping("/save/{id_cliente}")
	public String showSave(@PathVariable("id_cliente") Long id_cliente, Model model) {
		if (id_cliente != null && id_cliente != 0) {
			model.addAttribute("cliente", clienteServiceAPI.get(id_cliente));
		} else {
			model.addAttribute("cliente", new Cliente());
		}
		return "save";
	}

	@PostMapping("/saveCliente")
	public String save(Cliente cliente, Model model) {
		clienteServiceAPI.save(cliente);
		return "redirect:/home/";
	}

	@GetMapping("/delete/{id_cliente}")
	public String delete(@PathVariable Long id_cliente, Model model) {
		clienteServiceAPI.delete(id_cliente);

		return "redirect:/home/";
	}

}
