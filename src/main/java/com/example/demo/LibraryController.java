package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lib")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


//    @GetMapping("/retrive")
//    public Library Getretrive() {
//
//      return libraryService.retrivee();
//    }

    @GetMapping("/individual")
    public Library Getindividual(@RequestParam int id){
        return libraryService.retriveeind(id);
    }

    @PostMapping("/add")
    public void Getadd(@RequestBody Library library) {
       libraryService.addd(library);
    }

    @PostMapping("/update")
    public void Getupdate(@RequestBody Library library) {
         libraryService.updatee(library);
    }

    @PostMapping("/delete")
    public void Getdelete(@RequestParam int id) {
         libraryService.deletee(id);
    }
}
