import java.util.List;

public class LabExample {
    public static double sumOfPricesGreaterThan(List<Double> prices, Double value){ //1
        if(prices == null || prices.isEmpty()) //2
            throw new RuntimeException("List of prices is not ok"); //3
        double sum = 0; //4
        for(int i=0;i<prices.size();i++){ //5
            if(prices.get(i) < 0) //6
                throw new RuntimeException("Negative price is not allowed"); //7
            if(prices.get(i) > value) //8
                sum += prices.get(i); //9
        } //10
        return sum; //11
    } //12
}
