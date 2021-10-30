package com.example.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class LibraryService {
    private final JdbcTemplate jdbcTemplate;
    private final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;



    public LibraryService(JdbcTemplate jdbcTemplate, EntityManager entityManager, EntityManagerFactory entityManagerFactory) {
        this.jdbcTemplate = jdbcTemplate;

        this.entityManager = entityManager;
        this.entityManagerFactory = entityManagerFactory;
    }

//    @Transactional
//    public Library retrivee() {
//        Library library;
//
//        return library = entityManager.find(List.class);
//
//    }

    @Transactional
    public void addd(Library library) {
        entityManager.persist(library);
        List<Author>authors=library.getAuthors();
        for (Author i:authors){
            i.setLibrary(library);
            entityManager.persist(i);
        }
    }

    @Transactional
    public void deletee(int id) {
        Library library;

        library = entityManager.find(Library.class, id);
        entityManager.remove(library);


    }


    @Transactional
    public void updatee(Library library) {


        Library library1 = entityManager.find(Library.class, library.getId());

        library1.setNumber_of_pages(library.getNumber_of_pages());
        library1.setAuthor_name(library.getAuthor_name());
        library1.setPublish_date(library.getPublish_date());
        library1.setName(library.getName());
        entityManager.persist(library1);

    }

    @Transactional
    public Library retriveeind(int id) {
        Library library;
        return library = entityManager.find(Library.class, id);


    }


}


