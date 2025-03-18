/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author josesanchez
 * @param <T>
 */
public abstract class GenericDao< T extends Serializable> implements IGenericDao<T> {

 /**
     * Instancia generica (pojo) para las consultas
     */
    private Class<T> clase;
    /**
     * crea instancia de entityManager para persistencia
     */
    @PersistenceContext
    protected EntityManager entityManager;

    /**
     * Establece el tipo de clase pojo
     *
     * @param clase pojo
     */
    @Override
    public void setClase(final Class<T> clase) {
        this.clase = clase;
    }

    /**
     * Obtiene los registros dado el id. Query: SELECT * FROM table WHERE id = ?
     *
     * @param id clave primaria
     * @return listado
     */
    @Override
    public List<T> filter(final long id) {
        return null;
    }

    /**
     * Obtiene los registros dado el id. Query: SELECT * FROM table WHERE id = ?
     *
     * @param id objeto que tiene la clave primaria
     * @return listado
     */
    @Override
    public List<T> filter(T id) {
        return null;
    }

    /**
     * Obtiene el registro dado el id. Query: SELECT * FROM table WHERE id = ?
     *
     * @param id clave primaria
     * @return registro
     */
    @Override
    public T findOne(final long id) {
        return entityManager.find(this.clase, id);
    }

    /**
     * Obtiene el registro dado el id. Query: SELECT * FROM table WHERE id = ?
     * Necesario implementar en clases hijas
     *
     * @param id clave primaria
     * @return registro
     */
    @Override
    public T findOne(T id) {
        return entityManager.find(this.clase, id);
    }

    /**
     * Lista los registros de una tabla. Query: SELECT * FROM table
     *
     * @return listado
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        List<T> resp = entityManager.createQuery("from " + clase.getName()).getResultList();
        return resp;
    }

    /**
     * Guarda el registro en la tabla. Query: INSERT INTO table VALUES(?)
     *
     * @param object Objeto a guardar
     * @return objeto agredado
     */
    @Override
    public T create(T object) {
        entityManager.persist(object);
        return object;
    }

    /**
     * Actualizar el registro en la tabla. Query: UPDATE table SET ? WHERE id=?
     *
     * @param object registro a actualizar
     * @return registro actualizado
     */
    @Override
    public T merge(T object) {
        return entityManager.merge(object);
    }

    /**
     * Elimina un registro de la tabla. Query: DELETE FROM table WHERE id=?
     *
     * @param object objecto a eliminar
     */
    @Override
    public T delete(T object) {
        entityManager.remove(object);
        return object;
    }

    /**
     * Elimina un registro de la tabla. Query: DELETE FROM table WHERE id=?
     *
     * @param id id de tabla
     */
    @Override
    public T deleteById(long id) {
        T object = findOne(id);
        delete(object);
        return object;
    }
}
