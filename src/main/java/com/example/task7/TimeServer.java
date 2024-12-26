package com.example.task7;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TimeServer {
    private int time = 0;
    private List<IObserver> observers = new ArrayList<>();
    private Timer timer = new Timer();

    // Добавление наблюдателей
    public void attach(IObserver observer) {
        observers.add(observer);
    }

    // Уведомление всех наблюдателей
    private void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(time);
        }
    }

    // Старт отсчета времени
    public void start() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                time++;
                notifyObservers();
            }
        }, 1000, 1000);  // Каждый 1 секунду
    }

    // Остановка сервера
    public void stop() {
        timer.cancel();
    }

    // Получение текущего времени
    public int getTime() {
        return time;
    }
}
