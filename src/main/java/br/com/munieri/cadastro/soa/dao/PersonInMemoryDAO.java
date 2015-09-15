package br.com.munieri.cadastro.soa.dao;

import br.com.munieri.cadastro.soa.model.Address;
import br.com.munieri.cadastro.soa.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("PersonInMemoryDAO")
public class PersonInMemoryDAO implements PersonDAO {

    private List<Person> persons = new ArrayList<>();

    public PersonInMemoryDAO() {

        Person person = new Person();
        person.setName("Murilo Nieri");
        person.setMobile("99221133");
        person.setPhone("44553322");

        Address address = new Address();
        address.setAddress("Rua Tutoia");
        address.setNumber(1);
        address.setComplement("apto 11");
        address.setCity("Sao Paulo");
        address.setState("SP");

        person.setAddress(address);
        persons.add(person);
    }

    @Override
    public void save(Person person) {
        persons.add(person);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public List<Person> listar() {
        return persons;
    }

    @Override
    public Person findById(Long id) {
        return null;
    }
}
