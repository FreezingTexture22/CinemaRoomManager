package CinemaRoomManager;

import java.util.Scanner;

public class Stage5 {

	// some variables block
	static int rows = 0;
	static int seat = 0;
	static int totalSeats = 0;
	static int totalSeatsFront = 0;
	static int totalSeatsBack = 0;
	static int ticketPrice = 10;
	static int frontRows = 0;
	static int backRows = 0;
	static char[][] cinemaSeats;
	static boolean exit = false;
	static int numOfPurchasedTickets = 0;
	static double percentageOfTickets = 0;
	static double seatPercent = 0;
	static int currentIncome = 0;
	static int totalIncome = 0;
	static int priceFrontRows = 10;
	static int priceBackRows = 10;

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
		totalSeatsFront = frontRows * seat;
		totalSeatsBack = totalSeats - totalSeatsFront;

		seatPercent = (100.00 / totalSeats); // percentage of one seat

		// if total seats > 60 - price for back rows is $8
		if (totalSeats > 60) {
			priceBackRows = 8;
		}

		totalIncome = (totalSeatsFront * priceFrontRows) + (totalSeatsBack * priceBackRows); // total income

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
			System.out.println("3. Statistics");
			System.out.println("0. Exit");
			int option = input.nextInt();
			// STOP menu print

			switch (option) {

			case 1 -> {
				showSeats();
			}

			case 2 -> {
				buyTicket();

			}

			case 3 -> {
				statistics();

			}

			case 0 -> {

				exit();
			}

			}
			;
		} while (exit == false);
	}

	static void statistics() {
		System.out.println("Number of purchased tickets: " + numOfPurchasedTickets);
		System.out.printf("Percentage: %.2f%c", percentageOfTickets, '%');
		System.out.println();
		System.out.println("Current income: $" + currentIncome);
		System.out.println("Total income: $" + totalIncome);
	}

	static void showSeats() {
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
				System.out.print(" " + cinemaSeats[i][j]);
			}

			System.out.println();

		}

		System.out.println();

	}

	// START Bye a ticket
	static void buyTicket() {

		Scanner input = new Scanner(System.in);
		int rowNumberInput = 0;
		int seatNumberInput = 0;
		boolean wrongInput = false;
		boolean seatAlreadyPurchased = false;

		// Start of loop - check if ticket already purchased
		do {
			// Start of loop - check wrong input
			do {
				System.out.println();
				System.out.println("Enter a row number:");
				rowNumberInput = input.nextInt();

				System.out.println("Enter a seat number in that row:");
				seatNumberInput = input.nextInt();

				if (rowNumberInput <= 0 || rowNumberInput > rows || seatNumberInput <= 0 || seatNumberInput > seat) {
					System.out.println("Wrong input!");
					wrongInput = true;
					continue;
				} else {
					wrongInput = false;
				}

			} while (wrongInput);
			// End of loop - check wrong input

			// check if ticket already purchased
			if (cinemaSeats[rowNumberInput - 1][seatNumberInput - 1] == 'B') {
				System.out.println();
				System.out.println("That ticket has already been purchased!");
				seatAlreadyPurchased = true;
			} else {
				seatAlreadyPurchased = false;
			}
		} while (seatAlreadyPurchased);
		// End of loop - check if ticket already purchased

		cinemaSeats[rowNumberInput - 1][seatNumberInput - 1] = 'B';
		numOfPurchasedTickets++;
		percentageOfTickets = percentageOfTickets + seatPercent;

		if (rowNumberInput <= frontRows) {
			currentIncome = currentIncome + priceFrontRows;
			System.out.println();
			System.out.println("Ticket price: $" + priceFrontRows);
		} else {
			currentIncome = currentIncome + priceBackRows;
			System.out.println();
			System.out.println("Ticket price: $" + priceBackRows);
		}

	}
	// STOP Bye a ticket

	static void exit() {
		exit = true;
	}

}
