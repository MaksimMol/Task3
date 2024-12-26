package com.example.task7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TimeApp extends Application {

    private TimeServer timeServer;

    @Override
    public void start(Stage primaryStage) {
        // Создаем сервер времени
        timeServer = new TimeServer();

        // Создание компонентов
        Label timeLabel = new Label("Прошло: 0с");
        ComponentOne componentOne = new ComponentOne(timeLabel);
        timeServer.attach(componentOne);

        // Анимация круга (ComponentThree)
        Circle animatedCircle = new Circle(50, Color.RED);
        ComponentThree componentThree = new ComponentThree(animatedCircle, 20);  // Анимация каждые 20 секунд
        timeServer.attach(componentThree);

        // Музыкальный клип (ComponentTwo)
        String musicFilePath = "/music/vivo.mp3";  // Укажите путь к вашему аудиофайлу
        ComponentTwo componentTwo = new ComponentTwo(musicFilePath, 10);  // Проигрывать музыку каждые 10 секунд
        timeServer.attach(componentTwo);

        // Кнопки управления
        Button startButton = new Button("Запустить сервер");
        Button stopButton = new Button("Остановить сервер");

        startButton.setOnAction(e -> timeServer.start());
        stopButton.setOnAction(e -> timeServer.stop());

        HBox serverControlPanel = new HBox(10, startButton, stopButton);

        // Панель с меткой времени и анимацией
        VBox timePanel = new VBox(10, new Label("Отображение времени"), timeLabel);
        VBox circlePanel = new VBox(10, new Label("Анимация круга"), animatedCircle);
        HBox componentsPanel = new HBox(20, timePanel, circlePanel);

        BorderPane root = new BorderPane();
        root.setTop(serverControlPanel);
        root.setCenter(componentsPanel);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Time Server App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

