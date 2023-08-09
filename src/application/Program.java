package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {//Solução muito ruim porque a lógica está no programa princiapl, deveria estar na classe reserva

	public static void main(String[] args) throws ParseException {//porque não estou tratando a exceção
	
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) { // testando se a data final é anterior a inicial
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
						
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy) : ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy) :");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date(); // cria uma variável com data de agora
			if (checkIn.before(now) || checkOut.before(now)) {     //se a data de checkin ou a de checkout for antes de agora
			   System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if (!checkOut.after(checkIn)) {  //teste se a data de chekout não for posterior a data de checkin
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			}
		}
			
		
		
		sc.close();

	}

}
