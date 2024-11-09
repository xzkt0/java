package lab0;

public class Variant17 {

    public enum DAY_OF_WEEK {
        MONDAY, TUESDAY, WEDNESDAY
    }

    /**
     * Checks if the number is a positive odd three-digit number.
     * 
     * @param number the number to check
     * @return true if the number is a positive odd three-digit number, false otherwise
     */
    public boolean booleanTask17(int number) {
        return number > 99 && number < 1000 && number % 2 != 0; 
    }

    /**
     * Calculates the sum of the series: 1 + A + A^2 + A^3 + ... + A^N.
     * 
     * @param A the base value
     * @param N the number of terms (N > 0)
     * @return the sum of the series
     * @throws IllegalArgumentException if N <= 0
     */
    public double forTask17(double A, int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must be greater than 0");
        }
    
        double sum = 1.0; 
        double term = 1.0;
    
        for (int i = 1; i <= N; i++) {
            term *= A;  
            sum += term;
        }
    
        return sum;
    }
    
    /**
     * Computes the sum and product of elements in the K-th row of the matrix.
     * 
     * @param matrix the input matrix
     * @param K the row index (1-indexed)
     * @return an array containing the sum and product of the K-th row
     */
    public double[] matrixTask17(double[][] matrix, int K) {
        double sum = 0;
        double product = 1;
        for (double value : matrix[K - 1]) { // K is 1-indexed
            sum += value;
            product *= value;
        }
        return new double[] { sum, product };
    }

    /**
     * Reorders the array in alternating order, taking elements from the start
     * and the end of the array.
     * 
     * @param array the input array
     * @return the reordered array
     */
    public int[] arrayTask17(int[] array) {
        int N = array.length;
        int[] reordered = new int[N];
        int left = 0;
        int right = N - 1;

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                reordered[i] = array[left++];
            } else {
                reordered[i] = array[right--];
            }
        }
        return reordered;
    }

    /**
     * Converts a number into its string representation in Ukrainian.
     * 
     * @param number the number (in the range 10 to 40)
     * @return the string representation
     */
    public String caseTask17(int number) {
        String[] units = { "", "один", "два", "три", "чотири", "п’ять", "шість", "сім", "вісім", "дев’ять", "десять",
                           "одинадцять", "дванадцять", "тринадцять", "чотирнадцять", "п’ятнадцять", "шістнадцять", 
                           "сімнадцять", "вісімнадцять", "дев’ятнадцять", "двадцять", "двадцять один", "двадцять два",
                           "двадцять три", "двадцять чотири", "двадцять п’ять", "двадцять шість", "двадцять сім",
                           "двадцять вісім", "двадцять дев’ять", "тридцять", "тридцять один", "тридцять два",
                           "тридцять три", "тридцять чотири", "тридцять п’ять", "тридцять шість", "тридцять сім",
                           "тридцять вісім", "тридцять дев’ять", "сорок" };
    
        return units[number];
    }
    

    /**
     * Processes three numbers A, B, C according to the specified logic:
     * - If they are in increasing or decreasing order, multiply each by 2.
     * - Otherwise, negate the numbers.
     * 
     * @param A first number
     * @param B second number
     * @param C third number
     * @return the new values of A, B, C
     */
    public double[] ifTask17(double A, double B, double C) {
        if (A < B && B < C) {
            return new double[] { 2 * A, 2 * B, 2 * C };  
        } else if (A > B && B > C) {
            return new double[] { 2 * A, 2 * B, 2 * C }; 
        } else {
            return new double[] { -A, -B, -C };  
        }
    }

    /**
     * Extracts the hundreds digit from a number greater than 999.
     * 
     * @param number the number to process
     * @return the hundreds digit
     */
    public int integerTask17(int number) {
        return (number / 100) % 10; 
    }

    /**
     * Outputs all digits of a number in reverse order.
     * 
     * @param N the number to process (N > 0)
     * @return an array of digits in reverse order
     */
    public int[] whileTask17(int N) {
        java.util.List<Integer> digitsList = new java.util.ArrayList<>();
        
      
        while (N > 0) {
            digitsList.add(N % 10);  
            N /= 10;  
        }
        
        // Convert list to array
        int[] digits = new int[digitsList.size()];
        for (int i = 0; i < digitsList.size(); i++) {
            digits[i] = digitsList.get(i);
        }
    
        return digits;
    }

    public static void main(String... args) {
        System.out.println("Start of Variant 17 lab");
        System.out.println("Done!!!");
    }
}
