package proyecto;

public class Nodo 
{
    private int coe;
    private int exp;
    private Nodo Liga;

    public Nodo()
    {
        coe = 0;
        exp = 0;
        Liga = null;
    
    }

    public int getCoe() 
    {
        return coe;
    }

    public void setCoe(int coe) 
    {
        this.coe = coe;
    }

    public int getExp() 
    {
        return exp;
    }

    public void setExp(int exp) 
    {
        this.exp = exp;
    }

    public Nodo getLiga() 
    {
        return Liga;
    }

    public void setLiga(Nodo Liga) 
    {
        this.Liga = Liga;
    }
}
