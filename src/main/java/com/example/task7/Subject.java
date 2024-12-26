package com.example.task7;

public interface Subject {
    void notifyAllObservers(); // Уведомить всех наблюдателей
    void attach(IObserver observer); // Добавить наблюдателя
    void detach(IObserver observer); // Удалить наблюдателя
}

