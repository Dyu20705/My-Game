import java.util.*;

class SudokuGenerator {
    private static final int SIZE = 9;

    // Tạo bảng Sudoku đầy đủ
    public int[][] generateFullBoard() {
        int[][] board = new int[SIZE][SIZE];
        fillBoard(board);
        return board;
    }

    // Điền bảng Sudoku đầy đủ
    private boolean fillBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    List<Integer> numbers = getRandomNumbers(); // Xáo trộn số từ 1-9
                    for (int num : numbers) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (fillBoard(board)) {
                                return true;
                            }
                            board[row][col] = 0; // Hoàn tác nếu không hợp lệ
                        }
                    }
                    return false; // Không điền được số hợp lệ, quay lui
                }
            }
        }
        return true; // Hoàn thành bảng
    }

    // Kiểm tra số có hợp lệ không
    private boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    // Lấy danh sách số ngẫu nhiên từ 1 đến 9
    private List<Integer> getRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= SIZE; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    // Tạo bảng thử thách từ bảng đầy đủ
    public int[][] createChallenge(int[][] solution, int cellsToRemove) {
        int[][] challenge = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(solution[i], 0, challenge[i], 0, SIZE);
        }

        Random random = new Random();
        while (cellsToRemove > 0) {
            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);
            if (challenge[row][col] != 0) {
                challenge[row][col] = 0; // Xóa ô
                cellsToRemove--;
            }
        }
        return challenge;
    }
}
