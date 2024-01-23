package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICiudadanoRepository;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService{
    @Autowired
    private ICiudadanoRepository ciudadanoRepository;
    @Override
    public void guardar(Ciudadano ciudadano) {
       this.ciudadanoRepository.insertar(ciudadano);
    }
    @Override
    public Ciudadano buscar(Integer id) {
      return this.ciudadanoRepository.select(id);
    }
    @Override
    public void eliminar(Integer id) {
      this.ciudadanoRepository.eliminar(id);
    }
    @Override
    public void actualizar(Ciudadano ciudadano) {
      this.ciudadanoRepository.actualizar(ciudadano);
    }
    @Override
    public Empleado busacarPorCedula(String cedula) {
      return this.ciudadanoRepository.seleccionarPorCedula(cedula);
    }
    @Override
    public Ciudadano buscarPorCedulaCiu(String cedula) {
      return this.ciudadanoRepository.seleccionarPorCedulaCiu(cedula);
    }
    @Override
    public Ciudadano buscarPorApellido(String apellido) {
      return this.ciudadanoRepository.seleccionarPorApellido(apellido);
    }
    @Override
    public Ciudadano buscarPorCriteria(String nombre, String apellido, String cedula) {
      return this.ciudadanoRepository.seleccionarPorCriteria(nombre, apellido, cedula);
    }
    @Override
    public Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
      return this.ciudadanoRepository.seleccionarPorCriteriaAndOr(nombre, apellido, cedula);
    }

}
