package app.book;


import app.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping
    List<Book> list() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    @GetMapping("/{id}")
    Book get(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Book %d not found", id)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Book create(@Valid @RequestBody Book newBook) {
        return bookRepository.save(newBook);
    }

    @PutMapping("/{id}")
    Book update(@Valid @RequestBody Book book, @PathVariable Long id) {
        bookRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Book %d not found", id)));
        book.setId(id);
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }


}
