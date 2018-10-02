/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomep;

import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author jeannine
 */
public class ProyectoMep extends Application {

    //Botones
    Button btn1 = new Button("Calcular parametros");
    Button btn2 = new Button("Simulador de colas");
    Button btn3 = new Button("HELP");
    Button btnRegresar = new Button("Regresar");
    Button btnCalEntrada = new Button("Calcular");
    Button btnCalPara = new Button("Calcular");
    Button btnCalEspe = new Button("Calcular");
    Button btnCalWt = new Button("Calcular");
    Button btnCalWq = new Button("Calcular");
    Button graEsp = new Button("Graficar");
    Button graTesp = new Button("Graficar");
    Button btnBorrarPa = new Button("Borrar");
    Button btnBorrarEs = new Button("Borrar");
    Button btnBorrarWt = new Button("Borrar");
    Button btnBorrarWq = new Button("Borrar");
    Button btnBorrarGraEs = new Button("Borrar");
    Button btnBorrarGraTes = new Button("Borrar");
    Text tLambda = new Text("Lamba:");
    Text tMiu = new Text("Miu:");
    Text tRho = new Text("Rho=");
    Text tEficiencia = new Text("Eficiencia=");
    Text tL = new Text("L=");
    Text tW = new Text("W=");
    Text tLq = new Text("Lq=");
    Text tWq = new Text("Wq=");
    Text tPro = new Text("Probabilidad:");
    Text tClientes = new Text("Clientes en espera:");
    Text tTiempoW = new Text("En T:");
    Text tWt = new Text("W(t)=");
    Text tTiempoWq = new Text("En t:");
    Text tWqt = new Text("Wq(t)");
    Text tc1 = new Text("Entre:");
    Text tc2 = new Text("y:");
    Text te1 = new Text("Entre:");
    Text te2 = new Text("y:");
    RestrictiveTextField estab = new RestrictiveTextField();
    RestrictiveTextField nCliente = new RestrictiveTextField();
    RestrictiveTextField lambda1 = new RestrictiveTextField();
    RestrictiveTextField miu1 = new RestrictiveTextField();
    RestrictiveTextField rho = new RestrictiveTextField();
    RestrictiveTextField eficiencia = new RestrictiveTextField();
    RestrictiveTextField l = new RestrictiveTextField();
    RestrictiveTextField w = new RestrictiveTextField();
    RestrictiveTextField lq = new RestrictiveTextField();
    RestrictiveTextField wq = new RestrictiveTextField();
    RestrictiveTextField pro = new RestrictiveTextField();
    RestrictiveTextField clientes = new RestrictiveTextField();
    RestrictiveTextField tiempoW = new RestrictiveTextField();//recibe t
    RestrictiveTextField wt = new RestrictiveTextField();//muestra w(t)
    RestrictiveTextField tiempoWq = new RestrictiveTextField();
    RestrictiveTextField wqt = new RestrictiveTextField();
    RestrictiveTextField c1 = new RestrictiveTextField();
    RestrictiveTextField c2 = new RestrictiveTextField();
    RestrictiveTextField e1 = new RestrictiveTextField();
    RestrictiveTextField e2 = new RestrictiveTextField();

    public double lamda;
    public double mu;
    DecimalFormat dec = new DecimalFormat("0.00");
    DecimalFormat dec2 = new DecimalFormat("0.0000");
    DecimalFormat dec1 = new DecimalFormat("0.00");

    public void deshabilitarTodo() {
        rho.setDisable(true);
        eficiencia.setDisable(true);
        l.setDisable(true);
        w.setDisable(true);
        lq.setDisable(true);
        wq.setDisable(true);

    }

    public void habilitarTodo() {
        pro.setDisable(false);
        tiempoW.setDisable(false);
        tiempoWq.setDisable(false);
    }

    public void iniciarCalculos() {
        rho.setDisable(true);
        eficiencia.setDisable(true);
        l.setDisable(true);
        w.setDisable(true);
        lq.setDisable(true);
        wq.setDisable(true);
        pro.setDisable(true);
        clientes.setDisable(true);
        tiempoW.setDisable(true);
        wt.setDisable(true);
        tiempoWq.setDisable(true);
        wqt.setDisable(true);

    }

    public void iniciarTextFields() {

        rho.setText("");
        eficiencia.setText("");
        l.setText("");
        w.setText("");
        lq.setText("");
        wq.setText("");
        pro.setText("");
        clientes.setText("");
        tiempoW.setText("");
        wt.setText("");
        tiempoWq.setText("");
        wqt.setText("");
        c1.setText("");
        c2.setText("");
        e1.setText("");
        e2.setText("");

    }
    


    @Override
    public void start(final Stage primaryStage) {

        btn1.setEffect(new Reflection());//Efecto de boton
        btn1.setStyle("-fx-background-color: #593A8D; -fx-text-fill: white;-fx-font-size: 12pt;-fx-font-family:Segoe UI Light;");//Color de fondo y letra de boton
        btn2.setEffect(new Reflection());
        btn2.setStyle("-fx-background-color: #593A8D; -fx-text-fill: white;-fx-font-size: 12pt;-fx-font-family:Segoe UI Light;");
        btn3.setEffect(new Reflection());
        btn3.setStyle("-fx-background-color: #593A8D; -fx-text-fill: white;-fx-font-size: 12pt;-fx-font-family:Segoe UI Light;");
        btnRegresar.setEffect(new Reflection());
        btnRegresar.setStyle("-fx-background-color: #170B2E; -fx-text-fill: white;-fx-font-size: 12pt;-fx-font-family:Segoe UI Light;");

        
        btnCalEntrada.setEffect(new Reflection());
        btnCalEntrada.setStyle("-fx-background-color:#170B2E; -fx-text-fill: white;-fx-font-size: 12pt;-fx-font-family:Segoe UI Light;");
        btnCalPara.setEffect(new Reflection());
        btnCalPara.setStyle("-fx-background-color:#170B2E; -fx-text-fill: white;-fx-font-size: 12pt;-fx-font-family:Segoe UI Light;");
        btnCalEspe.setEffect(new Reflection());
        btnCalEspe.setStyle("-fx-background-color:#170B2E; -fx-text-fill: white;-fx-font-size: 12pt;-fx-font-family:Segoe UI Light;");
        btnCalWt.setEffect(new Reflection());
        btnCalWt.setStyle("-fx-background-color:#170B2E; -fx-text-fill: white;-fx-font-size: 12pt;-fx-font-family:Segoe UI Light;");
        btnCalWq.setEffect(new Reflection());
        btnCalWq.setStyle("-fx-background-color:#170B2E; -fx-text-fill: white;-fx-font-size: 12pt;-fx-font-family:Segoe UI Light;");
        graEsp.setEffect(new Reflection());
        graEsp.setStyle("-fx-background-color: #170B2E; -fx-text-fill: white;-fx-font-size: 12pt;-fx-font-family:Segoe UI Light;");
        graTesp.setEffect(new Reflection());
        graTesp.setStyle("-fx-background-color: #170B2E; -fx-text-fill: white;-fx-font-size: 12pt;-fx-font-family:Segoe UI Light;");
        btnBorrarPa.setEffect(new Reflection());
        btnBorrarPa.setStyle("-fx-background-color: #170B2E; -fx-text-fill: white;-fx-font-size: 12pt;-fx-font-family:Segoe UI Light;");
        btnBorrarEs.setEffect(new Reflection());
        btnBorrarEs.setStyle("-fx-background-color:#170B2E; -fx-text-fill: white;-fx-font-size: 12pt;-fx-font-family:Segoe UI Light;");
        btnBorrarWt.setEffect(new Reflection());
        btnBorrarWt.setStyle("-fx-background-color:#170B2E; -fx-text-fill: white;-fx-font-size: 12pt;-fx-font-family:Segoe UI Light;");
        btnBorrarWq.setEffect(new Reflection());
        btnBorrarWq.setStyle("-fx-background-color:#170B2E; -fx-text-fill: white;-fx-font-size: 12pt;-fx-font-family:Segoe UI Light;");

        VBox botones = new VBox(40);//Panel vertical que contiene los Botones
        botones.setAlignment(Pos.CENTER);//Centrar botones
        botones.setPadding(new Insets(10, 10, 10, 10));//Agregar margen al panel de botones
        botones.getChildren().addAll(btn1, btn2, btn3);//agregar los botones al panel

        Image imagen = new Image(getClass().getResourceAsStream("/multimedia/diseno.jpg"));//logo
        Label etiImagen = new Label();//label
        etiImagen.setGraphic(new ImageView(imagen));//labe con imagen(logo)
        etiImagen.setEffect(new Lighting());

        final VBox fondo = new VBox();//Panel vertical que contiene el logo
        fondo.setAlignment(Pos.CENTER);//centrar label
        fondo.getChildren().addAll(etiImagen);//agregar label con imagen(logo)

        final HBox panelMain = new HBox();//Panel principal horizontal que contiene los dos paneles verticales
        panelMain.setPadding(new Insets(15, 15, 15, 15));//margen al panel principal
        panelMain.getChildren().addAll(botones, fondo);//agregar paneles al panel principal

//Boton calcular parametros del menu
        btn1.setOnAction(new EventHandler<ActionEvent>() {//accion de boton de calcular parametros

            @Override
            public void handle(ActionEvent t) {

                iniciarCalculos();

                Text title1 = new Text("Parametros");
                Text title2 = new Text("Resultados");
                Text title3 = new Text("Probabilidad de clientes en espera");
                Text title4 = new Text("Resultados W(t)");
                Text title5 = new Text("Resultados W(q)");
                Text title6 = new Text("Grafica de probabilidad de clientes en espera");
                Text title7 = new Text("Grafica de tiempos de espera");
                //Color blanco de los Label
                title1.setFill(Color.WHITE);
                title2.setFill(Color.WHITE);
                title3.setFill(Color.WHITE);
                title4.setFill(Color.WHITE);
                title5.setFill(Color.WHITE);
                title6.setFill(Color.WHITE);
                title7.setFill(Color.WHITE);
                tLambda.setFill(Color.WHITE);
                tMiu.setFill(Color.WHITE);
                tRho.setFill(Color.WHITE);
                tEficiencia.setFill(Color.WHITE);
                tL.setFill(Color.WHITE);
                tW.setFill(Color.WHITE);
                tLq.setFill(Color.WHITE);
                tWq.setFill(Color.WHITE);
                tPro.setFill(Color.WHITE);
                tClientes.setFill(Color.WHITE);
                tTiempoW.setFill(Color.WHITE);
                tWt.setFill(Color.WHITE);
                tTiempoWq.setFill(Color.WHITE);
                tWqt.setFill(Color.WHITE);
                tc1.setFill(Color.WHITE);
                tc2.setFill(Color.WHITE);
                te1.setFill(Color.WHITE);
                te2.setFill(Color.WHITE);

                //Validacion de textField , no permite digitar letras, solo numeros con los digitos del 0-9
                lambda1.setRestrict("[0.0-99.0]");
                miu1.setRestrict("[0.0-99.0]");
                pro.setRestrict("[0.0-99.0]");
                tiempoW.setRestrict("[0.0-99.0]");
                tiempoWq.setRestrict("[0.0-99.0]");
                c1.setRestrict("[0.0-99.0]");
                c2.setRestrict("[0.0-99.0]");
                e1.setRestrict("[0.0-99.0]");
                e2.setRestrict("[0.0-99.0]");

                GridPane arriba1 = new GridPane();//panel de separacion
                arriba1.setPadding(new Insets(5));//margen del panel
                arriba1.add(title1, 3, 2);//titulo
                arriba1.add(tLambda, 3, 4);
                arriba1.add(lambda1, 4, 4);
                arriba1.add(tMiu, 3, 5);
                arriba1.add(miu1, 4, 5);
                arriba1.add(btnCalPara, 3, 7);
                arriba1.add(btnBorrarPa, 4, 7);

                arriba1.add(title2, 9, 2);//Resultados
                arriba1.add(tRho, 9, 4);
                arriba1.add(tEficiencia, 9, 5);
                arriba1.add(rho, 10, 4);
                arriba1.add(eficiencia, 10, 5);
                arriba1.add(tL, 14, 4);
                arriba1.add(l, 15, 4);
                arriba1.add(tW, 14, 5);
                arriba1.add(w, 15, 5);
                arriba1.add(tLq, 19, 4);
                arriba1.add(lq, 20, 4);
                arriba1.add(tWq, 19, 5);
                arriba1.add(wq, 20, 5);
                arriba1.setAlignment(Pos.CENTER);//central el panel de parametros
                arriba1.setHgap(5);//separacion entre 5 pixeles entre componentes
                arriba1.setVgap(5);//

                HBox panelArriba = new HBox(20); //lambda y miu1
                panelArriba.setPadding(new Insets(20));//margen del panel
                panelArriba.getChildren().add(arriba1);

                GridPane medio = new GridPane();//gridPane de medio
                medio.add(title3, 3, 2);//probabilidad de clientes en espera
                medio.add(tClientes, 3, 4);
                medio.add(tPro, 3, 5);
                medio.add(pro, 4, 4);
                medio.add(clientes, 4, 5);
                medio.add(btnCalEspe, 3, 7);
                medio.add(btnBorrarEs, 4, 7);

                medio.add(title4, 9, 2);//Resultados W(t)
                medio.add(tTiempoW, 9, 4);
                medio.add(tiempoW, 10, 4);
                medio.add(tWt, 9, 5);
                medio.add(wt, 10, 5);
                medio.add(btnCalWt, 9, 7);
                medio.add(btnBorrarWt, 10, 7);

                medio.add(title5, 14, 2);//Resultados Wq(t)
                medio.add(tTiempoWq, 14, 4);
                medio.add(tiempoWq, 15, 4);
                medio.add(tWqt, 14, 5);
                medio.add(wqt, 15, 5);
                medio.add(btnCalWq, 14, 7);
                medio.add(btnBorrarWq, 15, 7);

                medio.setAlignment(Pos.CENTER);//central el panel de parametros
                medio.setHgap(5);//separacion entre 5 pixeles entre componentes
                medio.setVgap(5);//

                HBox panelMedio = new HBox(20); //panel medio
                panelMedio.setPadding(new Insets(20));
                panelMedio.getChildren().add(medio);

                GridPane bajo = new GridPane();
                bajo.add(title6, 3, 2);
                bajo.add(tc1, 3, 4);
                bajo.add(c1, 4, 4);
                bajo.add(tc2, 6, 4);
                bajo.add(c2, 7, 4);
                bajo.add(graEsp, 5, 6);
                bajo.add(title7, 3, 9);
                bajo.add(te1, 3, 10);
                bajo.add(e1, 4, 10);
                bajo.add(te2, 6, 10);
                bajo.add(e2, 7, 10);
                bajo.add(graTesp, 5, 12);

                bajo.setAlignment(Pos.CENTER);//central el panel 
                bajo.setHgap(5);//separacion entre 5 pixeles entre componentes
                bajo.setVgap(5);//

                HBox panelBajo = new HBox(10);//servicio
                panelBajo.setPadding(new Insets(20));
                panelBajo.getChildren().add(bajo);

                VBox panelB = new VBox();//botones
                panelB.getChildren().add(btnRegresar);

                VBox panelP = new VBox(20);// a mostrar Parametros
                panelP.setPadding(new Insets(60));

                panelP.getChildren().addAll(panelB, panelArriba, panelMedio, panelBajo);//principal

                String image3 = "multimedia/fondo4.jpg";

                StackPane panel2 = new StackPane();//Crear el contenedor para agregar los layouts(HBox)
                panel2.setStyle("-fx-background-image: url('" + image3 + "'); "
                        + "-fx-background-position: center center; "
                        + "-fx-background-repeat: stretch;");

                panel2.getChildren().add(panelP);//agregar el layout al contenedor
                Scene escena1 = new Scene(panel2);//Crear escenario

                primaryStage.setScene(escena1);//A la ventana setearle el escenario
                primaryStage.setTitle("Calcular parametros");//Titulo de la ventana
                primaryStage.setResizable(true);//No permite redimencionar ventana
                primaryStage.show();

            }

        }
        );

        btn2.setOnAction(new EventHandler<ActionEvent>() {//accion de boton de simulador

            @Override
            public void handle(ActionEvent t) {
                iniciarCalculos();

                Text title0 = new Text("Parametros de entrada");
                Text title1 = new Text("Parametros de la distribucion:");
                Text title2 = new Text("Resultados");
                Text title3 = new Text("Probabilidad de clientes en espera");
                Text title6 = new Text("Grafica de probabilidad de clientes en espera");
                Text tEstab = new Text("Parametro de estabilización:");
                Text tNCliente = new Text("Número de clientes de simulación:");
                //Color blanco de los Label
                title0.setFill(Color.WHITE);
                title1.setFill(Color.WHITE);
                title2.setFill(Color.WHITE);
                title3.setFill(Color.WHITE);
                title6.setFill(Color.WHITE);
                tEstab.setFill(Color.WHITE);
                tNCliente.setFill(Color.WHITE);
                tLambda.setFill(Color.WHITE);
                tMiu.setFill(Color.WHITE);
                tRho.setFill(Color.BLUE);
                tEficiencia.setFill(Color.BLUE);
                tL.setFill(Color.BLUE);
                tW.setFill(Color.BLUE);
                tLq.setFill(Color.BLUE);
                tWq.setFill(Color.BLUE);
                tPro.setFill(Color.WHITE);
                tClientes.setFill(Color.WHITE);
                tc1.setFill(Color.WHITE);
                tc2.setFill(Color.WHITE);

                //Validacion de textField , no permite digitar letras, solo numeros con los digitos del 0-9
                estab.setRestrict("[0-9]");
                nCliente.setRestrict("[0-9]");
                lambda1.setRestrict("[0-9]");
                miu1.setRestrict("[0-9]");
                pro.setRestrict("[0-9]");
                c1.setRestrict("[0-9]");
                c2.setRestrict("[0-9]");

                GridPane arriba0 = new GridPane();//panel de separacion parametro de entrada
                arriba0.setPadding(new Insets(5));//margen del panel
                arriba0.add(title0, 3, 2);
                arriba0.add(tEstab, 3, 4);
                arriba0.add(estab, 4, 4);
                arriba0.add(tNCliente, 3, 5);
                arriba0.add(nCliente, 4, 5);
                arriba0.add(btnCalEntrada, 3, 7);

                arriba0.setAlignment(Pos.CENTER);//central el panel de parametros de la distribucion
                arriba0.setHgap(5);//separacion entre 5 pixeles entre componentes
                arriba0.setVgap(5);

                HBox panelEntrada = new HBox(20); //lambda y miu1
                panelEntrada.setPadding(new Insets(20));//margen del panel
                panelEntrada.getChildren().add(arriba0);

                GridPane arriba1 = new GridPane();//panel de separacion
                arriba1.setPadding(new Insets(5));//margen del panel
                arriba1.add(title1, 3, 2);//titulo
                arriba1.add(tLambda, 3, 4);
                arriba1.add(lambda1, 4, 4);
                arriba1.add(tMiu, 3, 5);
                arriba1.add(miu1, 4, 5);
                arriba1.add(btnCalPara, 3, 7);
                arriba1.add(btnBorrarPa, 4, 7);

                arriba1.add(title2, 9, 2);//Resultados
                arriba1.add(tRho, 9, 4);
                arriba1.add(tEficiencia, 9, 5);
                arriba1.add(rho, 10, 4);
                arriba1.add(eficiencia, 10, 5);
                arriba1.add(tL, 14, 4);
                arriba1.add(l, 15, 4);
                arriba1.add(tW, 14, 5);
                arriba1.add(w, 15, 5);
                arriba1.add(tLq, 19, 4);
                arriba1.add(lq, 20, 4);
                arriba1.add(tWq, 19, 5);
                arriba1.add(wq, 20, 5);
                arriba1.setAlignment(Pos.CENTER);//central el panel de parametros
                arriba1.setHgap(5);//separacion entre 5 pixeles entre componentes
                arriba1.setVgap(5);//

                HBox panelArriba = new HBox(20); //lambda y miu1
                panelArriba.setPadding(new Insets(20));//margen del panel
                panelArriba.getChildren().add(arriba1);

                GridPane medio = new GridPane();//gridPane de medio
                medio.add(title3, 3, 2);//probabilidad de clientes en espera
                medio.add(tClientes, 3, 4);
                medio.add(tPro, 3, 5);
                medio.add(pro, 4, 4);
                medio.add(clientes, 4, 5);
                medio.add(btnCalEspe, 3, 7);
                medio.add(btnBorrarEs, 4, 7);

                medio.setAlignment(Pos.CENTER);//central el panel de parametros
                medio.setHgap(5);//separacion entre 5 pixeles entre componentes
                medio.setVgap(5);//

                HBox panelMedio = new HBox(20); //panel medio
                panelMedio.setPadding(new Insets(20));
                panelMedio.getChildren().add(medio);

                GridPane bajo = new GridPane();
                bajo.add(title6, 3, 2);
                bajo.add(tc1, 3, 4);
                bajo.add(c1, 4, 4);
                bajo.add(tc2, 6, 4);
                bajo.add(c2, 7, 4);
                bajo.add(graEsp, 5, 6);

                bajo.setAlignment(Pos.CENTER);//central el panel 
                bajo.setHgap(5);//separacion entre 5 pixeles entre componentes
                bajo.setVgap(5);//

                HBox panelBajo = new HBox(10);//servicio
                panelBajo.setPadding(new Insets(20));
                panelBajo.getChildren().add(bajo);

                VBox panelB = new VBox();//botones
                panelB.getChildren().add(btnRegresar);

                VBox panelP = new VBox(20);// a mostrar Parametros
                panelP.setPadding(new Insets(60));

                panelP.getChildren().addAll(panelB, panelEntrada, panelArriba, panelMedio, panelBajo);//principal

                String image3 = "multimedia/fondo4.jpg";

                StackPane panel2 = new StackPane();//Crear el contenedor para agregar los layouts(HBox)
                panel2.setStyle("-fx-background-image: url('" + image3 + "'); "
                        + "-fx-background-position: center center; "
                        + "-fx-background-repeat: stretch;");

                panel2.getChildren().add(panelP);//agregar el layout al contenedor
                Scene escena1 = new Scene(panel2);//Crear escenario

                primaryStage.setScene(escena1);//A la ventana setearle el escenario
                primaryStage.setTitle("Simulador de colas: distribucion de llegadas y servicio exponencial");//Titulo de la ventana
                primaryStage.setResizable(true);//No permite redimencionar ventana
                primaryStage.show();
            }

        }
        );
        
       
        
        
       btn3.setOnAction(new EventHandler<ActionEvent>() {//accion de boton de regreso

            @Override
            public void handle(ActionEvent t) {
  
                try {
    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "src\\multimedia\\Manual de usuario.pdf");
} catch (IOException e) {
                e.printStackTrace();
}

}
                
            }

        
        );
        
        
        


        //Boton de regresar del menu de las pantallas
        btnRegresar.setOnAction(new EventHandler<ActionEvent>() {//accion de boton de regreso

            @Override
            public void handle(ActionEvent t) {
                String image3 = "multimedia/fondo4.jpg";

                StackPane panel1 = new StackPane();//Crear el contenedor para agregar los layouts(HBox)
                panel1.setStyle("-fx-background-image: url('" + image3 + "'); "
                        + "-fx-background-position: center center; "
                        + "-fx-background-repeat: stretch;");
                panel1.getChildren().add(panelMain);//agregar el layout al contenedor
                Scene escena = new Scene(panel1);//Crear escenario

                primaryStage.setScene(escena);//A la ventana setearle el escenario
                primaryStage.setTitle("Sistema de colas de MEP-115:M/M/1");//Titulo de la ventana
                primaryStage.setResizable(true);//No permite redimencionar ventana
                primaryStage.show();//muestra la ventana
            }

        }
        );

        btnCalEntrada.setOnAction(new EventHandler<ActionEvent>() {//calcular parametros de entrada
            @Override
            public void handle(ActionEvent t) {

                double lamda = Double.parseDouble(lambda1.getText());
                double mu = Double.parseDouble(miu1.getText());
                ModeloMM1 cal = new ModeloMM1(lamda, mu);
                cal.calculate();
                rho.setText("" + dec2.format(cal.getRho()));
                eficiencia.setText("" + dec2.format(cal.getEf()));
                l.setText("" + dec2.format(cal.getL()));
                w.setText("" + dec2.format(cal.getW()));
                lq.setText("" + dec2.format(cal.getLq()));
                wq.setText("" + dec2.format(cal.getWq()));
                habilitarTodo();
                pro.setEditable(true);
            }
        }
        );

        btnCalPara.setOnAction(new EventHandler<ActionEvent>() {//calcular parametros en base lambda y miu
            @Override
            public void handle(ActionEvent t) {

                double lamda = Double.parseDouble(lambda1.getText());
                double mu = Double.parseDouble(miu1.getText());
                ModeloMM1 cal = new ModeloMM1(lamda, mu);
                cal.calculate();
                rho.setText("" + dec2.format(cal.getRho()));
                eficiencia.setText("" + dec2.format(cal.getEf()));
                l.setText("" + dec2.format(cal.getL()));
                w.setText("" + dec2.format(cal.getW()));
                lq.setText("" + dec2.format(cal.getLq()));
                wq.setText("" + dec2.format(cal.getWq()));
                habilitarTodo();
                pro.setEditable(true);
            }
        }
        );

        btnBorrarPa.setOnAction(new EventHandler<ActionEvent>() {//borrar parametros en base a lambda y miu
            @Override
            public void handle(ActionEvent t) {
                iniciarTextFields();
                iniciarCalculos();
                lambda1.setText("");
                miu1.setText("");
                lambda1.setEditable(true);
                miu1.setEditable(true);
            }
        }
        );

        btnCalEspe.setOnAction(new EventHandler<ActionEvent>() {//calcular clientes esperando
            @Override
            public void handle(ActionEvent t) {
                double lamda = Double.parseDouble(lambda1.getText());
                double mu = Double.parseDouble(miu1.getText());
                int x = Integer.parseInt(pro.getText());
                ModeloMM1 cal = new ModeloMM1(lamda, mu);
                cal.calculate();
                clientes.setText("" + dec2.format(cal.getPn(x)));
                pro.setEditable(false);
            }
        }
        );

        btnBorrarEs.setOnAction(new EventHandler<ActionEvent>() {//borrar clientes esperando
            @Override
            public void handle(ActionEvent t) {

                pro.setText("");
                pro.setEditable(true);
                clientes.setText("");
            }
        }
        );

        btnCalWt.setOnAction(new EventHandler<ActionEvent>() {//calcular Wt
            @Override
            public void handle(ActionEvent t) {
                double lamda = Double.parseDouble(lambda1.getText());
                double mu = Double.parseDouble(miu1.getText());
                int x = Integer.parseInt(tiempoW.getText());
                ModeloMM1 cal = new ModeloMM1(lamda, mu);
                cal.calculate();
                wt.setText("" + dec2.format(cal.wt(lamda, mu, x)));
            }
        }
        );

        btnBorrarWt.setOnAction(new EventHandler<ActionEvent>() {//calcular Wt
            @Override
            public void handle(ActionEvent t) {
                tiempoW.setText("");
                wt.setEditable(true);
                wt.setText("");
            }
        }
        );

        btnCalWq.setOnAction(new EventHandler<ActionEvent>() {//calcular Wqt
            @Override
            public void handle(ActionEvent t) {
                double lamda = Double.parseDouble(lambda1.getText());
                double mu = Double.parseDouble(miu1.getText());
                int x = Integer.parseInt(tiempoWq.getText());
                ModeloMM1 cal = new ModeloMM1(lamda, mu);
                cal.calculate();
                wqt.setText("" + dec2.format(cal.wqdet(lamda, mu, x)));
            }
        }
        );

        btnBorrarWq.setOnAction(new EventHandler<ActionEvent>() {//calcular Wqt
            @Override
            public void handle(ActionEvent t) {
                tiempoWq.setText("");
                wqt.setEditable(true);
                wqt.setText("");
            }
        }
        );

        graEsp.setOnAction(new EventHandler<ActionEvent>() {//Grafico de clientes esperando
            @Override
            public void handle(ActionEvent t) {
                double lamda = Double.parseDouble(lambda1.getText());
                double mu = Double.parseDouble(miu1.getText());
                int t1 = Integer.parseInt(c1.getText());
                int t2 = Integer.parseInt(c2.getText());
                GraficoClientes graph = new GraficoClientes();
                graph.obtenerDatos(lamda, mu, t1, t2);
                graph.init();

            }
        }
        );

        btnBorrarGraEs.setOnAction(new EventHandler<ActionEvent>() {//Borra valores de la grafica de los clientes
            @Override
            public void handle(ActionEvent t) {
                c1.setText("");
                c2.setText("");
            }
        }
        );

        graTesp.setOnAction(new EventHandler<ActionEvent>() {//Grafico de tiempo de espera
            @Override
            public void handle(ActionEvent t) {
                double lamda = Double.parseDouble(lambda1.getText());
                double mu = Double.parseDouble(miu1.getText());
                int t1 = Integer.parseInt(e1.getText());
                int t2 = Integer.parseInt(e2.getText());
                GraficoEs gra = new GraficoEs();
                gra.obtenerDatos(lamda, mu, t1, t2);
                gra.init();
            }
        }
        );

        btnBorrarGraTes.setOnAction(new EventHandler<ActionEvent>() {//borra valores de la grafica de tiempo de espera
            @Override
            public void handle(ActionEvent t) {
                e1.setText("");
                e2.setText("");
            }
        }
        );

        String image = "multimedia/fondo4.jpg";

        StackPane panel1 = new StackPane();//Crear el contenedor para agregar los layouts(HBox)
        // panel1.setStyle("-fx-background-color: #1d1d1d");
        panel1.setStyle("-fx-background-image: url('" + image + "'); "
                + "-fx-background-position: center center; "
                + "-fx-background-repeat: stretch;");

        panel1.getChildren().add(panelMain);//agregar el layout al contenedor
        Scene escena = new Scene(panel1);//Crear escenario

        primaryStage.setScene(escena);//A la ventana setearle el escenario
        primaryStage.setTitle("Sistema de colas de MEP-115: M/M/1");//Titulo de la ventana
        primaryStage.setResizable(true);//No permite redimencionar ventana
        primaryStage.show();//muestra la ventana

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
