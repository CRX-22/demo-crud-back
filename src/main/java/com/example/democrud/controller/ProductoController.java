package com.example.democrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.democrud.model.Producto;
import com.example.democrud.service.api.ProductoServiceAPI;

@Controller
@RequestMapping("/home")
public class ProductoController {

	@Autowired
	private ProductoServiceAPI productoServiceAPI;

	@RequestMapping("/producto")
	public String index(Model model) {
		model.addAttribute("list", productoServiceAPI.getAll());
		return "index";
	}

	@GetMapping("/createProducto")
	public String create(Model model) {
		model.addAttribute("producto", new Producto());
		return "save";
	}

	@GetMapping("/save/{id_producto}")
	public String showSave(@PathVariable("id_producto") Long id_producto, Model model) {
		if (id_producto != null && id_producto != 0) {
			model.addAttribute("producto", productoServiceAPI.get(id_producto));
		} else {
			model.addAttribute("producto", new Producto());
		}
		return "save";
	}

	@PostMapping("/saveProducto")
	public String save(Producto producto, Model model) {
		productoServiceAPI.save(producto);
		return "redirect:/home/";
	}

	@GetMapping("/delete/{id_producto}")
	public String delete(@PathVariable Long id_producto, Model model) {
		productoServiceAPI.delete(id_producto);

		return "redirect:/home/";
	}

}
