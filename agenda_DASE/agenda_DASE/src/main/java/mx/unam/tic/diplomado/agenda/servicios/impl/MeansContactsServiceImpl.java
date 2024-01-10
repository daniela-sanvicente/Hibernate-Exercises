package mx.unam.tic.diplomado.agenda.servicios.impl;

import mx.unam.tic.diplomado.agenda.modelo.dao.MeansContactsDAO;
import mx.unam.tic.diplomado.agenda.modelo.dao.impl.MeansContactsDAOImpl;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MeansContacts;
import mx.unam.tic.diplomado.agenda.servicios.MeansContactsService;

import java.util.List;

public class MeansContactsServiceImpl implements MeansContactsService {
	
	private static MeansContactsServiceImpl instance;
	private static MeansContactsDAO contactoDAO = MeansContactsDAOImpl.getInstance();
	
	private MeansContactsServiceImpl() {}
	
	public static MeansContactsServiceImpl getInstance() {
		if (instance == null) {
			instance = new MeansContactsServiceImpl();
		}
		return instance;
	}

	@Override
	public MeansContacts getMeansContactsById(Integer id) {
		return contactoDAO.getMeansContactsById(id);
	}

	@Override
	public List<MeansContacts> getAllMeansContacts() {
		return contactoDAO.getAllMeansContacts();
	}

	@Override
	public Boolean insertMeansContacts(MeansContacts contacto) {
		return contactoDAO.insertMeansContacts(contacto);
	}

	@Override
	public Boolean updateMeansContacts(MeansContacts contacto) {
		return contactoDAO.updateMeansContacts(contacto);
	}

	@Override
	public Boolean deleteMeansContacts(MeansContacts contacto) {
		return contactoDAO.deleteMeansContacts(contacto);
	}
	
	@Override
	public List<MeansContacts> getMeansContactsByContact(Integer id) {
		return contactoDAO.getMeansContactsByContact(id);
	}
}
