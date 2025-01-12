import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SudokuGame game = new SudokuGame();
        Scanner scanner = new Scanner(System.in);

        // Vòng lặp chính
        while (!game.isWin()) {
            game.displayBoard();
            System.out.print("Nhập hàng, cột, và số (hoặc nhập 0 để thoát): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int num = scanner.nextInt();

            if (row == 0 || col == 0 || num == 0) {
                System.out.println("Thoát game. Cảm ơn đã chơi!");
                break;
            }

            if (game.makeMove(row - 1, col - 1, num)) {
                System.out.println("Nước đi hợp lệ!");
            } else {
                System.out.println("Nước đi không hợp lệ. Hãy thử lại.");
            }
        }

        if (game.isWin()) {
            System.out.println("Chúc mừng, bạn đã chiến thắng!");
        }

        scanner.close();
    }
}