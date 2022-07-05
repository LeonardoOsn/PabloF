package org.pablo.ibarra.ponce.service;

import java.util.List;

import org.pablo.ibarra.ponce.model.Vacante;

public interface IntVacantes {
	
	public List<Vacante> obtenerTodas();
	public void guardar(Vacante vacante);
	public void eliminar(Integer idVacante);
	public Vacante buscarPorId(Integer idVacante);
	public void modificar(Integer posicion, Vacante vacante);
	public int nuevoId();
	public int buscarPosicion(Vacante vacante);

}
