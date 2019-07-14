package escolaganesh.repositoris;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import escolaganesh.entitats.Mensualitat;

@Repository
public interface MensualitatRepository extends JpaRepository<Mensualitat, Integer> {
	public List<Mensualitat> findByAlumne_Id(int alumneId);
}
