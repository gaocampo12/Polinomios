package proyecto;

import javax.swing.*;

public class Forma2 
{
    //Atributos
    private int[] Vector2;
    private int Du;
    
    //Metodos
    public Forma2(int tamanio)
    {
        Du = tamanio + 1;
        Vector2 = new int[Du];          
    }
    
    public int GetVector2(int pos) 
    {
        return Vector2[pos];
    }

    public int GetDu2() 
    {
        return Du;
    }
    
    public void SetVector2(int pos, int dato)
    {
        Vector2[pos] = dato;
    }
    
    public void SetDu2(int Du) 
    {
        this.Du = Du;
    }
    
    public void IngresoPoli2(String polinomio)
    {
        int a = 0, i = 0, cont = 0;
        char[] aCaracteres = polinomio.toCharArray();
        String s = "";
        while(i < Vector2.length)
        {
            Vector2[i] = 0;
            i++;
        }
        while(a < aCaracteres.length)
        {
            if(aCaracteres[a] == '-' || aCaracteres[a] == '+' || cont == 0)
            {
                cont++;
            }
            a++;
        }
        Vector2[0] = cont;
        a = 1;
        for(int j = 0; j < aCaracteres.length; j++)
        {
            if(aCaracteres[j] == '-' || Character.isDigit(aCaracteres[j]))
            {
                s = s + aCaracteres[j];
            }
            else
            {
                if(aCaracteres[j] == '+' && aCaracteres[j + 1] != 'x')
                {
                    j++;
                    s = Character.toString(aCaracteres[j]);
                    a--;
                }
                else if(aCaracteres[j] == '+' && aCaracteres[j + 1] == 'x')
                {
                    Vector2[a] = 1;
                    Vector2[a+1] = 1;
                    a++;
                    j++;
                }
                else if(aCaracteres[j] == '^' )
                {
                   Vector2[a] = Integer.parseInt(Character.toString(aCaracteres[j+1]));
                   j++; 
                }
                else if(aCaracteres[j] == 'x' && s.equals(""))
                {
                    Vector2[a] = 1;
                    Vector2[a+1] = 1;
                    a++;
                    
                }
                else if(aCaracteres[j] == 'x' && s.equals("-"))
                {
                    Vector2[a] = -1;
                    Vector2[a+1] = 1;
                    a++;
                    s = "";
                }  
                else
                {
                    Vector2[a] = Integer.parseInt(s);
                    if(j + 1 != aCaracteres.length)
                    {
                        if(s != "" && aCaracteres[j + 1] != '^')
                        {
                            a++;
                            Vector2[a] = 1;   
                        } 
                    }

                    s = "";   

                }
                a++;
            }
        }
        if(s != "")
        {
            Vector2[a] = Integer.parseInt(s);
            Vector2[a+1] = 0;
            a = a + 2;
        }
    }
    
    public void Mostrar2()
    {
        int i = 0, b = 0;
        String aux = "";
        int Du = Vector2[0] * 2;
        while(i <= Du)
        {
            b = Vector2[i];
            aux = aux + "  |  " + b;
            i++;  
        }
        JOptionPane.showMessageDialog(null, aux + "  |");
    }
    
    public String ReconstruirPoli2()
    {
        String polinomio = "";
        int i = 1, du, j= 0;
        du = Vector2[0] * 2;
        while(j < du)
        {
            if(i % 2 != 0 );
            {
                if(Vector2[i] == -1 && Vector2[i + 1] != 1 && Vector2[i + 1] != 0)
                { 
                    polinomio = polinomio + "-x^" + Vector2[i + 1];
                }
                else if(Vector2[i] == -1 && Vector2[i + 1] == 1)
                {
                    polinomio = polinomio + "-x";
                }
                else if(Vector2[i] == -1 && Vector2[i + 1] == 0)
                {
                    polinomio = polinomio + Vector2[i];
                }
                else if(Vector2[i] == 1 && Vector2[i + 1] != 1 && Vector2[i + 1] != 0)
                {
                    polinomio = polinomio + "+x^" + Vector2[i + 1];
                }
                else if(Vector2[i] == 1 &&  Vector2[i + 1] == 1)
                {
                    polinomio = polinomio + "+x";
                }
                else if(Vector2[i] == 1 && Vector2[i + 1] == 0)
                {
                    polinomio = polinomio + "+" + Vector2[i];
                }
                else if(Vector2[i] > 0 && polinomio == "")
                {
                    polinomio = polinomio +  Vector2[i]+ "x^" + Vector2[i + 1];
                }
                else if(Vector2[i] > 0 && Vector2[i + 1] != 1 && Vector2[i + 1] != 0 && Vector2[i + 1] != Vector2[2])
                {
                    polinomio = polinomio + "+" + Vector2[i]+ "x^" + Vector2[i + 1];
                }
                else if(Vector2[i] > 0 && Vector2[i + 1] == 1)
                {
                    polinomio = polinomio + "+" + Vector2[i]+ "x";
                }
                else if(Vector2[i] > 0 && Vector2[i + 1] == 0)
                {
                    polinomio = polinomio + "+" + Vector2[i];
                }
                else if(Vector2[i] < 0 && Vector2[i + 1] != 1 && Vector2[i + 1] != 0)
                {
                    polinomio = polinomio + Vector2[i] + "x^" + Vector2[i + 1];
                }
                else if(Vector2[i] < 0 && Vector2[i + 1] == 1)
                {
                    polinomio = polinomio +  Vector2[i] + "x";
                }
                else if(Vector2[i] < 0 && Vector2[i + 1] == 0)
                {
                    polinomio = polinomio + Vector2[i];
                    
                }
                i++;
            }
            i++;
            j++;
        } 
        return polinomio;
    }
    
    public void Evaluar2(int num)
    {
        int resultado = 0, tamanio = Vector2[0], i = 2, j = 0, du = Vector2[0] * 2, aux = Vector2[i];
        String s = "";
        int[] evaluar = new int[tamanio];
        while(Vector2[i] > 1)
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
            if(num < 0 && (Vector2[i] % 2) == 0)
            {
                resultado = resultado * -1;
            }
            evaluar[j] = resultado;
            resultado = 0;
            j++;                          
            i = i + 2;
            aux = Vector2[i];
        }
        while(i <= Vector2[0] * 2)
        {
            if(Vector2[i] != 0)
            {
                evaluar[j] = num;
                j++;
            }
            else if(Vector2[i] == 0)
            {
                evaluar[j] = 1;
                j++;
            }
            i = i + 2; 
        }
        j = 0;
        i = 1;
        while(j < evaluar.length)
        {
            resultado = Vector2[i] * evaluar[j];
            evaluar[j] = resultado;
            j++;
            i = i + 2;
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
        s = ReconstruirPoli2();
        JOptionPane.showMessageDialog(null,"Polinomio = " + s + "\nX = " + num + "\nResultado = " + resultado);
    }
    
    public String Suma2(Forma2 A, Forma2 B)
    {
        String aux = "";
        int i = 0, a, b, n = 0,m = 0;
        while(i < Vector2.length)
        {
            Vector2[i] = 0;
            i++;
        }
        i = 0;
        if(A.GetVector2(2) > B.GetVector2(2))
        {
            Vector2[i] = A.GetVector2(2);
        }
        else
        {
            Vector2[i] = B.GetVector2(2);   
        }
        i++;
        a = A.GetVector2(2);
        b = B.GetVector2(2);
        m = 1;
        n = 1;
        while(a > -1 || b > -1)
        {
            if(a != 0 && A.GetVector2(m + 1) == 0)
            {
                a = 0;
            }
            else if(b != 0 && B.GetVector2(n + 1) == 0)
            {
                b = 0;
            }
            if(A.GetVector2(m + 1)  > B.GetVector2(n + 1))
            {
                if(A.GetVector2(m+1) == a)
                {
                    Vector2[i] = A.GetVector2(m);
                    i++;
                    m++;
                    Vector2[i]= A.GetVector2(m);
                    i++;
                    a--;
                    m++;
                }
                else
                {
                    a--;
                }
                    
            }
            else if(B.GetVector2(n + 1)  > A.GetVector2(m + 1))
            {
                if(B.GetVector2(n + 1) == b)
                {
                    Vector2[i] = B.GetVector2(n);
                    i++;
                    n++;
                    Vector2[i]= B.GetVector2(n);
                    i++;
                    b--;
                    n++;
                }
                else
                {
                    b--;
                }
            }
            else if(A.GetVector2(m + 1)  ==  B.GetVector2(n + 1))
            {
                Vector2[i] = A.GetVector2(m) + B.GetVector2(n);
                i++;
                m++;
                n++;
                Vector2[i] = A.GetVector2(m);
                m++;
                n++;
                i++;
                a--;
                b--;
            }
        }
        aux = ReconstruirPoli2();
        return aux;
    }
    
    public String Multiplicacion2(Forma2 A, Forma2 B)
    {
        String aux = "";
        int i = 0, j = 1,k = 1, resultado = 0,resultado2 = 0, c = 0, d = 0, exp1, exp2, cont;
        int a = A.GetVector2(2);
        int b = B.GetVector2(2);
        while(i < Vector2.length)
        {
            Vector2[i] = 0;
            i++;
        }  
        cont = a + b;
        i = 2;
        while(cont > -1)
        {
           Vector2[i] = cont;
           cont--;
           i = i + 2;
        }
        i = 1;
        c = 2;
        d = 2;
        exp1 = a;
        exp2 = b;
        while(exp2 > -1)
        {
            while(exp2 != B.GetVector2(d))
            {
                exp2--;
            }
            while(exp1 > -1)
            {
                resultado = A.GetVector2(j) * B.GetVector2(k);
                resultado2 = A.GetVector2(c) + B.GetVector2(d);
                while(resultado2 != Vector2[i + 1])
                {   
                    i = i + 2;  
                }
                Vector2[i] =  Vector2[i] + resultado;
                if(exp1 != 0)
                {
                    exp1 = A.GetVector2(c); 
                }            
                i = 1;
                j = j + 2; 
                c = j +1;
                exp1--;
            }
            exp1 = a;
            exp2 --;
            j = 1;
            c = 2;    
            k = k + 2; 
            d = k +1;
        }
        i = (Vector2[2] * 2) + 2;
        j = 1;
        cont = Vector2[2];
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        while(cont > -1)
        {
            while(Vector2[j] == 0)
            {
                k = j;
                while(b <= i)
                {
                    a = k;
                    b = k + 1;
                    c = k + 2;
                    d = k + 3;
                    Vector2[a] = Vector2[c];
                    Vector2[b] = Vector2[d];
                    Vector2[c] = 0;
                    Vector2[d] = 0;
                    k = k + 2;
                }
                a = 0;
                b = 0;
                c = 0;
                d = 0;
                if(Vector2[j] != 0)
                {
                    j = j + 2;
                }
            }
            if(cont != Vector2[j+1])
            {
                cont = Vector2[j+1]; 
            }
            else
            {
                j = j + 2;
                cont--;
            }    
        }
        i = 1;
        cont = 0;
        while(Vector2[i] != 0)
        {
            cont++;
            i = i + 2;
        }
        Vector2[0] = cont;
        aux = ReconstruirPoli2();
        return aux;
    }
}
