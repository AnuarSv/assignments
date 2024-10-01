public class StandardSchedule implements MovieSchedule {
    private Movie movie;
    private String time;

    // время показа
    @Override
    public void setTime(String time) {
        this.time = time;
    }

    // меняю глоб перем кино
    @Override
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    // копирую объект расписания
    @Override
    public MovieSchedule clone() {
        try {
            return (MovieSchedule) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    // вывод расписания
    public void printSchedule() {
        System.out.println("Movie: " + (movie != null ? movie.getTitle() : "No movie") + ", Time: " + time);
    }
}
