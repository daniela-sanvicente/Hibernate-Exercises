package proyecto_final.servicios;

import proyecto_final.entity.Pago;

import java.util.List;

public interface PagoService {
    Pago getPagoById(Integer id);
    List<Pago> getAllPagos();
    Boolean insertPago(Pago pago);
	Boolean updatePago(Pago pago);
	Boolean deletePago(Pago pago);
}
