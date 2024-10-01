/*Singleton - нужен чтобы дать гарантию что у класса будет всего один экземпляр класса.
а так же предоставляет глоб. точку доступа к экземляру данного класса*/
public class CinemaConfig {
    // если объект будет создан стандартным способом это для него конструктор
    private CinemaConfig() {}
    // cinemaName чтобы дать ему переменную
    private String cinemaName;
    // переменная инстанс с модификатором приват статик
    private static CinemaConfig instance;
    // Будет возращать переменную
    public static CinemaConfig getInstance() {
        // если клиент забыл инитнуть перемнную то для него напишу условие создадим за него объект
        if (instance == null) {
            instance = new CinemaConfig();
        }
        return instance;
    }
    // сетим имя чтобы изменить глоб. переменную
    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }
    // возвращаем
    public String getCinemaName() {
        return cinemaName;
    }
}
