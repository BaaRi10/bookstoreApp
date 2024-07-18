package com.bookStore.bookstoreApp;


//import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class BookStoreController {
    private final BookStoreService service;

    public BookStoreController(BookStoreService service) {
        this.service = service;
    }

    // requests
    @GetMapping("/")
    public String getHomePage(){
        return "home";//view name
    }

    @GetMapping("/book-register")
    public String geBookRegister(){
        return "BookRegister";
    }


    @PostMapping("/save")
    public String SaveBookstore(@ModelAttribute Bookstore bookstore ){
        service.insertBookStore(bookstore);
        return "redirect:/All";
    }

    @GetMapping("/All")
    public String getAll(Model model, @Param("Keyword")Long Keyword) {
        List<Bookstore> list = service.getAllBookStore(Keyword);
        model.addAttribute("bookies",list);
        model.addAttribute("Keyword",Keyword);
        return "View";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBookStore(@PathVariable Long id){
        service.deleteBookStore(id);
        return "redirect:/All";
    }

    @RequestMapping("/edit/{id}")
    public String UpdateBookStore(@PathVariable Long id, Model model){
        Bookstore book = service.getBookStoreById(id);
        model.addAttribute("book",book);
        return "EditBookStore";
    }



}



