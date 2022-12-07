package frequency;

import java.time.LocalDateTime;

public class EveryWeekFrequency implements IFrequency{
    @Override
    public LocalDateTime nextTime(LocalDateTime dateTime) {
        return dateTime.plusWeeks(1);
    }
}
