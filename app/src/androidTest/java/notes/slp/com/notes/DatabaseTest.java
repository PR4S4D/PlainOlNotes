package notes.slp.com.notes;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import notes.slp.com.notes.database.AppDatabase;
import notes.slp.com.notes.database.NoteDao;
import notes.slp.com.notes.database.NoteEntity;
import notes.slp.com.notes.utilities.SampleData;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    public static final String TAG = "Junit";
    private AppDatabase mDb;
    private NoteDao mDao;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        mDao = mDb.noteDao();
        Log.i(TAG, "createDb");
    }

    @After
    public void closeDb() {
        mDb.close();
        Log.i(TAG, "closeDb");
    }

    @Test
    public void createAndRetrieveNotes() {
        mDao.insertAll(SampleData.getNotes());
        int count = mDao.getCount();
        assertEquals(count, SampleData.getNotes().size());
    }

    @Test
    public void compareStrings() {
        mDao.insertAll(SampleData.getNotes());
        NoteEntity original = SampleData.getNotes().get(0);
        NoteEntity fromDb = mDao.getNodeById(1);
        assertEquals(original.getText(), fromDb.getText());
    }

}
