package org.mapeo2.modelo.dao;

import org.mapeo2.entity.Tabla;

import java.util.List;

public interface TablaDAO {
    Tabla getTablaById(Integer id);
    List<Tabla> getAllTablas();
}
