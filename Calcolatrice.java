/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatrice;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Mirko
 */
public class Calcolatrice extends Application 
implements EventHandler<ActionEvent> {
    
    Button btn_piu;
    Button btn_meno;
    Button btn_per;
    Button btn_div;
    TextField txt_in1;
    TextField txt_in2;
    TextField txt_out; 
    Label right;
    Label left;
    Label title;
    VBox vbox;
    HBox hbox_pulsanti;
    BorderPane border;
    Stage stage;
    @Override
    public void start(Stage primaryStage) {
       stage=primaryStage;
       inizializza(); 
       
       //event handler
       btn_piu.setOnAction(this);
        btn_meno.setOnAction(this);
        btn_per.setOnAction(this);
        btn_div.setOnAction(this);
       
       Scene scene = new Scene(border, 600, 500);
        stage.setTitle("Mini Calculator");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public void inizializza()
    {
          //crezione delle cose necessarie
        btn_piu=new Button("PIU");
        btn_meno=new Button("MENO");
        btn_per=new Button("PER");
        btn_div=new Button("DIV");
        txt_in1=new TextField();
        txt_in2=new TextField();
        txt_out=new TextField();
        right=new Label("right");
        left=new Label("left");
        title=new Label("MiniCalculator");
        vbox=new VBox();
        hbox_pulsanti=new HBox();
        border=new BorderPane();
        
        txt_in1.setPromptText("Primo operando");
        txt_in2.setPromptText("Secondo operando");
        txt_out.setPromptText("Risultato");
        //assegnazione ai vari pane
        HBox.setHgrow(btn_piu, Priority.ALWAYS);
        HBox.setHgrow(btn_meno, Priority.ALWAYS);
        HBox.setHgrow(btn_per, Priority.ALWAYS);
        HBox.setHgrow(btn_div, Priority.ALWAYS);
       
        btn_per.setMaxWidth(Double.MAX_VALUE);
        btn_div.setMaxWidth(Double.MAX_VALUE);
        
        btn_piu.setMaxWidth(Double.MAX_VALUE);
        btn_meno.setMaxWidth(Double.MAX_VALUE);
        BorderPane.setMargin(right, new Insets(20));
        
        BorderPane.setAlignment(left, Pos.CENTER_LEFT);
        BorderPane.setAlignment(right, Pos.CENTER);
        
        hbox_pulsanti.getChildren().addAll(btn_piu,btn_meno,btn_per,btn_div);
      
        hbox_pulsanti.setPrefWidth(Double.MAX_VALUE);
        
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(txt_in1,txt_in2,hbox_pulsanti,txt_out);
        vbox.setMaxWidth(400);
    
        border.setLeft(left);
        border.setRight(right);
        border.setCenter(vbox);
        title.setFont(Font.font(null, FontWeight.BOLD, 45));
        border.setTop(title);
        BorderPane.setAlignment(border.getTop(), Pos.TOP_CENTER);

        
        
    }

    @Override
    public void handle(ActionEvent t) {
       double risultato=0.0;
       double op1=Double.NaN;
       double op2=Double.NaN;
       op1=Double.parseDouble(txt_in1.getText());
       op2=Double.parseDouble(txt_in2.getText());
        if(t.getSource()==btn_piu)
        {
            risultato=op1+op2;
        }
        if(t.getSource()==btn_meno)
        {
            risultato=op1-op2;
        }
        if(t.getSource()==btn_div)
        {
            risultato=op1/op2;
        }
        if(t.getSource()==btn_per)
        {
            risultato=op1*op2;
        }
       txt_out.setText(Double.toString(risultato));
    }
    
}
