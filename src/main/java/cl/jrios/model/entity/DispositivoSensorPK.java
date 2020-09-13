package cl.jrios.model.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class DispositivoSensorPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8831190228063915626L;

	@ManyToOne
	@JoinColumn(name = "id_dispositivo", nullable = false)
	private Dispositivo dispositivo;

	@ManyToOne
	@JoinColumn(name = "id_sensor", nullable = false)
	private Sensor sensor;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dispositivo == null) ? 0 : dispositivo.hashCode());
		result = prime * result + ((sensor == null) ? 0 : sensor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DispositivoSensorPK other = (DispositivoSensorPK) obj;
		if (dispositivo == null) {
			if (other.dispositivo != null)
				return false;
		} else if (!dispositivo.equals(other.dispositivo))
			return false;
		if (sensor == null) {
			if (other.sensor != null)
				return false;
		} else if (!sensor.equals(other.sensor))
			return false;
		return true;
	}
	
	
	
}
