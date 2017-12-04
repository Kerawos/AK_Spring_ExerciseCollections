package pl.akademiakodu.AK_Spring_ExerciseCollectionsMaps.modells.services;
/**
 * Imports section
 */
import org.springframework.stereotype.Service;
import pl.akademiakodu.AK_Spring_ExerciseCollectionsMaps.modells.Article;
import pl.akademiakodu.AK_Spring_ExerciseCollectionsMaps.modells.Writer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Responsible for library exercise, calculations connecting with library management
 */
@Service
public class Library {

    /**
     * Articles declaration and initializations
     */
    Article pirates = new Article("Pirates", 3000);
    Article wanted = new Article("Fast Cars", 3004);
    Article trees = new Article("Trees", 3001);
    Article ocean = new Article("Undersea", 3001);
    Article mount = new Article("Mount and Horses", 3002);

    /**
     * Writers declaration and initializations
     */
    Writer johny = new Writer("Johny", Arrays.asList(pirates, wanted));
    Writer sam = new Writer("Sam",  Arrays.asList(ocean));
    Writer elvis = new Writer("Elvis",  Arrays.asList(pirates));
    Writer ana = new Writer("Ana",  Arrays.asList(mount));
    Writer michaliv = new Writer("Michaliv",  Arrays.asList(pirates));
    Writer olecia = new Writer("Olecia",  Arrays.asList(wanted));
    Writer reksio = new Writer("Reksio",  Arrays.asList(trees, mount));
    Writer kogijaszi = new Writer("Kogijaszi",  Arrays.asList(pirates, wanted, mount, trees));
    Writer enzo = new Writer("Enzo",  Arrays.asList(mount));


    /**
     * Method generate all writers which participated in given article
     * @param articleName name of article
     * @return list of all writers which participated in writing given article
     */
    public List<Writer> getWriters(String articleName){
        List<Writer> writers = createWriterList();
        List<Writer> resultList = new ArrayList<>();
        for (int i = 0; i < writers.size(); i++) {
            for (int j = 0; j < writers.get(i).getArticles().size(); j++) {
                if (articleName.equals(writers.get(i).getArticles().get(j).getName())){
                    resultList.add(writers.get(i));
                    break;
                }
            }
        }
        return resultList;
    }

    /**
     * Method generate all articles wrote by given writer
     * @param writerName name of writer
     * @return list of all articles wrote by given writer
     */
    public List<Article> getArticles(String writerName){
        List<Article> articleList = new ArrayList<>();
        List<Writer> writers = new ArrayList<>();
        writers = createWriterList();
        for (Writer writer : writers) {
            if (writerName.equals(writer.getName())){
                articleList = writer.getArticles();
                break;
            }
        }
        return articleList;
    }

    /**
     * Method create article list from predefined articles
     * @return list of articles
     */
    public List<Article>createArticleList(){
        List<Article> articles = new ArrayList<>();
        articles.add(pirates);
        articles.add(wanted);
        articles.add(trees);
        articles.add(ocean);
        articles.add(mount);
        return articles;
    }

    /**
     * Method create writer list from predefined writers
     * @return list of writers
     */
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

    /**
     * Mentohd checking if input is an writer name
     * @param userInput
     * @return result true if input is writer name
     */
    public boolean isWriter(String userInput){
        List<Writer> writers = createWriterList();
        for (Writer writer : writers) {
           if (writer.getName().equals(userInput)){
               return true;
           }
        }
        return false;
    }

    /**
     * Mentohd checking if input is an aricle name
     * @param userInput
     * @return result true if input is article name
     */
    public boolean isArticle(String userInput){
        List<Article> articles = createArticleList();
        for (Article articl : articles) {
            if (articl.getName().equals(userInput)){
                return true;
            }
        }
        return false;
    }

    /**
     * Method generate a string containing every writer with article
     * @return generated informations
     */
    public String showWriters(){
        StringBuilder sb = new StringBuilder();
        List<Writer> writers = createWriterList();
        for (Writer writer : writers) {
            sb.append("Writer: " + writer.getName() + ", Articles: ");
            writer.getArticles().forEach(article -> sb.append(article.getName() + ", "));
            sb.append(" *** ");
        }
        return sb.toString();
    }

    /**
     * Method generate a string containing every article
     * @return generated information
     */
    public String showArticles(){
        StringBuilder sb = new StringBuilder();
        List<Article> articles = createArticleList();
        for (Article articl : articles) {
            sb.append("Article: " + articl.getName() + ", Year: " + articl.getProductionYear() + " *** ");
        }
        return sb.toString();
    }

    /**
     * Method generate proper result based on inputs and methods
     * @param userInput writer or article
     * @return result
     */
    public String generateResult(String userInput){
        StringBuilder sb = new StringBuilder();
        if (isArticle(userInput)){
            for (Writer writer : getWriters(userInput)) {
                sb.append("Writer: " + writer.getName() + ", Articles: ");
                writer.getArticles().forEach(article -> sb.append(article.getName() + ", "));
                sb.append(" *** ");
            }
            return sb.toString();
        } else if (isWriter(userInput)){
            sb.append("Article: ");
            for (Article arti : getArticles(userInput)) {
                sb.append(arti.getName() + ", ");
            }
            return sb.toString();
        } else {
            return "Your input is incorrect";
        }
    }
}


