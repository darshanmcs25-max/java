import java.util.InputMismatchException;
import java.util.Scanner;

class SeatAlreadyBookedException extends Exception {
    SeatAlreadyBookedException(String msg) {
        super(msg);
    }
}

public class Reservation {
    boolean[] booked = new boolean[11]; // Tracks seats 1 to 10 individually

    void reserveSeat(int seat) throws SeatAlreadyBookedException {
        if (seat < 1 || seat > 10) {
            throw new IllegalArgumentException("Invalid seat number!");
        }
        if (booked[seat]) {
            throw new SeatAlreadyBookedException("Seat already booked!");
        }
        booked[seat] = true;
        System.out.println("Seat " + seat + " reserved successfully!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Reservation r = new Reservation();

        try {
            System.out.print("Enter seat number (1-10): ");
            int seat = sc.nextInt();
            r.reserveSeat(seat);
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input! Enter a number.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (SeatAlreadyBookedException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Transaction completed.");
            sc.close();
        }
    }
}
