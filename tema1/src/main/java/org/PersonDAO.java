package org;

public interface PersonDAO {
	public int insertPerson(Person person);
	public Person getPerson(String name, String email);
	}

