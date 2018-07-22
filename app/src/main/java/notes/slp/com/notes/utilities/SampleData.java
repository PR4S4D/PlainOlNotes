package notes.slp.com.notes.utilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import notes.slp.com.notes.database.NoteEntity;

public class SampleData {

    private static final String SAMPLE_TEXT_1 = "A Simple note";
    private static final String SAMPLE_TEXT_2 = "A note with a\n line feed";
    private static final String SAMPLE_TEXT_3 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum";

    private static Date getDate(int diff) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(Calendar.MILLISECOND, diff);
        return cal.getTime();
    }

    public static List<NoteEntity> getNotes(){
        List<NoteEntity> notes = new ArrayList<>();
        notes.add(new NoteEntity( getDate(0), SAMPLE_TEXT_1));
        notes.add(new NoteEntity( getDate(-1), SAMPLE_TEXT_2));
        notes.add(new NoteEntity( getDate(-2), SAMPLE_TEXT_3));
        return notes;
    }

}
