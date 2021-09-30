package Costigan;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        User user = new User(password);

        try {
            // Only Password should be set at this point
            System.out.println("Password: " + user.getPassword());
            System.out.println("Salt: " + user.getSalt());
            System.out.println("Hashed Password: " + user.getHashedPassword());

            // hashUserPassword is a static function (no NSALoginController object needed)
            // This function will set the salt and hashedPassword in the user object
            // We expect that the password will be cleared.
            NSALoginController.hashUserPassword(user);

            // Only salt and hashed password set at this point
            System.out.println("Password: " + user.getPassword());
            System.out.println("Salt: " + user.getSalt());
            System.out.println("Hashed Password: " + user.getHashedPassword());

            // Run a test of the hashed password.
            // Ask the user for the password and set it in the user object
            System.out.print("Enter password: ");
            password = scanner.nextLine();
            user.setPassword(password);

            // verifyPassword will check the password in the user object against the salt
            // and hashed password.
            if (NSALoginController.verifyPassword(user)) {
                System.out.println("Verified!");
            }
            else {
                System.out.println("Not Verified!");
            }
        }
        catch (WeakPasswordException e) {
            System.out.println("Weak Password Error: " + e.getMessage());
        }
        catch(Exception e) {
            System.out.println("General Exception: " + e.toString());
        }
    }
}
