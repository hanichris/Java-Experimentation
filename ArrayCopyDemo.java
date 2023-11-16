public class ArrayCopyDemo {
    
    public static void main(String[] args) {
        String[] copyFrom = {
            "Affogato", "Americano", "Cappuccino", "Corretto", "Cortado",   
            "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",      
            "Marocchino", "Ristretto"
        };

        // First approach of copying arrays from one destination to another.
        String[] copyTo = new String[7];
        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        for (String coffee : copyTo) {
            System.out.print(coffee + " ");
        }
        System.out.print("\n");
        
        // Second approach of copying arrays from one destination to another.
        String[] copyToV2 = java.util.Arrays.copyOfRange(copyFrom, 2, 9);
        for (String coffee : copyToV2) {
            System.out.print(coffee + " ");
        }
        System.out.print("\n");
    }
}
