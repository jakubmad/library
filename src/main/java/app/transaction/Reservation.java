package app.transaction;

import app.book.Book;
import app.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    @NotNull
    @ManyToOne
    User user;

    @NotNull
    @ManyToOne
    Book book;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @NotNull
    LocalDate validTill;

    @JsonFormat(pattern = "dd.MM.yyyy hh:mm:ss")
    //@NotNull
    LocalDateTime reservedOn;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getValidTill() {
        return validTill;
    }

    public void setValidTill(LocalDate validTill) {
        this.validTill = validTill;
    }
}
