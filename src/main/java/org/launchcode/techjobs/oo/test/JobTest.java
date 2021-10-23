package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

	@Test
	public void testSettingJobId() {
		Job job = new Job();
		Job job2 = new Job();
		assertNotEquals(job.getId(), job2.getId());
	}

	@Test
	public void testJobConstructorSetsAllFields(){
		Job job = new Job("Product tester",
		  new Employer("ACME"),
		  new Location("Desert"),
		  new PositionType("Quality " + "control"),
		  new CoreCompetency("Persistence"));

		assertTrue(job instanceof Job);
		assertTrue(job.getEmployer() instanceof Employer);
		assertTrue(job.getLocation() instanceof Location);
		assertTrue(job.getPositionType() instanceof PositionType);
		assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

		assertEquals(job.getName(),"Product tester");
		assertEquals(job.getEmployer().getValue(), "ACME");
		assertEquals(job.getLocation().getValue(),"Desert");
		assertEquals(job.getPositionType().getValue(),"Quality " + "control");
		assertEquals(job.getCoreCompetency().getValue(),"Persistence");

	}

	@Test
	public void testJobsForEquality(){

		Job job = new Job("Product tester",
		  new Employer("ACME"),
		  new Location("Desert"),
		  new PositionType("Quality " + "control"),
		  new CoreCompetency("Persistence"));

		Job job2 = new Job("Product tester",
		  new Employer("ACME"),
		  new Location("Desert"),
		  new PositionType("Quality " + "control"),
		  new CoreCompetency("Persistence"));

		assertFalse(job.getId() == (job2.getId()));
	}

	@Test
	public void testToStringStartsAndEndsWithNewLine(){
		Job job = new Job();
		assertEquals(job.toString().charAt(0), '\n');
		assertEquals(job.toString().charAt(job.toString().length()-1), '\n');
	}

	@Test
	public void testToStringContainsCorrectLabelsAndData(){
        Job job = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
		assertEquals(job.toString(),
		  "\n" +
			"ID: " + job.getId() + "\n" +
			"Name: Web Developer\n" +
			"Employer: LaunchCode\n" +
			"Location: St. Louis\n" +
			"Position Type: Front-end developer\n" +
			"Core Competency: JavaScript\n");
	}

	@Test
	public void testToStringHandlesEmptyField(){
		Job job1 = new Job();
		Job job2 = new Job("", new Employer(""), new Location("St. Louis"), new PositionType(
		"Front-end developer"), new CoreCompetency("JavaScript"));
		assertEquals(job1.toString(), '\n' +
		                             "OOPS! This job does not seem to exist." +
		                             '\n');
		assertEquals(job2.toString(), 		  '\n' +
			                                   "ID: " + job2.getId() + '\n' +
			                                   "Name: Data not available" + '\n' +
			                                   "Employer: Data not available" + '\n' +
			                                   "Location: St. Louis" + '\n' +
			                                   "Position Type: Front-end developer" + '\n' +
			                                   "Core Competency: JavaScript" + '\n');
	}
}
