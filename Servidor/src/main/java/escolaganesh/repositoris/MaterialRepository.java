package escolaganesh.repositoris;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import escolaganesh.entitats.Material;


@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {
	public List<Material> findByDescripcioContainingIgnoreCase(String descripcio);
}
