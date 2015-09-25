package br.com.munieri.cadastro.soa.repository;

import br.com.munieri.cadastro.soa.model.Person;
import br.com.munieri.cadastro.soa.repository.converter.PersonConverter;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Repository
public class PersonRepository {

    private static final String URL = "http://localhost:8081";
    private final PersonConverter personConverter = new PersonConverter();

    public List<Person> list(){

        RestTemplate restTemplate = new RestTemplate();
        List<HashMap> result = restTemplate.getForObject(URL + "/all", List.class);

        return PersonConverter.convert(result);
    }

    private void delete(Long id) {
        final String uri = URL + "/delete/{id}";

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "2");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete ( uri,  params );
    }

    private void create() {

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

        repository.delete(2l);
    }
}
