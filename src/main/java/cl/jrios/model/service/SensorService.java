package cl.jrios.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.jrios.model.dao.ISensorRepo;
import cl.jrios.model.entity.Sensor;

@Service
public class SensorService {

	@Autowired
	private ISensorRepo repo;

	public Sensor registrar(Sensor obj) {
		return repo.save(obj);
	}

	public Sensor modificar(Sensor obj) {
		return repo.save(obj);
	}

	public List<Sensor> listar() {
		return repo.findAll();
	}

	public Sensor leerPorId(Integer id) {
		Optional<Sensor> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Sensor();
	}

	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
