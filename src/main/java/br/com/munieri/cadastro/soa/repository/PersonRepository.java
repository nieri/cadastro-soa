package br.com.munieri.cadastro.soa.repository;

import br.com.munieri.cadastro.soa.model.Person;

import java.util.List;

public interface PersonRepository {

    List<Person> list();

    void delete(Long id);

    Person findById(Long id);

    void save(Person person);

    void update(Person person);

}
