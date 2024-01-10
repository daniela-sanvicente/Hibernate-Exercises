package proyecto_final.servicios.impl;

import proyecto_final.entity.MetodoPago;
import proyecto_final.modelo.dao.MetodoPagoDAO;
import proyecto_final.modelo.dao.impl.MetodoPagoDAOImpl;
import proyecto_final.servicios.MetodoPagoService;

import java.util.List;

public class MetodoPagoServiceImpl implements MetodoPagoService {
    private static MetodoPagoServiceImpl instance;

    private static final MetodoPagoDAO metodoPagoDAO = MetodoPagoDAOImpl.getInstance();

    private MetodoPagoServiceImpl() {}

    public static MetodoPagoServiceImpl getInstance() {
        if (instance == null)
            instance = new MetodoPagoServiceImpl();
        return instance;
    }

    @Override
    public MetodoPago getMetodoPagoById(Integer id) {
        return metodoPagoDAO.getMetodoPagoById(id);
    }

    @Override
    public List<MetodoPago> getAllMetodoPagos() {
        return metodoPagoDAO.getAllMetodoPagos();
    }

    @Override
    public Boolean insertMetodoPago(MetodoPago metodoPago) {
        return metodoPagoDAO.insertMetodoPago(metodoPago);
    }

    @Override
	public Boolean updateMetodoPago(MetodoPago metodoPago) {
        return metodoPagoDAO.updateMetodoPago(metodoPago);
    }

    @Override
	public Boolean deleteMetodoPago(MetodoPago metodoPago) {
        return metodoPagoDAO.deleteMetodoPago(metodoPago);
    }
}
