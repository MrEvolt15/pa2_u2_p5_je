package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoRepository {
    public void insertar(Empleado empleado);
    public Empleado seleccionar(Integer id);
    public void eliminar(Integer id);
    public void actualizar(Empleado empleado);
}
