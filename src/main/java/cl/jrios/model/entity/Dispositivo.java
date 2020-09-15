package cl.jrios.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter
	@Getter
	private Integer idDispositivo;
	@Setter
	@Getter
	private String nombre;
	@Setter
	@Getter
	private String mac;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDispositivo == null) ? 0 : idDispositivo.hashCode());
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
		Dispositivo other = (Dispositivo) obj;
		if (idDispositivo == null) {
			if (other.idDispositivo != null)
				return false;
		} else if (!idDispositivo.equals(other.idDispositivo))
			return false;
		return true;
	}

}
