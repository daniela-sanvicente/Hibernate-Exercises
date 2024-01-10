package proyecto_final.servicios;

import proyecto_final.entity.MetodoPago;

import java.util.List;

public interface MetodoPagoService {
    MetodoPago getMetodoPagoById(Integer id);
    List<MetodoPago> getAllMetodoPagos();
    Boolean insertMetodoPago(MetodoPago pago);
	Boolean updateMetodoPago(MetodoPago pago);
	Boolean deleteMetodoPago(MetodoPago pago);
}
