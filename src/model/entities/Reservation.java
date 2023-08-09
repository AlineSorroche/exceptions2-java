package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//stattic para que n�o seja estanciado um novo sdf a cada aplica��o
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {//tratar as exce��es no come�o do m�todo � uma boa pr�tica e se chama programa��o defensiva 
		if (!checkOut.after(checkIn)) {  //teste se a data de chekout n�o for posterior a data de checkin
			throw new DomainException("Check-out date must be after check-in date");
		}		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	

	public Date getCheckOut() {
		return checkOut;
	}

	
	public long duration() { // implementar a diferen�a entre duas datas
		long diff = checkOut.getTime() - checkIn.getTime();//calculo a diferen�a em milisegundos
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);//converte o valor diff que estava em miliseconds para dias
	}
	
	
	
	public void updateDates (Date checkIn, Date checkOut) {//recebe duas datas novas e atualiza as informa��es
	 //m�todo agora volta a ser void mas caso acont�a algum erro eu vou lan�ar a exce��o
		
		Date now = new Date(); // cria uma vari�vel com data de agora
		if (checkIn.before(now) || checkOut.before(now)) {     //se a data de checkin ou a de checkout for antes de agora
		   throw new DomainException("Reservation dates for update must be future dates");//erro nos argumentos dos m�todos, posso usar essa classe de exce��o pronta
		}
		if (!checkOut.after(checkIn)) {  //teste se a data de chekout n�o for posterior a data de checkin
			throw new DomainException("Check-out date must be after check-in date");
		}		
		this.checkIn = checkIn;
		this.checkOut = checkOut; // do objeto recebe o do argumento
	}
	
	@Override
	public String toString() {
		return "Room "
		    + roomNumber
		    + ", check-in: "
		    + sdf.format(checkIn)
		    + ", check-out: "
		    + sdf.format(checkOut)
		    + ", "
		    + duration()
		    + " nights";
	}
	
	

}
