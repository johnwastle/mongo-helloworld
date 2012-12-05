package com.jwastle.mongo;

import com.jwastle.mongo.domain.Person;
import com.jwastle.mongo.persistence.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;


@Controller
public class MongoSpringDataController {

    private static final Logger logger = LoggerFactory.getLogger(MongoSpringDataController.class);

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/mongoSpring", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        String NAME = "John";
        int AGE = 10;

        Person personToInsert =  new Person(NAME, AGE);
        personRepository.insertPerson(personToInsert);

        model.addAttribute("person", personToInsert );
        return "mongoDone";
    }

}
