/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.cdi.notify.implementation;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;

import javax.annotation.PostConstruct;
import javax.json.Json;
import javax.json.JsonObject;

import br.com.codecode.workix.cdi.notify.Notification;
import br.com.codecode.workix.cdi.qualifiers.Push;
import br.com.codecode.workix.interfaces.Debugable;
import br.com.codecode.workix.interfaces.Notificable;

/**
 * Push Message Implementation<br>
 * Send a Text Message to Firebase
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see Debugable
 */
@Push
public class PushMessage implements Notification, Debugable {

    private final String WEB_API_KEY = "GET ME FROM PROPERTIES";    

    @PostConstruct
    private void init() {
	Debugable.super.onStart();
    }

    @Override
    public void doSendMessage(Notificable to, String title, String body) {
	

	try {
		JsonObject jsonObject = Json.createObjectBuilder().add("to", to.getFirebaseMessageToken())
				.add("notification",
					Json.createObjectBuilder().add("body", body).add("title", title).add("icon", "myicon").build())
				.build();

			String json = jsonObject.toString();

			System.out.println(json);

		String FCM_SERVER = "https://fcm.googleapis.com/fcm/send";
		
		HttpRequest request = HttpRequest.newBuilder()
				  .uri(new URI(FCM_SERVER))
				  .header("Authorization", "key="+ WEB_API_KEY)				  
				  .POST(BodyPublishers.ofString(json))
				  .build();

	   

	    System.out.println(request.headers());

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}
