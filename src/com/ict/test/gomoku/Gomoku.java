package com.ict.test.gomoku;

import java.util.Arrays;
import java.util.Iterator;

public class Gomoku {
	static final int HORIZONTAL_SIZE = 10;
	static final int VERTICAL_SIZE = 10;

	static final int STATE_EMPTY = 0; // default
	static final int STATE_BLACK = 1;
	static final int STATE_WHITE = 2;

	static final int COUNT_GOMOKU = 5;

	int[][] map;

	public Gomoku() {
		map = new int[VERTICAL_SIZE][HORIZONTAL_SIZE];

//		//map 0으로 초기화
//		for (int i = 0; i < map.length; i++) {
//			Arrays.fill(map[i], STATE_EMPTY);
//		}

		// map 0으로 초기화
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = STATE_EMPTY;
			}
		}
	}

	public int[][] getMap() {
		return map;
	}

	boolean isInBound(int x, int y) {
		boolean result = true;

		// 행렬 주의!
		if (y < 0 || y >= VERTICAL_SIZE || x < 0 || x >= HORIZONTAL_SIZE) {
			result = false;
		}

		return result;
	}

	boolean isFull() {
		boolean result = true;

		for (int i = 0; i < map.length && result; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == STATE_EMPTY) {
					result = false;
					break;
				}
			}
		}

		return result;
	}

	boolean isEmpty(int x, int y) {
		boolean result = true;

		result = isState(x, y, STATE_EMPTY);

		return result;
	}

	boolean isState(int x, int y, int stateNum) {
		boolean result = true;

		result = isInBound(x, y);

		if (result) {
			if (map[y][x] != stateNum) { // 행렬 주의!
				result = false;
			}
		}

		return result;
	}

	boolean setState(int x, int y, int stateNum) {
		boolean result = true;

		result = isEmpty(x, y);

		if (result) {
			switch (stateNum) {
			case STATE_EMPTY:
			case STATE_BLACK:
			case STATE_WHITE:
				map[y][x] = stateNum;
				break;
			default:
				map[y][x] = STATE_EMPTY;
			}
		}

		return result;
	}

	// 오목확인
	boolean checkGomoku(int x, int y, int stoneColor) {
		boolean result = false;

		if (isState(x, y, stoneColor)) {
			if (COUNT_GOMOKU == 1 + checkGomoku4(x - 1, y, stoneColor, 0) + checkGomoku6(x + 1, y, stoneColor, 0))
				result = true;
			else if (COUNT_GOMOKU == 1 + checkGomoku7(x - 1, y - 1, stoneColor, 0)
					+ checkGomoku3(x + 1, y + 1, stoneColor, 0))
				result = true;
			else if (COUNT_GOMOKU == 1 + checkGomoku8(x, y - 1, stoneColor, 0) + checkGomoku2(x, y + 1, stoneColor, 0))
				result = true;
			else if (COUNT_GOMOKU == 1 + checkGomoku9(x + 1, y - 1, stoneColor, 0)
					+ checkGomoku1(x - 1, y + 1, stoneColor, 0))
				result = true;
		}

		return result;
	}

	// ←방향 확인
	int checkGomoku4(int x, int y, int stoneColor, int repNum) {
		int result = repNum;

		if (repNum >= COUNT_GOMOKU) {
			result *= -1;
		} else if (repNum > -1) {
			if (isState(x, y, stoneColor)) {
				result = checkGomoku4(x - 1, y, stoneColor, repNum + 1);
			}
		}

		return result;
	}

	// ↖방향 확인
	int checkGomoku7(int x, int y, int stoneColor, int repNum) {
		int result = repNum;

		if (repNum >= COUNT_GOMOKU) {
			result *= -1;
		} else if (repNum > -1) {
			if (isState(x, y, stoneColor)) {
				result = checkGomoku7(x - 1, y - 1, stoneColor, repNum + 1);
			}
		}

		return result;
	}

	// ↑방향 확인
	int checkGomoku8(int x, int y, int stoneColor, int repNum) {
		int result = repNum;

		if (repNum >= COUNT_GOMOKU) {
			result *= -1;
		} else if (repNum > -1) {
			if (isState(x, y, stoneColor)) {
				result = checkGomoku8(x, y - 1, stoneColor, repNum + 1);
			}
		}

		return result;
	}

	// ↗방향 확인
	int checkGomoku9(int x, int y, int stoneColor, int repNum) {
		int result = repNum;

		if (repNum >= COUNT_GOMOKU) {
			result *= -1;
		} else if (repNum > -1) {
			if (isState(x, y, stoneColor)) {
				result = checkGomoku9(x + 1, y - 1, stoneColor, repNum + 1);
			}
		}
		return result;
	}

	// →방향 확인
	int checkGomoku6(int x, int y, int stoneColor, int repNum) {
		int result = repNum;

		if (repNum >= COUNT_GOMOKU) {
			result *= -1;
		} else if (repNum > -1) {
			if (isState(x, y, stoneColor)) {
				result = checkGomoku6(x + 1, y, stoneColor, repNum + 1);
			}
		}

		return result;
	}

	// ↘방향 확인
	int checkGomoku3(int x, int y, int stoneColor, int repNum) {
		int result = repNum;

		if (repNum >= COUNT_GOMOKU) {
			result *= -1;
		} else if (repNum > -1) {
			if (isState(x, y, stoneColor)) {
				result = checkGomoku3(x + 1, y + 1, stoneColor, repNum + 1);
			}
		}

		return result;
	}

	// ↓방향 확인
	int checkGomoku2(int x, int y, int stoneColor, int repNum) {
		int result = repNum;

		if (repNum >= COUNT_GOMOKU) {
			result *= -1;
		} else if (repNum > -1) {
			if (isState(x, y, stoneColor)) {
				result = checkGomoku2(x, y + 1, stoneColor, repNum + 1);
			}
		}

		return result;
	}

	// ↙방향 확인
	int checkGomoku1(int x, int y, int stoneColor, int repNum) {
		int result = repNum;

		if (repNum >= COUNT_GOMOKU) {
			result *= -1;
		} else if (repNum > -1) {
			if (isState(x, y, stoneColor)) {
				result = checkGomoku1(x - 1, y + 1, stoneColor, repNum + 1);
			}
		}

		return result;
	}
}
