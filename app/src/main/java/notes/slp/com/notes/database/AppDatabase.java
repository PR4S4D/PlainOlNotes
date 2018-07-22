package notes.slp.com.notes.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;

@Database(entities = {NoteEntity.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    public  static final  String DATABASE_NAME = "AppDatabase.db";
    private static volatile AppDatabase instance;
    private static  final Object LOCK = new Object();

    public  abstract NoteDao noteDao();

    public static AppDatabase getInstance(Context context) {
        if(null == instance){
            synchronized (LOCK) {
                if(null == instance) {
                    instance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME).build();
                }
            }
        }
        return instance;
    }

}
