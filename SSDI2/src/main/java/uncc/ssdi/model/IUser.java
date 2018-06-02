package uncc.ssdi.model;

public interface IUser {
	
	public String getFirstname();
	public void setFirstname(String name);
	public String getEmailid();
	public String getPassword();
	public void setPassword(String password);
	public void setEmailid(String emailid);
}
