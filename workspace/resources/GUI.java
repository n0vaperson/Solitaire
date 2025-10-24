/*@author Roi Porat-Shliom with starter code from @menchukf
 * @version 10/22/2025
 * @purpose establish the visual component of the Black Jack game 
 */

package resources;

import javax.imageio.ImageIO;
import javax.swing.*;

import resources.Card.Suit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Stack;

public class GUI extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

	Blackjack game;

	public GUI(Blackjack game) {
		this.game = game;
		// Create and set up the window.
		setTitle("Black Jack");
		setSize(900, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// this supplies the background
		try {
			System.out.println(getClass().toString());
			Image blackImg = ImageIO.read(getClass().getResource("background.jpg"));
			ImagePanel panel = new ImagePanel(blackImg);
			panel.setBorder(BorderFactory.createLineBorder(Color.PINK, 5));

			// this establishes the containers
			JPanel northPanel = new JPanel();
			JPanel southPanel = new JPanel();
			JPanel eastPanel = new JPanel();
			JButton hitButton = new JButton("Hit");
			JButton standButton = new JButton("Stand");
			JButton splitButton = new JButton("Split");
			JButton doubleButton = new JButton("Double");
			panel.setLayout(new BorderLayout());

			// the following three sets of code make the container not opaque, set the
			// border, and resize to determined size
			northPanel.setOpaque(false);
			northPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			northPanel.setPreferredSize(new Dimension(0, 200));
			panel.add(northPanel, BorderLayout.NORTH);

			southPanel.setOpaque(false);
			southPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
			southPanel.setPreferredSize(new Dimension(0, 200));
			panel.add(southPanel, BorderLayout.SOUTH);

			eastPanel.setOpaque(false);
			eastPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
			eastPanel.setPreferredSize(new Dimension(300, 0));
			panel.add(eastPanel, BorderLayout.EAST);

			eastPanel.add(hitButton);
			eastPanel.add(standButton);
			eastPanel.add(splitButton);
			eastPanel.add(doubleButton);

			setContentPane(panel);

			//tests
			Stack<Card> test = new Stack<Card>();
			test.add(new Card(2, Suit.Spades));
			test.add(new Card(8, Suit.Spades));
			southPanel.add(drawPile(test));

			Stack<Card> testDealer = new Stack<Card>();
			testDealer.add(new Card(11, Suit.Spades));
			testDealer.add(new Card(1, Suit.Hearts));
			northPanel.add(drawPile(testDealer));

		} catch (IOException e) {
			e.printStackTrace();
		}

		/*******
		 * This is just a test to make sure images are being read correctly on your
		 * machine. Please replace
		 * once you have confirmed that the card shows up properly. The code below
		 * should allow you to play the solitare
		 * game once it's fully created.
		 */
		// Card card = new Card(2, Card.Suit.Diamonds);
		// System.out.println(card);
		// this.add(card);

		this.setVisible(true);
	}

	// precondition: stackIn is not null
	// postcondition: JLayeredPane is returned
	public JLayeredPane drawPile(Stack<Card> stackIn) {
		JLayeredPane cardPane = new JLayeredPane();
		cardPane.setPreferredSize(new Dimension(400,300));
		Object cards[];
		int offset = 0;
		cards = stackIn.toArray();
		for (Object o : cards) {
			Card c = (Card)o;
			c.setPreferredSize(new Dimension(100,140));
			c.setBounds(offset, offset, 100, 140);
			offset += 25;
			cardPane.add(c, 0);
		}
		return cardPane;

		// please note we convert this stack to an array so that we can iterate through
		// it backwards while drawing.
		// You’ll need to cast each element inside cards to a <Card> in order to use the
		// methods to adjust their position
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
