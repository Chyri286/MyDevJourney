package javafxtest;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ZodiacSign extends Application 
{
    private String[] zodiacs = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October",
            "November", "December"};
    private String[] zodiacDescriptions = {      
            "Aries ","Taurus","Gemini","Cancer","Leo","Virgo","Libra",
            "Scorpio","Sagittarius","Capricorn","Aquarius","Pisces"
    };

    private ComboBox<String> cbo = new ComboBox<>();
    private TextField tfDob = new TextField();
    private TextArea taDescription = new TextArea("Your zodiac sign is ...");

    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(5);

        // A Text Field to enter the day of the month
        Label label = new Label("  Enter the day of the month: ");
        Label label2 = new Label("  Select a month: ");
        label2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));
        gridPane.add(label, 0, 1);
        gridPane.add(label2, 0, 0);
        gridPane.add(tfDob, 1, 1);

        // Combo Box to select the month
        cbo.getItems().addAll(zodiacs);
        cbo.setPromptText("Select the month");
        cbo.setPrefWidth(200);
        gridPane.add(cbo, 1, 0);

        // Button to submit the date
        Button btSubmit = new Button("Submit");
        gridPane.add(btSubmit, 1, 3);
        btSubmit.setOnAction(e -> calculateH());

        Scene scene = new Scene(gridPane, 400, 150);
        primaryStage.setTitle("Zodiac Signs");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Description Area that pops up after the submit button is clicked
        taDescription.setWrapText(true);
        taDescription.setEditable(false); // Read only
        taDescription.setPrefColumnCount(15);
        taDescription.setPrefHeight(10);
        gridPane.add(taDescription, 1, 2);
    }

    private void calculateH()
    {
        int day = Integer.parseInt(tfDob.getText());
        String month = cbo.getValue();
        String zodiacSignDescription = determineZodiacSign(day, month);
        taDescription.setText("Your zodiac sign is: " + zodiacSignDescription);
    }

    private String determineZodiacSign(int day, String month) 
    {
        
        if ((month.equals("March") && day >= 21) || (month.equals("April") && day <= 19))
        {
            return zodiacDescriptions[0]; // Aries
        } 
        else if ((month.equals("April") && day >= 20) || (month.equals("May") && day <= 20))
        {
            return zodiacDescriptions[1]; // Taurus
        }
        else if ((month.equals("May") && day >= 21) || (month.equals("June") && day <= 20))
        {
            return zodiacDescriptions[2]; // Gemini
        }
        else if ((month.equals("June") && day >= 21) || (month.equals("July") && day <= 22))
        {
            return zodiacDescriptions[3]; // Cancer
        }
        else if ((month.equals("July") && day >= 23) || (month.equals("August") && day <= 22))
        {
            return zodiacDescriptions[4]; // Leo
        }
        else if ((month.equals("August") && day >= 23) || (month.equals("September") && day <= 22))
        {
            return zodiacDescriptions[5]; // Virgo
        }
        else if ((month.equals("September") && day >= 23) || (month.equals("October") && day <= 22))
        {
            return zodiacDescriptions[6]; // Libra
        }
        else if ((month.equals("October") && day >= 23) || (month.equals("November") && day <= 20))
        {
            return zodiacDescriptions[7]; // Scorpio
        }
        else if ((month.equals("November") && day >= 20) || (month.equals("December") && day <= 20))
        {
            return zodiacDescriptions[8]; // Sagittarius
        }
        else if ((month.equals("December") && day >= 20) || (month.equals("January") && day <= 20))
        {
            return zodiacDescriptions[9]; // Capricorn
        }
        else if ((month.equals("January") && day >= 20) || (month.equals("February") && day <= 20))
        {
            return zodiacDescriptions[10]; // Aquarius
        }
        else if ((month.equals("February") && day >= 20) || (month.equals("March") && day <= 20))
        {
            return zodiacDescriptions[11]; // Pisces
        }

        // If no condition is met, return an error message or handle it as needed
        return "Invalid input";
    }

    public static void main(String[] args) {
        launch(args);
    }
}