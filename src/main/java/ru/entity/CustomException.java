package ru.entity;

public class CustomException {

    private int type;
    private String message;
    private long duration;

    public CustomException(int type, String message, long duration) {
        this.type = type;
        this.message = message;
        this.duration = duration;
    }

    public CustomException() {}

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Exception{" +
                "type=" + type +
                ", message='" + message + '\'' +
                ", duration=" + duration +
                '}';
    }
}
