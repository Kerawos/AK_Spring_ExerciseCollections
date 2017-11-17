package pl.akademiakodu.AK_Spring_ExerciseCollections.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.AK_Spring_ExerciseCollections.modells.Market;
import pl.akademiakodu.AK_Spring_ExerciseCollections.modells.entities.UserInput;

@Controller
public class MarketController {

    private Market market = new Market();

    @GetMapping("/mar") public String marketGet(Model key, Model value){
        key.addAttribute("userInputKey", new UserInput());
        value.addAttribute("userInputValue", new UserInput());
        return "market";
    }

    @PostMapping("/mar") public String marketPost(@ModelAttribute UserInput userInputKey,
                                                  @ModelAttribute UserInput userInputValue, Model model){
        model.addAttribute("shopList", market.showShopList());
        return "market";
    }
}
