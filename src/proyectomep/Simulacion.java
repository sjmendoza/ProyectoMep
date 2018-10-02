/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomep;

import static java.lang.Math.min;

/**
 *
 * @author jeannine
 */
/*public class Simulacion {

    private double l;
    private double entrada;
    private double salida;
    private double aux;
    private double devolverE;
    private double devolverS;

    public Simulacion(double l, double entrada, double aux, double devolver) {
        this.l = l;
        this.entrada = entrada;
        this.aux = aux;
        this.devolverE = devolver;
    }

    public double devolverE(double entrada) {
        l = -1 / entrada;

        aux = Math.random();

        return devolverE = l * Math.log(aux);
    }

    public double devolverS(double salida) {
        l = -1 / salida;

        aux = Math.random();

        return devolverS = l * Math.log(aux);

    }

    public void calcular(int estab_n, int cliente_simu) {
        double a = 0;
        double b = -1;
        int n = 0;			//Numero de clientes que hay en el sistema
        int ntot = 0;		    //Contabiliza el numero de clientes que han entrado hasta ese instante en el sistema
        double minimo;

        while (ntot < estab_n) {

            if (n > 0) {
                minimo = Math.min(a, b);
            } else //Si n es 0, entoces b es -1, pero no puede ser el minimo
            {
                minimo = a;
            }

            if (minimo == a) //Hay una llegada
            {
                ntot = ntot + 1;	//Aumenta el numero de clientes que han entrado en el sistema
                if (n == 0) //No hay clientes en el sistema
                {
                    n = n + 1; 						//Aumenta n porque hay una llegada

                    a = devolverE(entrada);	//Tiempo que tarda en haber una nueva llegada
                    b = devolverS(salida); //Tiempo que tarda en haber una nueva salida
                } else {
                    n = n + 1; 						//Aumenta n porque hay una llegada
                    a = devolverE(entrada);	//Tiempo que tarda en haber una nueva llegada
                    b = b - minimo; //Tiempo que tarda en haber una nueva salida
                }
            } else {
                n = n - 1;		//Disminuye el numero de clientes del sistema

                if (n == 0) //No quedan clientes en el sistema
                {
                    b = -1;
                } else {
                    b = devolverS(salida);	//Tiempo que tarda en haber una nueva salida
                }
                a = a - minimo;					//Tiempo que tarda en haber una nueva entrada
            }

        }

        ntot = 0;
        double t = 0;			//Cronometro
        double c = 0;			//Acumula tiempo * nº clientes (sistema)
        double d = 0;			//Acumula tiempo * nº clientes (cola)

   // p  = zeros(1, n + 1);
        while (ntot < cliente_simu) {

            if (n > 0) {
                minimo = min(a, b);
            } else {
                //Si n es 0, entoces b es -1, pero no puede ser el minimo
                minimo = a;
            }

            if (minimo == a) //Hay una llegada
            {
                ntot = ntot + 1;	//Aumenta el numero de clientes que han entrado en el sistema
                if (n == 0) //No hay clientes en el sistema
                {
                    t = t + minimo;
                    p(1) = p(1) + minimo;
                    n = n + 1; //Aumenta n porque hay una llegada
                    a = devolverE(entrada);	//Tiempo que tarda en haber una nueva llegada
                    b = devolverS(salida);		//Tiempo que tarda en haber una nueva salida
                }
                else {
                    t = t + minimo;
                    if (n + 1) > length(p)
   	            
                            {
                    p = cat(2, p, zeros(1));
                    p(n + 1) = p(n + 1) + minimo;}
                    else
                            {
            	  p(n+1)=p(n+1)+minimo;
                                    }
                    c = c + minimo * n;
                    d = d + minimo * (n - 1);
                    n = n + 1; 						//Aumenta n porque hay una llegada
                    a = devolverE(entrada);	//Tiempo que tarda en haber una nueva llegada
                    b = b - minimo;					//Tiempo que tarda en haber una nueva salida
                }
                else{
   	      t=t+minimo;
                c = c + minimo * n;
                d = d + minimo * (n - 1);
                if (n + 1)  > length(p)

                {
                    p = cat(2, p, zeros(1));
                    p(n + 1) = p(n + 1) + minimo;
                }
                else
                 {
   	         p(n+1)=p(n+1)+minimo;
		  end
	      n=n-1;		//Disminuye el numero de clientes del sistema
           }
                if  {
                    (n == 0) //No quedan clientes en el sistema
                    b = -1;
                } else {
                    b = devolverS(salida);	//Tiempo que tarda en haber una nueva salida
                }

                a = a - minimo;					//Tiempo que tarda en haber una nueva entrada

            }
        }

    }*/
