package com.uce.edu;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.ILibroService;


@SpringBootApplication
public class Pa2U2P5JeApplication implements CommandLineRunner {
	//1. Query (JPQL) es el lenguaje de consulta orientado a objetos para la consulta a la base de datos
	//1.1 TypedQuery
	//1.2NamedQUery

	//2.NativeQUery(SQL puro) cuando tengo querys complejas, para optimizar rendimiento, pierdo la orientacion a objetos
	//3.Criteria Api Query

	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Empleado e1 =this.ciudadanoService.busacarPorCedula("1234");
		System.out.println(e1);
		Ciudadano c1 = this.ciudadanoService.buscarPorCedulaCiu("1234");
		System.out.println(c1);
	}
}
