package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmpleadoRepositpryImpl implements IEmpleadoRepository{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void insertar(Empleado empleado) {
       this.entityManager.persist(empleado);
    }

    @Override
    public Empleado seleccionar(Integer id) {
       return this.entityManager.find(Empleado.class, id);
    }

    @Override
    public void eliminar(Integer id) {
       this.entityManager.remove(this.seleccionar(id));
    }

    @Override
    public void actualizar(Empleado empleado) {
       this.entityManager.merge(empleado);
    }

   @Override
   public Empleado seleccionarPorCargo(String cargo) {
      TypedQuery<Empleado> query = this.entityManager.createQuery("SELECT e FROM Empleado e WHERE e.cargo = :cargo",Empleado.class);
      query.setParameter("cargo", cargo);
      return query.getSingleResult();
   }

   
}
