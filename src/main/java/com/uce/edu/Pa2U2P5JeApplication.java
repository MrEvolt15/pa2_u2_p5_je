package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IHotelService;


@SpringBootApplication
public class Pa2U2P5JeApplication implements CommandLineRunner {
	@Autowired
	private IEmpleadoService empleadoService;
	@Autowired
	private ICiudadanoService ciudadanoService;
	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Ciudadano ciu1 = new Ciudadano();
		ciu1.setNombre("Mauricio");
		ciu1.setApellido("Torres");
		//ciu1.setId(3);
		

		Empleado empl1 = new Empleado();
		empl1.setFechaIngreso(LocalDateTime.now());
		empl1.setSalario(BigDecimal.valueOf(100));
		ciu1.setEmpleado(empl1);
		//Ciudadano c2 = this.ciudadanoService.buscar(1);
		empl1.setCiudadano(ciu1);
		
		this.ciudadanoService.guardar(ciu1);
		//this.empleadoService.guardar(empl1);
		*/
		Hotel h1 = new Hotel();
		h1.setDireccion("Diego de Almagro");
		h1.setNombre("Hilton");

		Habitacion ha1 = new Habitacion();
		ha1.setNumero("H1");
		ha1.setClase("normal");
		ha1.setHotel(h1);

		Habitacion ha2 = new Habitacion();
		ha2.setClase("Vip");
		ha2.setNumero("HV2");
		ha2.setHotel(h1);
		
		List<Habitacion> habitaciones = new ArrayList<>();
		habitaciones.add(ha2);
		habitaciones.add(ha1);
		h1.setHabitaciones(habitaciones);
		
		this.hotelService.guardar(h1);
	}

}
