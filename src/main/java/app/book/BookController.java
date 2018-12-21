package app.book;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    String list() {
        return "all books";
    }

    @GetMapping("/{id}")
    String get(@PathVariable Long id) {

        return "one_ book"+ id;
    }

    @PostMapping
    Book newBook(@RequestBody Book newBook) {
        //return repository.save(newEmployee);
        return  newBook;
    }


}
