import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyJavaFXApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a new button
        Button btn = new Button();
        btn.setText("Click me!");

        // Add a handler for the button click event
        btn.setOnAction(e -> System.out.println("Hello, JavaFX!"));

        // Create a new VBox layout and add the button to it
        VBox root = new VBox();
        root.getChildren().add(btn);
        root.setAlignment(Pos.CENTER);

        // Create a new scene and set the layout to the VBox
        Scene scene = new Scene(root, 200, 100);

        // Set the scene for the primary stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("My JavaFX App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
