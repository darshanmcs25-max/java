
import java.util.Scanner;

public class EmailOperations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student email address: ");
        String email = sc.nextLine();

        System.out.println("Length of email: " + email.length());

        int pos = email.indexOf('@');
        String username = email.substring(0, pos);
        System.out.println("Username: " + username);

        String domain = email.substring(pos + 1);
        System.out.println("Domain: " + domain);

        if (domain.equals("bmsce.ac.in")) {
            System.out.println("Belongs to BMSCE institution");
        } else {
            System.out.println("Does not belong to BMSCE institution");
        }

        String lower = email.toLowerCase();
        System.out.println("Lowercase email: " + lower);

        System.out.print("Enter prefix: ");
        String prefix = sc.nextLine();

        if (email.startsWith(prefix)) {
            System.out.println("Email starts with given prefix");
        } else {
            System.out.println("Email does not start with given prefix");
        }

        if (email.endsWith("bmsce.ac.in")) {
            System.out.println("Email ends with valid domain");
        } else {
            System.out.println("Email does not end with valid domain");
        }

        String updated = email.replace(
            "bmsce.ac.in", "cse.bmsce.ac.in"
        );
        System.out.println("Updated email: " + updated);

        System.out.print("Enter sequence to search: ");
        String search = sc.nextLine();

        if (email.contains(search)) {
            System.out.println("Email contains the given sequence");
        } else {
            System.out.println("Email does not contain the sequence");
        }

        String trimmed = email.trim();
        System.out.println("Trimmed email: " + trimmed);

        System.out.print("Enter another email address: ");
        String email2 = sc.nextLine();

        if (email.trim().equalsIgnoreCase(email2.trim())) {
            System.out.println("Both email addresses are identical");
        } else {
            System.out.println("Email addresses are different");
        }

        sc.close();
    }
}
