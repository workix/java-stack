/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.android.login;

import static org.junit.Assert.assertNotNull;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.junit.Before;
import org.junit.Test;

import br.com.codecode.workix.core.common.Token;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;

/**
 * Do Login With Firebase Server with JsonP
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public class InvalidLoginFirebaseTestDefault extends BaseTest implements LoginTest {

    private String url = server + "/login/firebaselogin";

    private String json;

    @Before
    @Override
    public void doLoginWithFirebase() {

	System.out.println("[doLoginWithFirebase]");

	Token t = Token.builder().withKey("XXXXXXXXX").build();

	JsonObject jsonObject = Json.createObjectBuilder()
		.add("createdAt", t.getCreatedAt().toString())
		.add("key", t.getKey()).build();

	json = HttpTest.sendPost(url, jsonObject.toString());

	assertNotNull(json);

    }

    @Test
    @Override
    public void parseJson() {	

	System.out.println("[parseJson]");

	JsonReader jr = Json.createReader(new StringReader(json));

	JsonObject jo = jr.readObject();

	assertNotNull(jo);

	jr.close();
    }

}
