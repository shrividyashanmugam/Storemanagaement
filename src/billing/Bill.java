package billing;

import discount.Discount;

import java.time.LocalDateTime;
import java.util.Map;

public class Bill {
    private static int lastBillNumber=1000;
    private int billId;
    private float totalAmt;
    private Discount discount;
    private Map<Integer,Integer> cartItems;
    private ProductList products;
    private String billStr;

    public Bill(Map<Integer, Integer> cartItems,ProductList products,Discount discount) {
        this.billId=lastBillNumber;
        this.cartItems = cartItems;
        this.products= products;
        this.discount=discount;
        this.billStr="";
        lastBillNumber++;
    }
    public Bill(Map<Integer, Integer> cartItems,ProductList products){
        this.billId=lastBillNumber;
        this.cartItems = cartItems;
        this.products= products;
        this.discount=null;
        this.billStr="";
        lastBillNumber++;
    }

    public float getTotalAmt() {
        return totalAmt;
    }

    public  void calculateTotal() {
        int total=0;
        for(int i : cartItems.keySet()){
            Product p=products.getProductById(i);
            total+=p.getPrice()*cartItems.get(i);
        }
        this.totalAmt=total;
    }
    private float getDiscount(){
        try {
            return this.discount.calculateDiscount(this.totalAmt);
        }
        catch (NullPointerException e){
            return 0f;
        }
    }
    public void printBill(){
        if(this.billStr.equals(""))
            this.generateBillStr();
        FileGenerator fg=new FileGenerator(this.billStr);
        fg.generate("bill"+billId);
    }

    public String generateBillStr(){
        this.calculateTotal();
        this.billStr="";
        this.billStr+="\n+-----------------------------+";
        this.billStr+="\n+        SARAVANA STORES     +";
        this.billStr+="\n+-----------------------------+";
        this.billStr+="\nT-Nagar, Chennai-600028";
        this.billStr+="\nbillNo : "+this.billId;
        this.billStr+="\nDate : "+LocalDateTime.now();
        this.billStr+="\n+-----------------------------+";
        this.billStr+="\nItem | Price | Qty | subtotal";
        this.billStr+="\n+-----------------------------+";
        for(int i : cartItems.keySet()) {
            Product p = products.getProductById(i);
            this.billStr+="\n " +p.getName()
                    +" | "+p.getPrice()
                    +" | "+cartItems.get(i)
                    +" | "+p.getPrice()*cartItems.get(i);
        }
        this.billStr+="\n+-----------------------------+";
        this.billStr+="\nTotal : "+this.totalAmt;
        this.billStr+= "\nDiscount : "+this.getDiscount();
        this.billStr+="\n+-----------------------------+";
        this.billStr+="\nGrand Total:"+
                (this.totalAmt-this.getDiscount());
        this.billStr+="\n+-----------------------------+";

        return this.billStr;
    }


}
