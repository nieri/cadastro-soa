package br.com.munieri.cadastro.soa.repository;

import br.com.munieri.cadastro.soa.model.Person;
import br.com.munieri.cadastro.soa.repository.converter.PersonConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Repository
public class PersonRepository {

    private static final String URL = "http://localhost:8081";
    private final PersonConverter personConverter = new PersonConverter();

    public List<Person> list(){
        final String uri = URL + "/all";

        RestTemplate restTemplate = new RestTemplate();
        List<HashMap> result = restTemplate.getForObject(uri, List.class);

        return PersonConverter.convertList(result);
    }

    public void delete(Long id) {
        final String uri = URL + "/delete/{id}";

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id.toString());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete( uri,  params );
    }

    public Person findById(Long id) {
        final String uri = URL + "/person/{id}";

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id.toString());

        RestTemplate restTemplate = new RestTemplate();
        List<HashMap> result = restTemplate.getForObject(uri, List.class, params);

        return PersonConverter.convertOne(result);
    }

    public void save(Person person) {
        final String uri = URL + "/create";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject( uri, person, String.class);
    }

    public void update(Person person) {
        final String uri = URL + "/update";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject( uri, person, String.class);
    }
}
