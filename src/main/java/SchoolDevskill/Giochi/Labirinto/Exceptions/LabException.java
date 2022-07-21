package SchoolDevskill.Giochi.Labirinto.Exceptions;

public class LabException extends Exception
{
    public LabException(String s)
    {
        super(s);
    }

    public static LabException erroreIndice()
    {
        return new LabException("Sei oltre le dimensioni della Board");
    }

    public static LabException errorePercorso()
    {
        return new LabException("Sei fuori dal labirinto");
    }
}
