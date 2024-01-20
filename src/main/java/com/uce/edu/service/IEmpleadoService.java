package com.uce.edu.service;


import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoService {
    public void guardar(Empleado empleado);
    public Empleado buscar(Integer id);
    public void eliminar(Integer id);
    public void actualizar(Empleado empleado);
    public Empleado buscarPorCargo(String cargo);
}
