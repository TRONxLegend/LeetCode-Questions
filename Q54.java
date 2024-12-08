import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // Top row
            for (int j = startCol; j <= endCol; j++) {
                result.add(matrix[startRow][j]);
            }

            // Right column
            for (int i = startRow + 1; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }

            // Bottom row (if still valid)
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break; // Avoid double-counting the single row
                }
                result.add(matrix[endRow][j]);
            }

            // Left column (if still valid) 
            for (int i = endRow - 1; i > startRow; i--) {
                if (startCol == endCol) {
                    break; // Avoid double-counting the single column
                }
                result.add(matrix[i][startCol]);
            }

            // Move towards the inner spiral
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return result;
    }
}