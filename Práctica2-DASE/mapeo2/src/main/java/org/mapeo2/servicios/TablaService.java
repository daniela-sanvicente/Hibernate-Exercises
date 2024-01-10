package org.mapeo2.servicios;

import org.mapeo2.entity.Tabla;

import java.util.List;

public interface TablaService {
    Tabla getTablaById(Integer id);
    List<Tabla> getAllTablas();
}
