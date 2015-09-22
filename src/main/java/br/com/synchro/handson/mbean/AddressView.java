package br.com.synchro.handson.mbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.synchro.handson.domain.Address;
import br.com.synchro.handson.domain.dto.AddressDTO;
import br.com.synchro.handson.exception.ServiceException;
import br.com.synchro.handson.service.AddressService;
import br.com.synchro.handson.service.AddressServiceImpl;

/**
 * 
 * @author cvs
 * @version 1.0
 */
@ManagedBean
@SessionScoped
@SuppressWarnings("serial")
public class AddressView implements Serializable {

    private AddressService addressService;

    private Address address;

    @SuppressWarnings("unused")
    private List<AddressDTO> list;

    private String message;

    /**
     * 
     */
    public void addAddress() {
	try {
	    this.addressService.addContact(this.address);
	    this.address = new Address();
	} catch (final ServiceException ex) {
	    ex.printStackTrace();
	}
    }

    /**
     * @return the address
     */
    public Address getAddress() {
	return address;
    }

    /**
     * @return the list
     */
    public List<AddressDTO> getList() {
	try {
	    return this.list = this.addressService.loadAll();
	} catch (final ServiceException ex) {
	    ex.printStackTrace();
	}
	return null;
    }

    /**
     * @return the message
     */
    public String getMessage() {
	return message;
    }

    /**
     * @return nav item
     */
    public String goToFormAdd() {
	this.address = new Address();
	return "go-to-add-form";
    }

    /**
     * @return nav item
     */
    public String goToIndex() {
	this.address = new Address();
	return "go-to-index";
    }

    /**
     * 
     */
    @PostConstruct
    public void init() {
	this.addressService = new AddressServiceImpl();
	this.message = "Addresses List";
    }

    /**
     * @param pAddress
     *            the address to set
     */
    public void setAddress(final Address pAddress) {
	address = pAddress;
    }

    /**
     * @param pList
     *            the list to set
     */
    public void setList(final List<AddressDTO> pList) {
	list = pList;
    }

    /**
     * @param pMessage
     *            the message to set
     */
    public void setMessage(final String pMessage) {
	message = pMessage;
    }

}
