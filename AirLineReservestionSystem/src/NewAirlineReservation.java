import java.util.Scanner;

public class NewAirlineReservation {
	//array of seats
	boolean[] flightSeats = new boolean[11];
	Scanner scanner = new Scanner(System.in);
	
	public void start() {
		while(true)
		{
			bookSeat();
		}
	}
	
	
	//function for booking a seat in reservasion system
	public void bookSeat() {
		
		//ask the user for his preferred class to travel
		System.out.println("Choose you preference: type '1' for First class or '2' for Economy class:");
	    int passengerClass = scanner.nextInt();
	    if(passengerClass == 1) {
	    	firstClassBooking();
	    }
	    else {
	    	economyClassBooking();
	    }
	}
	
	//check and book for first class seating
	public void firstClassBooking() {
		for(int i=1; i<=5; i++) {
			
			//check if seat is available to allocate to user booking
			if(flightSeats[i] == false) {
				
				//book seat
				flightSeats[i] = true;
				System.out.printf("First class seet Booking: %d\n", i);
				break;
			}
			else if(flightSeats[5] == true) {
				if(flightSeats[10] == true) {
					
					//if both classes  are fully booked
					System.out.println("Apologies!! all seats are booked , next flight is scheduled in '3' hours");
					
				} else {
					
					//provide paseednger another available class option
					System.out.println("Sorry, first class bookings are over. would like to opt for economy class? select '1' for yes and '2' for no");
					
					int  selection = scanner.nextInt(); 
					if(selection == 1) {
						economyClassBooking();
						start();
						
					}else {
						System.out.println("Next flight is scheduled in '3' hours");
						System.exit(0);
					}
					
					
				}
				
				
			}
		}
	}
	
	//check and booking for economy class seating
	public void economyClassBooking() {
		for(int j=6; j<=10; j++) {
			if(flightSeats[j] == false) {
				flightSeats[j]= true;
				System.out.printf("Economy class seat booking %d\n", j);
				break;
			}
			else if(flightSeats[10] == true) {
				if(flightSeats[5] == true) {
					System.out.println("Apologies!! all seats are booked. Next flight is cheduled in '3' hours");
					System.exit(0);
				}
				else {
					System.out.println("Sorry, Economy class seat bookings are over. Wpold you like to opt for first seat? press '1' for yes and '2' foe No");
					int selection = scanner.nextInt();
					if(selection == 1) {
						firstClassBooking();
						start();
						
					}
					else {
						System.out.println("Next flight is scheduled in 3 hours");
						System.exit(0);
					}
				}
			}
		}
		
		
		
	}

	
}
