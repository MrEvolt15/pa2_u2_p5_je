package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Habitacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitacionRepositoryImpl implements IHabitacionRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Habitacion> seleccionarPorClase(String clase) {
        TypedQuery<Habitacion> query = this.entityManager.createNamedQuery("Habitacion.queryBuscarPorClase", Habitacion.class);
        query.setParameter("clase", clase);
        return query.getResultList();
    }
    @Override
    public Habitacion seleccionarPorNumero(String numero) {
        TypedQuery<Habitacion> query = this.entityManager.createQuery("SELECT h FROM Habitacion h WHERE h.numero = :numero",Habitacion.class);
        query.setParameter("numero", numero);
        return query.getSingleResult();
    }

}
