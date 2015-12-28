package administracion.services.login;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import administracion.services.login.data.CustomerTable;
import administracion.services.login.domain.Customer;
import administracion.services.login.models.ResponseLogin;
import administracion.services.login.models.UserObject;

@Transactional
public class LoginManager implements ILoginManager {

	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public UserObject getCustomerData(UserObject user) {
		
		Session session = getCurrentSession();		
		
		List<CustomerTable> customerTableList = session
				.createCriteria(CustomerTable.class)
				.add(Restrictions.like("customerNumber", user.getRequest()
						.getCustomerNumber()))
				.add(Restrictions.like("password", user.getRequest()
						.getPassword())).list();
		
		if (customerTableList.size() == 1) {
			CustomerTable customerTable = customerTableList.get(0);
			Customer customer = new Customer();
			BeanUtils.copyProperties(customerTable, customer);
			
			user.setResponse(new ResponseLogin());
			user.getResponse().setCustomer(customer);
		}
		
		return user;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

}
