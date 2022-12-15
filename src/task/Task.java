package task;

import frequency.Frequency;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Task implements Frequency {

    private String header;
    private String info;
    private int id;
    private LocalDateTime dateTime;
    private Type type;

    public Task(String header, String info, LocalDateTime dateTime, Type type) {
        this.header = header;
        this.info = info;
        this.id = IdGenerator.generateId();
        this.dateTime = dateTime;
        this.type = type;
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

    @Override
    public abstract boolean nextTime(LocalDate date);
}
