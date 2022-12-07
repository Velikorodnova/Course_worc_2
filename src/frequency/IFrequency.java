package frequency;

import java.time.LocalDateTime;

public interface IFrequency {

    LocalDateTime nextTime(LocalDateTime dateTime);
}
