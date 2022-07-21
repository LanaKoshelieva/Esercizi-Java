package SchoolDevskill.Giochi.Labirinto.Service.Classes;

public class Player
{
    String player;
    PointInteger posizioneAttuale;

    public Player(String nome)
    {
        this.player = nome;
        this.posizioneAttuale = new PointInteger(0,0);
    }

    public PointInteger provaSpostarti(String movimento)
    {
        switch (movimento)
        {
            case "sopra" : return new PointInteger(posizioneAttuale.x-1, posizioneAttuale.y);
            case "sotto" : return new PointInteger(posizioneAttuale.x+1, posizioneAttuale.y);
            case "destra" : return new PointInteger(posizioneAttuale.x, posizioneAttuale.y+1);
            case "sinistra" : new PointInteger(posizioneAttuale.x, posizioneAttuale.y-1);
        }
        return posizioneAttuale;
    }

    public void spostati(PointInteger nuovaPosizione)
    {
        this.posizioneAttuale.x = nuovaPosizione.x;
        this.posizioneAttuale.y = nuovaPosizione.y;
    }
}
