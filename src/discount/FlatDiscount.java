package discount;

public class FlatDiscount implements Discount{
    private float flatAmt;
    private int threshold;

    public FlatDiscount(float flatAmt,int threshold){
        this.flatAmt=flatAmt;
        this.threshold=threshold;
    }

    @Override
    public float calculateDiscount(float totalAmt) {
        if(totalAmt>threshold)
            return flatAmt;
        return 0f;

    }
}
