package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICiudadanoRepository;
import com.uce.edu.repository.modelo.Ciudadano;

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

}
