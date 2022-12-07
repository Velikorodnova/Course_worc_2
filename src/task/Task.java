package task;

import frequency.IFrequency;

import java.time.LocalDateTime;

public class Task {

    private String header;
    private String info;
    private int id;
    private LocalDateTime dateTime;
    private Type type;
    private IFrequency frequency;

    public Task(String header, String info, LocalDateTime dateTime, Type type, IFrequency frequency) {
        this.header = header;
        this.info = info;
        this.id = IdGenerator.generateId();
        this.dateTime = dateTime;
        this.type = type;
        this.frequency = frequency;
    }
    public String getHeader() {
        return header;
    }

    public String getInfo() {
        return info;
    }

    public int getId() {
        return id;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
