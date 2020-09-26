package com.indeco;

@FunctionalInterface
interface PaymentType{
	void pay();

}

class LocalPayment implements PaymentType{

	@Override
	public void pay() {
		System.out.println("Local payment in INR");
		
	}
	
}

public class Payment {
	
	public void perform(PaymentType type){
		System.out.println("Peform payment");
		type.pay();
	}
	
	public static void main(String[] args) {
		
		// Way to pass just functionality
		new Payment().perform(new LocalPayment());
		
		//Anonymous Class
		new Payment().perform(new PaymentType(){
			@Override
			public void pay() {
				System.out.println("Local payment in INR from Anonymous class");
			}
		});
		
		//Lamda way -- functional
		PaymentType lamda = () -> System.out.println("Payment performed using Lamda");
		new Payment().perform(lamda);
//		new Payment().perform(()-> System.out.println("Payment performed using Lamda") );
		
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("Thread running " + Thread.currentThread().getName());
				
			}
			
		});
		t.start();
		
		Thread t1 = new Thread(()->System.out.println("Thread running " + Thread.currentThread().getName()));
		t1.start();
	}

}
