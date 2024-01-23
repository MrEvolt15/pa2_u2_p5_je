package com.uce.edu.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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

    @Override
    public Libro seleccionarPorTituloMasFecha(String titulo, LocalDate fechaPublicaion) {
        //0. Creamos una instancia de la interfaz CriteriaBUilder a partir de un EM
        CriteriaBuilder builder= this.entityManager.getCriteriaBuilder();
        //1. Detterminamos el tipo de retorno que va a tener mi Consulta(Query)
        CriteriaQuery<Libro> myCriteriaQuery= builder.createQuery(Libro.class);
        //2 COnstruir el SQL
        //2.1 Determinamos el FROM
        Root<Libro> myFrom = myCriteriaQuery.from(Libro.class);
        //2.2 Construir las condiciones del (WHERE)
        Predicate condicionTotal = null;
        //c.nombre = :nombre
        Predicate condicionFechaPublicacion = builder.greaterThan(myFrom.get("fechaPublicacion"), fechaPublicaion);
        //c.apellido = :apellido
        Predicate condicionTitulo = builder.equal(myFrom.get("titulo"), titulo);
        //.nombre = :nombre OR c.apellido = :apellido
        condicionTotal = builder.and(condicionFechaPublicacion,condicionTitulo);
        
        //3. Construimos el SQL final
        myCriteriaQuery.select(myFrom).where(condicionTotal);   
        //4. Ejecutamos la onsulta con un TypedQuery
        TypedQuery<Libro> typedQuery = this.entityManager.createQuery(myCriteriaQuery);
        return typedQuery.getSingleResult();
    }

    @Override
    public Libro seleccionarSegundoTItulo(String titulo) {
        //0. Creamos una instancia de la interfaz CriteriaBUilder a partir de un EM
        CriteriaBuilder builder= this.entityManager.getCriteriaBuilder();
        //1. Detterminamos el tipo de retorno que va a tener mi Consulta(Query)
        CriteriaQuery<Libro> myCriteriaQuery= builder.createQuery(Libro.class);
        //2 COnstruir el SQL
        //2.1 Determinamos el FROM
        Root<Libro> myFrom = myCriteriaQuery.from(Libro.class);
        //2.2 Construir las condiciones del (WHERE)
        Predicate condicionTotal = null;
        //c.nombre = :nombre
        Predicate condicionFechaPublicacion = builder.greaterThan(myFrom.get("id"), 1);
        //c.apellido = :apellido
        Predicate condicionTitulo = builder.equal(myFrom.get("titulo"), titulo);
        //.nombre = :nombre OR c.apellido = :apellido
        condicionTotal = builder.and(condicionFechaPublicacion,condicionTitulo);
        
        //3. Construimos el SQL final
        myCriteriaQuery.select(myFrom).where(condicionTotal);   
        //4. Ejecutamos la onsulta con un TypedQuery
        TypedQuery<Libro> typedQuery = this.entityManager.createQuery(myCriteriaQuery);
        return typedQuery.getSingleResult();
    }

}
