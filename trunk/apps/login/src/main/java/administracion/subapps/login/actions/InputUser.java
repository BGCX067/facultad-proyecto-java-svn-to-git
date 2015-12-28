package administracion.subapps.login.actions;

import org.springframework.beans.BeanUtils;

import administracion.services.login.ILoginManager;
import administracion.services.login.models.RequestLogin;
import administracion.services.login.models.ResponseLogin;
import administracion.services.login.models.UserObject;
import administracion.subapps.login.models.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class InputUser extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = 1743524805130107231L;
	private User user = new User();
	private ILoginManager loginManager;
	
	public String validateUser(){
		//Accede a la base de datos y obtiene el resultado de la consulta, si no obtiene el usuario devuelve error, sino
		// va a la pagina de bienvenida
		
		UserObject userObject = new UserObject();
		RequestLogin requestLogin = new RequestLogin();
		requestLogin.setCustomerNumber(this.user.getCustomerNumber());
		requestLogin.setPassword(this.user.getPassword());
		userObject.setRequest(requestLogin);
		
		userObject = this.loginManager.getCustomerData(userObject);
		
		ResponseLogin responseLogin = userObject.getResponse();
		if (responseLogin == null) {
			return ERROR;
		}
		BeanUtils.copyProperties(responseLogin.getCustomer(), this.user);
		
		return SUCCESS;
	}

	public User getModel() {
		return this.user ;
	}
	
	public void validateValidateUser() {
		String customerNumber = this.user.getCustomerNumber();
		String password = this.user.getPassword();
		
		if (customerNumber == null || customerNumber.trim().length() == 0) {
			this.addFieldError("customerNumberError", "Por favor ingresar su número de cliente.");
		}		
		
		if (password == null || password.trim().length() == 0) {
			this.addFieldError("passwordError", "Por favor ingresar su contraseña.");
		}
	}

	public void setLoginManager(ILoginManager loginManager) {
		this.loginManager = loginManager;
	}

}
