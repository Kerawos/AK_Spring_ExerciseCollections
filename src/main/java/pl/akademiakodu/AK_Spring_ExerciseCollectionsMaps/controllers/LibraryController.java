package pl.akademiakodu.AK_Spring_ExerciseCollectionsMaps.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.AK_Spring_ExerciseCollectionsMaps.modells.Library;
import pl.akademiakodu.AK_Spring_ExerciseCollectionsMaps.modells.entities.UserInput;

@Controller
public class LibraryController {

    private Library library = new Library();

    @GetMapping("/lib") public String getLib(Model model){
        model.addAttribute("writers", library.showWriters());
        model.addAttribute("articles", library.showArticles());
        model.addAttribute("userInput", new UserInput());
        return "lib";
    }

    @PostMapping("/lib") public String postLibrary(@ModelAttribute UserInput userInput, Model model){
        model.addAttribute("writers", library.showWriters());
        model.addAttribute("articles", library.showArticles());
        model.addAttribute("result", library.generateResult(userInput.getInput()));
       return "lib";
    }
}