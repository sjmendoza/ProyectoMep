/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomep;

import java.awt.Color;
import java.awt.GradientPaint;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author jeannine
 */
    
    public class GraficoEs extends JFrame {

    JPanel panel;

    double lambda;
    double miu;
    int t1;
    int t2;

    public GraficoEs() {
        setTitle("Grafico Tiempos de Espera");
        setLocationRelativeTo(null);
        setSize(700, 465);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        // init();
    }

    public void obtenerDatos(double lambda, double miu, int t1, int t2) {
        this.lambda = lambda;
        this.miu = miu;
        this.t1 = t1;
        this.t2 = t2;
    }

    void init() {
        panel = new JPanel();
        getContentPane().add(panel);
        ModeloMM1 cal = new ModeloMM1(lambda, miu);
        cal.calculate();
        System.out.println("lam: " + lambda + " miu: " + miu + " t1: " + t1 + " t2: " + t2);
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        for (int i = t1; i <= t2; i++) {
            System.out.println("W(t)" + cal.wt(lambda, miu, (double) i));
            System.out.println("Wq(t)" + cal.wqdet(lambda, miu, (double) i));
            line_chart_dataset.addValue(cal.wt(lambda, miu, (double) i), "Promedio Espera En Sistema", "" + i);
            line_chart_dataset.addValue(cal.wqdet(lambda, miu, (double) i), "Promedio Espera en Cola", "" + i);
        }

        JFreeChart chart = ChartFactory.createLineChart("Espera en Cola", "Clientes", "Tiempo de Espera",
        line_chart_dataset, PlotOrientation.VERTICAL, true, true, false);
       
        chart.setBackgroundPaint(new GradientPaint(0, 0, Color.white, 0, 1000, Color.blue));   
        chart.getTitle().setPaint(Color.black);
        CategoryPlot p = chart.getCategoryPlot();
        p.setBackgroundPaint(Color.WHITE);
        
        

        p.setRangeGridlinePaint(Color.black);
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }

}


