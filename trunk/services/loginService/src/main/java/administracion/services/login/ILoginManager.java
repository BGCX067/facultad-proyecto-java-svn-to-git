package administracion.services.login;

import administracion.services.login.models.UserObject;

public interface ILoginManager {
	public UserObject getCustomerData(UserObject user);
}
