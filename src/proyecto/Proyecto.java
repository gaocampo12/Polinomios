package proyecto;

import java.util.*;
import javax.swing.*;

public class Proyecto 
{
    public static void main(String[] args) 
    {
        int menu = 0, opc = 0, opc1 , i= 0, num;
        Nodo x,a, b;
        x = new Nodo();
        String poli1 = "",poli1A = "", poli2 = "",poli2A = "", poli3 = "", poli3A = "", aux = "", aux2 = "", aux3 = "";
        Forma1 polinomio1 = new Forma1(100);
        Forma1 polinomio1A = new Forma1(100);
        Forma1 polinomio1B = new Forma1(100);
        Forma1 polinomioSuma1 = new Forma1(100);
        Forma1 polinomioMultiplicacion1 = new Forma1(100);
        Forma2 polinomio2 = new Forma2(100);
        Forma2 polinomio2A = new Forma2(100);
        Forma2 polinomio2B = new Forma2(100);
        Forma2 polinomioSuma2 = new Forma2(100);
        Forma2 polinomioMultiplicacion2 = new Forma2(100);
        Forma2 Polinomio3 = new Forma2(100);
        Forma3 polinomio3 = new Forma3();
        Forma3 polinomio3A = new Forma3();
        Forma3 polinomio3B = new Forma3();
        Forma3 polinomioSuma3 = new Forma3();
        Forma3 polinomioMultiplicacion3 = new Forma3();
  
        while(menu >= 0 && menu <= 4)
        {
            opc = 0;
            menu = Integer.parseInt(JOptionPane.showInputDialog("\n [ 1 ] Polinomio Forma 1. " + "\n [ 2 ] Polinomio Forma 2. " + "\n [ 3 ] Polinomio Forma 3. " + "\n [ 4 ] Operaciones Extras." + "\n " + "\n [ 5 ] Terminar. " + "\n "));                                                             
            switch(menu)
            {
                case 1:
                    opc = 0;
                    while(opc >= 0 && opc <= 8)
                    {
                        opc = Integer.parseInt(JOptionPane.showInputDialog("FORMA 1"+ "\n" +"\n [ 1 ] Ingresar." + "\n [ 2 ] Reconstruir." + "\n [ 3 ] Evaluar." + "\n [ 4 ] Sumar." + "\n [ 5 ] Multiplicar." + "\n [ 6 ] Dividir." + "\n [ 7 ] Mostrar." + "\n" + "\n [ 8 ] Volver." + "\n "));       
                        switch(opc)
                        {
                            case 1:
                                if(poli1 == "")
                                {
                                    poli1 = JOptionPane.showInputDialog("INGRESE EL POLINOMIO ORDENADO DE EXPONENTE MAYOR A MENOR" + "\n" + "\nEjemplo: 3x^3+2x^2-x+1   ¡ SIN ESPACIOS  !" + "\n" + "\n| Coeficiente | Parte Literal | ^ | Exponente | Operando |");
                                    polinomio1.IngresoPoli1(poli1);
                                    JOptionPane.showMessageDialog(null, "¡ Polinomio Ingresado Correctamente !");
                                }
                                else
                                {
                                    opc1 = Integer.parseInt(JOptionPane.showInputDialog("El polinomio Forma 1 ya fue ingresado, desea volverlo hacer?" + "\n\n[ 1 ] SI." + "\n[ 2 ] NO.\n " ));
                                    if(opc1 == 1)
                                    {
                                        poli1 = JOptionPane.showInputDialog("INGRESE EL POLINOMIO" + "\n" + "\nEjemplo: 3x^3+2x^2-x+1   ¡ SIN ESPACIOS  !" + "\n" + "\n| Coeficiente | Parte Literal | ^ | Exponente | Operando |");
                                        polinomio1.IngresoPoli1(poli1);
                                        JOptionPane.showMessageDialog(null, "¡ Polinomio Ingresado Correctamente !");
                                        opc1 = 0;
                                    }
                                }
                            break;
                        
                            case 2:
                                if(poli1 == "")
                                {
                                    JOptionPane.showMessageDialog(null, "Ingrese primero el polinomio"); 
                                }
                                else
                                {
                                    aux = polinomio1.ReconstruirPoli1();
                                    JOptionPane.showMessageDialog(null, aux); 
                                    aux = "";
                                }
                            break;
                        
                            case 3:
                                if(poli1 == "")
                                {
                                    JOptionPane.showMessageDialog(null, "Ingrese primero el polinomio"); 
                                }
                                else
                                {
                                    num = Integer.parseInt(JOptionPane.showInputDialog("¿Con que numero desea evaluar el polinomio?"));
                                    polinomio1.Evaluar1(num);     
                                }
                            break;
                        
                            case 4:
                                poli1A = JOptionPane.showInputDialog("INGRESE EL POLINOMIO A ORDENADO DE EXPONENTE MAYOR A MENOR" + "\n" + "\nEjemplo: 3x^3+2x^2-x+1   ¡ SIN ESPACIOS  !" + "\n" + "\n| Coeficiente | Parte Literal | ^ | Exponente | Operando |");
                                polinomio1A.IngresoPoli1(poli1A);
                                JOptionPane.showMessageDialog(null, "¡ Polinomio A Ingresado Correctamente !");
                                poli1A = JOptionPane.showInputDialog("INGRESE EL POLINOMIO B ORDENADO DE EXPONENTE MAYOR A MENOR" + "\n" + "\nEjemplo: 3x^3+2x^2-x+1   ¡ SIN ESPACIOS  !" + "\n" + "\n| Coeficiente | Parte Literal | ^ | Exponente | Operando |");
                                polinomio1B.IngresoPoli1(poli1A);
                                JOptionPane.showMessageDialog(null, "¡ Polinomio B Ingresado Correctamente !"); 
                                aux3 = polinomioSuma1.Suma1(polinomio1A, polinomio1B);
                                aux = polinomio1A.ReconstruirPoli1();
                                aux2 = polinomio1B.ReconstruirPoli1(); 
                                JOptionPane.showMessageDialog(null, " " + aux + "    + \n \n " + aux2 + "\n_________________________\n \n " + aux3 );
                                aux = "";
                                aux2 = "";
                                aux3 = "";
                                poli1A = "";
                            break;
                        
                            case 5:
                                poli1A = JOptionPane.showInputDialog("INGRESE EL POLINOMIO A ORDENADO DE EXPONENTE MAYOR A MENOR" + "\n" + "\nEjemplo: 3x^3+2x^2-x+1   ¡ SIN ESPACIOS  !" + "\n" + "\n| Coeficiente | Parte Literal | ^ | Exponente | Operando |");
                                polinomio1A.IngresoPoli1(poli1A);
                                JOptionPane.showMessageDialog(null, "¡ Polinomio A Ingresado Correctamente !");
                                poli1A = JOptionPane.showInputDialog("INGRESE EL POLINOMIO B ORDENADO DE EXPONENTE MAYOR A MENOR" + "\n" + "\nEjemplo: 3x^3+2x^2-x+1   ¡ SIN ESPACIOS  !" + "\n" + "\n| Coeficiente | Parte Literal | ^ | Exponente | Operando |");
                                polinomio1B.IngresoPoli1(poli1A);
                                JOptionPane.showMessageDialog(null, "¡ Polinomio B Ingresado Correctamente !"); 
                                aux3 = polinomioMultiplicacion1.Multiplicacion1(polinomio1A, polinomio1B);
                                aux = polinomio1A.ReconstruirPoli1();
                                aux2 = polinomio1B.ReconstruirPoli1();
                                JOptionPane.showMessageDialog(null, " " + aux + "    x \n \n " + aux2 + "\n_________________________\n \n " + aux3 );
                                aux = "";
                                aux2 = "";
                                aux3 = "";
                                poli1A = "";
                            break;
                        
                            case 6:
                                JOptionPane.showMessageDialog(null, "En desarrollo...");
                            break;
                            
                            case 7:
                                if(poli1 == "")
                                {
                                    JOptionPane.showMessageDialog(null, "Ingrese primero el polinomio"); 
                                }
                                else
                                {
                                    polinomio1.Mostrar1();
                                           
                                }
                            break;
                        
                            case 8:
                                opc = 9;
                            break;
                        
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese un valor valido");
                                opc = 0;
                            break; 
                        }   
                    }
                break;
                
                case 2:
                    opc = 0;
                    while(opc >= 0 && opc <= 8)
                    {
                        opc = Integer.parseInt(JOptionPane.showInputDialog("FORMA 2"+ "\n" +"\n [ 1 ] Ingresar." + "\n [ 2 ] Reconstruir." + "\n [ 3 ] Evaluar." + "\n [ 4 ] Sumar." + "\n [ 5 ] Multiplicar." + "\n [ 6 ] Dividir." + "\n [ 7 ] Mostrar." + "\n" + "\n [ 8 ] Volver." + "\n "));       
                        switch(opc)
                        {
                            case 1:
                                if(poli2 == "")
                                {
                                    poli2 = JOptionPane.showInputDialog(null, "INGRESE EL POLINOMIO ORDENADO DE EXPONENTE MAYOR A MENOR" + "\n" + "\nEjemplo: 3x^3+2x^2-x+1   ¡ SIN ESPACIOS  !" + "\n" + "\n| Coeficiente | Parte Literal | ^ | Exponente | Operando |");
                                    polinomio2.IngresoPoli2(poli2);
                                    JOptionPane.showMessageDialog(null, "¡ Polinomio Ingresado Correctamente !");
                                }
                                else
                                {
                                    opc1 = Integer.parseInt(JOptionPane.showInputDialog("El polinomio Forma 2 ya fue ingresado, desea volverlo hacer?" + "\n\n[ 1 ] SI." + "\n[ 2 ] NO.\n " ));
                                    if(opc1 == 1)
                                    {
                                        poli2 = JOptionPane.showInputDialog("INGRESE EL POLINOMIO" + "\n" + "\nEjemplo: 3x^3+2x^2-x+1   ¡ SIN ESPACIOS  !" + "\n" + "\n| Coeficiente | Parte Literal | ^ | Exponente | Operando |");
                                        polinomio2.IngresoPoli2(poli2);
                                        JOptionPane.showMessageDialog(null, "¡ Polinomio Ingresado Correctamente !");
                                        opc1 = 0;
                                    }
                                }
                            break;
                        
                            case 2:
                                if(poli2 == "")
                                {
                                    JOptionPane.showMessageDialog(null, "Ingrese primero el polinomio"); 
                                }
                                else
                                {
                                    aux = polinomio2.ReconstruirPoli2();
                                    JOptionPane.showMessageDialog(null, aux); 
                                    aux = "";
                                }
                            break;
                        
                            case 3:
                                if(poli2 == "")
                                {
                                    JOptionPane.showMessageDialog(null, "Ingrese primero el polinomio"); 
                                }
                                else
                                {
                                    num = Integer.parseInt(JOptionPane.showInputDialog("¿Con que numero desea evaluar el polinomio?"));
                                    polinomio2.Evaluar2(num);     
                                }
                            break;
                        
                            case 4:
                                poli2A = JOptionPane.showInputDialog("INGRESE EL POLINOMIO A ORDENADO DE EXPONENTE MAYOR A MENOR" + "\n" + "\nEjemplo: 3x^3+2x^2-x+1   ¡ SIN ESPACIOS  !" + "\n" + "\n| Coeficiente | Parte Literal | ^ | Exponente | Operando |");
                                polinomio2A.IngresoPoli2(poli2A);
                                JOptionPane.showMessageDialog(null, "¡ Polinomio A Ingresado Correctamente !");
                                poli2A = JOptionPane.showInputDialog("INGRESE EL POLINOMIO B ORDENADO DE EXPONENTE MAYOR A MENOR" + "\n" + "\nEjemplo: 3x^3+2x^2-x+1   ¡ SIN ESPACIOS  !" + "\n" + "\n| Coeficiente | Parte Literal | ^ | Exponente | Operando |");
                                polinomio2B.IngresoPoli2(poli2A);
                                JOptionPane.showMessageDialog(null, "¡ Polinomio B Ingresado Correctamente !"); 
                                aux3 = polinomioSuma2.Suma2(polinomio2A, polinomio2B);
                                aux = polinomio2A.ReconstruirPoli2();
                                aux2 = polinomio2B.ReconstruirPoli2(); 
                                JOptionPane.showMessageDialog(null, " " + aux + "    + \n \n " + aux2 + "\n_________________________\n \n " + aux3 );
                                aux = "";
                                aux2 = "";
                                aux3 = "";
                                poli2A = "";
                            break;
                        
                            case 5:
                                poli2A = JOptionPane.showInputDialog("INGRESE EL POLINOMIO A ORDENADO DE EXPONENTE MAYOR A MENOR" + "\n" + "\nEjemplo: 3x^3+2x^2-x+1   ¡ SIN ESPACIOS  !" + "\n" + "\n| Coeficiente | Parte Literal | ^ | Exponente | Operando |");
                                polinomio2A.IngresoPoli2(poli2A);
                                JOptionPane.showMessageDialog(null, "¡ Polinomio A Ingresado Correctamente !");
                                poli2A = JOptionPane.showInputDialog("INGRESE EL POLINOMIO B ORDENADO DE EXPONENTE MAYOR A MENOR" + "\n" + "\nEjemplo: 3x^3+2x^2-x+1   ¡ SIN ESPACIOS  !" + "\n" + "\n| Coeficiente | Parte Literal | ^ | Exponente | Operando |");
                                polinomio2B.IngresoPoli2(poli2A);
                                JOptionPane.showMessageDialog(null, "¡ Polinomio B Ingresado Correctamente !"); 
                                aux3 = polinomioMultiplicacion2.Multiplicacion2(polinomio2A, polinomio2B);
                                aux = polinomio2A.ReconstruirPoli2();
                                aux2 = polinomio2B.ReconstruirPoli2();
                                JOptionPane.showMessageDialog(null, " " + aux + "    x \n \n " + aux2 + "\n_________________________\n \n " + aux3 );
                                aux = "";
                                aux2 = "";
                                aux3 = "";
                                poli2A = "";
                            break;
                        
                            case 6:
                                JOptionPane.showMessageDialog(null, "En desarrollo...");
                            break;
                            
                            case 7:
                                if(poli2 == "")
                                {
                                    JOptionPane.showMessageDialog(null, "Ingrese primero el polinomio"); 
                                }
                                else
                                {
                                    polinomio2.Mostrar2();         
                                }
                            break;
                            
                            case 8:
                                opc = 9;
                            break;
                        
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese un valor valido"); 
                                opc = 0;
                            break; 
                        }         
                    }    
                break;
                
                case 3:
                    opc = 0;
                    while(opc >= 0 && opc <= 8)
                    {
                        opc = Integer.parseInt(JOptionPane.showInputDialog("FORMA 3"+ "\n" +"\n [ 1 ] Ingresar." + "\n [ 2 ] Reconstruir." + "\n [ 3 ] Evaluar." + "\n [ 4 ] Sumar." + "\n [ 5 ] Multiplicar." + "\n [ 6 ] Dividir." + "\n [ 7 ] Mostrar." + "\n" + "\n [ 8 ] Volver." + "\n "));       
                        switch(opc)
                        {
                            case 1:
                                if(poli3 == "")
                                {
                                    poli3 = JOptionPane.showInputDialog(null, "INGRESE EL POLINOMIO ORDENADO DE EXPONENTE MAYOR A MENOR" + "\n" + "\nEjemplo: 3x^3+2x^2-x+1   ¡ SIN ESPACIOS  !" + "\n" + "\n| Coeficiente | Parte Literal | ^ | Exponente | Operando |"); 
                                    Polinomio3.IngresoPoli2(poli3);
                                    x = new Nodo();
                                    x = polinomio3.IngresarPoli3(Polinomio3);
                                    JOptionPane.showMessageDialog(null, "¡ Polinomio Ingresado Correctamente !");
                                }
                                else
                                {
                                    opc1 = Integer.parseInt(JOptionPane.showInputDialog("El polinomio Forma 3 ya fue ingresado, desea volverlo hacer?" + "\n\n[ 1 ] SI." + "\n[ 2 ] NO.\n " ));
                                    if(opc1 == 1) 
                                    {
                                        x = null;
                                        x = new Nodo();
                                        poli3 = JOptionPane.showInputDialog(null, "INGRESE EL POLINOMIO ORDENADO DE EXPONENTE MAYOR A MENOR" + "\n" + "\nEjemplo: 3x^3+2x^2-x+1   ¡ SIN ESPACIOS  !" + "\n" + "\n| Coeficiente | Parte Literal | ^ | Exponente | Operando |"); 
                                        Polinomio3.IngresoPoli2(poli3);
                                        x = polinomio3.IngresarPoli3(Polinomio3);
                                        JOptionPane.showMessageDialog(null, "¡ Polinomio Ingresado Correctamente !");
                                        opc1 = 0;
                                    }
                                }
                            break;
                        
                            case 2:
                                if(poli3 == "")
                                {
                                    JOptionPane.showMessageDialog(null, "Ingrese primero el polinomio"); 
                                }
                                else
                                    
                                {
                                    aux = polinomio3.ReconstruirPoli3(x);
                                    JOptionPane.showMessageDialog(null, aux); 
                                    aux = "";
                                }
                            break;
                        
                            case 3:
                                if(poli3 == "")
                                {
                                    JOptionPane.showMessageDialog(null, "Ingrese primero el polinomio"); 
                                }
                                else
                                {
                                    num = Integer.parseInt(JOptionPane.showInputDialog("¿Con que numero desea evaluar el polinomio?"));
                                    polinomio3.Evaluar3(num);     
                                }
                            break;
                        
                            case 4:
                                poli3A = JOptionPane.showInputDialog("INGRESE EL POLINOMIO A ORDENADO DE EXPONENTE MAYOR A MENOR" + "\n" + "\nEjemplo: 3x^3+2x^2-x+1   ¡ SIN ESPACIOS  !" + "\n" + "\n| Coeficiente | Parte Literal | ^ | Exponente | Operando |");
                                Polinomio3.IngresoPoli2(poli3A);
                                a = new Nodo();
                                a = polinomio3A.IngresarPoli3(Polinomio3);
                                JOptionPane.showMessageDialog(null, "¡ Polinomio A Ingresado Correctamente !");
                                poli3A = JOptionPane.showInputDialog("INGRESE EL POLINOMIO B ORDENADO DE EXPONENTE MAYOR A MENOR" + "\n" + "\nEjemplo: 3x^3+2x^2-x+1   ¡ SIN ESPACIOS  !" + "\n" + "\n| Coeficiente | Parte Literal | ^ | Exponente | Operando |");
                                Polinomio3.IngresoPoli2(poli3A);
                                b = new Nodo();
                                b = polinomio3B.IngresarPoli3(Polinomio3);
                                JOptionPane.showMessageDialog(null, "¡ Polinomio B Ingresado Correctamente !"); 
                                aux3 = polinomioSuma3.Suma3(a ,b);
                                aux =  polinomio3A.ReconstruirPoli3(a);
                                aux2 = polinomio3B.ReconstruirPoli3(b); 
                                JOptionPane.showMessageDialog(null, " " + aux + "    + \n \n " + aux2 + "\n_________________________\n \n " + aux3 );
                                aux = "";
                                aux2 = "";
                                aux3 = "";
                                a = null;
                                b = null;
                                poli3A = "";
                            break;
                        
                            case 5:
                                poli3A = JOptionPane.showInputDialog("INGRESE EL POLINOMIO A ORDENADO DE EXPONENTE MAYOR A MENOR" + "\n" + "\nEjemplo: 3x^3+2x^2-x+1   ¡ SIN ESPACIOS  !" + "\n" + "\n| Coeficiente | Parte Literal | ^ | Exponente | Operando |");
                                Polinomio3.IngresoPoli2(poli3A);
                                a = new Nodo();
                                a = polinomio3A.IngresarPoli3(Polinomio3);
                                aux =  polinomio3A.ReconstruirPoli3(a);
                                JOptionPane.showMessageDialog(null, "¡ Polinomio A Ingresado Correctamente !");
                                poli3A = JOptionPane.showInputDialog("INGRESE EL POLINOMIO B ORDENADO DE EXPONENTE MAYOR A MENOR" + "\n" + "\nEjemplo: 3x^3+2x^2-x+1   ¡ SIN ESPACIOS  !" + "\n" + "\n| Coeficiente | Parte Literal | ^ | Exponente | Operando |");
                                Polinomio3.IngresoPoli2(poli3A);
                                b = new Nodo();
                                b = polinomio3B.IngresarPoli3(Polinomio3);
                                aux2 = polinomio3B.ReconstruirPoli3(b); 
                                JOptionPane.showMessageDialog(null, "¡ Polinomio B Ingresado Correctamente !"); 
                                aux3 = polinomioMultiplicacion3.Multiplicacion3(a ,b);      
                                JOptionPane.showMessageDialog(null, " " + aux + "    x \n \n " + aux2 + "\n_________________________\n \n " + aux3 );
                                aux = "";
                                aux2 = "";
                                aux3 = "";
                                a = null;
                                b = null;
                                poli3A = "";
                            break;
                        
                            case 6:
                                JOptionPane.showMessageDialog(null, "En desarrollo...");
                            break;
                            
                            case 7:
                                if(poli3 == "")
                                {
                                    JOptionPane.showMessageDialog(null, "Ingrese primero el polinomio"); 
                                }
                                else
                                {
                                    polinomio3.Mostrar3();      
                                }
                            break;
                        
                            case 8:
                                opc = 9;
                            break;      
                        
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese un valor valido"); 
                                opc = 0;
                            break; 
                        }
                    }
                break;
                
                case 4:
                    opc = 0;
                    while(opc >= 0 && opc <= 3)
                    {
                        opc = Integer.parseInt(JOptionPane.showInputDialog("OPERACIONES"+ "\n" +"\n [ 1 ] F1 + F3 = F2" + "\n [ 2 ] F1 x F2 = F3" + "\n" + "\n [ 3 ] Volver." + "\n "));
                        switch(opc)
                        {
                            case 1:
                                
                            break;
                            
                            case 2:
                                
                            break;
                            
                            case 3:
                                opc = 4;
                            break;
                            
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese un valor valido"); 
                                opc = 0;
                            break;
                        }
                    }
                break;
                
                case 5:
                   menu = 5;
                break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese un valor valido");
                    menu = 0;
                break;
                    
            }
        }
        
    } 
}


