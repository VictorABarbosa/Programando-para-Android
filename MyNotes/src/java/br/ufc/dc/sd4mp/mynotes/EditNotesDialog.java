package br.ufc.dc.sd4mp.mynotes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Victor on 24/04/2015.
 */
public class EditeNotesDialog extends DialogFragment {

    private MyNotes contexto;

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder
                .setMessage(R.string.deseja_confirmar_edicao)
                .setPositiveButton(R.string.editar_ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        contexto.editNote();

                        Context context = contexto;
                        CharSequence text = "Sua nota foi editada com sucesso!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                })
                .setNegativeButton(R.string.editar_cancela, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Context context = contexto;
                        CharSequence text = "Edição de nota cancelada!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    public void setContext(MyNotes context){
        this.contexto = context;
    }

}
