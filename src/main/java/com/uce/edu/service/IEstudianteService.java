package com.uce.edu.service;



import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Estudiante;


public interface IEstudianteService {
    public Estudiante buscar(Integer id);

	public void guardar(Estudiante estudiante);

	public void actulizar(Estudiante estudiante);

	public void borrar(Integer id);
	public Estudiante seleccionarPorCedula(String cedula);
	public Estudiante buscarPorApellidoNamed(String apellido);
	public List<Estudiante> buscarPorFecha(LocalDateTime fecha);
	public List<Estudiante> buscarPorIntervaloFechaCriteria(LocalDateTime fechaInicio,LocalDateTime fechaFin);
}
