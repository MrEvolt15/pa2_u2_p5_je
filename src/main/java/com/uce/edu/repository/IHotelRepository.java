package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Hotel;

public interface IHotelRepository {
    public void insertar(Hotel hotel);
    public Hotel seleccionar(Integer id);
    public void actualizar(Hotel hotel);
    public void eliminar(Integer id);

    public Hotel seleccionarPorNombreNamed(String nombre);
}
