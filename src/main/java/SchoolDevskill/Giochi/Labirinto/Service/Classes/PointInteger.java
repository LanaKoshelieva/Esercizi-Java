package SchoolDevskill.Giochi.Labirinto.Service.Classes;

public class PointInteger
{
    Integer x = 0;
    Integer y = 0;

    public PointInteger (Integer x, Integer y)
    {
        this.x = x;
        this.y = y;
    }

    public void reset()
    {
        this.x = 0;
        this.y = 0;
    }
}
