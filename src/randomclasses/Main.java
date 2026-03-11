import billing.Bill;
import billing.Cart;
import billing.Product;
import billing.ProductList;
import discount.Discount;
import discount.PercentageDiscount;

import java.util.Scanner;


public class Main {
    public static ProductList createRepo(){
        Product paste=new Product("colgatepaste",20.0f,20);
        Product soap=new Product("hamamsoap",10.0f,20);
        Product dhal=new Product("udayam dhal",60.0f,1000);
        Product oil=new Product("idhayam oil",90.5f,1000);
        Product shampoo=new Product("himalaya shampoo",120.0f,100);

        ProductList productList= new ProductList();
        productList.addProduct(paste);
        productList.addProduct(soap);
        productList.addProduct(dhal);
        productList.addProduct(oil);
        productList.addProduct(shampoo);

        return productList;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        ProductList productList=createRepo();
        Cart cart1=new Cart();

        while(true){
            System.out.println("Enter product Id:");
            int prodId=scan.nextInt();
            System.out.println("Enter Quantity:");
            int qty=scan.nextInt();

            if(productList.isValidCode(prodId))
                cart1.addItem(prodId,qty);
            else
                System.out.println("Invalid code");

            System.out.println("Choose Generate bill (n) / Continue (y)");
            char repeat=scan.next().charAt(0);
            if (repeat=='n')
                break;
        }
        System.out.println(cart1);
        Discount d1=new PercentageDiscount(20);
        Bill b1=new Bill(cart1.getCartItems(),productList,d1);
        System.out.println(b1.generateBillStr());
        b1.printBill();



    }
}
