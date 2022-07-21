package SchoolDevskill.Giochi.Labirinto.Controller;

import SchoolDevskill.Giochi.IGiochiController;
import SchoolDevskill.Giochi.Labirinto.Command.MovimentoCommand;

public interface IControllerLabirinto extends IGiochiController
{
    String movimento(MovimentoCommand command) throws Exception;
}
