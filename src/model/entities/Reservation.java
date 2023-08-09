package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//stattic para que não seja estanciado um novo sdf a cada aplicação
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {//tratar as exceções no começo do método é uma boa prática e se chama programação defensiva 
		if (!checkOut.after(checkIn)) {  //teste se a data de chekout não for posterior a data de checkin
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

	
	public long duration() { // implementar a diferença entre duas datas
		long diff = checkOut.getTime() - checkIn.getTime();//calculo a diferença em milisegundos
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);//converte o valor diff que estava em miliseconds para dias
	}
	
	
	
	public void updateDates (Date checkIn, Date checkOut) {//recebe duas datas novas e atualiza as informações
	 //método agora volta a ser void mas caso acontça algum erro eu vou lançar a exceção
		
		Date now = new Date(); // cria uma variável com data de agora
		if (checkIn.before(now) || checkOut.before(now)) {     //se a data de checkin ou a de checkout for antes de agora
		   throw new DomainException("Reservation dates for update must be future dates");//erro nos argumentos dos métodos, posso usar essa classe de exceção pronta
		}
		if (!checkOut.after(checkIn)) {  //teste se a data de chekout não for posterior a data de checkin
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
