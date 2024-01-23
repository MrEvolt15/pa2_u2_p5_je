package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Estudiante seleccionar(Integer id) {
        return this.entityManager.find(Estudiante.class, id);
    }

    @Override
    public void insertar(Estudiante estudiante) {
       this.entityManager.persist(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.entityManager.merge(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.seleccionar(id));
        
    }

    @Override
    public Estudiante seleccionarPorCedula(String cedula) {
        TypedQuery<Estudiante> query = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula = :cedula",Estudiante.class);
        query.setParameter("cedula", cedula);
        return query.getSingleResult();
        
    }

    @Override
    public Estudiante seleccionarPorApellidoNamed(String apellido) {
        TypedQuery<Estudiante> query = this.entityManager.createNamedQuery("Estudiante.queryBuscarPorApellido", Estudiante.class);
        query.setParameter("apellido", apellido);
        return query.getSingleResult();
    }

    @Override
    public List<Estudiante> seleccionarPorFecha(LocalDateTime fecha) {
        TypedQuery<Estudiante> query = this.entityManager.createNamedQuery("Estudiante.queryBuscarPorFecha", Estudiante.class);
        query.setParameter("fecha", fecha);
        return query.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarPorIntervaloFechaCriteria(LocalDateTime fechaInicio,LocalDateTime fechaFin) {
        //0. Creamos una instancia de la interfaz CriteriaBUilder a partir de un EM
        CriteriaBuilder builder= this.entityManager.getCriteriaBuilder();
        //1. Detterminamos el tipo de retorno que va a tener mi Consulta(Query)
        CriteriaQuery<Estudiante> myCriteriaQuery= builder.createQuery(Estudiante.class);
        //2 COnstruir el SQL
        //2.1 Determinamos el FROM
        Root<Estudiante> myFrom = myCriteriaQuery.from(Estudiante.class);
        //2.2 Construir las condiciones del (WHERE)
        Predicate condicionTotal = null;
        //c.nombre = :nombre
        Predicate condicionFechaInicio = builder.greaterThan(myFrom.get("fechaNacimiento"), fechaInicio);
        //c.apellido = :apellido
        Predicate condicionFechaFin = builder.lessThan(myFrom.get("fechaNacimiento"), fechaFin);
        //.nombre = :nombre OR c.apellido = :apellido
        condicionTotal = builder.and(condicionFechaInicio,condicionFechaFin);
        
        //3. Construimos el SQL final
        myCriteriaQuery.select(myFrom).where(condicionTotal);   
        //4. Ejecutamos la onsulta con un TypedQuery
        TypedQuery<Estudiante> typedQuery = this.entityManager.createQuery(myCriteriaQuery);
        return typedQuery.getResultList();
    }

}
