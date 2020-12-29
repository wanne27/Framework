package model;

import java.util.Objects;

public class Product {
    private String productUrl;
    private String article;
    private String failedArticle;
    private String size;
    private String price;

    public  Product(String article,String size,String price,String productUrl){
        this.article=article;
        this.size=size;
        this.price=price;
        this.productUrl = productUrl;
    }

    public  Product(String failedArticle){
        this.failedArticle=failedArticle;
    }

    public String getArticle(){ return article; }

    public void setArticle(String article){
        this.article=article;
    }

    public String getFailedArticle(){ return failedArticle; }

    public void setFailedArticle(String failedArticle){
        this.failedArticle=failedArticle;
    }

    public String getSize(){
        return size;
    }

    public void setSize(String size){
        this.size=size;
    }

    public String getProductUrl(){
        return productUrl;
    }

    public void setProductUrl(String productUrl){
        this.productUrl=productUrl;
    }

    public String getPrice(){
        return price;
    }

    public void setPrice(String productUrl){
        this.price=price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "article='" + article + '\'' +
                ", size='" + size + '\'' +
                ", price='" + price + '\'' +
                ", failedArticle='" + failedArticle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getArticle(),product.getArticle()) &&
                Objects.equals(getSize(), product.getSize());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArticle(), getSize());
    }
}
