package billing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductList {
    List<Product> products;
    public ProductList(){
        products=new ArrayList<>();
    }
    public void addProduct( Product p) {
        products.add(p);
    }
    public Product getProductById(int id){
        for(Product p: products){
            if(p.getId()==id)
                return p;
        }
        return null;
    }
    public void displayProduct()
    {
        for(Product p: products){
            System.out.println(p);
        }
    }

    public boolean isValidCode(int id){
        for(Product p: products){
            if(p.getId()==id)
                return true;
        }
        return false;
    }

}
