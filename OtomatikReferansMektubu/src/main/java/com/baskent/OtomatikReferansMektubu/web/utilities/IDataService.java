package com.baskent.OtomatikReferansMektubu.web.utilities;

import java.util.List;

public interface IDataService<T> {
public T save(T entity) throws DbException;
    
    public T update(T entity) throws DbException;
        
    public boolean delete(T entity ) throws DbException;
    
    public List<T> getAll();
    
    public T getById(Long entityId);
}
