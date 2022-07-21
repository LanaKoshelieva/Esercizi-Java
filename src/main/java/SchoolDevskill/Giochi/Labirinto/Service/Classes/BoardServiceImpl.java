package SchoolDevskill.Giochi.Labirinto.Service.Classes;

import SchoolDevskill.Giochi.Labirinto.Exceptions.LabException;
import SchoolDevskill.Giochi.Labirinto.Service.Interfaces.IBoardService;
import org.springframework.stereotype.Service;

@Service ("LabirintoService")

public class BoardServiceImpl implements IBoardService
{
    private final Integer righe = 8;
    private final Integer colonne = 12;
    Character[][] matrice = new Character[righe][colonne];

    Player giocatore = new Player("Lolo");

    public BoardServiceImpl()
    {
        creaBoard();
    }

    private void creaBoard()
    {
        for (Integer r=0; r<righe; r++)
        {
            for (Integer c=0; c<colonne; c++)
            {
                matrice[r][c] = 'x';
            }
        }
        creaLabirinto();
    }

    private void creaLabirinto()
    {
        matrice[0][0] = 's';
        matrice[0][1] = 's';
        matrice[0][2] = 's';
        matrice[0][3] = 's';
        matrice[0][4] = 's';
        matrice[0][5] = 's';

        matrice[1][5] = 's';

        matrice[2][5] = 's';

        matrice[3][5] = 's';
        matrice[3][6] = 's';
        matrice[3][7] = 's';
        matrice[3][8] = 's';
        matrice[3][9] = 's';
        matrice[3][10] = 's';

        matrice[4][2] = 's';
        matrice[4][3] = 's';
        matrice[4][4] = 's';
        matrice[4][5] = 's';

        matrice[5][5] = 's';
        matrice[6][5] = 's';
        matrice[7][5] = 'u';
    }

    private String mostraBoard()
    {
        String stringa = "";
        for (Integer r=0; r<righe; r++)
        {
            for (Integer c=0; c<colonne; c++)
            {
                if ( r == giocatore.posizioneAttuale.x && c == giocatore.posizioneAttuale.y)
                {
                    stringa += "p \t";
                }
                else
                {
                    stringa += matrice[r][c] + "\t";
                }
            }
            stringa += "\n\n";
        }
        return stringa;
    }

    private boolean puoSpostarsi(Integer nuovaRiga, Integer nuovaColonna) throws LabException
    {
        if (nuovaRiga < 0 || nuovaRiga >= righe )
        {
            throw LabException.erroreIndice();
        }
        if (nuovaColonna < 0 || nuovaColonna >= colonne )
        {
            throw LabException.erroreIndice();
        }
        return !matrice[nuovaRiga][nuovaColonna].equals('x');
    }

    public String muoviPlayer(String movimento) throws LabException
    {
        PointInteger prova = giocatore.provaSpostarti(movimento);
        if (puoSpostarsi(prova.x, prova.y))
        {
            giocatore.spostati(prova);
        }
        else
        {
            throw LabException.errorePercorso();
        }
        if (matrice[giocatore.posizioneAttuale.x][giocatore.posizioneAttuale.y] == 'u')
        {
            this.reset();
            return "Sei uscito dal labirinto";
        }
        return "Ti sei spostato in " + "riga "+  giocatore.posizioneAttuale.x + " colonna " +  giocatore.posizioneAttuale.y;
    }

    public void reset()
    {
        giocatore.posizioneAttuale.reset();
    }

    public String statoGioco()
    {
        return mostraBoard();
    }
}
