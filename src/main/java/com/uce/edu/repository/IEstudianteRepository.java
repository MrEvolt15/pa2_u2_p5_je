package com.uce.edu.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    public Estudiante seleccionar(Integer id);

	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(Integer id);
	public Estudiante seleccionarPorCedula(String cedula);
	public Estudiante seleccionarPorApellidoNamed(String apellido);
	public List<Estudiante> seleccionarPorFecha(LocalDateTime fecha);
	public List<Estudiante> seleccionarPorIntervaloFechaCriteria(LocalDateTime fechaInicio,LocalDateTime fechaFin);

}
