package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class HomeScreen extends Screen {

	public HomeScreen(MainFrame mainFrame) {
		super(mainFrame);

		JLabel jLabelTitle = new JLabel("FIM BIRD");
		jLabelTitle.setBounds(180, 120, 150, 160);

		add(jLabelTitle);

		JButton JButtonPlay = new JButton("play");
		add(JButtonPlay);

		ActionListener lsn1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new GameScreen(mainFrame));
			}
		};
		JButtonPlay.addActionListener(lsn1);

		JButton JButtonScore = new JButton("score");
		add(JButtonScore);
		ActionListener lsn2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new ScoreScreen(mainFrame));
			}
		};
		JButtonScore.addActionListener(lsn2);

		JButton JButtonSound = new JButton("sound");
		add(JButtonSound);
		ActionListener lsn3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		};
		JButtonSound.addActionListener(lsn3);

		jLabelTitle.setFont(new Font("Arial", Font.BOLD, 24));
		add(jLabelTitle);

		// umiestnenie tlacitok
		JButtonPlay.setBounds(100, 400, 280, 50);
		JButtonScore.setBounds(100, 460, 280, 50);
		JButtonSound.setBounds(100, 520, 280, 50);

		JButtonPlay.setFont(new Font("Arial", Font.PLAIN, 24));
		JButtonPlay.setBackground(Color.RED);
		JButtonScore.setFont(new Font("Arial", Font.PLAIN, 24));
		JButtonScore.setBackground(Color.RED);
		JButtonSound.setFont(new Font("Arial", Font.PLAIN, 24));
		JButtonSound.setBackground(Color.RED);

	}

}
