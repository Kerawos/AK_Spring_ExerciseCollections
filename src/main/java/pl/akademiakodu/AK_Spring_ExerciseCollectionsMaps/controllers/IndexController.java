package pl.akademiakodu.AK_Spring_ExerciseCollectionsMaps.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/") public String indexGet(){
        return "index";
    }

}