package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepository implements ICiudadanoRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void insertar(Ciudadano ciudadano) {
        this.entityManager.persist(ciudadano);
    }
    @Override
    public Ciudadano select(Integer id) {
        return this.entityManager.find(Ciudadano.class, id);
    }
    @Override
    public void eliminar(Integer id) {
       this.entityManager.remove(this.select(id));
    }
    @Override
    public void actualizar(Ciudadano ciudadano) {
        this.entityManager.merge(ciudadano);
    }

}
