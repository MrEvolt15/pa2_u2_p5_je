package com.uce.edu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5JeApplication implements CommandLineRunner {
	// 1. Query (JPQL) es el lenguaje de consulta orientado a objetos para la
	// consulta a la base de datos
	// 1.1 TypedQuery
	// 1.2NamedQUery

	// 2.NativeQUery(SQL puro) cuando tengo querys complejas, para optimizar
	// rendimiento, pierdo la orientacion a objetos
	// 3.Criteria Api Query(Query dinamicos)
	// para querys

	@Autowired
	private ICiudadanoService ciudadanoService;
	@Autowired
	private IEstudianteService estudianteService;
	@Autowired
	private IHabitacionService habitacionService;
	@Autowired
	private ILibroService iLibroService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Estudiante> e1 = this.estudianteService.buscarPorIntervaloFechaCriteria(LocalDateTime.of(2023, 1, 1, 0, 0, 0), LocalDateTime.of(2024, 1, 1, 0, 0, 0));
		for (Estudiante estudiante : e1) {
			System.out.println(estudiante);
		}
		Habitacion hab1 = this.habitacionService.buscarPorNumeroCriteria("H1");
		System.out.println(hab1);
		Habitacion hab2 = this.habitacionService.buscarPrimeroContiene("H1");
		System.out.println(hab2);
		Libro lib1 = this.iLibroService.buscarPorTituloMasFecha("Python", LocalDate.of(2023, 1, 1));
		System.out.println(lib1);
		Libro lib3 = this.iLibroService.buscarSegundoTitulo("Python");
		System.out.println(lib3);

	}
}
