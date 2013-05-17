package com.formation.spring.controllers;

import com.formation.spring.business.beans.Book;
import com.formation.spring.business.beans.User;
import com.formation.spring.business.services.LibraryService;
import com.formation.spring.business.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @Autowired
    private UserService userService;

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

    @RequestMapping(value = "/borrow", method = RequestMethod.POST)
    public String borrow(@RequestParam int id, @RequestParam String name, ModelMap model) {
        Book book = libraryService.findById(id);

        User user = userService.findByName(name);
        if (user == null) {
            model.addAttribute("book", book);
        } else {
            book.setBorrowed(true);
            book.setUser(user);

            model.addAttribute("book", libraryService.update(book));
        }

        return "redirect:/books/show/" + id;
    }

    @RequestMapping(value = "/lend", method = RequestMethod.POST)
    public String lend(@RequestParam int id, ModelMap model) {
        Book book = libraryService.findById(id);
        book.setBorrowed(false);
        book.setUser(null);

        model.addAttribute("book", libraryService.update(book));

        return "redirect:/books/show/" + id;
    }

    @RequestMapping(value = "/batchLend", method = RequestMethod.POST)
    public String batchLend(@RequestParam List<Integer> books, ModelMap map) {

        return "redirect:/books";
    }
}
