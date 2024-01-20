package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IEmpleadoRepository;
import com.uce.edu.repository.modelo.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
    @Autowired
    private IEmpleadoRepository empleadoRepository;
    @Override
    public void guardar(Empleado empleado) {
        this.empleadoRepository.insertar(empleado);
    }
    @Override
    public Empleado buscar(Integer id) {
        return this.empleadoRepository.seleccionar(id);
    }
    @Override
    public void eliminar(Integer id) {
        this.empleadoRepository.eliminar(id);
    }
    @Override
    public void actualizar(Empleado empleado) {
        this.empleadoRepository.actualizar(empleado);
    }
    @Override
    public Empleado buscarPorCargo(String cargo) {
        return this.empleadoRepository.seleccionarPorCargo(cargo);
    }

}
