package app.transaction;

import app.book.Book;
import app.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class BorrowTransaction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    @NotNull
    LocalDateTime borrowedOn;

    LocalDateTime returnedOn;

    @NotNull
    @ManyToOne
    User user;

    @NotNull
    @ManyToOne
    Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getBorrowedOn() {
        return borrowedOn;
    }

    public void setBorrowedOn(LocalDateTime borrowedOn) {
        this.borrowedOn = borrowedOn;
    }

    public LocalDateTime getReturnedOn() {
        return returnedOn;
    }

    public void setReturnedOn(LocalDateTime returnedOn) {
        this.returnedOn = returnedOn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
