import sun.misc.ExtensionDependency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board extends JFrame {
    private List<Card> cards;
    private Card selectedCard;
    private Card card1;
    private Card card2;
    private int counter;
    private Timer timer;

    public Board() {
        initiateCard();
        setupBoard();
        setupTimer();
    }

    public Card makeNewCard(int id, String image) {
        Card card = new Card(id, image);
        card.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedCard = card;
                flipCard();
                System.out.println(selectedCard.getId());
            }
        });
        return card;
    }

    public void play() {
        setVisible(true);
    }

    public void setupTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardsComparator();
            }
        });
        timer.setRepeats(false);
    }

    public void cardsComparator() {
        if (card1.getId().equals(card2.getId())) {
            card1.setEnabled(false);
            card2.setEnabled(false);
            card1.setMatched(true);
            card2.setMatched(true);

            if (isGameDone()) {
                System.out.println("follow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbangfollow @whxsbang");
                JOptionPane.showMessageDialog(this, "follow @whxsbang, you re atm&& null" + counter, "follow @whxsbang follow @whxsbang follow @whxsbangfollow @whxsbang" +
                        "", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

        } else {
            card1.setIcon(Card.bgImage);
            card2.setIcon(Card.bgImage);
        }
        card1 = null;
        card2 = null;


    }

    public boolean isGameDone() {
        for (Card draC : cards) {
            if (draC.isMatched() == false) {
                return false;
            }
        }
        return true;
    }

    public void flipCard() {
        if (card1 == null && card2 == null) {
            card1 = selectedCard;
            card1.setIcon(selectedCard.getImage());
        }

        if (card1 != null && card1 != selectedCard && card2 == null) {
            card2 = selectedCard;
            card2.setIcon(selectedCard.getImage());
            timer.start();
            counter++;
            System.out.println("Counter = " + counter);
        }
    }


    public void initiateCard() {
        int totalCard = 10;
        List<Card> temporaryCardList = new ArrayList<>();

        String[] imageName = {"1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png", "8.png", "9.png", "10.png",
                "11.png", "12.png", "13.png", "14.png", "15.png", "16.png", "17.png", "18.png"};

        Collections.shuffle(Arrays.asList(imageName));

        // Pairing Card
        for (int i = 0; i < totalCard; i++) {
            temporaryCardList.add(makeNewCard(i, imageName[i]));
            temporaryCardList.add(makeNewCard(i, imageName[i]));
        }

        Collections.shuffle(temporaryCardList);

        this.cards = temporaryCardList;

    }

    private void setupBoard() {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 5));
        for (Card i : cards) {
            pane.add(i);
        }
        setTitle("Memory Match");
        setLocation(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        pack();

    }

    private void countAttempt() {

    }
}
