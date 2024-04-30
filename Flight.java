public class Flight {
    private String route;
    private String date;
    private int availableSeats;
    private int price;

    
    public Flight(String route, String date, int availableSeats, int price) {
        this.route = route;
        this.date = date;
        this.availableSeats = availableSeats;
        this.price = price;
    }

    

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}