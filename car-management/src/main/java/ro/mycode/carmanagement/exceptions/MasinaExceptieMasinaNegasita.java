package ro.mycode.carmanagement.exceptions;

public class MasinaExceptieMasinaNegasita extends Exception{

    public MasinaExceptieMasinaNegasita(){
        super("Masina nu se afla in baza de date!!");
    }
}
