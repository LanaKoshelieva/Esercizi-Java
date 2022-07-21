package SchoolDevskill.Giochi.Labirinto.Service.Interfaces;

public interface IBoardService
{
    String muoviPlayer(String movimento) throws Exception;

    void reset();

    String statoGioco();
}
