package SchoolDevskill.Giochi.GiocoDellOca.Service.Interfaces;

public interface IBoardOcaService
{
    void aggiungiGiocatore(String nome) throws Exception;

    Integer lanciaDado();

    String  giocaTurno();

    String statoGioco();

    String reset();

    String resetPartita();

}
