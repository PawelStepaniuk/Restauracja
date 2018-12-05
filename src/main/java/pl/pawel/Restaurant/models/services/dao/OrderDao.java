package pl.pawel.Restaurant.models.services.dao;


import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.pawel.Restaurant.models.Meal;
import pl.pawel.Restaurant.models.OrderR;

import java.util.List;


@Repository
@Service
public interface OrderDao {

    List<OrderR> getAllOrders();


    void addOrder(OrderR order);


    void removeOrder(OrderR order);

    void addMealToOrder(OrderR order, Meal meal);

    void removeMealFromOrder(OrderR order, Meal meal);


    boolean checkIfMealAppearInOurOrder(OrderR order, Meal meal);
}