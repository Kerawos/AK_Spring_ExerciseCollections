package pl.akademiakodu.AK_Spring_ExerciseCollections.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.AK_Spring_ExerciseCollections.modells.Market;
import pl.akademiakodu.AK_Spring_ExerciseCollections.modells.entities.UserInput;
import pl.akademiakodu.AK_Spring_ExerciseCollections.modells.entities.UserInput2;

@Controller
public class MarketController {

    private Market market = new Market();

    @GetMapping("/mar") public String marketGet(Model model){
        model.addAttribute("availableList", market.showAllItems());
        model.addAttribute("userInput2", new UserInput2());
        return "market";
    }

    @PostMapping("/mar") public String marketPost(@ModelAttribute UserInput2 userInput2, Model model){
        model.addAttribute("availableList", market.showAllItems());
        market.addItem(market.parseEnum(userInput2.getInputKey()), market.parseInt(userInput2.getInputValue()));
        model.addAttribute("shopList", market.showCurrentList());
        return "market";
    }
}
