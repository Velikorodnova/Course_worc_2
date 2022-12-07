package frequency;

import java.time.LocalDateTime;

public class EveryDayFrequency implements IFrequency {

    @Override
    public LocalDateTime nextTime(LocalDateTime dateTime) {
        return dateTime.plusDays(1);
    }
}
