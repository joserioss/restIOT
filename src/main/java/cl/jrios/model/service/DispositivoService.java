package cl.jrios.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.jrios.model.dao.IDispositivoRepo;
import cl.jrios.model.dao.IDispositivoSensorRepo;
import cl.jrios.model.dto.DispositivosListaSensoresDto;
import cl.jrios.model.entity.Dispositivo;

@Service
public class DispositivoService {

	@Autowired
	private IDispositivoRepo repo;

	@Autowired
	private IDispositivoSensorRepo dsRepo;

	public Dispositivo registrar(Dispositivo obj) {
		return repo.save(obj);
	}

	@Transactional
	public Dispositivo registrarTransaccional(DispositivosListaSensoresDto dto) {
		repo.save(dto.getDispositivo());
		dto.getListaSensores()
				.forEach(ex -> dsRepo.registrar(dto.getDispositivo().getIdDispositivo(), ex.getIdSensor()));

		return dto.getDispositivo();
	}

	public Dispositivo modificar(Dispositivo obj) {
		return repo.save(obj);
	}

	public List<Dispositivo> listar() {
		return repo.findAll();
	}

	public Dispositivo leerPorId(Integer id) {
		Optional<Dispositivo> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Dispositivo();
	}

	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
