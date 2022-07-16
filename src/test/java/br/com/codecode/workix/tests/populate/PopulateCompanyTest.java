/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.populate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.core.enums.State;
import br.com.codecode.workix.jpa.models.Contact;
import br.com.codecode.workix.jpa.models.Company;
import br.com.codecode.workix.jpa.models.Locale;
import br.com.codecode.workix.jpa.models.User;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;

/**
 * Populate DB with Companies
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public class PopulateCompanyTest extends BaseTest implements CommonPopTest<Company> {

    private List<Company> companies;

    private String resp;

    private List<User> users;

    @Before
    public void downloadUsers() {

	System.out.println("[downloadUsers]");

	users = new ArrayList<>();

	resp = HttpTest.sendGet(server + "/users");

	users = getGson().fromJson(resp, new TypeToken<List<User>>(){}.getType());

	assertTrue(users.size() > 0);

    }

    @Override
    public void create() {

	assertNotNull(users);

	assertTrue(users.size() > 0);

	users = users.subList((users.size() / 2), users.size());

	assertTrue(users.get(0).getId() == 51L);

	companies = new ArrayList<>();

	for (User u : users) {

	    Company c = Company.builder()

		    .withName("Empresa 'Mockup' N# " + String.valueOf(u.getId()))

		    .withSegment("Segmento N# " + String.valueOf(u.getId()))

		    .withCnpj(Long.MAX_VALUE - u.getId())

		    .withContact(Contact.builder().withMobilePhone(123456).build())	    

		    .withLocale(Locale.builder()
			    .withCity("São José dos Campos")
			    .withEstate(State.SP)
			    .withNeighborhood("Bairro")
			    .withNumber("212")
			    .withStreet("Rua")
			    .withZipCode(45632145)
			    .build())

		    .withUser(u);
	    
	    c.setDescription("Descrição Aqui ");
	    
	    for (int i = 0; i < 5; i++) {
		c.setDescription(c.getDescription().concat(c.getDescription()));
	    }

		c.setLogo("http://localhost:8080/workix/resources/placeholder/220x100.jpg");

	    assertNotNull(c);

	    System.out.println("[create] " + c.getName());

	    addToList(c);

	}

	assertEquals(50, companies.size());

    }

    @Override
    public void addToList(Company company) {

	assertNotNull(company);

	assertNotNull(companies);

	System.out.println("[addToList] " + company.getName());

	companies.add(company);

    }

    @Test
    @Override
    public void sendToServer() {

	assertNotNull(users);

	create();

	assertNotNull(companies);

	companies.stream().forEach(c -> {

	    System.out.println("[sendToServer] " + c.getName());

	    resp = HttpTest.sendPost(server + "/companies", getGson().toJson(c));

	    assertNotNull(resp);
	});

    }

}
