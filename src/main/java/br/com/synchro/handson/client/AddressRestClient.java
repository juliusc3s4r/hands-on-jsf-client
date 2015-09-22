package br.com.synchro.handson.client;

import java.util.List;

import br.com.synchro.handson.domain.Address;
import br.com.synchro.handson.domain.dto.AddressDTO;
import br.com.synchro.handson.exception.RestException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

/**
 * 
 * 
 * @author cvs
 * @version 1.0
 */
public class AddressRestClient {

    private static final String REST_API_LOAD_ALL = "http://localhost:8080/hands-on-services/resource/handson-service/get-all";
    private static final String REST_API_ADD = "http://localhost:8080/hands-on-services/resource/handson-service/post";

    private Client jerseyClient;

    /**
     * 
     */
    public AddressRestClient() {
	final ClientConfig clientConfig = new DefaultClientConfig();
	clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
	this.jerseyClient = Client.create(clientConfig);
    }

    /**
     * @param address
     * @return status
     * @throws RestException
     */
    public String addContact(final Address address) throws RestException {
	try {
	    final WebResource webResource = this.jerseyClient.resource(REST_API_ADD);
	    final ClientResponse response = webResource.accept("application/xml").type("application/xml")
		    .post(ClientResponse.class, address);
	    return response.getEntity(String.class);
	} catch (final Exception ex) {
	    throw new RestException(ex.getMessage());
	}
    }

    /**
     * @return list
     * @throws RestException
     */
    public List<AddressDTO> loadAll() throws RestException {
	try {
	    final WebResource webResource = this.jerseyClient.resource(REST_API_LOAD_ALL);
	    final ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
	    return response.getEntity(new GenericType<List<AddressDTO>>() {
		// nothing to do
	    });
	} catch (final Exception ex) {
	    throw new RestException(ex.getMessage());
	}
    }

}
