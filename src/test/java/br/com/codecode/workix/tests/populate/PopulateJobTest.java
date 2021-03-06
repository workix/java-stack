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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.core.enums.JobCategory;
import br.com.codecode.workix.core.enums.JobType;
import br.com.codecode.workix.jpa.models.Company;
import br.com.codecode.workix.jpa.models.Job;
import br.com.codecode.workix.tests.android.BaseTest;
import br.com.codecode.workix.tests.util.HttpTest;

/**
 * Populate DB with Jobs
 * 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public class PopulateJobTest extends BaseTest implements CommonPopTest<Job> {

    private List<Company> companies;

    private List<Job> jobs;

    private String resp;

    private int howManyJobs = 50;

    @Before
    public void downloadCompanies() {

	System.out.println("[downloadCompanies]");

	resp = HttpTest.sendGet(server + "/companies");

	companies = getGson().fromJson(resp, new TypeToken<List<Company>>(){}.getType());

	assertNotNull(companies);

	assertTrue(companies.size() > 0);

    }

    @Override
    public void create() {

	assertNotNull(companies);

	assertTrue(companies.size() > 0);

	jobs = new ArrayList<>();

	for (int x = 0; x < howManyJobs; x++) {

	    Job j = Job.builder()

	    .withTitle("Vaga 'Mockup' N# " + String.valueOf(x + 1))

	    .withDescription("Descrição da Vaga " + String.valueOf(x + 1))

	    .withRequirement("Requerimentos da Vaga " + String.valueOf(x + 1))

	    .withBenefits("Benefícios da Vaga " + String.valueOf(x + 1))	    

	    .withJobType((x % 2 == 0) ? JobType.FULLTIME : JobType.TEMPORARY)
	    
	    .withJobCategory(JobCategory.OPERATOR)

	    .withMinPayment(new BigDecimal(1_00 * x + 1 + 10))

	    .withMaxPayment(new BigDecimal(1_00 * x + 1 + 20))

	    .withCompany(companies.get(x));

	    System.out.println("[create] " + j.getTitle());

	    addToList(j);
	}

	assertEquals(howManyJobs, companies.size());

    }

    @Override
    public void addToList(Job job) {

	assertNotNull(job);

	assertNotNull(jobs);

	System.out.println("[addToList]" + job.getTitle());

	jobs.add(job);
    }

    @Test
    @Override
    public void sendToServer() {

	create();

	assertNotNull(jobs);

	assertTrue(jobs.size() > 0);

	jobs.forEach(j -> {

	    System.out.println("[sendToServer] " + j.getTitle());

	    resp = HttpTest.sendPost(server + "/jobs", getGson().toJson(j));

	    assertNotNull(resp);

	});

    }

}
