import java.util.*;
import java.io.*;
public class atm
{
    static int amount[] = {2000,500,200,100};
    static int amountDen[] = {20,20,20,20};
    static String usrNames[] = {"shiyam", "prasad"};
    static int usrBal[] = {300000,50000};
	static int passArr[] = {1234,4321};
	static Scanner sf = new Scanner(System.in);
	
	public static void delay(int delay){
	    try {
            Thread.sleep(delay);
        } 
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
	}
	
    public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
    } 
    
    public static void checkDen(){
        clearScreen();
        System.out.println("Available Notes are");
        for(int i = 0;i<4;i++){
            System.out.println(amount[i] + " x " + amountDen[i]);
        }
        delay(3000);
        clearScreen();
    }
    
    public static void addDen(){
                    clearScreen();
		            System.out.println("Enter number of notes");
		            System.out.print("2000 x ");
		            int twoth1 = sf.nextInt();
		            amountDen[0] = amountDen[0]+twoth1;
		            System.out.print("500 x ");
		            int fiveh1 = sf.nextInt();
		            amountDen[1] = amountDen[1]+fiveh1;
		            System.out.print("200 x ");
		            int twoh1 = sf.nextInt();
		            amountDen[2] = amountDen[2]+twoh1;
		            System.out.print("100 x ");
		            int oneh1 = sf.nextInt();
		            amountDen[3] = amountDen[3]+oneh1;
		            delay(2000);
		            System.out.println("Successfully Added...");
		            System.out.println("Press 1 to check denotions");
		            int c = sf.nextInt();
		            if(c == 1){
		                checkDen();
		            } else {
		                clearScreen();
		            }
    }
    
    public static void thank(){
        clearScreen();
        System.out.println("*.*.*.*.*.Thank you for Banking with Us.*.*.*.*.*");
        delay(3000);
    }
    
    public static void admin(){
        clearScreen();
        System.out.print("Enter Your Username: ");
		String usr = sf.next();
		System.out.print("Enter Your Pin: ");
		int pass = sf.nextInt();
		if(usr.equals("admin") && pass == 1111){
		    clearScreen();
		    System.out.println("1. Check Denotions");
		    System.out.println("2. Add Denotions");
		    System.out.println("3. Exit");
		    int op = sf.nextInt();
		    switch(op){
		        case 1:
		            checkDen();
		            break;
		        case 2:
		            addDen();
		            break;
		        case 3:
		            exit();
		            break;
		        default:
		        thank();
		            break;
		    }
		} else {
		    System.out.println("Incorrect Admin Credentials");
		    delay(3000);
		    clearScreen();
		}
    }
    
    public static void chkBal(int user){
        clearScreen();
        System.out.println("Your available balance is "+usrBal[user]+" Rupees");
        delay(3000);
        thank();
    }
    
    public static void cshWtd(int user){
        clearScreen();
        int temp=0,m=0;
        int j=0;
        System.out.println("Enter amount to Withdraw: ");
        int wtdCsh = sf.nextInt();
        if(wtdCsh <= usrBal[user]){
        temp=wtdCsh;
        System.out.println("Withdrawing amount in denotion of ");
        for(int i=0;i<4;i++)
            {
            System.out.println("Notes in "+amount[i]+" x "+temp/amount[i]);
            amountDen[i] = amountDen[i] - (temp/amount[i]);
            temp=temp%amount[i];
            if(amountDen[i] <= 0){
                clearScreen();
                System.out.println("Insufficient notes...");
                System.out.println("Please try with a different amount to withdraw...");
                delay(3000);
                j=1;
                break;
            }
        }
        delay(2000);
        if(temp != 0){
            clearScreen();
            System.out.println("Cannot Withdraw "+ temp);
            System.out.println("Please Enter amount in multiples of 2000, 500, 200, 100 ");
            delay(3000);
        } else {
            if(j == 0){
        System.out.println();
        System.out.println("Please Collect your Cash");
        delay(3000);
        usrBal[user] = usrBal[user]-wtdCsh;
        clearScreen();
        System.out.println("Press 1 to check available balance");
        int n = sf.nextInt();
        if(n==1){
            System.out.println("Your available balance is "+usrBal[user]);
            delay(3000);
        }
        }
        }
        }
        else{
            clearScreen();
            System.out.println("Insufficient funds");
            delay(3000);
        }
        thank();
    }   
    public static void pinChng(int user){
        clearScreen();
        System.out.print("Please enter your old pin to continue: ");
        int old = sf.nextInt();
        clearScreen();
        if(old == passArr[user]){
            System.out.print("Enter your new Pin: ");
            int new1 = sf.nextInt();
            System.out.print("Re-Enter your new Pin: ");
            int new2 = sf.nextInt();
            if(new2 == new1){
                passArr[user] = new2;
                clearScreen();
                System.out.println("Pin Change Successful...");
                delay(3000);
            } else {
                System.out.println("Pin Mismatch... Please try again...");
                delay(3000);
            }
        } else {
            clearScreen();
            System.out.println("Incorrect Pin");
            delay(3000);
        }
        thank();
    }
    
    public static void cshDep(int user){
        clearScreen();
        System.out.println("Enter number of denotion to deposit");
        System.out.print("2000 x ");
        int twoth = sf.nextInt();
        System.out.print("500 x ");
        int fiveh = sf.nextInt();
        System.out.print("200 x ");
        int twoh = sf.nextInt();
        System.out.print("100 x ");
        int oneh = sf.nextInt();
        System.out.println();
        int tot = 2000*twoth+500*fiveh+200*twoh+100*oneh;
        System.out.println("Total amount to be deposited is: "+tot);
        System.out.println("Press 1 to deposit");
        int ok = sf.nextInt();
        if(ok == 1){
            clearScreen();
            System.out.println("Depositing...");
            delay(2000);
            clearScreen();
            System.out.println("Deposited...");
            usrBal[user] = usrBal[user] + tot;
            System.out.println("Press 1 to check available balance");
            int k = sf.nextInt();
            if(k==1){
                System.out.println("Your available balance is "+usrBal[user]);
                delay(3000);
            }
        }
        thank();
    }
    public static void exit(){
        thank();
    }
    
    public static void afterLogin(int user){
        clearScreen();
        System.out.print("              Welcome ");
        System.out.println(usrNames[user]);
        System.out.println("*.*.*.*.*.*. Choose an Option to continue .*.*.*.*.*.*");
        System.out.println();
        System.out.println("1. Check Balance");
        System.out.println("2. Cash Withdrawl");
        System.out.println("3. Pin Change");
        System.out.println("4. Cash Deposit");
        System.out.println("5. Exit");
        int opt = sf.nextInt();
        
        switch(opt){
            case 1:
                chkBal(user);
                break;
            
            case 2:
                cshWtd(user);
                break;
            case 3:
                pinChng(user);
                break;
            case 4:
                cshDep(user);
                break;
            case 5:
                exit();
                break;
            default:
                System.out.println("Incorrect option");
                delay(2000);
                thank();
        }
        
    }
    
	public static void main(String[] args) {
	    while(true){
	    int user=0,chk=0;
	    System.out.println("Welcome to IOB");
	    System.out.println();System.out.println();
	    System.out.println("Enter 1 to continue");
	    System.out.println("Enter 2 to login as Admin");
	    int ch = sf.nextInt();
	    if(ch == 2){
	        admin();
	    } else {
	        clearScreen();
	    System.out.println("Welcome to IOB");
	    System.out.println();System.out.println();
		System.out.print("Enter Your Username: ");
		String usr = sf.next();
		System.out.print("Enter Your Pin: ");
		int pass = sf.nextInt();
	
		for(int i=0;i<2;i++){
		 if(usr.equals(usrNames[i]) && pass == passArr[i]){
		     user = i;
		    afterLogin(user);
		    user=0;
		    chk=1;
		    break;
		 }
		}
		if(chk == 0){
		clearScreen();
		     System.out.println("Wrong Username or Password... Please Try Again...");
		     delay(3000);
		}
		clearScreen();
	}
	}
	}
}



