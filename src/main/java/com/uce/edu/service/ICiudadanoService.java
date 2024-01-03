package com.uce.edu.service;

import com.uce.edu.repository.modelo.Ciudadano;

public interface ICiudadanoService {
    public void guardar(Ciudadano ciudadano);
    public Ciudadano buscar(Integer id);
    public void eliminar(Integer id);
    public void actualizar(Ciudadano ciudadano);
}
