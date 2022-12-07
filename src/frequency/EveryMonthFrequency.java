package frequency;

import java.time.LocalDateTime;

public class EveryMonthFrequency implements IFrequency{
    @Override
    public LocalDateTime nextTime(LocalDateTime dateTime) {
        return dateTime.plusMonths(1);
    }
}
