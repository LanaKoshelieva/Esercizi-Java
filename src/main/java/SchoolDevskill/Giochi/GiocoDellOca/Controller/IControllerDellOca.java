package SchoolDevskill.Giochi.GiocoDellOca.Controller;

import SchoolDevskill.Giochi.GiocoDellOca.Command.PlayerCommand;
import SchoolDevskill.Giochi.IGiochiController;

public interface IControllerDellOca extends IGiochiController
{
    String aggiungiGiocatore(PlayerCommand command) throws Exception;
    String giocaTurno();


}
