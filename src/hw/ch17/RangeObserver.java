package hw.ch17;

public class RangeObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        int number = generator.getNumber();
        String label = "";

        // 값의 범위에 따른 레이블 판별
        if (number >= 0 && number < 10) {
            label = "Low";
        } else if (number >= 10 && number < 20) {
            label = "Mid";
        } else if (number >= 20) {
            label = "High";
        }

        System.out.println("RangeObserver: [" + label + "] " + number);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}