package turkcell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import turkcell.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
