/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asotec.riesgos.service;

import com.asotec.riesgos.dao.IGenericDao;
import com.asotec.riesgos.exception.InvalidAttributeException;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.asotec.riesgos.util.Validation;
/**
 *
 * @author josesanchez
 * @param <T>
 */
@Transactional
public abstract class GenericService<T extends Serializable> implements IGenericService<T> {

     /**
     * Resuelve la dependencia del dao automaticamente
     */
    @Autowired
     IGenericDao<T> dao;

    /**
     * Establece el tipo de dao manualmente
     *
     * @param dao instacia del dao
     */
    public final void setDao(IGenericDao<T> dao) {
        this.dao = dao;
    }

    /**
     * Obtiene los registros dado el id. Query: SELECT * FROM table WHERE id = ?
     *
     * @param id objeto que tiene la clave primaria
     * @return listado
     */
    @Override
    public List<T> filter(T id) {
        return dao.filter(id);
    }

    /**
     * Obtiene los registros dado el id. Query: SELECT * FROM table WHERE id = ?
     *
     * @param id clave primaria
     * @return listado
     */
    @Override
    public List<T> filter(final long id) {
        return dao.filter(id);
    }

    /**
     * Obtiene un registro dada la id
     *
     * @param id id del objecto
     * @return registro
     */
    @Override
    @Transactional(readOnly = true)
    public T findOne(final long id) {
        try {
            Validation.checkLessThanOne("id", id); //id debe ser mayor a cero
            return dao.findOne(id);
        } catch (InvalidAttributeException ex) {
            //Logger.getLogger(GenericService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Obtiene un registro dada la id
     *
     * @param obj objeto con id
     * @return registro
     */
    @Override
    @Transactional(readOnly = true)
    public T findOne(T obj) {
        try {
            Validation.checkNullObj(obj);
            return dao.findOne(obj);
        } catch (InvalidAttributeException ex) {
            //Logger.getLogger(GenericService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Obtiene todos los registros
     *
     * @return listado
     */
    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return Lists.newArrayList(dao.findAll());
    }

    /**
     * Agrega un registro nuevo
     *
     * @param entity instancia de la clase
     * @return registro agregado
     */
    @Override
    public T create(final T entity) {
        try {
            Validation.checkNullObj(entity);
            return dao.create(entity);
        } catch (InvalidAttributeException ex) {
            //Logger.getLogger(GenericService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Actualiza el registro
     *
     * @param entity instancia de la clase
     * @return registro
     */
    @Override
    public T update(final T entity) {
        try {
            Validation.checkNullObj(entity);
            return dao.merge(entity);
        } catch (InvalidAttributeException ex) {
            //Logger.getLogger(GenericService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Elimina un registro
     *
     * @param entity objecto a eliminar
     * @return registro
     */
    @Override
    public T delete(final T entity) {
        try {
            Validation.checkNullObj(entity);
            return dao.delete(entity);
        } catch (InvalidAttributeException ex) {
            //Logger.getLogger(GenericService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Elimina un registro por id
     *
     * @param entityId objecto a eliminar
     * @return registro
     */
    @Override
    public T deleteById(final long entityId) {
        try {
            Validation.checkLessThanOne("id", entityId);
            return dao.deleteById(entityId);
        } catch (InvalidAttributeException ex) {
            //Logger.getLogger(GenericService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


}
