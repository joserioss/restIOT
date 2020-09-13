package cl.jrios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.jrios.model.entity.Dispositivo;
import cl.jrios.model.service.DispositivoService;

@RestController
@RequestMapping("/dispositivos")
public class DispositivoController {

	@Autowired
	private DispositivoService service;

	@GetMapping
	public List<Dispositivo> listar() {
		return service.listar();
	}

	@GetMapping("/{id}")
	public Dispositivo listarPorId(@PathVariable("id") Integer id) {
		return service.leerPorId(id);
	}

	@PostMapping
	public Dispositivo registrar(@RequestBody  Dispositivo dispo) {
		return service.registrar(dispo);
	}
	
	@PutMapping
	public Dispositivo modificar(@RequestBody Dispositivo dispo) {
		return service.modificar(dispo);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
	}
}
