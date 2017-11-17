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

    public String showShopList(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Enum, Integer> element : shopList.entrySet()){
            sb.append("Item: " + element.getKey() + " = " + element.getValue() + "pcs; *** ");
        }
        return sb.toString();
    }

    public int calculatePrice(){
        int sum = 0;
        for(Map.Entry<Enum, Integer> element : shopList.entrySet()){
            sum+=element.getValue() * element.getKey().toString().length();
        }
        return sum;
    }

}
