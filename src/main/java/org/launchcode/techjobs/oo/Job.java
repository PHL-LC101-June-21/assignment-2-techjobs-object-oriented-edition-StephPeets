package org.launchcode.techjobs.oo;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Job {

	private final Integer id;
	private static Integer nextId = 1;

	private String name;
	private Employer employer;
	private Location location;
	private PositionType positionType;
	private CoreCompetency coreCompetency;


	public Job() {
		id = nextId;
		nextId++;
	}

	public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
		this();
		this.name = name;
		this.employer = employer;
		this.location = location;
		this.positionType = positionType;
		this.coreCompetency = coreCompetency;
	}


	public ArrayList<String> listClassValues() {
		try {
			String[] classValues =
			{getName(),
			getEmployer().toString(),
			getLocation().toString(),
			getPositionType().toString(),
			getCoreCompetency().toString()};

			ArrayList<String> values = new ArrayList<>();
			for (String classValue : classValues) {
				if (classValue.isEmpty()) {
					values.add("Data does not exist.");
				} else {
					values.add(classValue);
				}
			}
			return values;
		} catch (Exception n) {
			return new ArrayList<>();
		}
	}

	@Override
	public String toString() {
		String result;
		ArrayList<String> values = listClassValues();
		if (values.stream().distinct().count() <= 1) {
			result = "OOPS! This job does not seem to exist";
		} else {
			result = "\nID: " + this.getId() + "\n" +
			         "Name: " + values.get(0) + "\n" +
			         "Employer: " + values.get(1) + "\n" +
			         "Location: " + values.get(2) + "\n" +
			         "Position Type: " + values.get(3) + "\n" +
			         "Core Competency: " + values.get(4) + "\n";
		}
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Job))
			return false;
		Job job = (Job) o;
		return Objects.equals(getId(), job.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	public String getId() {
		return id.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public PositionType getPositionType() {
		return positionType;
	}

	public void setPositionType(PositionType positionType) {
		this.positionType = positionType;
	}

	public CoreCompetency getCoreCompetency() {
		return coreCompetency;
	}

	public void setCoreCompetency(CoreCompetency coreCompetency) {
		this.coreCompetency = coreCompetency;
	}

}
