// Builder - нужен чтобы поэтапно создавать сложные объекты, https://youtu.be/mg_TOPMYTuc?si=e6yc0b9oCYamn_lM

public class TicketBooking {
    private String movieTitle;
    private String seatNumber;
    private String snackCombo;
    // конструктор чтобы объекты можно было создавать только через билдер
    public TicketBooking(TicketBookingBuilder builder) {
        this.movieTitle = builder.movieTitle;
        this.seatNumber = builder.seatNumber;
        this.snackCombo = builder.snackCombo;
    }
    public String getMovieTitle() {
        return movieTitle;
    }
    public String getSeatNumber() {
        return seatNumber;
    }
    public String getSnackCombo() {
        return snackCombo;
    }
}