package ro.mycode.carmanagement.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ro.mycode.carmanagement.model.Masina;
import ro.mycode.carmanagement.service.MasinaService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class MasinaResponseTest {

    @Mock
    private MasinaService masinaService;

    @InjectMocks
    private MasinaResponse masinaResponse;

    private ObjectMapper mapper = new ObjectMapper();

    private MockMvc restMockMvc;

    @BeforeEach
    void initialConfig() {
        restMockMvc = MockMvcBuilders.standaloneSetup(masinaResponse).build();
    }
    @Captor
    ArgumentCaptor<Masina> masinaArgumentCaptor;
    @Captor
    ArgumentCaptor<Masina> masinaDTOArgumentCaptor;

    @Test
    void getAllMasini() throws Exception{
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

        doReturn(masinas).when(masinaService).getAllMasini();

        restMockMvc.perform(get("http://localhost:3005/api/v1/masina/getAllMasini")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(masinas)));
    }

    @Test
    void getAllMasiniWithAnGreaterThen() throws Exception{
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

        doReturn(masinas).when(masinaService).getAllMasiniWithYearGreater(2000);

        restMockMvc.perform(get("http://localhost:3005/api/v1/masina/getAllMasiniWithAnGreaterThen")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(masinas)));
    }

    @Test
    void getAllMasiniByCuloare() throws Exception{
        Masina masina = Masina.builder().an(1999).culoare("Indigo").marca("Kia").model("Sephia").build();
        Masina masina2 = Masina.builder().an(1992).culoare("Puce").marca("Geo").model("Metro").build();
        Masina masina3 = Masina.builder().an(2007).culoare("Turquoise").marca("Hyundai").model("Tiburon").build();
        Masina masina4 = Masina.builder().an(1991).culoare("Goldenrod").marca("Ford").model("Thunderbird").build();
        Masina masina5 = Masina.builder().an(1983).culoare("Blue").marca("Chevrolet").model("Caprice").build();
        Masina masina6 = Masina.builder().an(2006).culoare("Violet").marca("Suzuki").model("Daewoo Lacetti").build();

        List<Masina> masinas = new ArrayList<>();
        masinas.add(masina);
        masinas.add(masina2);
        masinas.add(masina3);
        masinas.add(masina4);
        masinas.add(masina5);
        masinas.add(masina6);

        doReturn(masinas).when(masinaService).getAllMasiniByCuloare("Green");

        restMockMvc.perform(get("http://localhost:3005/api/v1/masina/getAllMasiniByCuloare")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(masinas)));

    }

    @Test
    void getAllCarByMarca() throws Exception{
        Masina masina = Masina.builder().an(1999).culoare("Indigo").marca("Kia").model("Sephia").build();
        Masina masina2 = Masina.builder().an(1992).culoare("Puce").marca("Geo").model("Metro").build();
        Masina masina3 = Masina.builder().an(2007).culoare("Turquoise").marca("Hyundai").model("Tiburon").build();
        Masina masina4 = Masina.builder().an(1991).culoare("Goldenrod").marca("Ford").model("Thunderbird").build();
        Masina masina5 = Masina.builder().an(1983).culoare("Blue").marca("Chevrolet").model("Caprice").build();
        Masina masina6 = Masina.builder().an(2006).culoare("Violet").marca("Suzuki").model("Daewoo Lacetti").build();

        List<Masina> masinas = new ArrayList<>();
        masinas.add(masina);
        masinas.add(masina2);
        masinas.add(masina3);
        masinas.add(masina4);
        masinas.add(masina5);
        masinas.add(masina6);

        doReturn(masinas).when(masinaService).getAllCarByMarca("Audi");

        restMockMvc.perform(get("http://localhost:3005/api/v1/masina/getAllCarByMarca")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(masinas)));
    }
}