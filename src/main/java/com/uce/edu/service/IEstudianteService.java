package com.uce.edu.service;



import com.uce.edu.repository.modelo.Estudiante;


public interface IEstudianteService {
    public Estudiante buscar(Integer id);

	public void guardar(Estudiante estudiante);

	public void actulizar(Estudiante estudiante);

	public void borrar(Integer id);
}
