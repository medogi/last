package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lib")
public class LibraryController {

    private final  LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }



    @GetMapping("/retrive")
    public List<Library> Getretrive() {

        return libraryService.retrivee();
  }

    @GetMapping("/individual")
    public Library Getindividual(@RequestParam int id) {
        return libraryService.retriveeind(id);
    }

    @PostMapping("/add")
    public int Getadd(@RequestBody Library library) {
        return libraryService.addd(library);
    }

    @PostMapping("/update")
    public int Getupdate(@RequestBody Library library) {
        return libraryService.updatee(library);
    }

    @DeleteMapping("/delete")
    public int Getdelete(@RequestParam int id) {
        return libraryService.deletee(id);
    }
}
