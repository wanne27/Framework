package model;

public enum Article {

    US1("55899-919"),
    US2("55821-912"),
    US3("55892-915"),
    US4("55866-125"),
    US5("55123-945");

    private final String article;

    Article(String article) {
        this.article = article;
    }

    public String getArticle() {
        return article;
    }
}
