package com.txt.datacollection.resipository;

import com.txt.datacollection.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

// @RunWith(SpringRunner.class)
// @SpringBootTest
public class PersonResipositoryTest {
    // @Autowired
    // PersonResipository personResipository;
    @Test
    public void testPersonResipository() throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person(null, "Allen", "Boy", "随便一点备注了~~");


        Field name = person.getClass().getDeclaredField("name");

        name.setAccessible(true);
        name.set(person,"Allen2222");

        System.out.println(person);


    }
}