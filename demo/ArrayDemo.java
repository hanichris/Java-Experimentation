package demo;
public class ArrayDemo {
    public static void main(String[] args) {
        byte[] anArray = new byte[10];

        byte count = 0;

        for (int i = 0; i < anArray.length; i++, count++) {
            anArray[i] = count;
        }
        for (int i = 0; i < anArray.length; i++) {
            System.out.println("Element at index " + i + ": " + anArray[i]);
        }
    }
}
