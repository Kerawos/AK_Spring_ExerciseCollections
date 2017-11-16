package pl.akademiakodu.AK_Spring_ExerciseCollections.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.AK_Spring_ExerciseCollections.modells.Library;
import pl.akademiakodu.AK_Spring_ExerciseCollections.modells.entities.SingleUserInput;

@Controller
public class LibraryController {

    private Library library = new Library();

    @GetMapping("/")
    public String descGet(){
        return "desc";
    }

    @GetMapping("/lib") public String getLib(Model model){
        model.addAttribute("writers", library.showWriters());
        model.addAttribute("articles", library.showArticles());
        model.addAttribute("singleUserInput", new SingleUserInput());
        return "lib";
    }

    @PostMapping("/lib") public String postLibrary(@ModelAttribute SingleUserInput singleUserInput, Model model){
        model.addAttribute("writers", library.showWriters());
        model.addAttribute("articles", library.showArticles());
        System.out.println(library.generateResult(singleUserInput.getInput()));
        model.addAttribute("result", library.generateResult(singleUserInput.getInput()));
       return "lib";
    }
}
