package com.uce.edu;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;


@SpringBootApplication
public class Pa2U2P5JeApplication implements CommandLineRunner {
	//1. Query (JPQL) es el lenguaje de consulta orientado a objetos para la consulta a la base de datos
	//1.1 TypedQuery
	//1.2NamedQUery

	//2.NativeQUery(SQL puro) cuando tengo querys complejas, para optimizar rendimiento, pierdo la orientacion a objetos
	//3.Criteria Api Query

	@Autowired
	private IEmpleadoService empleadoService;
	@Autowired
	private IAutorService autorService;
	@Autowired
	private IEstudianteService estudianteService;
	@Autowired
	private IHabitacionService habitacionService;
	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Empleado e1 = this.empleadoService.buscarPorCargo("ingeniero");
		System.out.println(e1);
		Autor a1 = this.autorService.buscarPorNombre("Juan");
		System.out.println(a1);
		Autor a2 = this.autorService.buscarPorApellido("Gonzales");
		System.out.println(a2);
		Habitacion hab1 = this.habitacionService.buscarPorNumero("H1");
		System.out.println(hab1);
		Estudiante estu = this.estudianteService.seleccionarPorCedula("123");
		System.out.println(estu);

		Autor aN1 = this.autorService.buscarPorNombreNamed("Juan");
		System.out.println(aN1);
		Estudiante e = this.estudianteService.buscarPorApellidoNamed("Espinosa");
		System.out.println(e);
		List<Estudiante> estudiantes = this.estudianteService.buscarPorFecha(LocalDateTime.of(1998, 1, 1, 0, 0, 0));
		for (Estudiante estudiante : estudiantes) {
			System.out.println(estudiante);
		}
		List<Habitacion> habitaciones = this.habitacionService.buscarPorClase("Vip");
		for (Habitacion habitacion : habitaciones) {
			System.out.println(habitacion);
		}
		Hotel hotel = this.hotelService.buscarPorNombreNamed("Hilton");
		System.out.println(hotel);
	}
}
