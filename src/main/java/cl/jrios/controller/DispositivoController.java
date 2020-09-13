package cl.jrios.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cl.jrios.exception.ModeloNotFoundException;
import cl.jrios.model.entity.Dispositivo;
import cl.jrios.model.service.DispositivoService;

@RestController
@RequestMapping("/dispositivos")
public class DispositivoController {

	@Autowired
	private DispositivoService service;

	@GetMapping
	public ResponseEntity<List<Dispositivo>> listar() {
		List<Dispositivo> lista = service.listar();
		return new ResponseEntity<List<Dispositivo>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Dispositivo> listarPorId(@PathVariable("id") Integer id) {
		Dispositivo dispo = service.leerPorId(id);
		if(dispo.getId() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Dispositivo>(dispo, HttpStatus.OK);
	}

//	@PostMapping
//	public ResponseEntity<Dispositivo> registrar(@RequestBody Dispositivo dispositivo) {
//		Dispositivo dispo =  service.registrar(dispositivo);
//		return new ResponseEntity<Dispositivo>(dispo, HttpStatus.CREATED);
//
//	}

	@PostMapping
	public ResponseEntity<Dispositivo> registrar(@RequestBody Dispositivo dispositivo) {
		Dispositivo dispo = service.registrar(dispositivo);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dispositivo.getId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping
	public ResponseEntity<Dispositivo> modificar(@RequestBody Dispositivo dispositivo) {
		Dispositivo dispo = service.modificar(dispositivo);
		return new ResponseEntity<Dispositivo>(dispo, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Dispositivo dispo = service.leerPorId(id);
		if(dispo.getId() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
