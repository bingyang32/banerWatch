package com.txt.datacollection.resipository;

import com.txt.datacollection.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonResipositoryTest {
    @Autowired
    PersonResipository personResipository;
    @Test
    public void testPersonResipository() {
        Person person = new Person(null, "Allen", "Boy", "随便一点备注了~~");

        personResipository.save(person);


    }
}