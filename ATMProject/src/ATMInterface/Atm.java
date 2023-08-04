package ATMInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class Atm {
		
		int bal=30000, draw,depo;
		String ac_name;
		long ac_num;
		int ac_transfer;
		int flag;
		
		Scanner sc=new Scanner(System.in);
		ArrayList<String> his=new ArrayList<>();
		
		
		//Withdrawal of amount
		public void withdraw() {
			System.out.println("Enter the amount to withdraw : ");
			draw=sc.nextInt();
			if(bal>=draw) {
				bal=bal-draw;
				System.out.println("Withdrawal successful...");
				String w="Withdraw : "+draw;
				his.add(w);
				flag+=1;
			}
			else {
				System.out.println("Insufficient balance...");
			}
		}
		
		
		//Deposit the amount
		public void deposit() {
			System.out.print("Enter the amount to deposit :");
			depo=sc.nextInt();
			bal=bal+depo;
			System.out.println("Amount has been successfully deposited...");
			String d="Deposit : "+depo;
			his.add(d);
			flag+=1;
		}
		
		
		//Transfer the amount
		void transfer() {
			System.out.println("Enter the bank details");
			System.out.println("Account Number : ");
			ac_num=sc.nextLong();
			System.out.println("Enter amount : ");
			ac_transfer=sc.nextInt();
			if(ac_transfer>bal) {
				System.out.println("Insufficient balance...");
			}
			else {
				System.out.println("Account holder's name : ");
				ac_name=sc.next();
				bal=bal-ac_transfer;
				System.out.println("Transfer successful !!!");
				String t="Transfer : "+ac_transfer;
				his.add(t);
				flag+=1;
			}
		}
		
		
		//Check the balance
		void checkBalance() {
			System.out.println("Balance : "+bal);
		}
		
		
		//Transaction History
		void transHistory() {
			System.out.println("Your recent transactions are : ");
			for(int i=0;i<flag;i++) {
				System.out.println(his.get(i));
			}
		}
		
		
		//Exit
		void exit() {
			System.out.println("-----THANK YOU FOR USING THE ATM-----");
			System.exit(0);
		}
		
		
		class atm_interface{
			
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			int bal=30000;
			
			ArrayList<Integer> cust = new ArrayList<>();
			cust.add(12345);
			cust.add(11223);
			cust.add(99999);
			
			ArrayList<Integer> pin = new ArrayList<>();
			pin.add(1111);
			pin.add(1122);
			pin.add(2222);
			
			while(true) {
				Atm at = new Atm();
				System.out.println("\n");
				System.out.println("-----WELCOME-----");
				System.out.println();
				System.out.println("Enter the account number : ");
				int ac_num=sc.nextInt();
				System.out.println("Enter the PIN : ");
				int pin_num=sc.nextInt();
				
				for(int i=0;i<5;i++) {
					if(cust.get(i).equals(ac_num) && pin.get(i).equals(pin_num)) {
						while(true) {
							System.out.println("\n");
							System .out.println("1. Transaction History \n2. Withdraw \n3. Deposit \n4. Transfer \n5. Check Balance \n6. Exit");
	                        System.out.print("Choose the operation you would like to perform : ");
	                        int num = sc.nextInt();
	                        System.out.println("\n");

	                        switch (num) {
	                            case 1:
	                            	at.transHistory();
	                                break;
	                            case 2:
	                            	at.withdraw();
	                                break;
	                            case 3:
	                            	at.deposit();
	                                
	                                break;
	                            case 4:
	                                at.transfer();
	                                break;
	                            case 5:
	                            	at.checkBalance();
	                                break;
	                            case 6:
	                                at.exit();
	                                break;
	                            default:
	                                System.out.println("Invalid option");
	                                break;
	                        }
	                    }
	                }
	                else {
	                    System.out.println("Wrong password...Access denied !!!");
	                    break;
						}
					}
				}
			}
		}
	
}
