package CinemaRoomManager;

import java.util.Scanner;

public class Stage4 {
	// some variables block
	static int rows = 0;
	static int seat = 0;
	static int frontRows = 0;
	static int backRows = 0;
	static int totalSeats = 0;
	static int priceFrontRows = 0;
	static int priceBackRows = 0;
	static char[][] cinemaSeats;
	static boolean exit = false;

	public static void main(String[] args) {

		// read two positive integer numbers that represent the number of rows and seats
		// in each row
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the number of rows:");
		rows = input.nextInt();

		System.out.println("Enter the number of seats in each row:");
		seat = input.nextInt();

		// some variables block
		frontRows = rows / 2; // front rows
		backRows = rows - frontRows; // back rows
		totalSeats = rows * seat; // total seats number
		priceFrontRows = 10; // default price for front rows
		priceBackRows = 10; // default price for back rows

		// if total seats > 60 - price for back rows is $8
		if (totalSeats > 60) {
			priceBackRows = 8;
		}

		// START initial seats map array
		char[][] seats = new char[rows][seat];
		cinemaSeats = seats;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < seat; j++) {
				seats[i][j] = 'S';
			}
		}
		// STOP initial seats map array

		System.out.println();

		do {
			// START menu print
			System.out.println();
			System.out.println("1. Show the seats");
			System.out.println("2. Buy a ticket");
			System.out.println("0. Exit");
			int option = input.nextInt();
			// STOP menu print

			switch (option) {

			case 1 -> {
				showSeats();
			}

			case 2 -> {
				buyTicket();
				showSeats();
			}

			case 0 -> {

				exit();
			}

			}
			;
		} while (exit == false);
	}

	static void showSeats() {
		System.out.println();
//		System.out.println("showSeats START");
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
				System.out.print(" " + cinemaSeats[i][j]);
			}

			System.out.println();

		}
//		System.out.println("showSeats ENDS");
		System.out.println();

	}

//
//	
//	
//

	static void buyTicket() {
		Scanner input = new Scanner(System.in);
		// START Bye a ticket
		System.out.println("Enter a row number:");
		int rowNumberInput = input.nextInt();

		System.out.println("Enter a seat number in that row:");
		int seatNumberInput = input.nextInt();

		cinemaSeats[rowNumberInput - 1][seatNumberInput - 1] = 'B';

		int ticketPrice;

		if (rowNumberInput <= frontRows) {
			ticketPrice = priceFrontRows;
		} else {
			ticketPrice = priceBackRows;
		}
		System.out.println();
		System.out.println("Ticket price: $" + ticketPrice);
		// STOP Bye a ticket

	}

	static void exit() {
		exit = true;
	}

}
