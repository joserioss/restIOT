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
import cl.jrios.model.entity.Sensor;
import cl.jrios.model.service.SensorService;

@RestController
@RequestMapping("/sensores")
public class SensorController {

	@Autowired
	private SensorService service;

	@GetMapping
	public ResponseEntity<List<Sensor>> listar() {
		List<Sensor> lista = service.listar();
		return new ResponseEntity<List<Sensor>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Sensor> listarPorId(@PathVariable("id") Integer id) {
		Sensor obj = service.leerPorId(id);
		if (obj.getIdSensor() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Sensor>(obj, HttpStatus.OK);
	}

//	@PostMapping
//	public ResponseEntity<Sensor> registrar(@RequestBody Sensor sensor) {
//		Sensor obj =  service.registrar(sensor);
//		return new ResponseEntity<Sensor>(obj, HttpStatus.CREATED);
//
//	}

	@PostMapping
	public ResponseEntity<Sensor> registrar(@RequestBody Sensor sensor) {
		Sensor obj = service.registrar(sensor);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(sensor.getIdSensor()).toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping
	public ResponseEntity<Sensor> modificar(@RequestBody Sensor sensor) {
		Sensor obj = service.modificar(sensor);
		return new ResponseEntity<Sensor>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Sensor obj = service.leerPorId(id);
		if (obj.getIdSensor() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
