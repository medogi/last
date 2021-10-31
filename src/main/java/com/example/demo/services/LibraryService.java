package com.example.demo.services;

import com.example.demo.api.AuthorDTO;
import com.example.demo.api.LibraryDTO;
import com.example.demo.entities.Author;
import com.example.demo.entities.Library;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LibraryService {
    private final EntityManager entityManager;

    public LibraryService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void add(LibraryDTO library) {
        Library libraryEntity = new Library();
        List<AuthorDTO> authorDTOS = library.getAuthors();

        libraryEntity.setId(library.getId());
        libraryEntity.setAuthor_name(library.getAuthor_name());
        libraryEntity.setName(library.getName());
        libraryEntity.setNumber_of_pages(library.getNumber_of_pages());
        libraryEntity.setPublish_date(library.getPublish_date());

        entityManager.persist(libraryEntity);
        for (AuthorDTO authorDTO : authorDTOS) {
            Author authorEntity = new Author();
            authorEntity.setId(authorDTO.getId());
            authorEntity.setEmail(authorDTO.getEmail());
            authorEntity.setFirst_name(authorDTO.getFirst_name());
            authorEntity.setLast_name(authorDTO.getLast_name());
            authorEntity.setEmail(authorDTO.getEmail());
            authorEntity.setGender(authorDTO.getGender());
            authorEntity.setLibrary(libraryEntity);

            entityManager.persist(authorEntity);
        }
    }

    @Transactional
    public void delete(int id) {
        Library library;
        library = entityManager.find(Library.class, id);
        entityManager.remove(library);
    }

    @Transactional
    public void update(LibraryDTO library) {
        Library library1 = entityManager.find(Library.class, library.getId());

        library1.setNumber_of_pages(library.getNumber_of_pages());
        library1.setAuthor_name(library.getAuthor_name());
        library1.setPublish_date(library.getPublish_date());
        library1.setName(library.getName());
        entityManager.persist(library1);

    }

    @Transactional
    public LibraryDTO find(int id) {
        LibraryDTO result = new LibraryDTO();
        Library library = entityManager.find(Library.class, id);

        // TODO map other fields
        result.setId(library.getId());

        return result;
    }


    public void addAuthor(Author author) {
        entityManager.persist(author);
    }

    public List<LibraryDTO> findAll() {
        List<Library> libraries = entityManager.createQuery("SELECT l from Library l", Library.class).getResultList();

        return libraries.stream().map(library -> {
            LibraryDTO libraryDTO = new LibraryDTO();

            // TODO map other fields
            libraryDTO.setId(library.getId());
            libraryDTO.setAuthors(library.getAuthors().stream().map(author -> new AuthorDTO()).collect(Collectors.toUnmodifiableList()));

            return libraryDTO;
        }).collect(Collectors.toUnmodifiableList());
    }
}


