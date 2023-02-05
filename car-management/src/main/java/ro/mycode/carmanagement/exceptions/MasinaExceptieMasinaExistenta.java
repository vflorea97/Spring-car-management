package ro.mycode.carmanagement.exceptions;

public class MasinaExceptieMasinaExistenta extends Exception{

    public MasinaExceptieMasinaExistenta(){
        super("Masina deja exista in baza de date!!");
    }
}
