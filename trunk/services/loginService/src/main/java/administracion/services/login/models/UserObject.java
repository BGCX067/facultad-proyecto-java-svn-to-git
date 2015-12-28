package administracion.services.login.models;

public class UserObject {
	private RequestLogin request;
	private ResponseLogin response;

	public RequestLogin getRequest() {
		return request;
	}

	public void setRequest(RequestLogin request) {
		this.request = request;
	}

	public ResponseLogin getResponse() {
		return response;
	}

	public void setResponse(ResponseLogin response) {
		this.response = response;
	}
}
