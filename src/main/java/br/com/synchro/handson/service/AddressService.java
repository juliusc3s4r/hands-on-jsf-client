package br.com.synchro.handson.service;

import java.util.List;

import br.com.synchro.handson.domain.Address;
import br.com.synchro.handson.domain.dto.AddressDTO;
import br.com.synchro.handson.exception.ServiceException;

/**
 * 
 * @author cvs
 * @version 1.0
 */
public interface AddressService {

    /**
     * @param address
     * @return status
     * @throws ServiceException
     */
    public String addContact(Address address) throws ServiceException;

    /**
     * @return status
     * @throws ServiceException
     */
    public List<AddressDTO> loadAll() throws ServiceException;
}
