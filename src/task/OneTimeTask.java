package task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {
    public OneTimeTask(String header, String info, LocalDateTime dateTime, Type type) {
        super(header, info, dateTime, type);
    }

    @Override
    public boolean nextTime(LocalDate date) {
        if (date.isEqual(this.getDateTime().toLocalDate())) {
            return true;
        }
        return false;
    }
}
