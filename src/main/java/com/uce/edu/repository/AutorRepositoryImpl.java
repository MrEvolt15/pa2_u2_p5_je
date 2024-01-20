package com.uce.edu.repository;

import java.util.List;

import javax.management.Query;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AutorRepositoryImpl implements IAutorRepository {
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

  @Override
  public Autor seleccionarPorApellido(String apellido) {
    TypedQuery<Autor> query = this.entityManager.createQuery("SELECT a FROM Autor a WHERE a.apellido = :apellido",Autor.class);
    query.setParameter("apellido", apellido);
    return query.getSingleResult();
  }

  @Override
  public Autor seleccionarPorNombre(String nombre) {
    TypedQuery<Autor> query = this.entityManager.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre",Autor.class);
    query.setParameter("nombre", nombre);
    return query.getSingleResult();
  }

  @Override
  public List<Autor> seleccionarPorTitulo(String titulo) {
    TypedQuery<Autor> query = this.entityManager.createQuery("SELECT a FROM Autor a WHERE a.libros.titulo = :titulo", Autor.class);
    query.setParameter("titulo", titulo);
    return query.getResultList();
  }

  @Override
  public Autor seleccionarPorNombreNamed(String nombre) {
    TypedQuery<Autor> query = this.entityManager.createNamedQuery("Autor.queryBuscarPorTitulo",Autor.class);
    query.setParameter("nombre", nombre);
    return query.getSingleResult();
  }
  
}
