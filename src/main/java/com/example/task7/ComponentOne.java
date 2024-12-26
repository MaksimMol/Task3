package com.example.task7;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class ComponentOne implements IObserver {
    private Label timeLabel;

    public ComponentOne(Label timeLabel) {
        this.timeLabel = timeLabel;
    }

    @Override
    public void update(int time) {
        // Обновление метки времени
        Platform.runLater(() -> timeLabel.setText("Прошло: " + time + "с"));
    }
}
