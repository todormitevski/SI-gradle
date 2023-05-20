public class Calculator {
    public double divide(double a, double b){
        if(b == 0)
            throw new RuntimeException("Cannot divide by zero!");
        return a/b;
    }

    public int calculateTotalInterval(int from, int to){
        int total = 0;
        for(int i=from;i<to;i++){
            total += i;
        }
        return total;
    }
}
