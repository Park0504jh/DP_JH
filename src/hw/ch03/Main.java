package hw.ch03;

public class Main {
    public static void main(String[] args) {
        //AbstractDisplay d1 = new CharDisplay('H');
        //d1.display();

        //AbstractDisplay d2 = new StringDisplay("Hello");
        //d2.display(); 


        //AbstractDisplay d1 = new CharDisplay('X', 3);   
        //d1.display();  

        //AbstractDisplay d2 = new StringDisplay("Test", 7); 
        //d2.display(); 


        // NumberDisplay 
        AbstractDisplay num = new NumberDisplay(42, 4); 
        num.display(); 
    }
}
