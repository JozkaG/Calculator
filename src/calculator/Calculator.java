package calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


/**
 *
 * @author jozka
 */
public class Calculator extends Application {
    TextField Anstext = new TextField();
    Button[] numButtons = new Button[10];
    Button[] OperatorsButtons = new Button[9];
    
    double num1=0,num2=0,result=0;
    char operator;
     
    //main 
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {     
       
        //TextField to display the answer
        
        Anstext.setFont(Font.font(28));
        Anstext.setAlignment(Pos.CENTER_RIGHT);
        Anstext.setEditable(false);
        Anstext.setPrefHeight(120);
        
        //Buttons for OperatorsButtons
        Button Clear = new Button("C");
        Clear.setPrefSize(75, 45);
        Clear.setOnAction(new AllActions());//Register button to event
        
        Button Sign = new Button("+/-");
        Sign.setPrefSize(75, 45);
        Sign.setOnAction(new AllActions());//Register button to event
        
        Button Delete = new Button("DEL");
        Delete.setPrefSize(75, 45);
        Delete.setOnAction(new AllActions());//Register button to event
        
        Button Divide = new Button("÷");
        Divide.setPrefSize(75, 45);
        Divide.setOnAction(new AllActions());//Register button to event
        
        Button Multiply = new Button("X");
        Multiply.setPrefSize(75, 45);
        Multiply.setOnAction(new AllActions());//Register button to event
        
        Button Subtraction = new Button("-");
        Subtraction.setPrefSize(75, 45);
        Subtraction.setOnAction(new AllActions());//Register button to event
        
        Button Addition = new Button("+");
        Addition.setPrefSize(75, 45);
        Addition.setOnAction(new AllActions());//Register button to event
        
        Button Equal = new Button("=");
        Equal.setPrefSize(75, 45);
        Equal.setOnAction(new AllActions());//Register button to event
        
        Button Decimal = new Button(".");
        Decimal.setPrefSize(75, 45);
        Decimal.setOnAction(new AllActions());//Register button to event
        
        //add the operators the the operator array
        OperatorsButtons[0] = Addition;
        OperatorsButtons[1] = Subtraction;
        OperatorsButtons[2] = Multiply;
        OperatorsButtons[3] = Divide;
        OperatorsButtons[4] = Decimal;
        OperatorsButtons[5] = Equal;
        OperatorsButtons[6] = Delete;
        OperatorsButtons[7] = Clear;
        OperatorsButtons[8] = Sign;
        
        //Buttons for numbers
        Button Zero = new Button("0");
        Zero.setPrefSize(150, 45); //150 width
        Zero.setOnAction(new AllActions()); //register button to event
        
        Button One = new Button("1");
        One.setPrefSize(75, 45);
        One.setOnAction(new AllActions()); //Register button to event
        
        Button Two = new Button("2");
        Two.setPrefSize(75, 45);
        Two.setOnAction(new AllActions()); //Register button to event
        
        Button Three = new Button("3");
        Three.setPrefSize(75, 45);
        Three.setOnAction(new AllActions()); //Register button to event
        
        Button Four = new Button("4");
        Four.setPrefSize(75, 45);
        Four.setOnAction(new AllActions()); //Register button to event
        
        Button Five = new Button("5");
        Five.setPrefSize(75, 45);
        Five.setOnAction(new AllActions()); //Register button to event
        
        Button Six = new Button("6");
        Six.setPrefSize(75, 45);
        Six.setOnAction(new AllActions()); //Register button to event
        
        Button Seven = new Button("7");
        Seven.setPrefSize(75, 45);
        Seven.setOnAction(new AllActions()); //Register button to event
        
        Button Eight = new Button("8");
        Eight.setPrefSize(75, 45);
        Eight.setOnAction(new AllActions()); //Register button to event
        
        Button Nine = new Button("9");
        Nine.setPrefSize(75, 45);
        Nine.setOnAction(new AllActions()); //Register button to event
        
        //Adding the numbers to the arraybuttons so it can do operations 
        numButtons[0] = Zero;
        numButtons[1] = One;
        numButtons[2] = Two;
        numButtons[3] = Three;
        numButtons[4] = Four;
        numButtons[5] = Five;
        numButtons[6] = Six;
        numButtons[7] = Seven;
        numButtons[8] = Eight;
        numButtons[9] = Nine;
        

        //Gridpane Layout the button into its columns and Rows
        GridPane gridpane = new GridPane();
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.setPadding(new Insets(5));
        
        //Column 0
        gridpane.add(Clear,0,0);
        gridpane.add(Seven,0,1);
        gridpane.add(Four,0,2);
        gridpane.add(One,0,3);
        GridPane.setColumnSpan(Zero, 2);
        gridpane.add(Zero,0,4);
        
        //Column 1
        gridpane.add(Sign,1,0);
        gridpane.add(Eight,1,1);
        gridpane.add(Five,1,2);
        gridpane.add(Two,1,3);
        
        //Column 2
        gridpane.add(Delete,2,0);
        gridpane.add(Nine,2,1);
        gridpane.add(Six,2,2);
        gridpane.add(Three,2,3);
        gridpane.add(Decimal,2,4);
        
        
        //Column 3
        gridpane.add(Divide,3,0);
        gridpane.add(Multiply,3,1);
        gridpane.add(Subtraction,3,2);
        gridpane.add(Addition,3,3);
        gridpane.add(Equal,3,4);
        
        //Creat a Scene with VBOX
        VBox vbox = new VBox(Anstext,gridpane);
        
        //Scene 
        Scene scene = new Scene(vbox,320,450);
        
        
        //Display the whole stage
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    class AllActions implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            try{ //EXCPETION START 
                
           //Adds function to buttons
            for(int i=0;i<10;i++){
                if(event.getSource() == numButtons[i]){
                    Anstext.setText(Anstext.getText().concat(String.valueOf(i)));
                }
            }
            
            //Add function to decimal button
            if(event.getSource()== OperatorsButtons[4]){
                Anstext.setText(Anstext.getText().concat("."));
            }
            
            //Add Function to the Addition Button
            if(event.getSource()== OperatorsButtons[0]){
                num1 = Double.parseDouble(Anstext.getText());
                operator = '+';
                Anstext.setText("");
            }
            
            //Function for Substraction
            if(event.getSource()== OperatorsButtons[1]){
                num1 = Double.parseDouble(Anstext.getText());
                operator = '-';
                Anstext.setText("");
            }
            
            //Function for Multiply
            if(event.getSource()== OperatorsButtons[2]){
                num1 = Double.parseDouble(Anstext.getText());
                operator = '*';
                Anstext.setText("");
            }
            
            //Function for Division
            if(event.getSource()== OperatorsButtons[3]){
                num1 = Double.parseDouble(Anstext.getText());
                operator = '/';
                Anstext.setText("");
            }
            
            
            
            //equal button
            if(event.getSource()== OperatorsButtons[5]){
                num2=Double.parseDouble(Anstext.getText());
                
                //switch for which operator the user uses
                switch(operator) {
                    case '+':
                        result=num1+num2;
                        break;
                        
                    case '-':
                        result=num1-num2;
                        break;
                        
                    case '*':
                        result=num1*num2;
                        break;
                    //ADD EXCEPTION OF WHAT EVER 
                    case '/':
                        result=num1/num2;
                        break;
                }
                Anstext.setText(String.valueOf(result));
                num1=result; //if want to continue to use same number 
            }
            
            
            
            
            
            //Clear button
            if(event.getSource()== OperatorsButtons[7]){
                Anstext.setText("");
            }
            
            //Delete Button
            if(event.getSource()== OperatorsButtons[6]){
                String s = Anstext.getText();
                Anstext.setText("");
                
                for(int i =0; i<s.length()-1;i++){
                    Anstext.setText(Anstext.getText()+s.charAt(i));
                }
            }
             
            //Sign button
            if(event.getSource()== OperatorsButtons[8]){
                double temp = Double.parseDouble(Anstext.getText());
                if(temp >= 0){
                    double resultneg = temp *-1;
                    Anstext.setText(resultneg+"");
                }else{
                    double resultpos = temp *-1;
                    Anstext.setText(resultpos+"");
                }

            }
            
            } // END EXCPETION
            catch(NumberFormatException e){
               Anstext.setText(Anstext.getText());
            }
        }
               
        }
    }
      
