package com.example.demo.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Producto;
import com.example.demo.repository.FacturaRepository;
import com.example.demo.repository.ProductoRepository;

@Controller
@RequestMapping("/productos") // http:localhost:8080/productos
public class ProductController {

	private final org.slf4j.Logger log = LoggerFactory.getLogger(Producto.class);

	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private FacturaRepository facturaRepository;

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
	public String save(Producto producto) {

		log.info("Informacio del objeto  producto, {}", producto);
		productoRepository.save(producto);
		return "redirect:/productos";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {

		Producto producto = productoRepository.getOne(id);
		log.info("Objeto recuperado, {}", producto);
		model.addAttribute("producto", producto);

		return "edit";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {

		Producto producto = productoRepository.getOne(id);
		log.info("Objeto eliminado, {}", producto);
		productoRepository.delete(producto);

		return "redirect:/productos";
	}

	@GetMapping("/factura") // http:localhost:8080/factura
	public String factura(Model model) {
		
		model.addAttribute("facturas", facturaRepository.findAll());
		
		return "factura";
	}
}
