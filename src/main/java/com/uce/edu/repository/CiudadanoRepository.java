package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

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
    @Override
    public Ciudadano seleccionarPorApellido(String apellido) {
        //SELECT c FROM Ciudadano c WHERE c.apellido = :apellido
        //0. Creamos una instancia de la interfaz CriteriaBUilder a partir de un EM
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

        //1. Detterminamos el tipo de retorno que va a tener mi Consulta(Query)
        CriteriaQuery<Ciudadano> myCriteriaQuery= builder.createQuery(Ciudadano.class);

        //2. Construir el SQL
        //2.1 Determinar el from
        //Nota: No necesariamente el from es igual al tipo de retorno
        //SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre =:dato
        Root<Ciudadano> tablaFrom = myCriteriaQuery.from(Ciudadano.class);

        //2.2 Construir las condiciones(WHERE) del SQL
        //En criteria api query las condiciones se las conoce como "Predicate"
        //c.apellido = :variable
        Predicate condicionApellido = builder.equal(tablaFrom.get("apellido"), apellido);

        //3. Construimos el SQL final
        myCriteriaQuery.select(tablaFrom).where(condicionApellido);

        //4. Ejecutamos la consulta con un TypedQuery
        TypedQuery<Ciudadano> typedQuery = this.entityManager.createQuery(myCriteriaQuery);
        
        return typedQuery.getSingleResult();
    }
    @Override
    public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula) {
        //0. Creamos una instancia de la interfaz CriteriaBUilder a partir de un EM
        CriteriaBuilder builder= this.entityManager.getCriteriaBuilder();
        //1. Detterminamos el tipo de retorno que va a tener mi Consulta(Query)
        CriteriaQuery<Ciudadano> myCriteriaQuery= builder.createQuery(Ciudadano.class);
        //2 COnstruir el SQL
        //2.1 Determinamos el FROM
        Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);
        //2.2 Construir las condiciones del (WHERE)
        Predicate condicionGenerica = null;

        if(cedula.startsWith("17")){
            condicionGenerica = builder.equal(myFrom.get("nombre"), nombre);
        }else if (cedula.startsWith("05")) {
            condicionGenerica = builder.equal(myFrom.get("apellido"), apellido);
        }else{
            condicionGenerica = builder.equal(myFrom.get("cedula"), cedula);
        }
        //3. Construimos el SQL final
        myCriteriaQuery.select(myFrom).where(condicionGenerica);   
        //4. Ejecutamos la onsulta con un TypedQuery
        TypedQuery<Ciudadano> typedQuery = this.entityManager.createQuery(myCriteriaQuery);
        return typedQuery.getSingleResult();
    }
    @Override
    public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
        //0. Creamos una instancia de la interfaz CriteriaBUilder a partir de un EM
        CriteriaBuilder builder= this.entityManager.getCriteriaBuilder();
        //1. Detterminamos el tipo de retorno que va a tener mi Consulta(Query)
        CriteriaQuery<Ciudadano> myCriteriaQuery= builder.createQuery(Ciudadano.class);
        //2 COnstruir el SQL
        //2.1 Determinamos el FROM
        Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);
        //2.2 Construir las condiciones del (WHERE)
        Predicate condicionTotal = null;
        //c.nombre = :nombre
        Predicate condicionNombre = builder.equal(myFrom.get("nombre"), nombre);
        //c.apellido = :apellido
        Predicate condicionApellido = builder.equal(myFrom.get("apellido"), apellido);

        if(cedula.startsWith("17")){
            //.nombre = :nombre OR c.apellido = :apellido
            condicionTotal = builder.or(condicionNombre,condicionApellido);
        }else if (cedula.startsWith("05")) {
            //.nombre = :nombre AND c.apellido = :apellido
            condicionTotal = builder.and(condicionNombre,condicionApellido);
        }
        //3. Construimos el SQL final
        myCriteriaQuery.select(myFrom).where(condicionTotal);   
        //4. Ejecutamos la onsulta con un TypedQuery
        TypedQuery<Ciudadano> typedQuery = this.entityManager.createQuery(myCriteriaQuery);
        return typedQuery.getSingleResult();
    }
    
}
