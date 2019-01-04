package app.transaction;


import app.book.BookRepository;
import app.exception.NotFoundException;
import app.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;

    @GetMapping
    List<Reservation> list() {
        List<Reservation> reservations = new ArrayList<>();
        reservationRepository.findAll().forEach(reservations::add);
        return reservations;
    }

    @GetMapping("/{id}")
    Reservation get(@PathVariable Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Reservation %d not found", id)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Reservation create(@Valid @RequestBody Reservation newReservation) {

//        User user  = userRepository.findById(newReservation.getUser().getId()).orElseThrow(() -> new NotFoundException(String.format("User %d not found", (newReservation.getUser().getId()))));
//        newReservation.setUser(user);
//        Book book  = bookRepository.findById(newReservation.getBook().getId()).orElseThrow(() -> new NotFoundException(String.format("Book %d not found", (newReservation.getBook().getId()))));
//        newReservation.setBook(book);
//
//        final List<Reservation> reservations = reservationRepository.findByUserAndBook(user, book);
      //  if(reservations.isEmpty())

        return reservationRepository.save(newReservation);
    }

//    @PutMapping("/{id}")
//    Reservation update(@Valid @RequestBody Reservation reservation, @PathVariable Long id) {
//        reservationRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Reservation %d not found", id)));
//        reservation.setId(id);
//        return reservationRepository.save(reservation);
//    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        reservationRepository.deleteById(id);
    }


    private void throwNotFound(Long id) {

    }


}
