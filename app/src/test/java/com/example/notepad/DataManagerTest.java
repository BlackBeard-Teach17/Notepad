package com.example.notepad;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Before;

import static org.junit.Assert.*;

public class DataManagerTest {
    static DataManager sDataManager;

    @BeforeClass
    public static void classSetUp() throws Exception {
        sDataManager = DataManager.getInstance();
    }

    @Before
    public  void setUp() throws Exception {
        sDataManager.getNotes().clear();
        sDataManager.initializeExampleNotes();
    }

    @Test
    public void createNewNote() throws Exception {
        final CourseInfo course = sDataManager.getCourse("android_async");
        final String noteTitle = "Test note Title";
        final String noteText = "Note Text Body test Hello Hello";

        int noteIndex = sDataManager.createNewNote();
        NoteInfo newNote = sDataManager.getNotes().get(noteIndex);
        newNote.setCourse(course);
        newNote.setTitle(noteTitle);
        newNote.setText(noteText);

        NoteInfo compareNote = sDataManager.getNotes().get(noteIndex);
        assertEquals(noteText, compareNote.getText());
        assertEquals(course, compareNote.getCourse());
        assertEquals(noteText, compareNote.getText());
    }
}
