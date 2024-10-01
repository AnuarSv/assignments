public class RegularMovie extends Movie {
    private String title;
    // меняем глоб перем
    public RegularMovie(String title) {
        this.title = title;
    }
    // вернем имя
    @Override
    public String getTitle() {
        return title;
    }
    // вернем тип
    @Override
    public String getType() {
        return "обычный";
    }
}
