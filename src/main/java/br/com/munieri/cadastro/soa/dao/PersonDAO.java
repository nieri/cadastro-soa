package br.com.munieri.cadastro.soa.dao;

import br.com.munieri.cadastro.soa.model.Person;

import java.util.List;

public interface PersonDAO {

    void save(Person person);
    void update(Person person);
    List<Person> list();
    Person findById(Long id);
    void delete(Long id);
}
