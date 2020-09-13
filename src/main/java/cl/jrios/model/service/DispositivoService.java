package cl.jrios.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.jrios.model.dao.IDispositivoRepo;
import cl.jrios.model.entity.Dispositivo;

@Service
public class DispositivoService {
	
	@Autowired
	private IDispositivoRepo repo;

	public Dispositivo registrar(Dispositivo dispo) {
		return repo.save(dispo);
	} 

	public Dispositivo modificar(Dispositivo dispo) {
		return repo.save(dispo);
	} 
	
	public List<Dispositivo> listar(){
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
