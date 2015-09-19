package br.com.munieri.cadastro.soa.dao;

import br.com.munieri.cadastro.soa.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class PersonHibernateDAO implements PersonDAO {

    private Session session;

    @Autowired
    public PersonHibernateDAO(SessionFactory factory) {
        session = factory.openSession();
    }

    @Override
    public void save(Person person) {
        session.save(person);
    }

    @Override
    public void update(Person person) {
        session.update(person);
    }

    @Override
    public List<Person> list() {
        List<Person> persons = session.createQuery("from Person").list();
        return persons;
    }

    @Override
    public Person findById(Long id) {
        return (Person) session.get(Person.class, id);
    }

    @Override
    public void delete(Long id) {
        session.delete(id);
    }
}
