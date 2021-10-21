package com.example.demo;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class LibraryService {
    private final JdbcTemplate jdbcTemplate;

    public LibraryService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Library> retrivee() {
        String sql = "SELECT * FROM public.bookinfo";

        List<Library> library = jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper(Library.class));

        return library;
    }


    public int addd(Library library) {
        return jdbcTemplate.update(
                "INSERT INTO public.bookinfo VALUES (?, ?, ?, ?, ?)",
                library.getId(), library.getName(), library.getAuthor_name(), library.getNumber_of_pages(), library.getPublish_date());
    }

    public int deletee(int id) {
        String SQL = "delete from public.bookinfo where id = ?";
        SimpleTriggerContext jdbcTemplateObject = new SimpleTriggerContext();
        return jdbcTemplate.update(SQL, id);
    }

    public int updatee(Library library) {
        String SQL = "delete from public.bookinfo where id = ?";
        SimpleTriggerContext jdbcTemplateObject = new SimpleTriggerContext();
        jdbcTemplate.update(SQL, library.getId());
        return jdbcTemplate.update("INSERT INTO public.bookinfo VALUES (?, ?, ?, ?, ?)",
                library.getId(), library.getName(), library.getAuthor_name(), library.getNumber_of_pages(), library.getPublish_date());
    }

    public Library retriveeind(int id) {
        return jdbcTemplate.queryForObject("SELECT * from public.bookinfo WHERE id = ?", new Object[]{id}, new RowMapper<Library>() {
            @Override
            public Library mapRow(ResultSet rs, int rowNum) throws SQLException {
                Library library = new Library();
                library.setId(rs.getInt(1));
                library.setName(rs.getString(2));
                library.setAuthor_name(rs.getString(3));
                library.setNumber_of_pages(rs.getInt(4));
                library.setPublish_date(rs.getInt(5));
                return library;

            }
        });


    }

}


