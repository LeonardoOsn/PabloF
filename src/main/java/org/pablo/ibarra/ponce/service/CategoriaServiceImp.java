package org.pablo.ibarra.ponce.service;

import java.util.LinkedList;
import java.util.List;

import org.pablo.ibarra.ponce.model.Categoria;
import org.springframework.stereotype.Service;

@Service 
public class CategoriaServiceImp implements IntCategorias {
	
	//Agregar atributo
	private List<Categoria> lista = null;
	/*-------------------------------------------*/
	//Método Constructor
	public CategoriaServiceImp() {
		lista = new LinkedList<Categoria>();
		//Una instancia
		Categoria c1 = new Categoria();
		c1.setId(1);
		c1.setNombre("IoT");
		c1.setDescripcion("Relación con IoT");
		
		Categoria c2 = new Categoria();
		c2.setId(2);
		c2.setNombre("Salud");
		c2.setDescripcion("Relación con Salud");
		
		Categoria c3 = new Categoria();
		c3.setId(3);
		c3.setNombre("Arquitectura");
		c3.setDescripcion("Relación con construccion");
		
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
	}
	/*-------------------------------------------*/
	
	@Override
	public List<Categoria> obtenerTodas() {
		return lista;
	}

	@Override
	public void agregar(Categoria categoria) {
		lista.add(categoria);
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		for(Categoria categoria : lista) {
			if ( categoria.getId() == idCategoria) {
				return categoria;
			}
		}
		return null;
	}

	@Override
	public void eliminar(Integer idCategoria) {
		lista.remove(buscarPorId(idCategoria));

	}

	@Override
	public int totalCategorias() {
		return lista.size();
	}

	@Override
	public void modificar(Integer posicion, Categoria categoria) {
		lista.set(posicion, categoria);
		
	}

	@Override
	public int buscarPosicion(Categoria categoria) {
		int index = 0; Categoria aux = null;
		int posicion = -1;
		while(index < lista.size()) {
			aux = lista.get(index);
			if(aux.getId()==categoria.getId()) {
				posicion= index;
				break;
		} index++;
		
	} return posicion;
}

	@Override
	public int nuevoId() {
		int id=0;
		for(Categoria c: lista) {
			id=c.getId();
		}
		return id;
	}
}
