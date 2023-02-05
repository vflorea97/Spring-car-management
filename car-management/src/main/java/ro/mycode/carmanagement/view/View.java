package ro.mycode.carmanagement.view;

import org.springframework.stereotype.Component;
import ro.mycode.carmanagement.exceptions.MasinaExceptieMasinaExistenta;
import ro.mycode.carmanagement.model.Masina;
import ro.mycode.carmanagement.service.MasinaService;

import java.util.List;
import java.util.Scanner;

@Component
public class View {

    private MasinaService masinaService;
    private Scanner scanner;

    public View(MasinaService masinaService) {
        this.masinaService = masinaService;
        scanner = new Scanner(System.in);

    }

    public void meniu(){
        System.out.println("Apasa 1 pentru a afisa toate masinile");
        System.out.println("Apasa 2 pentru a afisa masinile mai noi de 2010");
        System.out.println("Apasa 3 pentru a afisa masinile dupaa culoare");
        System.out.println("Apasa 4 pentru a afisa masinile audi");
        System.out.println("Apasa 5 pentru a adauga o masina");
    }

    public void play(){
        boolean run = true;
        meniu();
        while (run){
            int buton = Integer.parseInt(scanner.nextLine());
            switch (buton){
                case 1:
                    masinaService.afisare();
                break;
                case 2:
                    getCardYear2010();
                    break;
                case 3:
                    getAllMasiniByCuloare();
                    break;
                case 4:
                    getAllAudiCar();
                    break;
                case 5:
                    addMasina();
                    break;
                default:
                run = false;
                break;
            }
        }
    }
    public void getCardYear2010(){
        List<Masina> masinas = masinaService.getAllMasiniWithYearGreater(2000);
        for (int i = 0; i < masinas.size(); i++){
            System.out.println(masinas.get(i));
        }
    }
    public void getAllMasiniByCuloare(){
        List<Masina> masinas = masinaService.getAllMasiniByCuloare("Green");
        for (int i = 0; i < masinas.size(); i++){
            System.out.println(masinas.get(i));
        }
    }
    public void getAllAudiCar(){
        List<Masina> masinas = masinaService.getAllCarByMarca("Audi");
        for (int i = 0; i < masinas.size(); i++){
            System.out.println(masinas.get(i));
        }
    }
    public void addMasina(){
        System.out.println("Introdu marca:");
        String marca = scanner.nextLine();
        System.out.println("Introdu modelul:");
        String model = scanner.nextLine();
        System.out.println("Introdu anul fabricatiei: ");
        int an = Integer.parseInt(scanner.nextLine());
        System.out.println("Introdu culaore:");
        String culoare = scanner.nextLine();
       try{
           Masina masina = Masina.builder().marca(marca).model(model).an(an).culoare(culoare).build();
           masinaService.addMasina(masina);
           System.out.println("Ai adaugat o nousa masina!!");
       }catch (MasinaExceptieMasinaExistenta m){
           System.err.println(m.getMessage());
       }
    }
}
