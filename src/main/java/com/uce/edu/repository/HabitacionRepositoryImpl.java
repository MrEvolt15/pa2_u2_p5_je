package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Habitacion;

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
    @Override
    public Habitacion seleccionarPorNumeroCriteria(String numero) {
        //0. Creamos una instancia de la interfaz CriteriaBUilder a partir de un EM
        CriteriaBuilder builder= this.entityManager.getCriteriaBuilder();
        //1. Detterminamos el tipo de retorno que va a tener mi Consulta(Query)
        CriteriaQuery<Habitacion> myCriteriaQuery= builder.createQuery(Habitacion.class);
        //2 COnstruir el SQL
        //2.1 Determinamos el FROM
        Root<Habitacion> myFrom = myCriteriaQuery.from(Habitacion.class);
        //2.2 Construir las condiciones del (WHERE)
        
        Predicate condicionNumero = builder.equal(myFrom.get("numero"), numero);
       
        //3. Construimos el SQL final
        myCriteriaQuery.select(myFrom).where(condicionNumero);   
        //4. Ejecutamos la onsulta con un TypedQuery
        TypedQuery<Habitacion> typedQuery = this.entityManager.createQuery(myCriteriaQuery);
        return typedQuery.getSingleResult();
    }
    @Override
    public Habitacion seleccionarPrimeroContiene(String numero) {
        //0. Creamos una instancia de la interfaz CriteriaBUilder a partir de un EM
        CriteriaBuilder builder= this.entityManager.getCriteriaBuilder();
        //1. Detterminamos el tipo de retorno que va a tener mi Consulta(Query)
        CriteriaQuery<Habitacion> myCriteriaQuery= builder.createQuery(Habitacion.class);
        //2 COnstruir el SQL
        //2.1 Determinamos el FROM
        Root<Habitacion> myFrom = myCriteriaQuery.from(Habitacion.class);
        //2.2 Construir las condiciones del (WHERE)
        
        Predicate condicionNumero = builder.equal(myFrom.get("numero"), numero);
       
        //3. Construimos el SQL final
        myCriteriaQuery.select(myFrom).where(condicionNumero);   
        //4. Ejecutamos la onsulta con un TypedQuery
        TypedQuery<Habitacion> typedQuery = this.entityManager.createQuery(myCriteriaQuery);
        Habitacion buscada = typedQuery.getSingleResult();
        if(buscada.getId().equals(1)){
            return buscada;
        }
        return null;
    }

}
