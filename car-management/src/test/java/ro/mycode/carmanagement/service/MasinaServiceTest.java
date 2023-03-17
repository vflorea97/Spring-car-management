package ro.mycode.carmanagement.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ro.mycode.carmanagement.exceptions.MasinaExceptieMasinaExistenta;
import ro.mycode.carmanagement.model.Masina;
import ro.mycode.carmanagement.repository.MasinaRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MasinaServiceTest {
    @Mock
    private MasinaRepository masinaRepository;

    @InjectMocks
    private MasinaService masinaService;

    @Captor
    ArgumentCaptor<Masina> masinaArgumentCaptor;
    @Captor
    ArgumentCaptor<String> masinaField1;
    @Captor
    ArgumentCaptor<String> masinaField2;

    @Test
    void getAllMasini() {
        Masina masina = Masina.builder().an(1999).culoare("Indigo").marca("Kia").model("Sephia").build();
        Masina masina2 = Masina.builder().an(1992).culoare("Puce").marca("Geo").model("Metro").build();
        Masina masina3 = Masina.builder().an(2007).culoare("Turquoise").marca("Hyundai").model("Tiburon").build();
        Masina masina4 = Masina.builder().an(1991).culoare("Goldenrod").marca("Ford").model("Thunderbird").build();
        Masina masina5 = Masina.builder().an(1983).culoare("Blue").marca("Chevrolet").model("Caprice").build();
        Masina masina6 = Masina.builder().an(2006).culoare("Violet").marca("Suzuki").model("Daewoo Lacetti").build();

        List<Masina> masinas =new ArrayList<>();
        masinas.add(masina);
        masinas.add(masina2);
        masinas.add(masina3);
        masinas.add(masina4);
        masinas.add(masina5);
        masinas.add(masina6);

        doReturn(masinas).when(masinaRepository).findAll();

        assertEquals(6, masinaService.getAllMasini().size());
    }

    @Test
    void getAllMasiniWithYearGreater() {
        Masina masina = Masina.builder().an(1999).culoare("Indigo").marca("Kia").model("Sephia").build();
        Masina masina2 = Masina.builder().an(1992).culoare("Puce").marca("Geo").model("Metro").build();
        Masina masina3 = Masina.builder().an(2007).culoare("Turquoise").marca("Hyundai").model("Tiburon").build();
        Masina masina4 = Masina.builder().an(1991).culoare("Goldenrod").marca("Ford").model("Thunderbird").build();
        Masina masina5 = Masina.builder().an(1983).culoare("Blue").marca("Chevrolet").model("Caprice").build();
        Masina masina6 = Masina.builder().an(2006).culoare("Violet").marca("Suzuki").model("Daewoo Lacetti").build();

        List<Masina> masinas =new ArrayList<>();
        masinas.add(masina);
        masinas.add(masina2);
        masinas.add(masina3);
        masinas.add(masina4);
        masinas.add(masina5);
        masinas.add(masina6);

        Collections.sort(masinas);
        doReturn(Optional.of(masinas)).when(masinaRepository).getAllMasiniWithAnGreaterThen(2000);

        assertEquals(masina3,masinas.get(5));
        assertEquals(masina6,masinas.get(4));
    }

    @Test
    void getAllMasiniByCuloare() {
        Masina masina = Masina.builder().an(1999).culoare("Indigo").marca("Kia").model("Sephia").build();
        Masina masina2 = Masina.builder().an(1992).culoare("Puce").marca("Geo").model("Metro").build();
        Masina masina3 = Masina.builder().an(2007).culoare("Turquoise").marca("Hyundai").model("Tiburon").build();
        Masina masina4 = Masina.builder().an(1991).culoare("Goldenrod").marca("Ford").model("Thunderbird").build();
        Masina masina5 = Masina.builder().an(1983).culoare("Blue").marca("Chevrolet").model("Caprice").build();
        Masina masina6 = Masina.builder().an(2006).culoare("Violet").marca("Suzuki").model("Daewoo Lacetti").build();

        List<Masina> masinas =new ArrayList<>();
        masinas.add(masina);
        masinas.add(masina2);
        masinas.add(masina3);
        masinas.add(masina4);
        masinas.add(masina5);
        masinas.add(masina6);

        doReturn(Optional.of(masinas)).when(masinaRepository).getAllMasiniByCuloare("Blue");

        assertEquals(1, masinaService.getAllMasiniByCuloare("Blue").size());


    }

    @Test
    void getAllCarByMarca() {
    }

    @Test
    void addMasina() throws MasinaExceptieMasinaExistenta {
        Masina masina = Masina.builder().an(1999).culoare("Indigo").marca("Kia").model("Sephia").build();

        doReturn(Optional.empty()).when(masinaRepository).findByModel("Sephia");

        masinaService.addMasina(masina);

        verify(masinaRepository, times(1)).saveAndFlush(masinaArgumentCaptor.capture());

        assertEquals(masinaArgumentCaptor.getValue(), masina);

    }
}