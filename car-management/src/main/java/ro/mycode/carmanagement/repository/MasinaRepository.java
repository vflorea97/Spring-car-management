package ro.mycode.carmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.carmanagement.model.Masina;

import java.util.List;
import java.util.Optional;

@Repository
public interface MasinaRepository extends JpaRepository<Masina,Long> {

    @Query("select m from Masina  m where m.an > ?1")
    Optional<List<Masina>> getAllMasiniWithAnGreaterThen(int an);

    @Query("select m from Masina m where m.culoare = ?1")
    Optional<List<Masina>> getAllMasiniByCuloare(String culoare);

    @Query("select m from Masina m where m.marca = ?1")
    Optional<List<Masina>> getAllCarByMarca(String marca);

    @Query("select m from Masina m where m.an = ?1 and m.culoare = ?2")
    Optional<List<Masina>> getAllCarByAnAndCuloare(int an, String culoare);




    Optional<Masina> findByModel(String model);

}
