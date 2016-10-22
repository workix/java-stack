package br.com.codecode.openjobs.bean;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.tasks.OnSuccessListener;

/*@SessionScoped
@Named
@ManagedBean*/
@Model
public class FirebaseMB implements Serializable {

	private String name,email,uid,photo;

	private String idToken;

	private static final long serialVersionUID = -6683482350467577281L;	

	public FirebaseMB() {
		System.out.println("[CDI] " + getClass().getSimpleName());
	}

	@PostConstruct
	private void init(){		

		try{
			initFirebaseConfig();	
		}catch (Exception e) {
			System.err.println("Firebase Not Loaded");
		}
		

	}

	private void initFirebaseConfig() {

		FirebaseOptions options = null;

		try {

			options = new FirebaseOptions.Builder()
					.setServiceAccount(new URL("http://localhost:8080/jobs/google-services.json").openStream())					
					.build();

			FirebaseApp.initializeApp(options);		

		} catch (IOException e) {

			e.printStackTrace();

			System.err.println("Cannot Initialize Firebase App - Config File not Found");
		}

	}

	public String getIdToken() {
		System.out.println(idToken);
		return idToken;
	}

	public void setIdToken(String idToken) {

		this.idToken = idToken;

		if(idToken != null)
			if(!idToken.equals(""))

		verifyToken(idToken);

	}


	private void verifyToken(String token) {

		FirebaseAuth.getInstance().verifyIdToken(token)		
		.addOnSuccessListener(new OnSuccessListener<FirebaseToken>() {

			@Override
			public void onSuccess(FirebaseToken decodedToken) {

				uid = decodedToken.getUid();

				email = decodedToken.getEmail();

				name = decodedToken.getName();

				photo = decodedToken.getPicture();

				// ...
			}



		});

	}

	public String getEmail() {
		System.out.println("Email = " + email);
		return email;		
	}

	public String getPhoto() {
		return photo;
	}

	public String getName() {
		System.out.println("Name = " + name);
		return name;
	}

	public String getUid() {
		System.out.println("UID = " + uid);
		return uid;		
	}



}
