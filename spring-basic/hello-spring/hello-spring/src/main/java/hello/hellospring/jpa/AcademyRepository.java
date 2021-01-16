package hello.hellospring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademyRepository extends JpaRepository< Academy, Long> {
}
