package br.com.munieri.cadastro.soa.repository.converter;

import br.com.munieri.cadastro.soa.model.Person;
import br.com.munieri.cadastro.soa.repository.PersonRepository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonConverter {

    public static List<Person> convert(List<HashMap> result) {

        List<Person> personList = new ArrayList<Person>();
        Person person;
        for (HashMap map : result) {
            person = new Person();
            person.setName((String) map.get("name"));
            person.setPhone((String) map.get("phone"));
            personList.add(person);
        }

        return personList;
    }
}