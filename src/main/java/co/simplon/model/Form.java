package co.simplon.model;

public class Form {
	 String email;
     String objet;
     String message;
     
    public Form () {};
     
	public Form(String email, String objet, String message) {
		this.email = email;
		this.objet = objet;
		this.message = message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Form [email=" + email + ", objet=" + objet + ", message=" + message + "]";
	}
     
     
}
