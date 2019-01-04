package app.transaction;

import app.book.Book;
import app.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findByUserAndBook(User user, Book book);
}
