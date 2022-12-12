package com.co.ebs.cooperagro.general;

import java.util.List;

/**
 *
 * @author Brayan F Silva R
 * @param <T>
 */
public interface GenericRepository<T> {

    T create(T t) throws Exception;

    void delete(T t) throws Exception;

    T find(T t) throws Exception;

    T update(T t) throws Exception;

    List<T> findAll() throws Exception;

    List<T> findByNamedQueryForValueString(T t, String sNameQuery, String sCampoFind, String sValueFind) throws Exception;

    List<T> findByNamedQueryForValueEntity(T t, String sNameQuery, String sCampoFind, T valueEntity) throws Exception;
    
    List<T> findAllOrderByCampo(String sTipoOrder, String sCampoOrder);
}
