package escolaganesh.repositoris;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import escolaganesh.entitats.Alumne;

@Repository
public interface AlumneRepository extends JpaRepository<Alumne, Integer> {
    public List<Alumne> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);

    public List<Alumne> findByActiuTrue();
}
