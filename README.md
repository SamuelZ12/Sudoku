# Java Sudoku Solver

This Java program solves standard 9x9 Sudoku puzzles using a backtracking algorithm.

## Description

The program reads a 9x9 Sudoku grid from the standard input, where numbers 1-9 represent filled cells and the character '.' represents empty cells. It then attempts to find a valid solution to the puzzle and prints the solved grid to the standard output in a formatted manner.

## Algorithm

The solver employs a recursive **backtracking** approach:
1.  It scans the grid to find the next empty cell ('.').
2.  If no empty cells are found, the puzzle is solved.
3.  If an empty cell is found, it tries placing numbers from 1 to 9 in that cell.
4.  For each number, it checks if placing it violates Sudoku rules (unique in row, column, and 3x3 subgrid).
5.  If the placement is valid, it recursively calls the solver function for the next empty cell.
6.  If the recursive call returns successfully (meaning a solution was found), the current placement was correct, and the success propagates back up.
7.  If the recursive call fails (meaning the current placement led to a dead end), the program **backtracks**: it resets the cell to '.' and tries the next number.
8.  If all numbers 1-9 have been tried for a cell and none led to a solution, the function returns failure, triggering backtracking in the previous step.

## Requirements

* Java Development Kit (JDK) installed (e.g., version 8 or later).

## How to Compile and Run

1.  **Save:** Save the code as `Sudoku.java`.
2.  **Compile:** Open a terminal or command prompt, navigate to the directory where you saved the file, and compile it:
    ```bash
    javac Sudoku.java
    ```
3.  **Prepare Input:** Create a text file (e.g., `puzzle.txt`) containing the Sudoku puzzle. It must have exactly 9 lines, each with 9 characters. Use digits '1' through '9' for filled cells and '.' for empty cells.

    *Example `puzzle.txt`:*
    ```
    53..7....
    6..195...
    .98....6.
    8...6...3
    4..8.3..1
    7...2...6
    .6....28.
    ...419..5
    ....8..79
    ```

4.  **Run:** Execute the compiled code, redirecting the input from your puzzle file:
    ```bash
    java Sudoku < puzzle.txt
    ```
    Alternatively, you can run `java Sudoku` and paste the 9 lines directly into the terminal, followed by an end-of-file signal (Ctrl+D on Linux/macOS, Ctrl+Z then Enter on Windows).

## Output Format

The program will print the solved Sudoku grid to the console, formatted with separators for clarity:

```
+-------+-------+-------+
| 5 3 4 | 6 7 8 | 9 1 2 |
| 6 7 2 | 1 9 5 | 3 4 8 |
| 1 9 8 | 3 4 2 | 5 6 7 |
+-------+-------+-------+
| 8 5 9 | 7 6 1 | 4 2 3 |
| 4 2 6 | 8 5 3 | 7 9 1 |
| 7 1 3 | 9 2 4 | 8 5 6 |
+-------+-------+-------+
| 9 6 1 | 5 3 7 | 2 8 4 |
| 2 8 7 | 4 1 9 | 6 3 5 |
| 3 4 5 | 2 8 6 | 1 7 9 |
+-------+-------+-------+
```

## Code Structure

* **`Sudoku.java`**: Main class containing all logic.
* **`map[][]`**: A `char[9][9]` array holding the Sudoku grid state.
* **`main()`**: Reads input, calls `solve()`, and prints the formatted output.
* **`solve()`**: The recursive backtracking function.
* **`isValid()`**: Helper function to check if placing a number in a cell is valid according to Sudoku rules.
