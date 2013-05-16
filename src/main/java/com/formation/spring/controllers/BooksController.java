package com.formation.spring.controllers;

import com.formation.spring.business.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 16/05/13
 * Time: 15:52
 */
@Controller
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private LibraryService libraryService;

    @RequestMapping()
    public String index(ModelMap model) {
        model.addAttribute("books", libraryService.findAll());

        return "books/list";
    }

    @RequestMapping("/show/book")
    public String show(ModelMap model) {
        model.addAttribute("book", libraryService.findByName("Canti"));

        return "books/show";
    }
}
