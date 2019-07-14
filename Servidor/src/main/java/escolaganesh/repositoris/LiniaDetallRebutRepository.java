package escolaganesh.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import escolaganesh.entitats.LiniaDetallRebut;

@Repository
public interface LiniaDetallRebutRepository extends JpaRepository<LiniaDetallRebut, Integer> {


}
