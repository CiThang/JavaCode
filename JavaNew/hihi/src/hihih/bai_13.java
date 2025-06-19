package hihih;

public class bai_13 {
    public static void main(String[] args) {
        int height = 6; 

     
        for (int i = height; i >= 3; i--) {
           
            for (int j = 0; j < height - i; j++) {
                System.out.print("  ");
            }
    
            for (int j = 1; j <= (i * 2) - 1; j++) {
                System.out.print("* ");
            }
            System.out.println(); 
        }


        for (int i = 4; i <= height; i++) {
           
            for (int j = 0; j < height - i; j++) {
                System.out.print("  ");
            }
        
            for (int j = 1; j <= (i * 2) - 1; j++) {
                System.out.print("* ");
            }
            System.out.println(); 
        }
    }
}
