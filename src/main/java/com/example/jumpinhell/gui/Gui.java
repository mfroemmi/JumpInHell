package com.example.jumpinhell.gui;

import com.example.jumpinhell.actions.*;
import com.example.jumpinhell.draw.Draw_Main;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Marcel
 */
public class Gui {
    
    // Definieren der Variablen
    public static Draw_Main dm;
    
    public static int width = 1280, height = 720;
    public static GraphicsContext gc_main;
    
    // Initialisieren bzw. Zeichnen der Oberflächen
    public void init() {
        
        dm = new Draw_Main();
    }
    
    // Erstellen des StackPane(Container)
    public void create(Stage stage) {
        
        Canvas canvas_main;
        StackPane root = new StackPane();
        int cWidth = width-10, cHeight = height-10;
        canvas_main = new Canvas(width, height);
        gc_main = canvas_main.getGraphicsContext2D();
        dm.draw(gc_main);
        
        root.getChildren().add(canvas_main);
        Scene scene = new Scene(root, cWidth, cHeight);
        
        scene.setOnKeyPressed(new KeyPressed());
        scene.setOnKeyReleased(new KeyReleased());

        scene.setOnMouseReleased(new MouseReleased());
        scene.setOnMouseMoved(new MouseMoved());
        scene.setOnMouseDragged(new MouseDragged());
        scene.setOnMousePressed(new MousePressed());

        stage.setTitle("Jump In Hell");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
        
    }
    
}
