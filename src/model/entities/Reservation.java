package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//Constructor's
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	//Getters and Setters
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

	//Methods anda toString
	public long duration () {
		long diff = checkOut.getTime() - checkIn.getTime(); //Usando o getTime pega a data fornecida  na variavel em milisegundos, com isso e possivel fazer calculos colocandoas numa variavel tipo long
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //Com o Time Unit converte os milisegundos em dias
	}
	
	public void updateDates (Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString () {
		return "Room " + roomNumber + ", "
				+ "check-in " + sdf.format(checkIn) + ", "
				+ "check-out " + sdf.format(checkOut) + ", "
				+ duration() + " nights";
	}
	
}
