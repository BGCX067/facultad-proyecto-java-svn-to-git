package administracion.services.login.models;

import administracion.services.login.domain.Customer;

public class ResponseLogin {
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
