package mx.unam.tic.diplomado.agenda.servicios.impl;

import mx.unam.tic.diplomado.agenda.modelo.dao.PhoneTypeDAO;
import mx.unam.tic.diplomado.agenda.modelo.dao.impl.PhoneTypeDAOImpl;
import mx.unam.tic.diplomado.agenda.modelo.entidades.PhoneType;
import mx.unam.tic.diplomado.agenda.servicios.PhoneTypeService;

import java.util.List;

public class PhoneTypeServiceImpl implements PhoneTypeService {
	
	private static PhoneTypeServiceImpl instance;
	private static final PhoneTypeDAO phoneTypeDAO = PhoneTypeDAOImpl.getInstance();
	
	private PhoneTypeServiceImpl() {
		
	}
	
	public static PhoneTypeServiceImpl getInstance() {
		if (instance == null) {
			instance = new PhoneTypeServiceImpl();
		}
		return instance;
	}
	
	@Override
	public List<PhoneType> getAllPhoneTypes() {
		return phoneTypeDAO.getAllPhoneTypes();
	}

	@Override
	public PhoneType getPhoneTypeById(Integer id) {
		return phoneTypeDAO.getPhoneTypeById(id);
	}
	
	@Override
	public Boolean insertPhoneType(PhoneType phoneType) {
		return phoneTypeDAO.insertPhoneType(phoneType);
	}
	
	@Override
	public Boolean updatePhoneType(PhoneType phoneType) {
		return phoneTypeDAO.updatePhoneType(phoneType);
	}
	
	@Override
	public Boolean deletePhoneType(PhoneType phoneType) {
		return phoneTypeDAO.deletePhoneType(phoneType);
	}
}
