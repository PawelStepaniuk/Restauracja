package pl.pawel.Restaurant.models.services.dao;

/**
 * Imports section
 */
import org.springframework.stereotype.Service;
import pl.pawel.Restaurant.models.Meal;
import pl.pawel.Restaurant.models.OrderR;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for order logic
 */
@Service
public class OrderDaoImpl implements OrderDao {


    private List<OrderR> orderList;


    public OrderDaoImpl() {
        orderList = new ArrayList<>();
    }

    @Override
    public List<OrderR> getAllOrders() {
        return orderList;
    }

    @Override
    public void addOrder(OrderR order) {
        orderList.add(order);
    }

    @Override
    public void removeOrder(OrderR order) {
        for (OrderR order1 : orderList) {
            if (order1.equals(order)){
                orderList.remove(order);
                break;
            }
        }
    }

    @Override
    public void addMealToOrder(OrderR order, Meal meal) {

        List<Meal> ourMeals = order.getMealList();
        ourMeals.add(meal);
        order.setMealList(ourMeals);
    }

    @Override
    public void removeMealFromOrder(OrderR order, Meal meal) {
        List<Meal> ourMeals = order.getMealList();
        ourMeals.remove(meal);
        order.setMealList(ourMeals);
    }

    @Override
    public boolean checkIfMealAppearInOurOrder(OrderR order, Meal meal){
        for (int i = 0; i < order.getMealList().size(); i++) {
            if (order.getMealList().get(i).equals(meal)){
                return true;
            }
        }
        return false;
    }
}
