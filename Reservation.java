public class Reservation{
    private User user;
    private Flight flight;
    private int seatNumber;

    public Reservation(User user, Flight flight, int seatNumber) {
        this.user = user;
        this.flight = flight;
        this.seatNumber = seatNumber;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}