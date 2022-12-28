package ru.netology.productManager.domain;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Товар с id " + id + " не найден");
    }
}
