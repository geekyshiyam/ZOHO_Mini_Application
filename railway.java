import java.util.*;

public class railway {
    static Scanner sc = new Scanner(System.in);
    static String adminName = "shiyam", adminPass = "s";
    static int booking[][] = new int[5][7];
    static ArrayList<Waiting> Waitingl = new ArrayList<>();
    static ArrayList<Bookings> Books = new ArrayList<>();
    static ArrayList<User> Userl = new ArrayList<>();
    static int Index = -1;

    public static void welcome() {
        Userl.add(new User("shiyam", "s", "UID00"));
        clearScreen();
        boolean flag = true;
        System.out.println("\t\t-Welcome to Indian Railways-\n");
        System.out.println("1) Admin");
        System.out.println("2) Passesngers");
        System.out.println("3) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        while (flag) {
            switch (a) {
                case 1:
                    admin();
                    break;
                case 2:
                    passenger();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Enter Valid Number !");
                    welcome();
                    break;
            }
        }

    }

    public static void admin() {
        clearScreen();
        System.out.println("\t\t- Login to Continue -\n");
        System.out.print("Enter Ur Name : ");
        String a = sc.nextLine();
        System.out.print("Enter Ur Passcode : ");
        String b = sc.nextLine();
        if (adminName.equals(a) && adminPass.equals(b)) {
            adminWork();
        } else {
            System.out.println("Invalid Name Or Passcode !");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                welcome();
        }

    }

    public static void adminWork() {
        clearScreen();
        System.out.println("\t\tWelcome Admin !\n");
        System.out.println("1) View Booked Tickets");
        System.out.println("2) View Reserved Tickets");
        System.out.println("3) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1:
                viewBooked();
                break;
            case 2:
                viewReserved();
                break;
            case 3:
                welcome();
                break;
            default:
                System.out.println("Enter Valid Number !");
                adminWork();
                break;
        }
    }

    public static void viewBooked() {
        clearScreen();
        System.out.println("\t\t- Booked Tickets -");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(booking[i][j]);
            }
            System.out.println("");
        }
        Enter();
        String k = sc.nextLine();
        if (k.equals(""))
            adminWork();

    }

    public static void viewReserved() {
        clearScreen();
        System.out.println("\t\t- Waiting Lists -");
        int c = 0;
        for (int i = 0; i < Waitingl.size(); i++) {
            c++;
            System.out.println("User Id : " + Waitingl.get(i).uid);
            System.out.println("Starting station : " + Waitingl.get(i).start);
            System.out.println("Ending station : " + Waitingl.get(i).end);
        }
        if (c == 0) {
            System.out.println("\t\t\tEmpty !");
        }
        Enter();
        String k = sc.nextLine();
        if (k.equals(""))
            adminWork();
    }

    public static void passenger() {
        clearScreen();
        System.out.println("\t\t- Welcome Passenger ! -");
        System.out.println("1) Login");
        System.out.println("2) Signup");
        System.out.println("3) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1:
                passengerLogin();
                break;
            case 2:
                passengerSignin();
                break;
            case 3:
                welcome();
                break;
            default:
                System.out.println("Enter Valid Number !");
                passenger();
                break;
        }
    }

    public static void passengerLogin() {
        Index = -1;
        clearScreen();
        System.out.println("\t\t-Login To Continue !-\n");
        System.out.print("Enter Your Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Your Password : ");
        String pass = sc.nextLine();
        for (int i = 0; i < Userl.size(); i++) {
            if ((Userl.get(i).name.equals(name)) && (Userl.get(i).password.equals(pass))) {
                Index = i;
                passengerWork();
            }
        }
        if (Index < 0) {
            System.out.println("Invalid Name Or Password !");
            System.out.println("Enter Valid Details !");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                passenger();
        }

    }

    public static void passengerSignin() {
        clearScreen();
        System.out.println("\t\t-Signup to Continue !-\n");
        System.out.print("Enter Your Name : ");
        String a = sc.nextLine();
        System.out.print("Enter Password : ");
        String b = sc.nextLine();
        System.out.print("Re-enter Password : ");
        String c = sc.nextLine();
        if (b.equals(c)) {
            Userl.add(new User(a, b, "UID" + Userl.size()));
            System.out.println("You Have Successfully Signed up!");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                passenger();
        } else {
            System.out.println("Re-enter Password Correctly !");
            Enter();
            String k = sc.nextLine();
            if (k.equals(""))
                passengerSignin();

        }
    }

    public static void passengerWork() {
        clearScreen();
        System.out.println("\t\t- Welcome Passenger! -\n");
        System.out.println("1) Ticket Booking");
        System.out.println("2) Ticket Cancellation");
        System.out.println("3) Booking History");
        System.out.println("4) Exit");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1 : ticketBook();
            case 2 : ticketCancel();
            case 3 : ticketHistory();
            case 4 : welcome();
            default : {
                System.out.println("Enter valid Number !");
                Enter();
                String k = sc.nextLine();
                if (k.equals(""))
                    passengerWork();
            }
        }

    }

    public static void ticketBook() {
        clearScreen();
        System.out.println("\t\t- Booking -\n");
        System.out.print("Enter No Of Passengers : ");
        int a = sc.nextInt();
        for (int i = 0; i < a; i++) {
            System.out.println(
                    "1) Coimbatore \n2) Salem \n3) Erode \n4) Chennai \n5) Cochin \n6) Banglore \n7) Andhra");
            System.out.print("Enter Starting Point for Passenger : ");
            int s = sc.nextInt();
            System.out.print("Enter Ending Point for Passenger : ");
            int e = sc.nextInt();
            sc.nextLine();
            int Seatnum = 0;
            for (int seat = 0; seat < booking.length; seat++) {
                int sum = 0;
                for (int station = s - 1; station <= e - 1; station++) {
                    sum += booking[seat][station];
                }
                if (sum == 0) {
                    System.out.println("Seat Number " + seat + 1 + " Booked!");
                    String Ticketid = "TICKET" + Books.size();
                    System.out.println("Your Ticket Id is : " + Ticketid);
                    Books.add(new Bookings(Userl.get(Index).id, s, e, Ticketid, "No", seat + 1));
                    for (int k = s - 1; k <= e - 1; k++) {
                        booking[seat][k] = i + 1;
                    }
                    Seatnum = 1;
                    break;
                }
            }
            for (int n = 0; n < 5; n++) {
                for (int stat = 0; stat < 7; stat++) {
                    System.out.print(booking[n][stat]);
                }
                System.out.println();
            }
            if (Seatnum == 0 && Waitingl.size() < 5) {
                System.out.println("Adding in Waiting List !");
                Waitingl.add(new Waiting(Userl.get(Index).id, s, e));
            } else if (Waitingl.size() == 5) {
                System.out.println("Seats Not Available !");
            } else {
                Seatnum = 0;
            }
            for (Waiting l : Waitingl) {
                System.out.println(l.uid + " " + l.start + " " + l.end);
            }
        }
        Enter();
        String l = sc.nextLine();
        if (l.equals(""))
            passengerWork();

    }

    public static void ticketCancel() {
        clearScreen();
        System.out.println("\t\t-Ticket Cancelling -\n");
        System.out.print("Enter Your Ticket ID(eg:TICKET1) : ");
        String t = sc.nextLine();
        int count = 0;
        for (int i = 0; i < Books.size(); i++) {
            if (Books.get(i).Ticketid.equals(t) && Userl.get(Index).id.equals(Books.get(i).uid)
                    && Books.get(i).travel.equals("No")) {
                System.out.println("Enter Yes To Confirm Cancellation");
                String s = sc.nextLine();
                count++;
                if (s.equals("Yes")) {
                    Books.get(i).travel = "Cancelled";
                    System.out.println("Ticket cancelled Successfully");
                    for (int k = 0; k < booking.length; k++) {
                        for (int w = Books.get(i).start - 1; w < Books.get(i).end; w++) {
                            booking[Books.get(i).seatno - 1][w] = 0;
                        }
                        for (int j = 0; j < Waitingl.size(); j++) {
                            for (int p = 0; p < booking.length; p++) {
                                int sum = 0;
                                for (int o = Books.get(j).start - 1; o < Books.get(j).end; o++) {
                                    sum += booking[p][o];
                                }
                                if (sum == 0) {
                                    System.out.println("Seat Allocated " + (k + 1));
                                    String Ticketid = "TICKET" + Books.size();
                                    System.out.println("Your Ticket Id is : " + Ticketid);
                                    Books.add(new Bookings(Waitingl.get(j).uid, Waitingl.get(j).start,
                                            Waitingl.get(j).end,
                                            Ticketid, "No", k + 1));
                                    for (int n = Waitingl.get(j).start - 1; n < Waitingl.get(j).end; n++) {
                                        booking[k][n] = i + 1;
                                    }
                                    Waitingl.remove(j);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (count == 0) {
            System.out.println("User Not Found Or User Already Travelled");
            Enter();
            String l = sc.nextLine();
            if (l.equals(""))
                passengerWork();
        } else {
            Enter();
            String l = sc.nextLine();
            if (l.equals(""))
                passengerWork();
        }

    }

    public static void ticketHistory() {
        clearScreen();
        System.out.println("\t\t- Your Travel History ! -");
        int a = 1;
        for (int i = Books.size() - 1; i >= 0; i--) {
            if (Books.get(Index).uid.equals(Userl.get(Index).id)) {
                System.out.println(a + ") Starting point : " + Books.get(Index).start);
                System.out.println("   Ending point : " + Books.get(Index).end);
                System.out.println("   Seat Number : " + Books.get(Index).seatno);
                System.out.println("   Ticket ID : " + Books.get(Index).Ticketid);
                System.out.println("   Ticket Expirey : " + Books.get(Index).travel);
                a++;
            }
        }
        if (a == 1) {
            System.out.println("\t\tEmpty !");
        }
        Enter();
        String k = sc.nextLine();
        if (k.equals(""))
            passengerWork();

    }

    public static void Exit() {
        clearScreen();
        System.out.println("-Thank You For Visiting Railway Reservation Services-");
        Enter();
        String k = sc.nextLine();
        if (k.equals("")) {

        }
    }

    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void Enter() {
        System.out.println("Press Enter to Continue !");
    }

    public static void main(String args[]) {
        clearScreen();
        welcome();
    }
}

class Bookings {
    String uid, Ticketid, travel;
    int start, end, seatno;

    Bookings(String uid, int start, int end, String Ticketid, String travel, int seatno) {
        this.uid = uid;
        this.start = start;
        this.end = end;
        this.Ticketid = Ticketid;
        this.travel = travel;
        this.seatno = seatno;

    }

}

class Waiting {
    String uid;
    int start, end;

    Waiting(String uid, int start, int end) {
        this.uid = uid;
        this.start = start;
        this.end = end;

    }

}

class User {
    String name, password, id;

    User(String uname, String upass, String uid) {
        this.name = uname;
        this.password = upass;
        this.id = uid;
    }
}
