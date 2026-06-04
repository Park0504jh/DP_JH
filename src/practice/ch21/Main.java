package practice.ch21;

public class Main {
    public static void main(String[] args) {

        // 본인 생성 -> 시간 오래 걸림
        Printable p1 = new Printer("Alice");
        System.out.println("이름은 현재 " + p1.getPrinterName() + "입니다.");
        p1.setPrinterName("Bob");   

        // 프록시를 이용해 생성 -> 시간 오래 걸리지 않음
        Printable p2 = new PrinterProxy("Charlie");
        System.out.println("이름은 현재 " + p2.getPrinterName() + "입니다.");
        p2.setPrinterName("David");
        System.out.println("이름은 현재 " + p2.getPrinterName() + "입니다.");
        p2.print("Hello, world.");
    }
}
