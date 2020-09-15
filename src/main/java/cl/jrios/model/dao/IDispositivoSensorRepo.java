package cl.jrios.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cl.jrios.model.entity.DispositivoSensor;

public interface IDispositivoSensorRepo extends JpaRepository<DispositivoSensor, Integer>{
	
	@Modifying
	@Query(value = "INSERT INTO dispositivo_sensor(id_dispositivo, id_sensor) VALUES (:idDispositivo, :idSensor)", nativeQuery = true)
	Integer registrar(@Param("idDispositivo") Integer idDispositivo, @Param("idSensor") Integer idSensor);
}
