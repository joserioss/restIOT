package cl.jrios.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dispositivo_sensor")
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
