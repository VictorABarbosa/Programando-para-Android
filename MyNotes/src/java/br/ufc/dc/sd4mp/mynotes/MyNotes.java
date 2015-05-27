package br.ufc.dc.sd4mp.mynotes;

import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MyNotes extends Activity implements DialogInterface.OnCancelListener{
    private NoteDAO noteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes);
        noteDAO = new NoteDAO(this);
    }

    public void UserConfirmAddNote(View view){
        AddNotesDialog addDialog = new AddNotesDialog();
        addDialog.setContext(this);
        addDialog.show(getFragmentManager(),"Adicionar nota");
    }

    public void UserConfirmEditNote(View view){
        EditeNotesDialog editDialog = new EditeNotesDialog();
        editDialog.setContext(this);
        editDialog.show(getFragmentManager(),"Editar nota");
    }

    public void UserConfirmDeleteNote(View view){
        DeleteNotesDialog deleteDialog = new DeleteNotesDialog();
        deleteDialog.setContext(this);
        deleteDialog.show(getFragmentManager(),"Remover nota");
    }

    public void addNote() {
        EditText noteId = (EditText) findViewById(R.id.editTextId);

        if (noteId.getText().toString().isEmpty()) {
            EditText titleText = (EditText) findViewById(R.id.editTextTitle);
            EditText contentText = (EditText) findViewById(R.id.editTextContent);
            Note note = new Note();
            note.setTitle(titleText.getText().toString());
            note.setContent(contentText.getText().toString());



            noteDAO.create(note);

            List<Note> notes = noteDAO.list();
            Iterator<Note> it = notes.iterator();
            StringBuffer buffer = new StringBuffer();
            buffer.append("\n");
            while (it.hasNext()) {
                note = it.next();
                buffer.append(note.toString());
                buffer.append("\n");
            }
            TextView list = (TextView) findViewById(R.id.textViewNotes);
            list.setText(buffer.toString());
        }
    }

    public void editNote(){
        EditText noteId = (EditText) findViewById(R.id.editTextId);

        if (!noteId.getText().toString().isEmpty()) {
            EditText titleText = (EditText) findViewById(R.id.editTextTitle);
            EditText contentText = (EditText) findViewById(R.id.editTextContent);
            Note note = new Note();
            note.setId(new Integer(noteId.getText().toString()));
            note.setTitle(titleText.getText().toString());
            note.setContent(contentText.getText().toString());
            noteDAO.update(note);
        }
    }

    public void deleteNote(){
        EditText noteId = (EditText) findViewById(R.id.editTextId);
        if (!noteId.getText().toString().isEmpty()){
            noteDAO.delete(new Integer(noteId.getText().toString()));
        }
    }

    public void listNote(View view) {
        EditText noteId = (EditText) findViewById(R.id.editTextId);

        if (!noteId.getText().toString().isEmpty()) {
            Note note = null;
            note = noteDAO.retrieve(new Integer(noteId.getText().toString()));

            if (note != null) {
                StringBuffer buffer = new StringBuffer();
                buffer.append(note.toString());
                buffer.append("\n");

                TextView list = (TextView) findViewById(R.id.textViewNotes);
                list.setText(buffer.toString());
            }
        }
    }

    public void listDescCreationTime(View view){
        Note note = null;
        List<Note> notes = noteDAO.listByCreationTime();
        if (notes != null) {
            Iterator<Note> it = notes.iterator();
            StringBuffer buffer = new StringBuffer();
            buffer.append("\n");
            while (it.hasNext()) {
                note = it.next();
                buffer.append(note.toString());
                buffer.append("\n");
            }
            TextView list = (TextView) findViewById(R.id.textViewNotes);
            list.setText(buffer.toString());
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {

    }
}
