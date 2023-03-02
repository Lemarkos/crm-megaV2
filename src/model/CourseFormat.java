package model;

import enums.Format;

public class CourseFormat extends BaseEntity {
    private enums.Format format;
    private int duration;
    private boolean isOnline;
    private int lessonDuration;
    private int lessonsInWeek;

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public int getLessonDuration() {
        return lessonDuration;
    }

    public void setLessonDuration(int lessonDuration) {
        this.lessonDuration = lessonDuration;
    }

    public int getLessonsInWeek() {
        return lessonsInWeek;
    }

    public void setLessonsInWeek(int lessonsInWeek) {
        this.lessonsInWeek = lessonsInWeek;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "CourseFormat{" +
                "id='" + getId() + "\'" +
                "format=" + format.getF() +
                ", duration=" + duration +
                ", isOnline=" + isOnline +
                ", lessonDuration=" + lessonDuration +
                ", lessonsInWeek=" + lessonsInWeek +
                '}';
    }
}
