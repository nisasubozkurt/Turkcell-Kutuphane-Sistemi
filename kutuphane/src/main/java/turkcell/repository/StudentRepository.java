package turkcell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import turkcell.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
