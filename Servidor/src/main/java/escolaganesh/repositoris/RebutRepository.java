package escolaganesh.repositoris;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import escolaganesh.entitats.Rebut;

@Repository
public interface RebutRepository extends JpaRepository<Rebut, Integer> {
	public List<Rebut> findByAlumne_Id(int alumneId);
}
