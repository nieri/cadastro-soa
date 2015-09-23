package br.com.munieri.cadastro.soa.repository;

import br.com.munieri.cadastro.soa.model.Person;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PersonRepository {

    private static final String URL = "http://localhost:8081";

    public HashSet<Person> findAll(){
        RestTemplate restTemplate = new RestTemplate();
        HashSet<Person> personList = restTemplate.getForObject(URL + "/all", HashSet.class);
        return personList;
    }

    private void delete()
    {
        final String uri = URL + "/delete";

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "4");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete ( uri,  params );
    }

    private void create()
    {

        final String uri = URL + "/create";

        Person person = new Person();
        person.setName("Maluco");
        person.setPhone("123");

        RestTemplate restTemplate = new RestTemplate();
        Person result = restTemplate.postForObject( uri, person, Person.class);

        System.out.println(result);
    }

    public static void main(String... args) {

        PersonRepository repository = new PersonRepository();
//        System.out.println(repository.findAll());
//
//        HashSet<Person> personList = repository.findAll();
//
//        System.out.println(personList);

        repository.create();

    }
}
