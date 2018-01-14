public class Tests {
    public static void main(String[] args) {
        int count = 6;
        while(count <= 10) {
            System.out.println("The value is " + count);
            count++;
        }

        count = 6;
        do {
            System.out.println("The value is " + count);
            count++;
        } while(count != 6);
    }
}
