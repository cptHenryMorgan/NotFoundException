package ru.netology.productManager.domain.Repository;

import ru.netology.productManager.domain.Book;
import ru.netology.productManager.domain.NotFoundException;
import ru.netology.productManager.domain.Product;

public class Repository {

    private Product[] products = new Product[0];


    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[products.length] = product;
        products = tmp;
    }

    public void removeById(int removeId) {
        if (findById(removeId) == null) {
            throw new NotFoundException(removeId);
        }
        Product[] tmp = new Product[products.length - 1];
        int indexToInsert = 0;
        for (Product product : products) {
            if (product.getId() != removeId) {
                tmp[indexToInsert] = product;
                indexToInsert++;
            }
        }
        products = tmp;
    }

    private Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product[] findAll() {
        return products;
    }
}
