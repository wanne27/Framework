package service;

import model.Product;

public class ProductCreator {
    public static final String PRODUCT_ARTICLE="testdata.product.article";
    public static final String PRODUCT_SIZE="testdata.product.size";
    public static final String PRODUCT_PRICE="testdata.product.price";
    public static final String PRODUCT_FAILED_ARTICLE="testdata.product.failed.article";
    public static final String PRODUCT_URL="testdata.product.product.url";
    public static Product withAllProperty(){
        return new Product(TestDataReader.getTestData(PRODUCT_ARTICLE),
                TestDataReader.getTestData(PRODUCT_SIZE),
                TestDataReader.getTestData(PRODUCT_PRICE),
                TestDataReader.getTestData(PRODUCT_URL));
    }
    public static Product withFailedSearch(){
        return new Product(TestDataReader.getTestData(PRODUCT_FAILED_ARTICLE));
    }
}
