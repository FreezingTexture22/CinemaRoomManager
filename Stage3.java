package CinemaRoomManager;

import java.util.Scanner;

public class Stage3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the number of rows:");
		int rows = input.nextInt();
		int frontRows = rows / 2;
		int backRows = rows - frontRows;

		System.out.println("Enter the number of seats in each row:");
		int seat = input.nextInt();

		int totalSeats = rows * seat;

		int priceFrontRows = 10;
		int priceBackRows = 10;

		if (totalSeats > 60) {
			priceBackRows = 8;
		}

		char[][] seats = new char[rows][seat];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < seat; j++) {
				seats[i][j] = 'S';
			}
		}

		// START Initial Cinema seat plan
		System.out.println();
		System.out.println("Cinema:");
		for (int i = 0; i <= seat; i++) {
			if (i == 0) {
				System.out.print(" ");
			} else if (i == seat) {
				System.out.println(" " + i);
			} else {
				System.out.print(" " + i);
			}

		}

		for (int i = 0; i < rows; i++) {
			System.out.print(i + 1);

			for (int j = 0; j < seat; j++) {
				System.out.print(" " + seats[i][j]);
			}

			System.out.println();

		}
		System.out.println();
		// STOP Initial Cinema seat plan

		// START Ticket price
		System.out.println("Enter a row number:");
		int rowNumberInput = input.nextInt();

		System.out.println("Enter a seat number in that row:");
		int seatNumberInput = input.nextInt();

		seats[rowNumberInput - 1][seatNumberInput - 1] = 'B';

		int ticketPrice;

		if (rowNumberInput <= frontRows) {
			ticketPrice = priceFrontRows;
		} else {
			ticketPrice = priceBackRows;
		}
		System.out.println();
		System.out.println("Ticket price: $" + ticketPrice);
		// STOP Ticket price

		// START New Cinema seat plan
		System.out.println();
		System.out.println("Cinema:");
		for (int i = 0; i <= seat; i++) {
			if (i == 0) {
				System.out.print(" ");
			} else if (i == seat) {
				System.out.println(" " + i);
			} else {
				System.out.print(" " + i);
			}

		}

		for (int i = 0; i < rows; i++) {
			System.out.print(i + 1);

			for (int j = 0; j < seat; j++) {
				System.out.print(" " + seats[i][j]);
			}

			System.out.println();

		}
		System.out.println();

		// STOP New Cinema seat plan

	}

}
