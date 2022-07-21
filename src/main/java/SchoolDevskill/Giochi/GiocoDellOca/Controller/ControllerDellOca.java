package SchoolDevskill.Giochi.GiocoDellOca.Controller;

import SchoolDevskill.Giochi.GiocoDellOca.Service.Classes.BoardOcaServiceImpl;
import SchoolDevskill.Giochi.GiocoDellOca.Command.PlayerCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/delloca")
public class ControllerDellOca implements IControllerDellOca
{
    @Autowired
    BoardOcaServiceImpl board;

    @PostMapping ("/addgiocatore")
    public String aggiungiGiocatore(@RequestBody PlayerCommand command) throws Exception
    {
        board.aggiungiGiocatore(command.getNome());
        return "Giocatore aggiunto";
    }

    @Override
    @PostMapping ("/turno")
    public String giocaTurno()
    {
        return board.giocaTurno();
    }

    @Override
    @PostMapping ("/reset")
    public String reset()
    {
        return board.reset();
    }

    @PostMapping ("/resetpartita")
    public String resetPartita()
    {
        return board.resetPartita();
    }

    @Override
    @GetMapping("/stato")
    public String statoGioco() {
        return board.statoGioco();
    }
}
