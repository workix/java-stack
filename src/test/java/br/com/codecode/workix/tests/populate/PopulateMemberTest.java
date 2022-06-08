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

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.codecode.workix.jpa.models.Member;
import br.com.codecode.workix.jpa.models.SocialMedia;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;

/**
 * Populate DB with Members
 * 
 * @author felipe
 * @since 1.1
 * @version 1.0
 */
public class PopulateMemberTest extends BaseTest implements CommonPopTest<Member> {

    private List<Member> members;

    private String resp;    

    @Before
    @Override
    public void create() {

	members = new ArrayList<>();	

	    Member felipe = Member.builder()

	    .withName("FELIPE RODRIGUES MICHETTI")
	    
	    .withOccupation("Fundador e Desenvolvedor")
	    
	    .withShortText("Porque pagar por um conteúdo que você não tem certeza de sua verdade?")
	    
	    .withPicture("http://localhost:8080/workix/resources/images/members/felipe_140_140.jpg");	    	    
	    
	    felipe.addSocialMedia(SocialMedia.builder().withMedia("GitHub").withUrl("https://github.com/frmichetti").build());
	    
	    felipe.addSocialMedia(SocialMedia.builder().withMedia("Twitter").withUrl("https://twitter.com/frmichetti").build());
	    
	    felipe.addSocialMedia(SocialMedia.builder().withMedia("Linkedin").withUrl("https://br.linkedin.com/pub/felipe-rodrigues-michetti/105/61/511").build());

	    System.out.println("[create] " + felipe.getName());

	    addToList(felipe);

	assertEquals(1 , members.size());

    }

    @Override
    public void addToList(Member m) {

	assertNotNull(m);

	System.out.println("[addToList] " + m.getName());

	members.add(m);

    }

    @Test
    @Override
    public void sendToServer() {

	members.stream().forEach(m -> {

	    System.out.println("[sendToServer] " + m.getName());

	    resp = HttpTest.sendPost(server + "/members", getGson().toJson(m));

	    assertNotNull(resp);

	});

    }

}
