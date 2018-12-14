package app.book;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class BookController {

    @RequestMapping("/books")
    String list() {
        return "all books";
    }

    @RequestMapping("/books/{id}")
    String get(@PathVariable Long id) {
        return "one book"+ id;
    }

}
