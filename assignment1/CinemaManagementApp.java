// Main Application
public class CinemaManagementApp {
    public static void main(String[] args) {
        // Singleton usage
        CinemaConfig config = CinemaConfig.getInstance();
        config.setCinemaName("Starlight Cinemas");
        System.out.println("Cinema Name: " + config.getCinemaName());
        // Factory Method usage
        MovieFactory regularFactory = new RegularMovieFactory();
        Movie movie = regularFactory.createMovie("Inception");
        System.out.println("Movie: " + movie.getTitle() + ", Type: " + movie.getType());
        // Abstract Factory usage
        UIFactory uiFactory = new DarkThemeFactory();
        Button button = uiFactory.createButton();
        button.render();
        // Builder usage
        TicketBooking booking = new TicketBookingBuilder()
                .setMovieTitle("Inception")
                .setSeatNumber("A1")
                .setSnackCombo("Popcorn and Soda")
                .build();
        System.out.println("фильм: " + booking.getMovieTitle());
        System.out.println("место: " + booking.getSeatNumber());
        System.out.println("еда: " + booking.getSnackCombo());
        // Prototype usage
        StandardSchedule template = new StandardSchedule();
        template.setTime("18:00");
        MovieSchedule eveningSchedule = template.clone();
        eveningSchedule.setMovie(movie);
        System.out.println("Cinema Management System initialized.");
        template.printSchedule();
    }
}