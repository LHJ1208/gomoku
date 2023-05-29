package com.ict.test.gomoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gomoku_Frame extends JFrame implements ActionListener {
	Gomoku myGomoku;
	int winner = 0;
	boolean gomoku = false;
	boolean boardFull = false;
	int curTurn = 0;

	int xFocus = 0, yFocus = 0;

	JPanel main, menu;
	JPanel[][] board;

	JButton[][] btArr;

	JButton undo;
	JButton reset;
	JButton exit;

	JLabel jlGomoku = new JLabel("Gomoku", JLabel.CENTER);
	JLabel jlFull = new JLabel("Full", JLabel.CENTER);

	final static int btSize = 70; // 버튼 사이즈
	final static Color emptyColor = new Color(180, 90, 0);
	final static Color blackColor = Color.BLACK;
	final static Color whiteColor = Color.WHITE;
	final static Color actionColor = new Color(184, 207, 229);

	// 이미지 아이콘 만들기
	int stoneSize = (int) (btSize * 0.9);
	ImageIcon blackStoneOrigin = new ImageIcon("src/com/ict/test/gomoku/images/black.png");
	ImageIcon whiteStoneOrigin = new ImageIcon("src/com/ict/test/gomoku/images/white.png");
	Image blackOriginImage = blackStoneOrigin.getImage();
	Image blackImage = blackOriginImage.getScaledInstance(stoneSize, stoneSize, Image.SCALE_SMOOTH);
	Image whiteOriginImage = whiteStoneOrigin.getImage();
	Image whiteImage = whiteOriginImage.getScaledInstance(stoneSize, stoneSize, Image.SCALE_SMOOTH);
	ImageIcon blackStone = new ImageIcon(blackImage);
	ImageIcon whiteStone = new ImageIcon(whiteImage);

	Dimension ds = new Dimension(btSize, btSize);
	Rectangle panelSize = new Rectangle(btSize, btSize);

	arrowkeysKeyAdapter keyAdapter = new arrowkeysKeyAdapter();

	public Gomoku_Frame() {
		super("Gomoku");

		main = new JPanel(new GridLayout(Gomoku.VERTICAL_SIZE, Gomoku.HORIZONTAL_SIZE));

		board = new JPanel[Gomoku.VERTICAL_SIZE][Gomoku.HORIZONTAL_SIZE];

		btArr = new JButton[Gomoku.VERTICAL_SIZE][Gomoku.HORIZONTAL_SIZE];

		for (int i = 0; i < btArr.length; i++) {
			for (int j = 0; j < btArr[i].length; j++) {
				board[i][j] = new JPanel(new BorderLayout());
				board[i][j].setBounds(panelSize);
				board[i][j].setBackground(blackColor);
				main.add(board[i][j]);
			}
		}

		reset();

		menu = new JPanel();
		undo = new JButton("Undo");
		reset = new JButton("Reset");
		exit = new JButton("Exit");

		undo.setMnemonic(KeyEvent.VK_U);
		reset.setMnemonic(KeyEvent.VK_R);
		exit.setMnemonic(KeyEvent.VK_E);

		menu.add(undo);
		menu.add(reset);
		menu.add(exit);

		add(main, BorderLayout.CENTER);
		add(menu, BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

		btArr[0][0].requestFocusInWindow();

		undo.addActionListener(new undoActionListener());

		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reset();
			}
		});

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}

	public void addBtnToPanel(JButton[][] bArr, JPanel[][] pArr, int x, int y) {
		pArr[y][x].removeAll();
		bArr[y][x] = new JButton();
		bArr[y][x].setName(x + "," + y);
		bArr[y][x].setPreferredSize(ds);
		bArr[y][x].setBackground(emptyColor);
		bArr[y][x].addActionListener(Gomoku_Frame.this);
		pArr[y][x].add(btArr[y][x]);
		bArr[y][x].addKeyListener(keyAdapter);
	}

	public class undoActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Point prev = myGomoku.popPutList();

			if (prev != null) {
				int x = prev.x;
				int y = prev.y;

				addBtnToPanel(btArr, board, x, y);

				if (curTurn == Gomoku.STATE_BLACK) {
					curTurn = Gomoku.STATE_WHITE;
				} else if (curTurn == Gomoku.STATE_WHITE) {
					curTurn = Gomoku.STATE_BLACK;
				}

				yFocus = y;
				xFocus = x;
				btArr[yFocus][xFocus].requestFocusInWindow();
				setVisible(true);
			}
		}
	}

	public class arrowkeysKeyAdapter extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();

			switch (key) {
			case KeyEvent.VK_UP: {
				if (yFocus > 0) {
					btArr[yFocus][xFocus].setBackground(emptyColor);
					yFocus -= 1;
				}
				break;
			}
			case KeyEvent.VK_DOWN: {
				if (yFocus < btArr.length - 1) {
					btArr[yFocus][xFocus].setBackground(emptyColor);
					yFocus += 1;
				}
				break;
			}
			case KeyEvent.VK_LEFT: {
				if (xFocus > 0) {
					btArr[yFocus][xFocus].setBackground(emptyColor);
					xFocus -= 1;
				}
				break;
			}
			case KeyEvent.VK_RIGHT: {
				if (xFocus < btArr[yFocus].length - 1) {
					btArr[yFocus][xFocus].setBackground(emptyColor);
					xFocus += 1;
				}
				break;
			}
			}

			switch (key) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_RIGHT:
				JButton curBtn = (JButton) board[yFocus][xFocus].getComponent(0);
				btArr[yFocus][xFocus].setBackground(actionColor);
				curBtn.requestFocusInWindow();
				setVisible(true);
			}
		}
	}

	public void reset() {
		myGomoku = new Gomoku();
		winner = Gomoku.STATE_EMPTY;
		gomoku = false;
		boardFull = false;
		curTurn = Gomoku.STATE_BLACK;

		for (int i = 0; i < btArr.length; i++) {
			for (int j = 0; j < btArr[i].length; j++) {
				addBtnToPanel(btArr, board, j, i);
			}
		}

		remove(jlGomoku);
		remove(jlFull);

		btArr[yFocus][xFocus].setBackground(emptyColor);
		xFocus = 0;
		yFocus = 0;
		btArr[0][0].setBackground(actionColor);
		btArr[0][0].requestFocusInWindow();

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton obj = (JButton) e.getSource();
		String[] strXY = new String[2];
		strXY = obj.getName().split(",");
		int x = Integer.parseInt(strXY[0]);
		int y = Integer.parseInt(strXY[1]);

		if (!gomoku && myGomoku.pushPutList(x, y, curTurn)) {
			board[y][x].removeAll();
			if (curTurn == Gomoku.STATE_BLACK) {
				obj = new JButton(blackStone);
			} else if (curTurn == Gomoku.STATE_WHITE) {
				obj = new JButton(whiteStone);
			}
			obj.setPreferredSize(ds);
			obj.setBackground(emptyColor);
			board[y][x].add(obj);
			obj.addKeyListener(keyAdapter);
			btArr[yFocus][xFocus].setBackground(emptyColor);
			yFocus = y;
			xFocus = x;
			btArr[yFocus][xFocus].setBackground(actionColor);
			obj.requestFocusInWindow();
			setVisible(true);

			gomoku = myGomoku.checkGomoku(x, y, curTurn);

			if (!gomoku) {
				if (curTurn == Gomoku.STATE_BLACK) {
					curTurn = Gomoku.STATE_WHITE;
				} else if (curTurn == Gomoku.STATE_WHITE) {
					curTurn = Gomoku.STATE_BLACK;
				}

			} else {
				winner = curTurn;
				add(jlGomoku, BorderLayout.NORTH);
				setVisible(true);
			}

			if (boardFull = myGomoku.isFull()) {
				add(jlFull, BorderLayout.NORTH);
				setVisible(true);
			}
		}
	}
}