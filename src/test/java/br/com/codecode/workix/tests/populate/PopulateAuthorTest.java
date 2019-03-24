/**
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 */
package br.com.codecode.workix.tests.populate;

import br.com.codecode.workix.jpa.models.Author;
import br.com.codecode.workix.jpa.models.SocialMedia;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Populate DB with Authors
 *
 * @author felipe
 * @version 1.0
 * @since 1.1
 */
public class PopulateAuthorTest extends BaseTest implements CommonPopTest<Author> {

    private List<Author> authors;

    private String resp, serviceUrl;

    @Before
    @Override
    public void create() {

        authors = new ArrayList<>();

        if (server.contains("localhost")) {
            serviceUrl = "http://localhost/resources/placeholder/140x140.jpg";
        } else {
            serviceUrl = "http://www.workix.com.br/resources/placeholder/140x140.jpg";
        }

        int howManyAuthors = 100;
        for (int x = 0; x < howManyAuthors; x++) {


            Author a = Author.builder()
                    .withName("Autor 'Mockup' " + String.valueOf(x + 1))
                    .withPicture(serviceUrl)
                    .withAboutText("Sobre o Autor " + x);

            a.addSocialMedia(SocialMedia.builder().withMedia("Facebook").withUrl("http://www.facebook.com.br").build());

            a.addSocialMedia(SocialMedia.builder().withMedia("Twitter").withUrl("http://www.twitter.com.br").build());

            a.addSocialMedia(SocialMedia.builder().withMedia("Google Plus").withUrl("http://www.plus.google.com").build());

            System.out.println("[create] " + a.getName());

            addToList(a);
        }

        assertEquals(howManyAuthors, authors.size());

    }

    @Override
    public void addToList(Author a) {

        assertNotNull(a);

        System.out.println("[addToList] " + a.getName());

        authors.add(a);

    }

    @Test
    @Override
    public void sendToServer() {

        authors.forEach(a -> {

            System.out.println("[sendToServer] " + a.getName());

            resp = HttpTest.sendPost(server + "/authors", getGson().toJson(a));

            assertNotNull(resp);

        });

    }

}
