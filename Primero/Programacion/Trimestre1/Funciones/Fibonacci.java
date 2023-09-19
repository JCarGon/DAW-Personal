public class Fibonacci {

    public static int fibonacci(int n){
        if(n > 1){
            int res = fibonacci(n-1)+fibonacci(n-2);

            System.out.println(res);

            return res;
        }
        else if(n == 1){

            return 1;
        }
        else{ //caso base
            return 0;
        }
    }
    public static void main(String[] args) {
        
        System.out.println(fibonacci(5));
    }
}