package hw.ch03;

public class Main {
    public static void main(String[] args) {
        //AbstractDisplay d1 = new CharDisplay('H');
        //AbstractDisplay d2 = new StringDisplay("Hello");
        //d1.display();
        //d2.display(); 


        //AbstractDisplay d1 = new CharDisplay('X', 3);     
        //AbstractDisplay d2 = new StringDisplay("Test", 7); 
        //d1.display();
        //d2.display(); 

        AbstractDisplay num = new NumberDisplay(42, 4); 
        num.display(); 
    }
}
