package bank;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Transaction {
	private static int counter=1000;
	private String transactionId;
	private String transactionType;
	private double amount;
	private LocalDateTime dateTime;
	private String status;
	
	public Transaction(String transactionType,double amount,String status) {
		this.transactionId="TXN"+(++counter);
		this.transactionType=transactionType;
		this.amount=amount;
		this.status=status;
		this.dateTime=LocalDateTime.now();
	}
	
	public void displayTransaction() {
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		System.out.println("Transaction ID: "+transactionId);
		System.out.println("Type: "+transactionType);
		System.out.printf("Amount: Rs. %.2f%n",amount);
		System.out.println("Date and Time: "+ dateTime.format(formatter));
		System.out.println("Status: "+status);
		System.out.println("--------------------------------------");
	}
}
