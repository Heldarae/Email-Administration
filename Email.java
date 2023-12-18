import java.util.Random;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailCapacity;
    private String alternateEmailAddress;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        mailCapacity = 500;
        signIn(firstName, lastName);
    }

    // Create a Email and a random password.
    private void signIn(String firstName, String lastName) {
        String email;
        setDepartment();
        if (department.equals("")) {
            email = String.format("%s.%s@company.com", firstName.toLowerCase().replaceAll(" ", ""),
                    lastName.toLowerCase());
        } else {
            email = String.format("%s.%s@%s.company.com", firstName.toLowerCase().replaceAll(" ", ""),
                    lastName.toLowerCase(),
                    department);
        }
        System.out.println("Your email address is: " + email);
        System.out.println("Your password is: " + passwordCreator());
    }

    // Random password creation with nums and words.
    private String passwordCreator() {
        int leftLimit = 48;
        int rightLimit = 122;
        int passLength = 8;
        Random random = new Random();

        password = random.ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(passLength).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return password;
    }

    // Taking department for email creation.
    private String setDepartment() {
        System.out.print("Please choose your department:\n1 - Sales\n2 - Development\n3 - Accounting\n0 - None\n");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                department = "sales";
                break;
            case 2:
                department = "development";
                break;
            case 3:
                department = "accounting";
                break;
            case 0:
                department = "";
                break;
            default:
                System.out.println("Please enter valid choices!");
                setDepartment();
                break;
        }

        return department;

    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMailCapacity(int mailCapacity) {
        this.mailCapacity = mailCapacity;
    }

    public void setAlternateEmailAddress(String alternateEmailAddress) {
        this.alternateEmailAddress = alternateEmailAddress;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public int getMailCapacity() {
        return mailCapacity;
    }

    public String getAlternateEmailAddress() {
        return alternateEmailAddress;
    }

    public String getPassword() {
        return password;
    }
}