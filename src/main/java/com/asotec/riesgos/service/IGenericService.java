/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.service;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author josesanchez
 * @param <T>
 */
public interface IGenericService<T extends Serializable> {

   /**
     * Obtiene los registros dado el id. Query: SELECT * FROM table WHERE id = ?
     *
     * @param id clave primaria
     * @return listado
     */
    public List<T> filter(final long id);

    /**
     * Obtiene los registros dado el id. Query: SELECT * FROM table WHERE id = ?
     *
     * @param id objeto que tiene la clave primaria
     * @return listado
     */
    public List<T> filter(T id);

    /**
     * Obtiene un registro dada la id
     *
     * @param id id del objecto
     * @return registro
     */
    public T findOne(final long id);

    /**
     * Obtiene un registro dada la id
     *
     * @param id objeto con id
     * @return registro
     */
    public T findOne(T id);

    /**
     * Obtiene todos los registros
     *
     * @return listado
     */
    public List<T> findAll();

    /**
     * Agrega un registro nuevo
     *
     * @param entity instancia de la clase
     * @return objeto agregado
     */
    public T create(final T entity);

    /**
     * Actualiza el registro
     *
     * @param entity instancia de la clase
     * @return registro
     */
    public T update(final T entity);

    /**
     * Elimina un registro
     *
     * @param entity objecto a eliminar
     * @return objeto eliminado
     */
    public T delete(final T entity);

    /**
     * Elimina un registro por id
     *
     * @param entityId objecto a eliminar
     * @return objeto eliminado
     */
    public T deleteById(final long entityId);

}
