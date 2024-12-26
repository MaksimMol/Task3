package com.example.task7;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ComponentTwo implements IObserver {

    private MediaPlayer mediaPlayer;
    private int playInterval;

    public ComponentTwo(String musicFilePath, int playInterval) {
        // Загружаем музыкальный файл
        Media media = new Media(getClass().getResource(musicFilePath).toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        this.playInterval = playInterval;

        // Установка действия по завершению воспроизведения
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.stop());
    }

    @Override
    public void update(int time) {
        // Проигрываем музыку каждые playInterval секунд
        if (time % playInterval == 0 && time != 0) { // музыка не воспроизводится на первом шаге
            playMusic();
        }
    }

    // Запуск музыки
    private void playMusic() {
        if (mediaPlayer.getStatus() != MediaPlayer.Status.PLAYING) {
            mediaPlayer.seek(javafx.util.Duration.ZERO); // Сбрасываем к началу
            mediaPlayer.play();
        }
    }
}
