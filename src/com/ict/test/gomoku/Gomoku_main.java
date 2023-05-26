package com.ict.test.gomoku;

import java.util.HashMap;
import java.util.Scanner;

public class Gomoku_main {
	public static void main(String[] args) {
		new Gomoku_Frame();
		/*
		 * Scanner scan = new Scanner(System.in);
		 * 
		 * int inputX = 0; int inputY = 0;
		 * 
		 * int curTurn = 0;
		 * 
		 * boolean boardFull = false;
		 * 
		 * final int stateEmpty = Gomoku.STATE_EMPTY; final int stateBlack =
		 * Gomoku.STATE_BLACK; final int stateWhite = Gomoku.STATE_WHITE;
		 * 
		 * Gomoku myGomoku = new Gomoku();
		 * 
		 * HashMap<Integer, String> myMatch = new HashMap<>(); //
		 * myMatch.put(Gomoku.STATE_EMPTY, "▢ "); // myMatch.put(Gomoku.STATE_BLACK,
		 * "★ "); // myMatch.put(Gomoku.STATE_WHITE, "☆ "); myMatch.put(stateEmpty,
		 * "  "); myMatch.put(stateBlack, "1 "); myMatch.put(stateWhite, "2 ");
		 * 
		 * curTurn = stateBlack; while (!boardFull) { // printMap(myGomoku.getMap(),
		 * myMatch); printMapWithNumber(myGomoku.getMap(), myMatch);
		 * System.out.println();
		 * 
		 * do { System.out.print("x y >> "); inputX = scan.nextInt(); inputY =
		 * scan.nextInt();
		 * 
		 * } while (!myGomoku.setState(inputX, inputY, curTurn));
		 * 
		 * // 오목 확인 if (myGomoku.checkGomoku(inputX, inputY, curTurn)) break;
		 * 
		 * if (curTurn == stateBlack) { curTurn = stateWhite; } else if (curTurn ==
		 * stateWhite) { curTurn = stateBlack; }
		 * 
		 * // 모든 곳이 꽉 찼는지 확인 boardFull = myGomoku.isFull(); }
		 * 
		 * System.out.println(); System.out.println("승부 결과"); System.out.println();
		 * 
		 * if (boardFull) { System.out.println("무승부"); } else {
		 * System.out.println("오목!"); } System.out.println();
		 * 
		 * printMapWithNumber(myGomoku.getMap(), myMatch);
		 */
	}

	public static void printMap(int[][] arrMap, HashMap<Integer, String> matchMap) {
		for (int i = 0; i < arrMap.length; i++) {
			for (int j = 0; j < arrMap[i].length; j++) {
				System.out.print(matchMap.get(arrMap[i][j]));
			}
			System.out.println();
		}
	}

	public static void printMapWithNumber(int[][] arrMap, HashMap<Integer, String> matchMap) {
		System.out.print("  ");

		for (int i = 0; i < arrMap[0].length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (int i = 0; i < arrMap.length; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < arrMap[i].length; j++) {
				System.out.print(matchMap.get(arrMap[i][j]));
			}
			System.out.println();
		}
	}
}
