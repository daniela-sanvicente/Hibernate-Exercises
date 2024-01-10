package proyecto_final.modelo.dao;

import proyecto_final.entity.MetodoPago;

import java.util.List;

public interface MetodoPagoDAO {
    MetodoPago getMetodoPagoById(Integer id);
    List<MetodoPago> getAllMetodoPagos();
    Boolean insertMetodoPago(MetodoPago pago);
	Boolean updateMetodoPago(MetodoPago pago);
	Boolean deleteMetodoPago(MetodoPago pago);
}
