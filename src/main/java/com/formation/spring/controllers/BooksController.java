package com.formation.spring.controllers;

import com.formation.spring.business.beans.Book;
import com.formation.spring.business.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("books", libraryService.findAll());

        return "/books/list";
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable int id, ModelMap model) {
        model.addAttribute("book", libraryService.findById(id));

        return "/books/show";
    }

    @RequestMapping(value = "/lend/{id}", method = RequestMethod.POST)
    public String lend(@PathVariable int id, ModelMap model) {
        Book book = libraryService.findById(id);
        book.setBorrowed(false);
        book.setUser(null);

        model.addAttribute("book", libraryService.update(book));

        return "redirect:/books/show/" + id;
    }
}
