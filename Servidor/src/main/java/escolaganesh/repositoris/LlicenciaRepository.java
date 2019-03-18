package escolaganesh.repositoris;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import escolaganesh.entitats.Llicencia;

@Repository
public interface LlicenciaRepository extends JpaRepository<Llicencia, Integer> {
	public List<Llicencia> findByAlumne_Id(int alumneId);
}
