package escolaganesh.repositoris;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import escolaganesh.entitats.Rebut;

@Repository
public interface RebutRepository extends JpaRepository<Rebut, Integer> {

    List<Rebut> findByMes(String cercaMes);

    List<Rebut> findByYear(String cercaYear);

    List<Rebut> findByMesAndYear(String cercaMes, String cercaYear);

}
