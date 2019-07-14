package escolaganesh.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import escolaganesh.entitats.LiniaRebut;

@Repository
public interface LiniaRebutRepository extends JpaRepository<LiniaRebut, Integer> {


}
