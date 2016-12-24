package services;

import javax.ejb.Local;

@Local
public interface GwMessageServiceLocal {
	 public void sendEmail(String to, String from, String subject, String content);

}
