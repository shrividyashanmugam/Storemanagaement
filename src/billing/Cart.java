package billing;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Integer,Integer> cartItems;

    public Cart(){
        cartItems=new HashMap<Integer,Integer>();
    }

    public void addItem(int productCode,int qty){
        cartItems.put(productCode,qty);
    }

    public void removeItem(int productCode){
        cartItems.remove(productCode);
    }

    public Map<Integer, Integer> getCartItems() {
        return cartItems;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartItems=" + cartItems +
                '}';
    }
}
