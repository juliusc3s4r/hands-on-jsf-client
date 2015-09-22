package br.com.synchro.handson.service;

import java.util.List;

import br.com.synchro.handson.client.AddressRestClient;
import br.com.synchro.handson.domain.Address;
import br.com.synchro.handson.domain.dto.AddressDTO;
import br.com.synchro.handson.exception.RestException;
import br.com.synchro.handson.exception.ServiceException;

/**
 * 
 * @author cvs
 * @version 1.0
 */
public class AddressServiceImpl implements AddressService {

    private AddressRestClient addressRestClient;

    /**
     * 
     */
    public AddressServiceImpl() {
	this.addressRestClient = new AddressRestClient();
    }

    public String addContact(final Address address) throws ServiceException {
	try {
	    return this.addressRestClient.addContact(address);
	} catch (final RestException ex) {
	    throw new ServiceException(ex.getMessage());
	}
    }

    public List<AddressDTO> loadAll() throws ServiceException {
	try {
	    return this.addressRestClient.loadAll();
	} catch (final RestException ex) {
	    throw new ServiceException(ex.getMessage());
	}
    }
}
