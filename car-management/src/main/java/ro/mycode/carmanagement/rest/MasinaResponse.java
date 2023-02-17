package ro.mycode.carmanagement.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.mycode.carmanagement.model.Masina;
import ro.mycode.carmanagement.service.MasinaService;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class MasinaResponse {

    private MasinaService masinaService;

    public MasinaResponse(MasinaService masinaService){
        this.masinaService = masinaService;
    }

    @GetMapping("api/v1/masina/getAllMasini")
    public ResponseEntity<List<Masina>> getAllMasini(){
        log.info("REST request to get all Masini");
        List<Masina> masini = masinaService.getAllMasini();
        return new ResponseEntity<>(masini, HttpStatus.OK);
    }
    @GetMapping("api/v1/masina/getAllMasiniWithAnGreaterThen")
    public ResponseEntity<List<Masina>> getAllMasiniWithAnGreaterThen(){
        log.info("REST request to get all Masini dupa 2000");
        List<Masina> masini = masinaService.getAllMasiniWithYearGreater(2000);
        return new ResponseEntity<>(masini, HttpStatus.OK);
    }
    @GetMapping("api/v1/masina/getAllMasiniByCuloare")
    public ResponseEntity<List<Masina>> getAllMasiniByCuloare(){
        log.info("REST request to get all Masini verzi");
        List<Masina> masini = masinaService.getAllMasiniByCuloare("Green");
        return new ResponseEntity<>(masini, HttpStatus.OK);
    }
    @GetMapping("api/v1/masina/getAllCarByMarca")
    public ResponseEntity<List<Masina>> getAllCarByMarca(){
        log.info("REST request to get all Masini Audi");
        List<Masina> masini = masinaService.getAllCarByMarca("Audi");
        return new ResponseEntity<>(masini, HttpStatus.OK);
    }
}
