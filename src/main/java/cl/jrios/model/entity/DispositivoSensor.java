package cl.jrios.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(DispositivoSensorPK.class)
public class DispositivoSensor {
	@Id
	@Setter
	@Getter
	private Dispositivo dispositivo;
	@Id
	@Setter
	@Getter
	private Sensor sensor;
}
