public class Main {

public static void main(String args[])

       {
        Werknemer herman = new Werknemer("Herman", "Hermans", 1, 1000);
        Werknemer koen = new Werknemer("Koen", "Soontjens", 2, 1000);
        Werknemer lorenz = new Werknemer("Lorenz", "Adriaensen", 3, 1000);
        Werknemer jurgen = new Werknemer("Jurgen", "Dedeckere", 4, 1100);

        System.out.println(koen.voornaam + " verdient " + koen.getSalaris());
       }


}