package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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
    @Override
    public Empleado seleccionarPorCedula(String cedula) {
        //1)SELECT p FROM Padre p
        //2)SELECT p FROM Padre p, Hijo j WHERE ............
        TypedQuery<Empleado> myQuery = this.entityManager.createQuery("SELECT e FROM Empleado e WHERE e.ciudadano.cedula = :cedula",Empleado.class);
        myQuery.setParameter("cedula", cedula);
        return null;
    }
    @Override
    public Ciudadano seleccionarPorCedulaCiu(String cedula) {
       Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciu_cedula = :cedula", Ciudadano.class);
       myQuery.setParameter("cedula", cedula);
       return (Ciudadano) myQuery.getSingleResult();
    }
    
}
