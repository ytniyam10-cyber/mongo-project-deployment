package com.mongpro.mongo_project.services;

import com.mongpro.mongo_project.entities.Book;
import com.mongpro.mongo_project.entities.User;
import com.mongpro.mongo_project.repo.BookRepo;
import com.mongpro.mongo_project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {
    @Autowired
    public BookRepo repo;
    @Autowired
    public UserRepo urepo;

    public void add(Book book, User user){
        Book save = repo.save(book);
        user.getBooks().add(save);
        urepo.save(user);

    }
    public void add(Book book){
        repo.save(book);
    }


    public List<Book> fall(){
        return repo.findAll();

    }

    public Book find(int id){
        return repo.findById(id).orElse(null);
    }

    public void dele(String username, int id){
        User user = urepo.findByUsername(username);
        user.getBooks().removeIf(book -> book.getId() == id);
        Book book = find(id);
        urepo.save(user);
        repo.delete(book);
    }
}
