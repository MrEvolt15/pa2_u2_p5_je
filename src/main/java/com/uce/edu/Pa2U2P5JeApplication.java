package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;


@SpringBootApplication
public class Pa2U2P5JeApplication implements CommandLineRunner {
	@Autowired
	private IEmpleadoService empleadoService;
	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Empleado empl1 = new Empleado();
		empl1.setFechaIngreso(LocalDateTime.now());
		empl1.setSalario(BigDecimal.valueOf(200));
		
		Ciudadano ciu1 = new Ciudadano();
		ciu1.setNombre("Joel");
		ciu1.setApellido("Espinosa");
		
		Ciudadano c2 = this.ciudadanoService.buscar(1);
		empl1.setCiudadano(c2);
		
		//this.ciudadanoService.guardar(ciu1);
		this.empleadoService.guardar(empl1);
	}

}
