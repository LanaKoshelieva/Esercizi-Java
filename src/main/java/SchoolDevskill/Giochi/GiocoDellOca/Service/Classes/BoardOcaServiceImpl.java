package SchoolDevskill.Giochi.GiocoDellOca.Service.Classes;

import SchoolDevskill.Giochi.GiocoDellOca.Service.Interfaces.IBoardOcaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service ("OcaService")
public class BoardOcaServiceImpl implements IBoardOcaService
{
    CasellaSpeciale[] oca = new CasellaSpeciale[14];
    List<Player> players = new ArrayList<>();

    public BoardOcaServiceImpl()
    {
        creaArray();
    }

    public void aggiungiGiocatore(String nome) throws Exception {
        if (players.size() >=4)
        {
            throw new Exception("Numero massimo di giocatori ragiunto");
        }
        Player giocatore = new Player(nome);
        players.add(giocatore);
    }

    public Integer lanciaDado()
    {
        Random dado = new Random();
        return dado.nextInt(1, 6);
    }

    private void creaArray()
    {
        oca[0] = new CasellaSpeciale(false, 0, false);
        oca[1] = new CasellaSpeciale(false, 2, false);
        oca[2] = new CasellaSpeciale(false, 0, false);
        oca[3] = new CasellaSpeciale(false, 0, false);
        oca[4] = new CasellaSpeciale(false, 0, false);
        oca[5] = new CasellaSpeciale(false, -1, false);
        oca[6] = new CasellaSpeciale(false, 0, false);
        oca[7] = new CasellaSpeciale(false, 3, false);
        oca[8] = new CasellaSpeciale(true, 0, false);
        oca[9] = new CasellaSpeciale(false, 0, true);
        oca[10] = new CasellaSpeciale(false, 0, false);
        oca[11] = new CasellaSpeciale(false, 0, false);
        oca[12] = new CasellaSpeciale(false, -3, false);
        oca[13] = new CasellaSpeciale(false, 0, false);
    }

    public String giocaTurno()
    {
        for (Player player: players)
        {

            if (player.saltaTurno)
            {
                player.saltaTurno = false;
                continue;
            }
            player.numeroLanci ++;

            Integer risultatoDado = lanciaDado();
            Integer next = player.posizione + risultatoDado;
            if (next >= 13)
            {
                player.posizione = 13;
                String ret = "Il giocatore " + player.nome + " ha vinto" + "\n" + statoGioco();
                resetPartita();
                return ret;
            }

            CasellaSpeciale casella = oca[next];
            if (casella.imprevisto)
            {
                casella = pescaImprevisto();
            }

            if (casella.stop)
            {
                player.saltaTurno = true;
            }
            else if (casella.spostamento != 0)
            {
                next += casella.spostamento;
            }

            player.posizione = next;
        }
        return statoGioco();
    }

    private CasellaSpeciale pescaImprevisto()
    {
        Random random = new Random();
        Integer imprevisto = random.nextInt(0, 4);

        if(imprevisto == 0 )
        {
            return new CasellaSpeciale(false, 0, true);
        }
        else if(imprevisto == 1 )
        {
            return new CasellaSpeciale(false, -3, false);
        }
        else if(imprevisto == 2 )
        {
            return new CasellaSpeciale(false, -1, false);
        }
        else if(imprevisto == 3 )
        {
            return new CasellaSpeciale(false, +2, false);
        }
        else
        {
            return new CasellaSpeciale(false, +3, false);
        }
    }

    public String statoGioco()
    {
        return players.toString();
    }

    public String reset()
    {
        players.clear();
        return "Il gioco e' stato azzerato";
    }

    public String resetPartita()
    {
        for (Player player: players)
        {
            player.numeroLanci = 0;
            player.posizione = 0;
            player.saltaTurno = false;
        }
        return statoGioco();
    }

}
