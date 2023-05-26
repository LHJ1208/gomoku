package com.ict.test.gomoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

	JButton reset;
	JButton exit;

	JLabel jlGomoku = new JLabel("Gomoku", JLabel.CENTER);
	JLabel jlFull = new JLabel("Full", JLabel.CENTER);

	final static int btSize = 70; // 버튼 사이즈
	final static Color emptyColor = new Color(180, 90, 0);
	final static Color blackColor = Color.BLACK;
	final static Color whiteColor = Color.WHITE;

	ImageIcon blackStoneOrigin = new ImageIcon("src/com/ict/test/gomoku/images/black.png");
	ImageIcon whiteStoneOrigin = new ImageIcon("src/com/ict/test/gomoku/images/white.png");
	Image blackOriginImage = blackStoneOrigin.getImage();
	Image blackImage = blackOriginImage.getScaledInstance(btSize, btSize, Image.SCALE_SMOOTH);
	Image whiteOriginImage = whiteStoneOrigin.getImage();
	Image whiteImage = whiteOriginImage.getScaledInstance(btSize, btSize, Image.SCALE_SMOOTH);
	ImageIcon blackStone = new ImageIcon(blackImage);
	ImageIcon whiteStone = new ImageIcon(whiteImage);

	Dimension ds = new Dimension(btSize, btSize);
	Rectangle panelSize = new Rectangle(btSize, btSize);

	arrowkeysKeyAdapter keyAdapter = new arrowkeysKeyAdapter();

	public Gomoku_Frame() {
		super("Gomoku");

		main = new JPanel(new GridLayout(Gomoku.HORIZONTAL_SIZE, Gomoku.VERTICAL_SIZE));

		board = new JPanel[Gomoku.VERTICAL_SIZE][Gomoku.HORIZONTAL_SIZE];

		btArr = new JButton[Gomoku.VERTICAL_SIZE][Gomoku.HORIZONTAL_SIZE];

		for (int i = 0; i < btArr.length; i++) {
			for (int j = 0; j < btArr[i].length; j++) {
				board[i][j] = new JPanel(new BorderLayout());
				board[i][j].setBounds(panelSize);
				main.add(board[i][j]);
			}
		}

		reset();

		menu = new JPanel();
		reset = new JButton("Reset");
		exit = new JButton("Exit");

		menu.add(reset);
		menu.add(exit);

		add(main, BorderLayout.CENTER);
		add(menu, BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		btArr[xFocus][yFocus].requestFocus();

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);

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

	public class arrowkeysKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			boolean isBtn = false;
			System.out.println("이벤트 발생주체: " + e.getComponent().getName());
			System.out.println("포커스 주인: " + getFocusOwner().getName());

			for (int i = 0; i < board.length && !isBtn; i++) {
				for (int j = 0; j < board.length; j++) {
					if (e.getSource() == (Object) btArr[i][j]) {
						isBtn = true;
						break;
					}
				}
			}

			if (isBtn) {
				int key = e.getKeyCode();
				switch (key) {
				case KeyEvent.VK_UP: {
					String[] strXY = new String[2];
					strXY = getFocusOwner().getName().split(",");
					int x = Integer.parseInt(strXY[0]);
					int y = Integer.parseInt(strXY[1]);

					if (y > 0) {
						btArr[x][y - 1].requestFocus();
					}

					break;
				}
				case KeyEvent.VK_DOWN: {
					String[] strXY = new String[2];
					strXY = getFocusOwner().getName().split(",");
					int x = Integer.parseInt(strXY[0]);
					int y = Integer.parseInt(strXY[1]);

					if (y < btArr[x].length - 1) {
						btArr[x][y + 1].requestFocus();
					}

					break;
				}
				case KeyEvent.VK_LEFT: {
					String[] strXY = new String[2];
					strXY = getFocusOwner().getName().split(",");
					int x = Integer.parseInt(strXY[0]);
					int y = Integer.parseInt(strXY[1]);

					if (x > 0) {
						btArr[x - 1][y].requestFocus();
					}

					break;
				}
				case KeyEvent.VK_RIGHT: {
					String[] strXY = new String[2];
					strXY = getFocusOwner().getName().split(",");
					int x = Integer.parseInt(strXY[0]);
					int y = Integer.parseInt(strXY[1]);

					if (x < btArr[x].length - 1) {
						btArr[x + 1][y].requestFocus();
					}

					break;
				}
				}
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
				board[i][j].removeAll();
				btArr[i][j] = new JButton();
				btArr[i][j].setName(i + "," + j);
				btArr[i][j].setPreferredSize(ds);
				btArr[i][j].setBackground(emptyColor);
				btArr[i][j].addActionListener(this);
				btArr[i][j].addKeyListener(keyAdapter);
				board[i][j].add(btArr[i][j]);
			}
		}

		remove(jlGomoku);
		remove(jlFull);
		setVisible(true);

		btArr[0][0].requestFocus();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton obj = (JButton) e.getSource();
		String[] strXY = new String[2];
		strXY = obj.getName().split(",");
		int x = Integer.parseInt(strXY[0]);
		int y = Integer.parseInt(strXY[1]);

		if (myGomoku.setState(x, y, curTurn) && !gomoku) {
			board[x][y].removeAll();
			if (curTurn == Gomoku.STATE_BLACK) {
				obj = new JButton(blackStone);
			} else if (curTurn == Gomoku.STATE_WHITE) {
				obj = new JButton(whiteStone);
			}
			obj.setPreferredSize(ds);
			obj.setBackground(emptyColor);
			obj.addKeyListener(keyAdapter);
			board[x][y].add(obj);
			setVisible(true);
			obj.requestFocus();
			System.out.println("이벤트 발생주체: " + ((Component)e.getSource()).getName());
			System.out.println("포커스 주인: " + getFocusOwner().getName());

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
