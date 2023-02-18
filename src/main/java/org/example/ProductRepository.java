package org.example;

public class ProductRepository {
    Product[] repoProduct = new Product[0];

    public Product[] findAll() {
        return repoProduct;
    }

    public void save(Product product) {
        Product[] tmp = new Product[repoProduct.length + 1];
        for (int i = 0; i < repoProduct.length; i++) {
            tmp[i] = repoProduct[i];
        }
        tmp[tmp.length - 1] = product;
        repoProduct = tmp;
    }

    public void removeById(int id) {
        Product foundProduct = findById(id);
        if (foundProduct == null){
            throw new NotFoundException(id);
        }
        Product[] tmp = new Product[repoProduct.length - 1];
        int index = 0;
        for (Product product : repoProduct) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;

            }
        }
        repoProduct = tmp;
    }
    private Product findById(int id) {
        for (Product product : repoProduct) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}
