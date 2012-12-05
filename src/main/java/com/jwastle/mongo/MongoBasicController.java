package com.jwastle.mongo;

import com.jwastle.mongo.domain.Person;
import com.mongodb.Mongo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.UnknownHostException;
import java.util.Locale;


@Controller
public class MongoBasicController {

    private static final Logger logger = LoggerFactory.getLogger(MongoBasicController.class);

    @RequestMapping(value = "/mongo", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        String NAME = "Joe3";
        int AGE = 36;
        Person personToInsert =  new Person(NAME, AGE);

        try {
            MongoOperations mongoOps = new MongoTemplate(new Mongo(), "mydb");
            mongoOps.insert(personToInsert);
            logger.info("" + mongoOps.findOne(new Query(Criteria.where("name").is(NAME)), Person.class));
            //mongoOps.dropCollection("person");
        } catch (UnknownHostException ex) {
            logger.error(ex.getMessage());
        }

        model.addAttribute("person", personToInsert );
        return "mongoDone";
    }

}
