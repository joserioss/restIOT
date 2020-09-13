package cl.jrios.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.jrios.model.entity.Dispositivo;

public interface IDispositivoRepo extends JpaRepository<Dispositivo, Integer>{

}
