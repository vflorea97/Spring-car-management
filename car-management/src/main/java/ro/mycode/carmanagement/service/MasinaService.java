package ro.mycode.carmanagement.service;

import org.springframework.stereotype.Service;
import ro.mycode.carmanagement.exceptions.MasinaExceptieMasinaExistenta;
import ro.mycode.carmanagement.model.Masina;
import ro.mycode.carmanagement.repository.MasinaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MasinaService {

    private MasinaRepository masinaRepository;

    public MasinaService(MasinaRepository masinaRepository) {
        this.masinaRepository = masinaRepository;
    }


    public void afisare(){


        List<Masina>  masini= masinaRepository.findAll();

        masini.forEach(m-> System.out.println(m));
    }

    public List<Masina> getAllMasini(){
        List<Masina>  masini= masinaRepository.findAll();
        if (masini.size() > 0) {
            return masini;
        }
        return null;
    }


    public List<Masina> getAllMasiniWithYearGreater(int n){
        List<Masina> masinas = masinaRepository.getAllMasiniWithAnGreaterThen(n).get();
        return  masinas;

    }

    public  List<Masina> getAllMasiniByCuloare(String culoare){
        return masinaRepository.getAllMasiniByCuloare(culoare).get();
    }

    public List<Masina> getAllCarByMarca(String marca){
        return masinaRepository.getAllCarByMarca(marca).get();
    }

    @Transactional
    public void addMasina(Masina masina) throws MasinaExceptieMasinaExistenta {
        Optional<Masina> m=masinaRepository.findByModel(masina.getModel());
        if(m.isEmpty()){
            masinaRepository.saveAndFlush(masina);
        }else{
            throw  new MasinaExceptieMasinaExistenta();
        }
    }

}

//Daca am pus anotarea @Service care contine @Component => spring o sa creeze un obiect de tip MasinaService
//Dar pentru a crea un pbiect de  tip MasinaService ne trebuie un obiect de tip MasianRepository , iar pe acela
//spring o sa-l ia din  "cutia cu obiecte" spring aplication context
//cutia cu obiecte se umple la rulare cu toate clasele ce au @Component