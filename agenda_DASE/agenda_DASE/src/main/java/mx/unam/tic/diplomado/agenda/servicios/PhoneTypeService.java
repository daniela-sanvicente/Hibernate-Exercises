package mx.unam.tic.diplomado.agenda.servicios;

import mx.unam.tic.diplomado.agenda.modelo.entidades.PhoneType;

import java.util.List;

public interface PhoneTypeService {
	List<PhoneType> getAllPhoneTypes();

	PhoneType getPhoneTypeById(Integer id);

	Boolean insertPhoneType(PhoneType phoneType);

	Boolean updatePhoneType(PhoneType phoneType);

	Boolean deletePhoneType(PhoneType phoneType);
}
