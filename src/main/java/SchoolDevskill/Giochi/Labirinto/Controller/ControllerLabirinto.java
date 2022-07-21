package SchoolDevskill.Giochi.Labirinto.Controller;

import SchoolDevskill.Giochi.Labirinto.Command.MovimentoCommand;
import SchoolDevskill.Giochi.Labirinto.Service.Classes.BoardServiceImpl;
import SchoolDevskill.Giochi.Labirinto.Exceptions.LabException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/labirinto")
public class ControllerLabirinto implements IControllerLabirinto
{
    @Autowired
    BoardServiceImpl board;

    @Override
    @PostMapping ("/reset")
    public String reset()
    {
        board.reset();
        return "Il gioco e' stato resettato";
    }

    @Override
    @GetMapping ("/stato")
    public String statoGioco()
    {
        return board.statoGioco();
    }

    @PostMapping ("/movimento")
    public String movimento(@RequestBody MovimentoCommand command) throws LabException
            {
        return board.muoviPlayer(command.getDirezione());
    }
}
