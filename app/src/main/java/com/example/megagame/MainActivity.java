package com.example.megagame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtNumber=null;
    private Button btnCompare;
    private TextView lblResult;
    private ProgressBar progressBar;
    private TextView txthis;

    private int valeurCherche;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber = (EditText) findViewById(R.id.txtNumber);
        btnCompare = (Button) findViewById(R.id.btnCompare);
        lblResult = (TextView) findViewById(R.id.lblResult);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        txthis = (TextView) findViewById(R.id.txthis);


        btnCompare.setOnClickListener(btnCompareListener);



        init();

    }

    private void bravo(){


        lblResult.setText("Bien joué, voullez vous rejouer?");
        AlertDialog retryAlert = new AlertDialog.Builder(this).create();
        retryAlert.setTitle(R.string.app_name);
        //retryAlert.setMessage(getString(score, "gg "));
        retryAlert.setButton(AlertDialog.BUTTON_POSITIVE, "Oui", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                 init();
            }


        });
        retryAlert.setButton(AlertDialog.BUTTON_NEGATIVE, "Non", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
           finish();
            }


        });
        retryAlert.show();
    }
    private void init(){
        score =0;
        valeurCherche=  1 + (int)(Math.random()*100);
        Log.i("DEBUG", "Valeur recherché :"+valeurCherche);
        txtNumber.setText("");
        lblResult.setText("");
        txthis.setText("");
        progressBar.setProgress(score);
        txtNumber.requestFocus();
    }
    private View.OnClickListener btnCompareListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.i("DEBUG", "Bouton cliqué");
            String txtNumberr = txtNumber.getText().toString();
            if(txtNumberr.equals("")) return;
             txthis.append(txtNumber+ "\r\n");
             progressBar.incrementProgressBy(1);
             score++;


            int valeurentre = Integer.parseInt(txtNumberr);

            if(valeurentre==valeurCherche){
                bravo();
            }
            else if(valeurentre>valeurCherche)
            {
                lblResult.setText(R.string.valplusgrand);
            }
            else { lblResult.setText(R.string.valpluspetit);}

               txtNumber.setText("");
            txtNumber.requestFocus();

        }
    };

}
