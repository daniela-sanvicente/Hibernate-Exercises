package proyecto_final.servicios.impl;

import proyecto_final.entity.Pago;
import proyecto_final.modelo.dao.PagoDAO;
import proyecto_final.modelo.dao.impl.PagoDAOImpl;
import proyecto_final.servicios.PagoService;

import java.util.List;

public class PagoServiceImpl implements PagoService {
    private static PagoServiceImpl instance;

    private static final PagoDAO pagoDAO = PagoDAOImpl.getInstance();

    private PagoServiceImpl() {}

    public static PagoServiceImpl getInstance() {
        if (instance == null)
            instance = new PagoServiceImpl();
        return instance;
    }

    @Override
    public Pago getPagoById(Integer id) {
        return pagoDAO.getPagoById(id);
    }

    @Override
    public List<Pago> getAllPagos() {
        return pagoDAO.getAllPagos();
    }

    @Override
    public Boolean insertPago(Pago pago) {
        return pagoDAO.insertPago(pago);
    }

    @Override
	public Boolean updatePago(Pago pago) {
        return pagoDAO.updatePago(pago);
    }

    @Override
	public Boolean deletePago(Pago pago) {
        return pagoDAO.deletePago(pago);
    }
}
