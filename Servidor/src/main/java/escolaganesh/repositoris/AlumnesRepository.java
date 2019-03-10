package escolaganesh.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import escolaganesh.entitats.Alumnes;

@Repository
public interface AlumnesRepository extends JpaRepository<Alumnes, Integer> {
}
