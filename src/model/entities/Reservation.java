package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//stattic para que n�o seja estanciado um novo sdf a cada aplica��o
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
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
	
	
	
	public String updateDates (Date checkIn, Date checkOut) {//recebe duas datas novas e atualiza as informa��es
	 //m�todo agora n�o � mais void mas sim String porque dependendo do erro ele vai retornanr a mensagem
		
		Date now = new Date(); // cria uma vari�vel com data de agora
		if (checkIn.before(now) || checkOut.before(now)) {     //se a data de checkin ou a de checkout for antes de agora
		   return "Reservation dates for update must be future dates";
		}
		if (!checkOut.after(checkIn)) {  //teste se a data de chekout n�o for posterior a data de checkin
			return "Check-out date must be after check-in date";
		}		
		this.checkIn = checkIn;
		this.checkOut = checkOut; // do objeto recebe o do argumento
	    return null; // crit�rio que falar� se a minha opera��o n�o deu nenhum erro
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
