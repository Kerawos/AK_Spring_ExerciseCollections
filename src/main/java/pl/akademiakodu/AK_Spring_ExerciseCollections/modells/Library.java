package pl.akademiakodu.AK_Spring_ExerciseCollections.modells;

import java.util.ArrayList;
import java.util.List;

public class Library {

    Article pirates = new Article("Pirates", 3000);
    Article wanted = new Article("Fast Cars", 3004);
    Article trees = new Article("Trees", 3001);
    Article ocean = new Article("Undersea", 3001);
    Article mount = new Article("Mount and Horses", 3002);

    Writer johny = new Writer("Johny", pirates);
    Writer sam = new Writer("Sam", ocean);
    Writer elvis = new Writer("Elvis", pirates);
    Writer ana = new Writer("Ana", mount);
    Writer michaliv = new Writer("Michaliv", pirates);
    Writer olecia = new Writer("Olecia", wanted);
    Writer reksio = new Writer("Reksio", trees);
    Writer kogijaszi = new Writer("Kogijaszi", pirates);
    Writer enzo = new Writer("Enzo", mount);

    public List<Writer> getWriters(String articleName){
        List<Writer> writers = createWriterList();
        List<Writer> resultList = new ArrayList<>();
        for (int i = 0; i < writers.size(); i++) {
            if (articleName.equals(writers.get(i).getArticle().getName())){
                resultList.add(writers.get(i));
            }
        }
        return resultList;
    }

    public Article getArticles(String writerName){
        Article result = null;
        List<Writer> writers = new ArrayList<>();
        writers = createWriterList();
        for (Writer writer : writers) {
            if (writerName.equals(writer.getName())){
                result = writer.getArticle();
            }
        }
        return result;
    }

    public List<Article>createArticleList(){
        List<Article> articles = new ArrayList<>();
        articles.add(pirates);
        articles.add(wanted);
        articles.add(trees);
        articles.add(ocean);
        articles.add(mount);
        return articles;
    }

    public List<Writer>createWriterList(){
        List<Writer> writers = new ArrayList<>();
        writers.add(johny);
        writers.add(sam);
        writers.add(elvis);
        writers.add(ana);
        writers.add(michaliv);
        writers.add(olecia);
        writers.add(reksio);
        writers.add(kogijaszi);
        writers.add(enzo);
        return writers;
    }

    public boolean isWriter(String userInput){
        List<Writer> writers = createWriterList();
        for (Writer writer : writers) {
           if (writer.getName().equals(userInput)){
               return true;
           }
        }
        return false;
    }

    public boolean isArticle(String userInput){
        List<Article> articles = createArticleList();
        for (Article articl : articles) {
            if (articl.getName().equals(userInput)){
                return true;
            }
        }
        return false;
    }

    public String showWriters(){
        StringBuilder sb = new StringBuilder();
        List<Writer> writers = createWriterList();
        for (Writer writer : writers) {
            sb.append("Writer: " + writer.getName() + ", Article: " + writer.getArticle().getName() + " *** ");
        }
        return sb.toString();
    }

    public String showArticles(){
        StringBuilder sb = new StringBuilder();
        List<Article> articles = createArticleList();
        for (Article articl : articles) {
            sb.append("Article: " + articl.getName() + ", Year: " + articl.getProductionYear() + " *** ");
        }
        return sb.toString();
    }

    public String generateResult(String userInput){
        StringBuilder sb = new StringBuilder();
        if (isArticle(userInput)){
            getWriters(userInput).forEach(writer->sb.append("Writer: " + writer.getName() + ", Article: " + writer.getArticle().getName() + " *** "));
            return sb.toString();
        } else if (isWriter(userInput)){
            System.out.println(getArticles(userInput).getName());
            return "Article: " + getArticles(userInput).getName() + ", Year: " + getArticles(userInput).getProductionYear() + " *** ";
        } else {
            return "Your input is incorrect";
        }
    }
}


