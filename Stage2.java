package CinemaRoomManager;

import java.util.Scanner;

public class Stage2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the number of rows:");
		int rows = input.nextInt();
		int frontRows = rows / 2;
		int backRows = rows - frontRows;

		System.out.println("Enter the number of seats in each row:");
		int seats = input.nextInt();

		int totalSeats = rows * seats;

		int priceFrontRows = 10;
		int priceBackRows = 10;

		if (totalSeats > 60) {
			priceBackRows = 8;
		}

		int totalIncome = (priceFrontRows * frontRows * seats) + (priceBackRows * backRows * seats);

		System.out.println("Total income:");
		System.out.println("$" + totalIncome);

	}
}
