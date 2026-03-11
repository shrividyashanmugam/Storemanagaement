package discount;

public class PercentageDiscount implements Discount {
    private float percent;

    public PercentageDiscount(float percent){
        this.percent=percent;
    }
    @Override
    public float calculateDiscount(float totalAmt) {
        return (totalAmt*this.percent)/100;
    }
}