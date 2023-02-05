package ro.mycode.carmanagement.service;

import org.springframework.stereotype.Service;
import ro.mycode.carmanagement.exceptions.MasinaExceptieMasinaExistenta;
import ro.mycode.carmanagement.model.Masina;
import ro.mycode.carmanagement.repository.MasinaRepository;

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
        return masini;
    }


    public List<Masina> getAllMasiniWithYearGreater(int n){

        return  masinaRepository.getAllMasiniWithAnGreaterThen(n).get();

    }

    public  List<Masina> getAllMasiniByCuloare(String culoare){
        return masinaRepository.getAllMasiniByCuloare(culoare).get();
    }

    public List<Masina> getAllCarByMarca(String marca){
        return masinaRepository.getAllCarByMarca(marca).get();
    }


    public void addMasina(Masina masina) throws MasinaExceptieMasinaExistenta {


        Optional<Masina> m=masinaRepository.findByModel(masina.getModel());


        if(m.equals(Optional.empty())){

            masinaRepository.save(masina);
        }else{


            throw  new MasinaExceptieMasinaExistenta();
        }
    }

}

//Daca am pus anotarea @Service care contine @Component => spring o sa creeze un obiect de tip MasinaService
//Dar pentru a crea un pbiect de  tip MasinaService ne trebuie un obiect de tip MasianRepository , iar pe acela
//spring o sa-l ia din  "cutia cu obiecte" spring aplication context
//cutia cu obiecte se umple la rulare cu toate clasele ce au @Component