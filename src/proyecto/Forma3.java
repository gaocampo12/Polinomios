package proyecto;

import javax.swing.*;

public class Forma3 
{
    //Atributos
    private Nodo Punta;
    
    //Metodos
    public Forma3()
    {
        Punta = null;
    }
    
    public Nodo IngresarPoli3(Forma2 A)
    {
        int i = 1, j = A.GetVector2(0), k = 2;
        Nodo t, x;
        Punta = null;
        while(j > 0)
        {
            if(Punta == null)
            {
                Punta = new Nodo();
                Punta.setCoe(A.GetVector2(i));
                Punta.setExp(A.GetVector2(k));
                Punta.setLiga(null);
            }
            else
            {
                x = new Nodo();
                x.setCoe(A.GetVector2(i));
                x.setExp(A.GetVector2(k));
                x.setLiga(null);
                t = Punta;
                while(t.getLiga() != null)
                {
                    t = t.getLiga();
                }
                t.setLiga(x); 
            }
            i = i + 2;
            k = k + 2;
            j--;
        }
        return Punta;
    }
    
    void Mostrar3()
    {
        int i = 0, a, b;
        String aux = "";
        Nodo p;
        p = Punta;
        while(p != null)
        {
            a = p.getExp();
            b = p.getCoe();
            aux = aux + "->     | " + a + "  |  " + b + " |     ";
            p = p.getLiga();
            i++; 
        }
        JOptionPane.showMessageDialog(null, aux );

    }
    
    public String ReconstruirPoli3(Nodo x)
    {
        String polinomio = "";
        Nodo t;
        t = x;
        while(t != null)
        {
            if(t.getCoe() == -1 && t.getExp() != 1 && t.getExp() != 0)
            { 
                polinomio = polinomio + "-x^" + t.getExp();
            }
            else if(t.getCoe() == -1 && t.getExp() == 1)
            {
                polinomio = polinomio + "-x";
            }
            else if(t.getCoe() == -1 && t.getExp() == 0)
            {
                polinomio = polinomio + t.getCoe();
            }
            else if(t.getCoe() == 1 && t.getExp() != 1 && t.getExp() != 0)
            {
                polinomio = polinomio + "+x^" + t.getExp();
            }
            else if(t.getCoe() == 1 &&  t.getExp() == 1)
            {
                polinomio = polinomio + "+x";
            }
            else if(t.getCoe() == 1 && t.getExp() == 0)
            {
                polinomio = polinomio + "+" + t.getCoe();
            }
            else if(t.getCoe() > 0 && polinomio == "")
            {
                polinomio = polinomio +  t.getCoe() + "x^" + t.getExp();
            }
            else if(t.getCoe() > 0 && t.getExp() != 1 && t.getExp() != 0 && t.getExp() != x.getExp())
            {
                polinomio = polinomio + "+" + t.getCoe() + "x^" + t.getExp();
            }
            else if(t.getCoe() > 0 && t.getExp() == 1)
            {
                polinomio = polinomio + "+" + t.getCoe() + "x";
            }
            else if(t.getCoe() > 0 && t.getExp() == 0)
            {
                polinomio = polinomio + "+" + t.getCoe();
            }
            else if(t.getCoe() < 0 && t.getExp() != 1 && t.getExp() != 0)
            {
                polinomio = polinomio + t.getCoe() + "x^" + t.getExp();
            }
            else if(t.getCoe() < 0 && t.getExp() == 1)
            {
                polinomio = polinomio +  t.getCoe() + "x";
            }
            else if(t.getCoe() < 0 && t.getExp() == 0)
            {
                polinomio = polinomio + t.getCoe();           
            }
            t = t.getLiga();
        }
        return polinomio;
    } 
    
    public void Evaluar3(int num)
    {
        int resultado = 0, tamanio = 1, i = 2, j = 0,  aux;
        String s = "";
        Nodo t = Punta;
        aux = t.getExp();
        while(t.getLiga() != null)
        {
            tamanio++;
            t = t.getLiga();
        }
        t = Punta;
        int[] evaluar = new int[tamanio];
        while(t.getExp() > 1)
        {
            while(aux != 0)
            {
                if(resultado == 0)
                {
                    resultado = num;
                }
                else
                {
                    resultado = resultado * num;
                }
                aux--;
            }
            if(num < 0 && (t.getExp() % 2) == 0)
            {
                resultado = resultado * -1;
            }
            evaluar[j] = resultado;
            resultado = 0;
            j++;                          
            t = t.getLiga();
            aux = t.getExp();
        }
        if(t.getExp() != 0)
        {
            evaluar[j] = num;
            j++;
            t = t.getLiga();
        }
        if(t.getExp() == 0)
        {
            evaluar[j] = 1;
            j++;
            t = t.getLiga();
        }
        j = 0;
        t = Punta;
        while(j < evaluar.length)
        {
            resultado = t.getCoe() * evaluar[j];
            evaluar[j] = resultado;
            j++;
            t = t.getLiga();
        }
        i = 0;
        resultado = 0;
        while(i < evaluar.length)
        {
            resultado = resultado + evaluar[i];
            System.out.println(resultado);
            i++;
        }
        while(i < evaluar.length)
        {
            resultado = resultado + evaluar[i];
            i++;
        }
        s = ReconstruirPoli3(Punta);
        JOptionPane.showMessageDialog(null,"Polinomio = " + s + "\nX = " + num + "\nResultado = " + resultado);
    }
    
    public String Suma3(Nodo A, Nodo B)
    {
        String aux = "";
        int i = 0, a, b, n = 0,m = 0;
        Punta = null;
        Punta = new Nodo();
        Nodo x, t, s, z;
        s = A;
        z = B;
        
        if(s.getExp() > z.getExp())
        {
            Punta.setExp(s.getExp());
        }
        else
        {
            Punta.setExp(z.getExp());   
        }
        a = s.getExp();
        b = z.getExp();
        m = 1;
        n = 1;
        
        
        if(a != 0 && s.getExp() == 0)
        {
            a = 0;
        }
        else if(b != 0 && z.getExp() == 0)
        {
            b = 0;
        }
        if(s.getExp()  > z.getExp())
        {
            if(s.getExp() == a)
            {  
                Punta.setCoe(s.getCoe());
                Punta.setLiga(null);
                a--;
                s = s.getLiga();
            }
            else
            {
                a--;
            }        
        }
        else if(s.getExp() < z.getExp())
        {
            if(z.getExp() == b)
            {
                Punta.setCoe(z.getCoe());
                Punta.setLiga(null);
                b--;
                z = z.getLiga();
            }
            else
            {
                b--;
            }
        }
        else if(s.getExp() == z.getExp())
        {
            Punta.setCoe(s.getCoe() + z.getCoe());
            Punta.setExp(z.getExp());
            Punta.setLiga(null);
            a--;
            b--;
        }        
        
        while(a > -1 || b > -1)
        {
            t = Punta;
            if(a != 0 && s.getExp() == 0)
            {
                a = 0;
            }
            else if(b != 0 && z.getExp() == 0)
            {
                b = 0;
            }
            if(s.getExp()  > z.getExp())
            {
                if(s.getExp() == a)
                {  
                    x = new Nodo();
                    x.setCoe(s.getCoe());
                    x.setExp(s.getExp());
                    while(t.getLiga() != null)
                    {
                        t = t.getLiga();
                    }
                    t.setLiga(x);
                    a--;
                    s = s.getLiga();
                }
                else
                {
                    a--;
                }        
            }
            else if(z.getExp() > s.getExp())
            {
                if(z.getExp() == b)
                {
                    x = new Nodo();
                    x.setCoe(z.getCoe());
                    x.setExp(z.getExp());
                    while(t.getLiga() != null)
                    {
                        t = t.getLiga();
                    }
                    t.setLiga(x);
                    b--;
                    z = z.getLiga();
                }
                else
                {
                    b--;
                }
            }
            else if(s.getExp() == z.getExp())
            {
                x = new Nodo();
                x.setCoe(s.getCoe() + z.getCoe());
                x.setExp(z.getExp());
                while(t.getLiga() != null)
                {
                    t = t.getLiga();
                }
                t.setLiga(x);
                s = s.getLiga();
                z = z.getLiga();
                a--;
                b--;
            }
        }
        aux = ReconstruirPoli3(Punta);
        return aux;
    }
    
    public String Multiplicacion3(Nodo A, Nodo B)
    {
        String aux = "";
        Nodo s, z, t, x, y;
        Punta = null;
        Punta = new Nodo();
        s = A;
        z = B;
        
        Punta.setCoe(s.getCoe() * z.getCoe());
        Punta.setExp(s.getExp() + z.getExp());
        Punta.setLiga(null);
        s = s.getLiga();
        t = Punta;
        while(z != null)
        {
            while(s != null)
            {
                t = Punta;
                x = new Nodo();
                x.setCoe(s.getCoe() * z.getCoe());
                x.setExp(s.getExp() + z.getExp());
                while(t.getExp() != x.getExp() && t.getLiga() != null && t.getExp() > x.getExp())
                {
                    t = t.getLiga();
                }
                if(t.getExp() == x.getExp())
                {
                    t.setCoe(t.getCoe() + x.getCoe());
                }
                else if(t.getExp() > x.getExp() && t.getLiga() != null)
                {
                    y = t.getLiga();
                    t.setLiga(x);
                    x.setLiga(y);
                }
                else if(t.getExp() < x.getExp() && t.getLiga() != null)
                {
                    y = Punta;
                    while(y.getLiga() != t)
                    {
                        y = y.getLiga();
                    }
                    y.setLiga(x);
                    x.setLiga(t);
                }
                else if(t.getLiga() == null)
                {
                    t.setLiga(x);
                }
                s = s.getLiga();
                x = null;    
            }
            s = A;
            z = z.getLiga();
        }
        aux = ReconstruirPoli3(Punta);
        return aux;
    }
}
