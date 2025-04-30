import java.util.*;
import java.io.*;

public class Sudoku {
	static int size = 9;
	static char[][] map = new char[size][size];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int r = 0; r < size; r++) {
			map[r] = br.readLine().toCharArray();
		}
		solve();
		System.out.println("+-------+-------+-------+");
		for (int r = 0; r < size; r++) {
			System.out.print("| ");
			for (int c = 0; c < size; c++) {
				System.out.print(map[r][c] + " ");
				if ((c + 1) % 3 == 0) {
					System.out.print("| ");
				}
			}
			System.out.println();
			if ((r + 1) % 3 == 0) {
				System.out.println("+-------+-------+-------+");
			}
		}
	}

	static boolean solve() {
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (map[r][c] == '.') {
					for (int n = 1; n <= size; n++) {
						if (isValid(r, c, n)) {
							map[r][c] = (char) (n + '0');
							if (solve()) {
								return true;
							} else {
								map[r][c] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	static boolean isValid(int r, int c, int k) {
		if (map[r][c] != '.') {
			return false;
		}
		for (int i = 0; i < size; i++) {
			if (map[r][i] == (char) (k + '0')) {
				return false;
			}
			if (map[i][c] == (char) (k + '0')) {
				return false;
			}
		}
		for (int i = r - r % 3; i < r - r % 3 + 3; i++) {
			for (int j = c - c % 3; j < c - c % 3 + 3; j++) {
				if (map[i][j] == (char) (k + '0')) {
					return false;
				}
			}
		}
		return true;
	}
}
