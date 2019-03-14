package escolaganesh.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import escolaganesh.entitats.Alumne;

@Repository
public interface AlumneRepository extends JpaRepository<Alumne, Integer> {
}
