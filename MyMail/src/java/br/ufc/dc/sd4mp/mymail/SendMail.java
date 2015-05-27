package br.ufc.dc.sd4mp.mymail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class SendMail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mail);
    }

    public void SendEmailImplicit(View view){
        EditText email = (EditText)findViewById(R.id.email_destinatario);
        EditText assunto = (EditText)findViewById(R.id.assunto_email);
        EditText corpo = (EditText)findViewById(R.id.corpo_email);

        if(email.getEditableText().toString().isEmpty() || assunto.getEditableText().toString().isEmpty() || corpo.getEditableText().toString().isEmpty()){
            return;
        }

        else {
            Intent message = new Intent(Intent.ACTION_SEND);
            message.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getEditableText().toString()});
            message.putExtra(Intent.EXTRA_SUBJECT, assunto.getEditableText().toString());
            message.putExtra(Intent.EXTRA_TEXT, corpo.getEditableText().toString());
            message.setType("plain/text");
            startActivity(Intent.createChooser(message, "Enviando e-mail..."));
        }
    }

    public void TelaAnterior(View view){
        Context context = getApplicationContext();
        CharSequence text = "Email descartado!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        finish();
    }

}
