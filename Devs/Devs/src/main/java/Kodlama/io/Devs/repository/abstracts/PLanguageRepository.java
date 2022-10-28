package Kodlama.io.Devs.repository.abstracts;

import Kodlama.io.Devs.entities.concretes.PLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PLanguageRepository extends JpaRepository<PLanguage, Integer> {


}
