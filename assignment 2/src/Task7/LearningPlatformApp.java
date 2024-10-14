package Task7;

interface VideoLecture {
    String getInfo();
    void play();
}

class RealVideoLecture implements VideoLecture {
    private String title;

    public RealVideoLecture(String title) {
        this.title = title;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading video: " + title);
    }

    public String getInfo() {
        return title;
    }

    public void play() {
        System.out.println("Playing video: " + title);
    }
}

class ProxyVideoLecture implements VideoLecture {
    private RealVideoLecture realVideo;
    private String title;

    public ProxyVideoLecture(String title) {
        this.title = title;
    }

    public String getInfo() {
        return title;
    }

    public void play() {
        if (realVideo == null) {
            realVideo = new RealVideoLecture(title);
        }
        realVideo.play();
    }
}

class OnlineCourse {
    private java.util.List<VideoLecture> lectures = new java.util.ArrayList<>();

    public void addLecture(VideoLecture lecture) {
        lectures.add(lecture);
    }

    public void playLecture(int index) {
        VideoLecture lecture = lectures.get(index);
        lecture.play();
    }

    public void showLectureList() {
        for (int i = 0; i < lectures.size(); i++) {
            System.out.println(i + ": " + lectures.get(i).getInfo());
        }
    }
}

class LearningPlatformApp {
    public static void main(String[] args) {
        OnlineCourse course = new OnlineCourse();
        course.addLecture(new ProxyVideoLecture("Design Patterns in Java"));
        course.addLecture(new ProxyVideoLecture("Advanced Java Programming"));

        course.showLectureList();
        course.playLecture(0);
        course.playLecture(1);
    }
}
