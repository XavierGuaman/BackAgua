/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @param <T>
 * @author josesanchez
 */
public interface IGenericDao<T extends Serializable> {

    /**
     * Establece el tipo de clase pojo
     *
     * @param clase pojo
     */
    public void setClase(final Class<T> clase);

    /**
     * Obtiene el registro dado el id. Query: SELECT * FROM table WHERE id = ?
     *
     * @param id clave primaria
     * @return registro
     */
    public T findOne(final long id);

    /**
     * Obtiene los registros dado el id. Query: SELECT * FROM table WHERE id = ?
     *
     * @param id clave primaria
     * @return listado
     */
    public List<T> filter(final long id);

    /**
     * Obtiene el registro dado el id. Query: SELECT * FROM table WHERE id = ?
     *
     * @param id objeto que tiene la clave primaria
     * @return registro
     */
    public T findOne(T id);

    /**
     * Obtiene los registros dado el id. Query: SELECT * FROM table WHERE id = ?
     *
     * @param id objeto que tiene la clave primaria
     * @return listado
     */
    public List<T> filter(T id);

    /**
     * Lista los registros de una tabla. Query: SELECT * FROM table
     *
     * @return listado
     */
    public List<T> findAll();

    /**
     * Guarda el registro en la tabla. Query: INSERT INTO table VALUES(?)
     *
     * @param object Objeto a guardar
     * @return registro agregado
     */
    public T create(T object);

    /**
     * Actualizar el registro en la tabla. Query: UPDATE table SET ? WHERE id=?
     *
     * @param object registro a actualizar
     * @return registro actualizado
     */
    public T merge(T object);

    /**
     * Elimina un registro de la tabla. Query: DELETE FROM table WHERE id=?
     *
     * @param object objecto a eliminar
     * @return objeto borrado
     */
    public T delete(T object);

    /**
     * Elimina un registro de la tabla. Query: DELETE FROM table WHERE id=?
     *
     * @param id id de tabla
     * @return objeto borrado
     */
    public T deleteById(long id);
}
