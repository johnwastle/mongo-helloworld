package com.jwastle.mongo.persistence;

import com.jwastle.mongo.domain.Person;

public interface PersonRepository {

    public void logAllPersons();

    public void insertPerson(Person p) ;

    public void createPersonCollection();

    public void dropPersonCollection();

}
