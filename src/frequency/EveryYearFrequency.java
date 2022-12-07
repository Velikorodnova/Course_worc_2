package frequency;

import java.time.LocalDateTime;

public class EveryYearFrequency implements IFrequency{
    @Override
    public LocalDateTime nextTime(LocalDateTime dateTime) {
        return dateTime.plusYears(1);
    }
}
