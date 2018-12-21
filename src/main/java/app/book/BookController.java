package app.book;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    List<Book> list() {
        return new ArrayList<Book>();
    }

    @GetMapping("/{id}")
    Book get(@PathVariable Long id) {
        return new Book();
    }

    @PostMapping
    Book create(@RequestBody Book newBook) {
        return  new Book();
    }

    @PutMapping("/{id}")
    Book update(@RequestBody Book newBook, @PathVariable Long id) {
        return   new Book();
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
    }

}
