package Kodlama.io.Devs.repository.abstracts;

import Kodlama.io.Devs.entities.concretes.Framework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrameworkRepository extends JpaRepository<Framework,Integer> {
}
