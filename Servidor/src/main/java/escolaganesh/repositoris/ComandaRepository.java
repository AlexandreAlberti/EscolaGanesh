package escolaganesh.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import escolaganesh.entitats.Comanda;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Integer> {

}
