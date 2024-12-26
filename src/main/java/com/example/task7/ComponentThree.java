package com.example.task7;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class ComponentThree implements IObserver {
    private Circle animatedCircle;
    private int animationInterval;
    private boolean moveRight = true; // Флаг для направления движения

    public ComponentThree(Circle animatedCircle, int animationInterval) {
        this.animatedCircle = animatedCircle;
        this.animationInterval = animationInterval;
    }

    @Override
    public void update(int time) {
        if (time % animationInterval == 0) {
            restartAnimation();
        }
    }

    private void restartAnimation() {
        // Настраиваем направление движения
        double moveDistance = moveRight ? 300 : -300; // Двигаем вправо или влево
        moveRight = !moveRight; // Меняем направление для следующего раза

        // Создаем анимацию перемещения
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(animatedCircle);
        transition.setDuration(Duration.seconds(2)); // Длительность анимации
        transition.setByX(moveDistance); // Перемещение по оси X
        transition.setCycleCount(1); // Анимация выполняется один раз
        transition.setAutoReverse(false); // Без обратного движения
        transition.play(); // Запускаем анимацию
    }
}
