// абстрактный метод который фабрики должны реализовать, изучал от сюда https://www.youtube.com/watch?v=lDAmTcmnpx4&ab_channel=AlexeyPashchenko и https://www.youtube.com/watch?v=EdFq_JIThqM&t=338s&ab_channel=Geekific
// фабрика позволяет одним методом расписать разные объекты
public abstract class MovieFactory {
    public abstract Movie createMovie(String title);
}