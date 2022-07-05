package org.pablo.ibarra.ponce.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.pablo.ibarra.ponce.model.Categoria;
import org.pablo.ibarra.ponce.model.Vacante;
import org.springframework.stereotype.Service;


@Service
public class VacantesServiceImp implements IntVacantes {

	//Agregar atributo
	private List<Vacante> lista = null;
	
	//Método Constructor
		public VacantesServiceImp() {
			lista = new LinkedList<Vacante>();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			//Una instancia
			
			try {
			Vacante v1 = new Vacante();
			v1.setId(1);
			v1.setNombre("Desarrollo de SW");
			v1.setDescripcion("Apps en Kotlin");
			v1.setFecha(LocalDate.parse("05/12/2021", formato));
			v1.setSalario(421.00);
			v1.setEstatus("Creada");
			v1.setDestacado(1);
			v1.setImagen("logo2.png");
			v1.setDetalles("<h2>Ofrecemos</h2>"
					+ "<ul><li>Salario atractivo</li>"
					+ "<li>Oportunidad de desarrollo</li></ul>");
			Categoria cat1 = new Categoria();
			cat1.setId(4);
			cat1.setNombre("Programación");
			cat1.setDescripcion("");
			v1.setCategoria(cat1);
			//********************************************************
			Vacante v2 = new Vacante();
			v2.setId(2);
			v2.setNombre("Doctor");
			v2.setDescripcion("Conocimiento en cirujias");
			v2.setFecha(LocalDate.parse("23/02/2022", formato));
			v2.setSalario(134.00);
			v2.setEstatus("Creada");
			v2.setDestacado(1);
			v2.setImagen("logo8.png");
			v2.setDetalles("<h2>Ofrecemos</h2>"
					+ "<ul><li>Salario atractivo</li>"
					+ "<li>Oportunidad de desarrollo</li></ul>");
			Categoria cat2 = new Categoria();
			cat2.setId(2);
			cat2.setNombre("Medicina");
			cat2.setDescripcion("blabla");
			v2.setCategoria(cat2);
			//***********************************************************
			Vacante v3 = new Vacante();
			v3.setId(3);
			v3.setNombre("Arquitecto");
			v3.setDescripcion("Conocimiento en puentes");
			v3.setFecha(LocalDate.parse("01/07/2022", formato));
			v3.setSalario(345.50);
			v3.setEstatus("Creada");
			v3.setDestacado(1);
			v3.setImagen("logo12.png");
			v3.setDetalles("<h2>Ofrecemos</h2>"
					+ "<ul><li>Salario atractivo</li>"
					+ "<li>Oportunidad de desarrollo</li></ul>");
			Categoria cat3 = new Categoria();
			cat3.setId(5);
			cat3.setNombre("Civil");
			cat3.setDescripcion("frd");
			v3.setCategoria(cat3);
			
			lista.add(v1);
			lista.add(v2);
			lista.add(v3);
			}catch(DateTimeParseException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
		}

	@Override
	public List<Vacante> obtenerTodas() {
		return lista;
	}

	@Override
	public void guardar(Vacante vacante) {
		lista.add(vacante);
	}

	@Override
	public void eliminar(Integer idVacante) {
		lista.remove(buscarPorId(idVacante));
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		for(Vacante v : lista) {
			if(v.getId()==idVacante) {
				return v;
			}
		} return null;
	}

	@Override
	public void modificar(Integer posicion, Vacante vacante) {
		lista.set(posicion, vacante);
		
	}

	@Override
	public int nuevoId() {
		int id=0;
		for(Vacante c: lista) {
			id=c.getId();
		}
		return id;
		
	}

	@Override
	public int buscarPosicion(Vacante vacante) {
	 int index=0, posicion=-1; Vacante aux=null;
		 while(index < lista.size()) {
			aux = lista.get(index);
			if(aux.getId()==vacante.getId()) {
				posicion= index;
				break;
		} index++;
		
	}
		
		
		return posicion;
	
	}
}
	


