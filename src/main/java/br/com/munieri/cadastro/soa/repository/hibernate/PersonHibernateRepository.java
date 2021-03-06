package br.com.munieri.cadastro.soa.repository.hibernate;

import br.com.munieri.cadastro.soa.model.Person;
import br.com.munieri.cadastro.soa.repository.PersonRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PersonHibernateRepository implements PersonRepository {

    private Session session;

    @Autowired
    public PersonHibernateRepository(SessionFactory factory) {
        session = factory.openSession();
    }

    @Override
    public void save(Person person) {
        session.save(person);
    }

    @Override
    public void update(Person person) {
        Transaction tx = session.beginTransaction();
        session.merge(person);
        tx.commit();
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
        Query query = session.createQuery("delete Person where id = :ID");
        query.setParameter("ID", id);

        query.executeUpdate();
    }
}
