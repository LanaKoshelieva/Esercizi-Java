package SchoolDevskill.Giochi.GiocoDellOca.Service.Classes;

import lombok.Getter;

@Getter
public class Player
{
    String nome;
    Integer numeroLanci;
    Integer posizione;
    boolean saltaTurno;

    public Player(String nome)
    {
        this.nome = nome;
        numeroLanci = 0;
        posizione = 0;
        saltaTurno = false;
    }

    @Override
    public String toString() {
        return
                "{" + "\"nome\": \"" + nome + '\"' + ", " +
                "\"numeroLanci\": " + numeroLanci +  ", " +
                "\"posizione\": " + posizione + ", " +
                "\"saltaTurno\": " + saltaTurno + "}"
                ;
    }
}
