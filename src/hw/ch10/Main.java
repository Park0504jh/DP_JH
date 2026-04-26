package hw.ch10;

public class Main {
    public static void main(String[] args) {
        // 1. CyclicStrategy 단독 순환 테스트 
        System.out.println("===== CyclicStrategy 의 손가락 순환 =====");
        Strategy cyclic = new CyclicStrategy();
        for (int i = 0; i < 9; i++) {
            Hand hand = cyclic.nextHand();
            System.out.println((i + 1) + "번째: " + hand);
            cyclic.study(false); 
        }

        // 2. 두 플레이어 간의 게임 진행 (10번) 
        System.out.println("\n===== Game Start: Random vs Cyclic =====");
        Player player1 = new Player("Taro", new RandomStrategy(314)); // Seed 값 임의 설정
        Player player2 = new Player("Bob", new CyclicStrategy());

        for (int i = 0; i < 10; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            
            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner: " + player1);
                player1.win();
                player2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Winner: " + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }

        System.out.println("\nTotal result:");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }
}