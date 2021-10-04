package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static int genCard(Random rand) {
        int card = rand.nextInt(14);
        card += 1;
        if (card > 11) {
            card = 10;
        }
        return card;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("welcome to blackjack");
        while (true) {
            boolean bust = false;
            int cpuCard1 = genCard(rand);
            int cpuCard2 = genCard(rand);
            int cpuHand = cpuCard1 + cpuCard2;
            int playerCard1 = genCard(rand);
            int playerCard2 = genCard(rand);
            int playerHand = playerCard1 + playerCard2;
            System.out.println("your cards are " + playerCard1 + " and " + playerCard2 + " they add up to " + playerHand);
            while (cpuHand <= 16) {
                System.out.println("the cpu takes a card");
                int hit = genCard(rand);
                cpuHand += hit;
                System.out.println("the cpu now has a total of " + cpuHand);
            }
            if (cpuHand > 21) {
                System.out.println("the cpu has gone bust!");
                bust = true;
                System.out.println("you win");
            }
            while (!bust) {
                System.out.println("do you want to take a card? y/n");
                String yn = sc.next();
                if (yn.equals("y")) {
                    int hit = genCard(rand);
                    playerHand += hit;
                    System.out.println("you got " + hit);
                    System.out.println("you now have " + playerHand);
                    if (playerHand > 21) {
                        System.out.println("you have gone bust!");
                        bust = true;
                        System.out.println("you lose");
                    }
                }
                else if (yn.equals("n")) {
                    break;
                }
                else {
                    System.out.println("please type y or n");
                }
            }
            if (!bust) {
                System.out.println("cpu has " + cpuHand + " you have " + playerHand);
            }
            if (cpuHand > playerHand && !bust) {
                System.out.println("the cpu wins");
            }
            if (playerHand > cpuHand && !bust){
                System.out.println("you win");
            }
            System.out.println("do you want to play again? y/n");
            String agane = sc.next();
            if (agane.equals("y")){
                continue;
            }
            if (agane.equals("n")){
                break;
            }
            else{
                System.out.println("you didn't type y or n so you're playing again");
            }
        }
    }
}