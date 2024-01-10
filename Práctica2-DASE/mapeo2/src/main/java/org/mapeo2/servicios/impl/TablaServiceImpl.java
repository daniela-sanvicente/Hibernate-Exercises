package org.mapeo2.servicios.impl;

import org.mapeo2.entity.Tabla;
import org.mapeo2.modelo.dao.TablaDAO;
import org.mapeo2.modelo.dao.impl.TablaDAOImpl;
import org.mapeo2.servicios.TablaService;

import java.util.List;

public class TablaServiceImpl implements TablaService {
    private static TablaServiceImpl instance;

    private static final TablaDAO tablaDAO = TablaDAOImpl.getInstance();

    private TablaServiceImpl() {}

    public static TablaServiceImpl getInstance() {
        if (instance == null)
            instance = new TablaServiceImpl();
        return instance;
    }

    @Override
    public Tabla getTablaById(Integer id) {
        return tablaDAO.getTablaById(id);
    }

    @Override
    public List<Tabla> getAllTablas() {
        return tablaDAO.getAllTablas();
    }
}
