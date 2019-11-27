package yte.spring.mailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class MailsenderApplication implements CommandLineRunner {

	@Autowired
	private JavaMailSender javaMailSender;

	public static void main(String[] args) {
		SpringApplication.run(MailsenderApplication.class, args);
	}

	@Override
	public void run(String... args){
		System.out.println("Sending Email...");
		try {
			sendEmail();
		}catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("Done");
	}

	public void sendEmail(){

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("kenanaygoren@gmail.com");
		msg.setSubject("Testing from spring boot");
		msg.setText("Hello World \n Spring Boot EMail");
		javaMailSender.send(msg);
	}
}
