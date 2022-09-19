package br.com.criarapi.springbootdemo.service;

import br.com.criarapi.springbootdemo.entity.BookEntity;
import br.com.criarapi.springbootdemo.entity.dto.BookDTO;
import br.com.criarapi.springbootdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    public BookEntity findById(Long id) {
        Optional<BookEntity> entity = bookRepository.findById(id);

        if (entity.isPresent()){
            return entity.get();
        }
        throw new RuntimeException();
    }

    public BookEntity save(BookDTO bookDTO) {

        BookEntity entity = new BookEntity();
        entity.setName(bookDTO.getName());
        entity.setYear(bookDTO.getYear());
        entity.setAuthor(bookDTO.getAuthor());
        entity.setEdition(bookDTO.getEdition());

        return bookRepository.save(entity);
    }

    public BookEntity update(BookEntity entity, BookDTO bookDTO) {
        entity.setName(bookDTO.getName());
        entity.setYear(bookDTO.getYear());
        entity.setAuthor(bookDTO.getAuthor());
        entity.setEdition(bookDTO.getEdition());
        return bookRepository.save(entity);
    }

    public void delete(Long id) {
         bookRepository.deleteById(id);

    }
}
