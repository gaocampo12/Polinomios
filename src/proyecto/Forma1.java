package proyecto;

import javax.swing.*;

public class Forma1
{
    //Atributos
    private int[] Vector1;
    private int Du;
    
    //Metodos
    public Forma1(int tamanio)
    {
        Du = tamanio + 1;
        Vector1 = new int[Du];          
    }
    
    public int GetDu1()
    {
        return Du;
    }
    
    public void SetDu1(int datos)
    {
        Du = datos; 
    }
    
    public int GetVector1(int pos) 
    {
        return Vector1[pos];
    }
    
    public void SetVector1(int pos, int dato)
    {
        Vector1[pos] = dato;
    }
    
    public void IngresoPoli1(String polinomio)
    {
        int[] Vp1 = new int[100];
        int a = 0, b = 0, c = 0, d = 0, aux, i = 0, j = 0;
        char[] aCaracteres = polinomio.toCharArray();
        String s = "", p = "";
        while(i < Vector1.length)
        {
            Vector1[i] = 0;
            i++;
        }
        while(aCaracteres[a] != '^')
        {
            a++;
        }
        Vp1[0] = Integer.parseInt(Character.toString(aCaracteres[a + 1]));
        a = 1;
        for(j = 0; j < aCaracteres.length; j++)
        {
            if(aCaracteres[j] == '-' || Character.isDigit(aCaracteres[j]))
            {
                s = s + aCaracteres[j];
                if(j == aCaracteres.length - 1)
                {
                    Vp1[a] = Integer.parseInt(s);
                    if(aCaracteres[j] == 'x')
                    {
                        p = "";
                    }
                    else
                    {
                        p = s;
                    }
                    s = "";
                }
            }
            else
            {
                if(aCaracteres[j] == '+' && aCaracteres[j + 1] != 'x')
                {
                    s = Character.toString(aCaracteres[j + 1]);
                    j++;
                    if(j == aCaracteres.length - 1)
                    {
                        Vp1[a] = Integer.parseInt(s);
                        if(aCaracteres[j] == 'x')
                        {
                            p = "";
                        }
                        else
                        {
                            p = s;
                        }
                        s = "";
                    }
                    a--;
                    

                }
                else if(aCaracteres[j] == '+' && aCaracteres[j + 1] == 'x')
                {
                    Vp1[a] = 1;
                    j++;
                }
                else if(aCaracteres[j] == '^' )
                {
                   Vp1[a] = Integer.parseInt(Character.toString(aCaracteres[j+1]));
                   j++; 
                }
                else if(aCaracteres[j] == 'x' && s.equals(""))
                {
                    Vp1[a] = 1;
                    p = "";
                }
                else if(aCaracteres[j] == 'x' && s.equals("-"))
                {
                    Vp1[a] = -1;
                    p = "";
                    s = "";
                }
                else
                {
                    Vp1[a] = Integer.parseInt(s);
                    if(aCaracteres[j] == 'x')
                    {
                        p = "";
                    }
                    else
                    {
                        p = s;
                    }
                    s = "";
                    
                }
                a++;
            }
            
        }
        if(s != "")
        {
            Vp1[a] = Integer.parseInt(s);
            a++; 
        }
        a = 2;       
        aux = Vp1[0];

        while(aux != 0)
        {
            if(aux >= 2)
            {
                if(aux == Vp1[a])
                {
                    a = a + 2;
                    aux--;
                }
                else
                {
                    a = a - 2;
                    b = a;
                    while(Vp1[b] != 0)
                    {
                        b++;
                    }
                   
                    c = b - 1;
                    d = b + 1;
                    while(c != a)
                    {
                        Vp1[d] = Vp1[c];
                        Vp1[c] = 0;
                        Vp1[b] = aux;
                        b--;
                        c--;
                        d--;
                    }
                    a = a + 2;
                }
            }
            else
            {
                if(Vp1[a] == 0)
                {
                    b = a;
                    a = a - 2;
                    c = b - 1;
                    d = b + 1;
                    Vp1[d] = Vp1[c];
                    Vp1[c] = 0;
                    Vp1[b] = aux;
                }
                else
                {
                    if(Vp1[a + 2] != 0)
                    {
                        b = a + 2;
                        d = b + 1;
                        Vp1[d] = Vp1[b];
                        Vp1[b] = 1;   
                    }
                    else if(Vp1[a + 2] == 0 && p == "")
                    {
                        Vp1[a + 2]= 1;
                    }
                    else if(Vp1[a + 2] == 0 && p != "" && aux + 1 == Vp1[a-1])
                    {
                        b = a + 2;
                        c = b - 1;
                        d = b + 1;
                        Vp1[d] = Vp1[c];
                        Vp1[c] = 0;
                        Vp1[b] = 1;
                    } 
                    else if(Vp1[a + 2] == 0 && p != "" && aux + 1 != Vp1[a-1])
                    {
                        b = a;
                        a = a - 1;
                        c = b + 1;
                        Vp1[c] = Vp1[b];
                        Vp1[b] = 1;
                        a = a + 1;
                    }
                }
                aux--;
            }
        }
        int ñ = 0;
        
        a = 0;
        c = 0;
        while(c <= d)
        {
            Vector1[c] = 0;
            c++;
        }
        Vector1[0] = Vp1[0];
        a = Vp1[0];
        b = 1;
        c = 1;
        while(ñ < 15)
        {
            System.out.println(Vp1[ñ]);
            ñ++;
        }
        while(a > -1)
        {
            Vector1[c] =  Vp1[b];
            c++;
            a--;
            b = b + 2;
        }
    }
    
    public String ReconstruirPoli1()
    {
        String polinomio = "";
        int exp = Vector1[0], i = 1;
        while(exp > -1)
        {
            if(Vector1[i] == -1 && exp != 1 && exp != 0)
            {
                polinomio = polinomio + "-x^" + exp;
            }
            else if(Vector1[i] == -1 && exp == 1)
            {
                polinomio = polinomio + "-x";
            }
            else if(Vector1[i] == -1 && exp == 0)
            {
                polinomio = polinomio + Vector1[i];
            }
            else if(Vector1[i] == 1 && exp != 1 && exp != 0)
            {
                polinomio = polinomio + "+x^" + exp;
            }
            else if(Vector1[i] == 1 && exp == 1)
            {
                polinomio = polinomio + "+x";
            }
            else if(Vector1[i] == 1 && exp == 0)
            {
                polinomio = polinomio + "+" + Vector1[i];
            }
            else if(Vector1[i] > 0 && exp == Vector1[0])
            {
                polinomio = polinomio +  Vector1[i]+ "x^" + exp;
            }
            else if(Vector1[i] > 0 && exp != 1 && exp != 0 && exp != Vector1[0])
            {
                polinomio = polinomio + "+" + Vector1[i]+ "x^" + exp;
            }
            else if(Vector1[i] > 0 && exp == 1)
            {
                polinomio = polinomio + "+" + Vector1[i]+ "x";
            }
            else if(Vector1[i] > 0 && exp == 0)
            {
                polinomio = polinomio + "+" + Vector1[i];
            }
            else if(Vector1[i] < 0 && exp != 1 && exp != 0)
            {
                polinomio = polinomio + Vector1[i] + "x^" + exp;
            }
            else if(Vector1[i] < 0 && exp == 1)
            {
                polinomio = polinomio +  Vector1[i] + "x";
            }
            else if(Vector1[i] < 0 && exp == 0)
            {
                polinomio = polinomio + Vector1[i];
            }
            else if(Vector1[i] == 0)
            {
                polinomio = polinomio;
            }
            i++;
            exp--;
        }
        return polinomio;
    }
    
    public void Mostrar1()
    {
        int i = 0, b = 0;
        String aux = "";
        int exp = Vector1[0] + 1;
        while(exp > -1)
        {

            b = Vector1[i];
            aux = aux + "  |  " + b;
            i++;
            exp--;  
        }
        JOptionPane.showMessageDialog(null, aux + "  |");

        
    }
    
    public void Evaluar1(int num)
    {
        int i = 1, resultado = 0, exp = Vector1[0], aux = exp, j = 0, k = 1, ñ;
        String s = "";
        int[] evaluar = new int[exp + 1];
        while(exp > 1)
        {
            if(Vector1[i] != 0)
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
                if(num < 0 && (exp % 2) == 0)
                {
                    resultado = resultado * -1;
                }
                evaluar[j] = resultado;
                resultado = 0;
                j++;
            }
            exp--;
            i++;
            aux = exp;
        }
        while(exp > -1)
        {
            if(Vector1[i] != 0 && exp != 0)
            {
                evaluar[j] = num;
                j++;
            }
            else if(Vector1[i] != 0 && exp == 0)
            {
                evaluar[j] = 1;
                j++;
            }
            i++;
            exp--; 
        }
        i = 0;
        resultado = 0;
        while(i < j)
        {
            ñ = Vector1[k];
            while(Vector1[k] == 0)
            {
                k++;
                ñ = Vector1[k];
            }
            ñ = Vector1[k];
            evaluar[i] = evaluar[i] * Vector1[k];
            resultado = evaluar[i];
            i++;
            k++;    
        }
        resultado = 0;
        i = 0;
        while(i < j)
        {
            resultado = resultado + evaluar[i];
            i++;
        }
        s = ReconstruirPoli1();
        JOptionPane.showMessageDialog(null,"Polinomio = " + s + "\nX = " + num + "\nResultado = " + resultado);
    }
    
    public String Suma1(Forma1 A, Forma1 B)
    {
        
        int i = 0, j = 1,k = 1, resultado = 0;
        String aux = "";
        int a = A.GetVector1(0);
        int b = B.GetVector1(0);
        while(i < Vector1.length)
        {
            Vector1[i] = 0;
            i++;
        }
        i = 0;
        while(a > -1 && b > -1)
        {
            if(Vector1[0] == 0)
            {
                if(a > b)
                {
                    Vector1[i] = A.GetVector1(0);
                }
                else if(b > a)
                {
                    Vector1[i] = B.GetVector1(0);
                }
                else if(a == b)
                {
                    Vector1[i] = A.GetVector1(0);
                }
                i++;
            }
            else
            {
                if(a > b)
                {
                    Vector1[i] = A.GetVector1(j);
                    a--;
                    j++;
                }
                else if(b > a)
                {
                    Vector1[i] = B.GetVector1(k);
                    b--;
                    k++;
                }
                else if(a == b)
                {
                    resultado = A.GetVector1(j) + B.GetVector1(k);
                    Vector1[i] = resultado;
                    a--;
                    b--;
                    j++;
                    k++;
                }
                i++;
            }
          
        }
        aux = ReconstruirPoli1();
        return aux;
    }
    
    public String Multiplicacion1(Forma1 A, Forma1 B)
    {
        int i = 0, j = 1,k = 1, resultado = 0, c = 0, d = 0, du, pos;
        String aux = "";
        int a = A.GetVector1(0);
        int b = B.GetVector1(0);
        while(i < Vector1.length)
        {
            Vector1[i] = 0;
            i++;
        }
        i = 0;
        Vector1[0] = a + b;
        du = Vector1[0] + 1;
        c = a;
        d = b;
                
            while(d > -1)
            {
                if(B.GetVector1(k) != 0)
                {
                    while(c > -1)
                    {
                        if(A.GetVector1(j) != 0)
                        {
                            resultado = A.GetVector1(j) * B.GetVector1(k);
                            pos = du - (c + d);
                            Vector1[pos] = Vector1[pos] + resultado;
                        }
                        j++;
                        c--;  
                    }
                    j = 1;
                    c = a;
                }
                k++;
                d--; 
            }
            aux = ReconstruirPoli1();
        return aux;
    }
    
}


