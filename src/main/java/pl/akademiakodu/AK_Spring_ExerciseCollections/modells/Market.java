package pl.akademiakodu.AK_Spring_ExerciseCollections.modells;

import java.util.HashMap;
import java.util.Map;

public class Market {

    public enum Item {POTATO, ONION, TOMATO, CUCUMBER, GARLIC, PEPER, APPLE, BREAD}
    public static HashMap<Enum, Integer> shopList;

    public Market() {
        shopList = new HashMap<>();
    }

    public void addItem(Item item, int qty){
        boolean isContain = false;
        for (Map.Entry<Enum, Integer> element : shopList.entrySet()){
            if (element.getKey()==item){
                element.setValue(element.getValue()+qty);
                isContain = true;
                break;
            }
        }
        if (!isContain){
            shopList.put(item, qty);
        }
    }


}
