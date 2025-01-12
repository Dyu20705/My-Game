class SudokuGame {
    private final int[][] solution;  // Bảng Sudoku đầy đủ
    private final int[][] challenge; // Bảng thử thách
    private static final int SIZE = 9;

    public SudokuGame() {
        SudokuGenerator generator = new SudokuGenerator();
        solution = generator.generateFullBoard(); // Tạo bảng đầy đủ
        challenge = generator.createChallenge(solution, 31); // Xóa các ô để tạo thử thách
    }

    // Hiển thị bảng thử thách
    public void displayBoard() {
        System.out.println("Bảng Sudoku hiện tại:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print((challenge[i][j] == 0 ? ". " : challenge[i][j] + " "));
            }
            System.out.println();
        }
    }

    // Kiểm tra và thực hiện nước đi
    public boolean makeMove(int row, int col, int num) {
        // Kiểm tra vị trí có thể điền và giá trị khớp với solution
        if (challenge[row][col] == 0 && solution[row][col] == num) {
            challenge[row][col] = num; // Điền giá trị vào bảng thử thách
            return true;
        }
        return false; // Nước đi không hợp lệ
    }

    // Kiểm tra xem người chơi đã hoàn thành bảng Sudoku hay chưa
    public boolean isWin() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (challenge[i][j] == 0) {
                    return false; // Vẫn còn ô trống
                }
            }
        }
        return true;
    }
}
