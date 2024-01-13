package com.uce.edu.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LibroRepositoryImpl implements ILibroRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Libro libro) {
        this.entityManager.persist(libro);
    }

    @Override
    public Libro seleccionar(Integer id) {
        return this.entityManager.find(Libro.class, id);
    }

    @Override
    public void actualizar(Libro libro) {
        this.entityManager.merge(libro);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.seleccionar(id));
    }

    @Override
    public Libro seleccionarPorNombre(String nombre) {
        Query query = this.entityManager.createQuery("SELECT l from Libro l WHERE l.titulo = :variable");// SQL1
        query.setParameter("variable", nombre);
        return (Libro) query.getSingleResult();
    }

    @Override
    public List<Libro> seleccionarPorFecha(LocalDate fechaPublicacion) {
        // SQL = SELECT * FROM libro l WHERE l.libr_fecha_publicacion >= ?
        // JPQL= SELECT l from Libro l WHERE l.fechaPublicacion >= :fecha
        Query query = this.entityManager.createQuery("SELECT l from Libro l WHERE l.fechaPublicacion >= :fecha");
        query.setParameter("fecha", fechaPublicacion);
        return (List<Libro>) query.getResultList();
    }

    @Override
    public Libro seleccionarPorTitulo(String titulo) {
        TypedQuery<Libro> typedQuery = this.entityManager.createQuery("SELECT l from Libro l WHERE l.titulo = :titulo",
                Libro.class);
        typedQuery.setParameter("titulo", titulo);
        return typedQuery.getSingleResult();
    }

    @Override
    public List<Libro> seleccionarPorFechaTyped(LocalDate fechaPublicacion) {
        TypedQuery<Libro> query = this.entityManager
                .createQuery("SELECT l from Libro l WHERE l.fechaPublicacion >= :fecha", Libro.class);
        query.setParameter("fecha", fechaPublicacion);
        return query.getResultList();
    }

    @Override
    public Libro seleccionarPorTituloNamed(String titulo) {
        TypedQuery<Libro> myQuery = this.entityManager.createNamedQuery("Libro.queryBuscarPorTitulo", Libro.class);
        myQuery.setParameter("titulo", titulo);
        return myQuery.getSingleResult();
    }

    @Override
    public List<Libro> seleccionarPorFechaNamed(LocalDate fechaPublicacion) {
        TypedQuery<Libro> myQuery = this.entityManager.createNamedQuery("Libro.queryBuscarPorFecha", Libro.class);
        myQuery.setParameter("fecha", fechaPublicacion);
        return myQuery.getResultList();
    }

}
