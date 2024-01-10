package proyecto_final.modelo.dao;

import proyecto_final.entity.Pago;

import java.util.List;

public interface PagoDAO {
    Pago getPagoById(Integer id);
    List<Pago> getAllPagos();
    Boolean insertPago(Pago pago);
	Boolean updatePago(Pago pago);
	Boolean deletePago(Pago pago);
}
