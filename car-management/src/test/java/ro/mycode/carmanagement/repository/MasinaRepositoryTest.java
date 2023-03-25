package ro.mycode.carmanagement.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ro.mycode.carmanagement.CarManagementApplication;
import ro.mycode.carmanagement.model.Masina;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CarManagementApplication.class)
@Transactional
class MasinaRepositoryTest {

    @Autowired
    MasinaRepository masinaRepository;

    @BeforeEach
    public void clean(){
        masinaRepository.deleteAll();
    }

    @Test
    void getAllMasiniWithAnGreaterThen() {
        Masina masina = Masina.builder().an(1999).culoare("Indigo").marca("Kia").model("Sephia").build();
        Masina masina2 = Masina.builder().an(1992).culoare("Puce").marca("Geo").model("Metro").build();
        Masina masina3 = Masina.builder().an(2007).culoare("Turquoise").marca("Hyundai").model("Tiburon").build();
        Masina masina4 = Masina.builder().an(1991).culoare("Goldenrod").marca("Ford").model("Thunderbird").build();
        Masina masina5 = Masina.builder().an(1983).culoare("Blue").marca("Chevrolet").model("Caprice").build();
        Masina masina6 = Masina.builder().an(2006).culoare("Violet").marca("Suzuki").model("Daewoo Lacetti").build();

        masinaRepository.saveAndFlush(masina);
        masinaRepository.saveAndFlush(masina2);
        masinaRepository.saveAndFlush(masina3);
        masinaRepository.saveAndFlush(masina4);
        masinaRepository.saveAndFlush(masina5);
        masinaRepository.saveAndFlush(masina6);

        List<Masina> masini = masinaRepository.getAllMasiniWithAnGreaterThen(2000).get();

        assertEquals(2, masini.size());
        assertEquals(masina3, masini.get(1));

    }

    @Test
    void getAllMasiniByCuloare() {
        Masina masina = Masina.builder().an(1999).culoare("Indigo").marca("Kia").model("Sephia").build();
        Masina masina2 = Masina.builder().an(1992).culoare("Puce").marca("Geo").model("Metro").build();
        Masina masina3 = Masina.builder().an(2007).culoare("Turquoise").marca("Hyundai").model("Tiburon").build();
        Masina masina4 = Masina.builder().an(1991).culoare("Goldenrod").marca("Ford").model("Thunderbird").build();
        Masina masina5 = Masina.builder().an(1983).culoare("Blue").marca("Chevrolet").model("Caprice").build();
        Masina masina6 = Masina.builder().an(2006).culoare("Violet").marca("Suzuki").model("Daewoo Lacetti").build();

        masinaRepository.saveAndFlush(masina);
        masinaRepository.saveAndFlush(masina2);
        masinaRepository.saveAndFlush(masina3);
        masinaRepository.saveAndFlush(masina4);
        masinaRepository.saveAndFlush(masina5);
        masinaRepository.saveAndFlush(masina6);

        List<Masina> masini = masinaRepository.getAllMasiniByCuloare("Puce").get();

        assertEquals(1,masini.size());
    }

    @Test
    void getAllCarByMarca() {
        Masina masina = Masina.builder().an(1999).culoare("Indigo").marca("Kia").model("Sephia").build();
        Masina masina2 = Masina.builder().an(1992).culoare("Puce").marca("Geo").model("Metro").build();
        Masina masina3 = Masina.builder().an(2007).culoare("Turquoise").marca("Hyundai").model("Tiburon").build();
        Masina masina4 = Masina.builder().an(1991).culoare("Goldenrod").marca("Geo").model("Thunderbird").build();
        Masina masina5 = Masina.builder().an(1983).culoare("Blue").marca("Chevrolet").model("Caprice").build();
        Masina masina6 = Masina.builder().an(2006).culoare("Violet").marca("Suzuki").model("Daewoo Lacetti").build();

        masinaRepository.saveAndFlush(masina);
        masinaRepository.saveAndFlush(masina2);
        masinaRepository.saveAndFlush(masina3);
        masinaRepository.saveAndFlush(masina4);
        masinaRepository.saveAndFlush(masina5);
        masinaRepository.saveAndFlush(masina6);

        List<Masina> masini = masinaRepository.getAllCarByMarca("Geo").get();

        assertEquals(2, masini.size());
    }

    @Test
    void getAllCarByAnAndCuloare() {
        Masina masina = Masina.builder().an(1999).culoare("Indigo").marca("Kia").model("Sephia").build();
        Masina masina2 = Masina.builder().an(1992).culoare("Puce").marca("Geo").model("Metro").build();
        Masina masina3 = Masina.builder().an(2007).culoare("Turquoise").marca("Hyundai").model("Tiburon").build();
        Masina masina4 = Masina.builder().an(1991).culoare("Goldenrod").marca("Ford").model("Thunderbird").build();
        Masina masina5 = Masina.builder().an(1983).culoare("Blue").marca("Chevrolet").model("Caprice").build();
        Masina masina6 = Masina.builder().an(2006).culoare("Violet").marca("Suzuki").model("Daewoo Lacetti").build();

        masinaRepository.saveAndFlush(masina);
        masinaRepository.saveAndFlush(masina2);
        masinaRepository.saveAndFlush(masina3);
        masinaRepository.saveAndFlush(masina4);
        masinaRepository.saveAndFlush(masina5);
        masinaRepository.saveAndFlush(masina6);

        List<Masina> masini = masinaRepository.getAllCarByAnAndCuloare(2006,"Violet").get();

        assertEquals(1, masini.size());
    }
}