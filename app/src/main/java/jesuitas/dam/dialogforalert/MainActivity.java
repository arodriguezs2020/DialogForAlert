package jesuitas.dam.dialogforalert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowAlert(View view) {
        AlertDialog.Builder myAlertBuilder = new
                AlertDialog.Builder(MainActivity.this);

        myAlertBuilder.setTitle(R.string.alert_title);
        myAlertBuilder.setMessage(R.string.alert_message);

        myAlertBuilder.setPositiveButton(R.string.ok_button, new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User clicked OK button.
                        displayToast(getString(R.string.press_ok));

                    }
                });
        myAlertBuilder.setNegativeButton(R.string.cancel_button, new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User cancelled the dialog.
                        displayToast(getString(R.string.press_cancel));

                    }
                });

        myAlertBuilder.show();

    }

    public void onClickShowAlertList(View view) {

        AlertDialog.Builder myAlertBuilder = new
                AlertDialog.Builder(MainActivity.this);

        myAlertBuilder.setTitle(R.string.alert_title);

        myAlertBuilder.setItems(R.array.array, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                String band;
                band = getResources().getStringArray(R.array.array)[i];
                displayToast(band);
            }
        });

        myAlertBuilder.show();

    }

    public void displayToast(String text) {
        Toast.makeText(getApplicationContext(), text,
                Toast.LENGTH_SHORT).show();
    }
}