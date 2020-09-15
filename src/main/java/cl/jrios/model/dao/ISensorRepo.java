package cl.jrios.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.jrios.model.entity.Sensor;

public interface ISensorRepo extends JpaRepository<Sensor, Integer>{

}
