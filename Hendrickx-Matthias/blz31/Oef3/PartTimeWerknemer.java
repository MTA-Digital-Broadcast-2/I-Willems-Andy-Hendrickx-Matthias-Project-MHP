public class Werknemer extends Werknemer{
        public int urenGewerkt;

public PartTimeWerknemer(String voornaam, String achternaam, int wNummer, float salaris, int urengw)
       {
        super(voornaam, achternaam, wNummer, salaris);
        this.urenGewerkt = urengw;
       }


public float getWeekLoon()
       {
        return this.salaris * (float)this.urenGewerkt;
       }
    

}