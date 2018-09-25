package co.simplon.model;

public class MailInfoDest {
	
	Long id;
	String emailAdresseDesti;
	
	public MailInfoDest() {}
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getEmailAdresseDesti() {
		return emailAdresseDesti;
	}



	public void setEmailAdresseDesti(String emailAdresseDesti) {
		this.emailAdresseDesti = emailAdresseDesti;
	}



	@Override
	public String toString() {
		return "MailInfoDest [id=" + id + ", emailAdresseDesti=" + emailAdresseDesti + "]";
	}

	
	
	

}
