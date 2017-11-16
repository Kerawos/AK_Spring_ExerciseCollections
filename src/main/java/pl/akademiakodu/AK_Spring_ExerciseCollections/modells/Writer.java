package pl.akademiakodu.AK_Spring_ExerciseCollections.modells;

public class Writer {

    private String name;
    private Article article;

    public Writer(String name, Article article) {
        this.name = name;
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
