package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;

import com.uce.edu.service.ICiudadanoService;

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

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Criteria API Query
		Ciudadano c = this.ciudadanoService.buscarPorApellido("Narvaez");
		System.out.println(c);

		//
		Ciudadano c1 = this.ciudadanoService.buscarPorCriteria("Santiago", "Narvaez", "1726333196");
		System.out.println(c1);
		Ciudadano c2 = this.ciudadanoService.buscarPorCriteria("Santiago", "Narvaez", "0526333196");
		System.out.println(c2);
		//Ciudadano c3 = this.ciudadanoService.buscarPorCriteria("Santiago", "Narvaez", "0626333196");
		//System.out.println(c3);

		System.out.println("Criteria API Query AND OR");

		Ciudadano c4 = this.ciudadanoService.buscarPorCriteria("Santiago", "Narvaez1111", "1726333196");
		System.out.println(c4);
		Ciudadano c5 = this.ciudadanoService.buscarPorCriteria("Santiago", "Narvaez", "0526333196");
		System.out.println(c5);
	}
}
