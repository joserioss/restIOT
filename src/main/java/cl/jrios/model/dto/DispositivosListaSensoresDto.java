package cl.jrios.model.dto;

import java.util.List;

import cl.jrios.model.entity.Dispositivo;
import cl.jrios.model.entity.Sensor;

public class DispositivosListaSensoresDto {
	private Dispositivo dispositivo;
	private List<Sensor> listaSensores;

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public List<Sensor> getListaSensores() {
		return listaSensores;
	}

	public void setListaSensores(List<Sensor> listaSensores) {
		this.listaSensores = listaSensores;
	}

}
