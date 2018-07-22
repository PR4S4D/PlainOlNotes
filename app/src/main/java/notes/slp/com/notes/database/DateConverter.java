package notes.slp.com.notes.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateConverter {

    @TypeConverter
    public static Date todate(Long timestamp) {
        return null == timestamp ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimeStamp(Date date) {
        return date == null ? null : date.getTime();
    }

}
