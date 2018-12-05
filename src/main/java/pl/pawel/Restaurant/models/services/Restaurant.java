package pl.pawel.Restaurant.models.services;


import org.springframework.stereotype.Service;
import pl.pawel.Restaurant.models.Meal;
import pl.pawel.Restaurant.models.MealDatabase;
import pl.pawel.Restaurant.models.OrderR;

import java.util.List;


@Service
public class Restaurant {


    private List<Meal> menu = new MealDatabase().getMeals();


    public boolean checkIfMealExist(String mealName){
        for (Meal meal : menu) {
            if (mealName.equals(meal.getName())){
                return true;
            }
        }
        return false;
    }

    /**
     * Method calculate total price of order. Count every meal in order list
     * @param orderR user wish list
     * @return total price for order
     */
    public int calculateOrderPrice(OrderR orderR){
        int sum = 0;
        for (int i = 0; i < orderR.getMealList().size(); i++) {
           sum+= orderR.getMealList().get(i).getPrice();
        }
        return sum;
    }



    public Meal getMeal(String mealName){
        for (int i = 0; i < menu.size(); i++) {
            if(menu.get(i).getName().equals(mealName)){
                return menu.get(i);
            }
        }
        return null;
    }

    public List<Meal> getMenu() {
        return menu;
    }
}
