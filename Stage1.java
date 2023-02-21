package CinemaRoomManager;

public class Stage1 {

	public static void main(String[] args) {
		
		System.out.println("Cinema:");
		
		char[][] seats = new char[7][8];

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 8; j++) {
				seats[i][j] = 'S';
			}
		}

		System.out.println("  1 2 3 4 5 6 7 8");

		for (int i = 0; i < 7; i++) {
			System.out.print(i + 1);

			for (int j = 0; j < 8; j++) {
				System.out.print(" " + seats[i][j]);
			}

			System.out.println();
		}

	}

}
