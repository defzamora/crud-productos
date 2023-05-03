package com.example.demo.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;



@Controller
@RequestMapping("/productos") // http:localhost:8080/productos
public class ProductController {
	
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(Producto.class);

	@Autowired
	private ProductoRepository productoRepository;

	@GetMapping("")
	public String home(Model model) {

		model.addAttribute("productos", productoRepository.findAll());

		return "home";
	}
	
	@GetMapping("/create") // http:localhost:8080/create
	public String create() {
		return "create";
	}
	
	@PostMapping("/save")
	public String save( Producto producto) {
		
		logger.info("Informacio del objeto  producto, {}", producto);
		return "home";
	}
}
