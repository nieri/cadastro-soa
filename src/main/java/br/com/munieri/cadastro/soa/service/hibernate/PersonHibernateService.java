package br.com.munieri.cadastro.soa.service.hibernate;

import br.com.munieri.cadastro.soa.model.Person;
import br.com.munieri.cadastro.soa.repository.PersonRepository;
import br.com.munieri.cadastro.soa.repository.hibernate.PersonHibernateRepository;
import br.com.munieri.cadastro.soa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PersonHibernateService implements PersonService{

    @Autowired
    PersonRepository repository;

    @Override
    public List<Person> list() {
        return repository.list();
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Person findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Person person) {
        repository.save(person);
    }

    @Override
    public void update(Person person) {
        repository.save(person);
    }
}
