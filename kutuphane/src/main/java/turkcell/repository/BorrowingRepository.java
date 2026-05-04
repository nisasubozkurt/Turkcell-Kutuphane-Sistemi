package turkcell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import turkcell.entity.Borrowing;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
}
