package br.com.criarapi.springbootdemo.controller;

import br.com.criarapi.springbootdemo.entity.BookEntity;
import br.com.criarapi.springbootdemo.entity.dto.BookDTO;
import br.com.criarapi.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookEntity> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookEntity findById(@PathVariable Long id) {
        return bookService.findById(id);

    }
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BookEntity save(@RequestBody BookDTO bookDTO) {
        return bookService.save(bookDTO);
    }


    @PutMapping("/{id}")
    public BookEntity updateBook(@RequestBody BookDTO bookDTO, @PathVariable Long id) {
        BookEntity bookEntity = bookService.findById(id);
        return bookService.update(bookEntity, bookDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.delete(id);
    }


}
