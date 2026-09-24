package com.mongpro.mongo_project.controllers;

import com.mongpro.mongo_project.entities.Book;
import com.mongpro.mongo_project.entities.User;
import com.mongpro.mongo_project.services.BookService;
import com.mongpro.mongo_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")

public class BookController {
    @Autowired
    public BookService service;
    @Autowired
    public UserService userService;

    @PostMapping("/add")
    public void add (@RequestBody Book book){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String name= authentication.getName();
        User user=userService.findbyname(name);
        service.add(book,user);
    }

//    @GetMapping("/list")
//    public List<Book> list(){
//        return service.fall();
//    }

    @GetMapping ("/get")
    public List<Book> fid(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username= authentication.getName();
        User user= userService.findbyname(username);
        return user.getBooks();
    }

    @DeleteMapping ("/id/{mid}")
    public ResponseEntity<?> del(@PathVariable int mid){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        User user= userService.findbyname(username);
        List<Book> l1= user.getBooks();
        for(Book book:l1) {
            if(book.getId()==mid)
            {service.dele(username, mid);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/id/{id}")
    public Book findBid(@PathVariable int id){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        User user= userService.findbyname(username);
        List<Book> l1= user.getBooks();
        for(Book book: l1){
            if(book.getId()==id)return book;
        }
        return null;
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<?> update (@PathVariable int id, @RequestBody Book book){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        User user= userService.findbyname(username);
        List<Book> l1= user.getBooks();
        for(Book book1: l1){
            if(book1.getId()==id){
                if(book.getName()!=null)book1.setName(book.getName());
                if(book.getContext()!=null)book1.setContext(book1.getContext());
                service.add(book1);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

}
