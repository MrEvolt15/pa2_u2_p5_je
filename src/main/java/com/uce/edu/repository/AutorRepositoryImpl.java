package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AutorRepositoryImpl implements IAutorRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Autor autor) {
       this.entityManager.persist(autor);
    }

    @Override
    public Autor seleccionar(Integer id) {
       return this.entityManager.find(Autor.class, id);
    }

    @Override
    public void actualizar(Autor autor) {
      this.entityManager.merge(autor);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.seleccionar(id));
    }

}
