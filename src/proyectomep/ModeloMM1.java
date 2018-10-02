/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomep;

/**
 *
 * @author jeannine
 */
public class ModeloMM1 {

    private double lamda;
    private double mu;
    private double rho;
    private double L;
    private double Lq;
    private double W;
    private double Wq;
    private double ef;
    private double[] Pn;

    public ModeloMM1(double tasaLlegadas, double tasaServicio) {
        this.lamda = tasaLlegadas;
        this.mu = tasaServicio;
        this.Pn = new double[8];
    }


    public void calculate() {
        rho = lamda / mu;
        L = rho / (1.0 - rho);
        Lq = rho * rho / (1 - rho);
        W = 1.0 / (mu - lamda);
        Wq = rho / (mu - lamda);
        ef = mu / (mu - lamda);
        for (int i = 0; i < Pn.length; i++) {
            Pn[i] = Pn(rho, i);
        }
    }

    public double Pn(double rho, int n) {
        if (n == 0) {
            return 1.0 - rho;
        } else if (n == 1) {
            return rho * (1.0 - rho);
        } else {
            return Math.pow(rho, n) * (1.0 - rho);
        }
    }

    public double wt(double lamda, double mu, double tiempo) {
        return 1 - Math.pow(Math.E, (-(mu - lamda)) * tiempo);
    }

    public double wqdet(double lamda, double mu, double tiempo) {
        return 1 - (lamda / mu) * Math.pow(Math.E, (-(mu - lamda)) * tiempo);
    }

    public double getLamda() {
        return lamda;
    }

    public void setLamda(double lamda) {
        this.lamda = lamda;
    }

    public double getMu() {
        return mu;
    }

    public void setMu(double mu) {
        this.mu = mu;
    }

    public double getRho() {
        return rho;
    }

    public void setRho(double rho) {
        this.rho = rho;
    }

    public double getL() {
        return L;
    }

    public void setL(double l) {
        L = l;
    }

    public double getLq() {
        return Lq;
    }

    public void setLq(double lq) {
        Lq = lq;
    }

    public double getW() {
        return W;
    }

    public void setW(double w) {
        W = w;
    }

    public double getWq() {
        return Wq;
    }

    public void setWq(double wq) {
        Wq = wq;
    }

    public double getPn(int i) {
        return Pn[i];
    }

    public double getEf() {
        return ef;
    }
}
