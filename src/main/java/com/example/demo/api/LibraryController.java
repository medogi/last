package com.example.demo.api;

import com.example.demo.entities.Library;
import com.example.demo.services.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/lib")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("all")
    public List<LibraryDTO> findALl() {
        return libraryService.findAll();
    }

    @GetMapping("individual")
    public LibraryDTO get(@RequestParam int id) {
        return libraryService.find(id);
    }

    @PostMapping("add")
    public void add(@RequestBody LibraryDTO library) {
        libraryService.add(library);
    }

    @PostMapping("/update")
    public void update(@RequestBody LibraryDTO library) {
        libraryService.update(library);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam int id) {
        libraryService.delete(id);
    }
}
