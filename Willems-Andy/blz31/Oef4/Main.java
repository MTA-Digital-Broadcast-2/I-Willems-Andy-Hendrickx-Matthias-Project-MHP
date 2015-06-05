public class Main {
       public static void main(String args[])

       {
        Werknemer herman = new Werknemer("Herman", "Hermans", 1, 1000);
        Werknemer koen = new Werknemer("Koen", "Soontjens", 2, 1000);
        Werknemer lorenz = new Werknemer("Lorenz", "Adriaensen", 3, 1000);
        Werknemer jurgen = new Werknemer("Jurgen", "Dedeckere", 4, 1100);

        //oef 2
        herman.salarisVerhogen(10);
        koen.salarisVerhogen(10);

        //oef3
        PartTimeWerknemer ilse = new PartTimeWerknemer("Ilse", "Luiaert", 5, 12, 25); 
        PartTimeWerknemer peggy = new PartTimeWerknemer("Peggy", "Tammegans", 6, 12, 20);
        
        //oef4
        ilse.salarisVerhogen(10);
        peggy.salarisVerhogen(5);

        System.out.println("peggy verdient nu " + peggy.getSalaris());
       
              
       }


}