package g313.bashmachenkov.lab05;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText text;
    CheckBox box1,box2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.input_text);
        box1 = findViewById(R.id.Box1);
        box2 = findViewById(R.id.Box2);
    }

    @Override
    protected void onActivityResult(int requestcode, int resultCode, @Nullable Intent data){
        if(requestcode == 555)
        {
            if(data != null)
            {
                String s = data.getStringExtra("qwe1");
                box1.setChecked(data.getBooleanExtra("qwe2",false));
                box2.setChecked(data.getBooleanExtra("qwe3",false));
                Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
                text.setText(s);
            }
        }
        super.onActivityResult(requestcode,resultCode,data);
    }


    public void on_exit_click(View v){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setView(R.layout.dialog);
        dialog.setTitle("Есть вопрос");
        dialog.setIcon(R.drawable.logo1);
        dialog.setPositiveButton("ОК", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                finish();
            }
        });
        dialog.setNegativeButton("Отмена",null);
        dialog.show();


    }

    public void on_dialog_click(View v){
        String s = text.getText().toString();

        Intent i = new Intent(this,MainActivity2.class);

        i.putExtra("text",s);
        i.putExtra("box1",box1.isChecked());
        i.putExtra("box2",box2.isChecked());


        startActivityForResult(i,555);

    }

    public void open_isolated_diaalog(View v ){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setView(R.layout.activity_main2);
        dialog.setTitle("Есть вопрос");
        dialog.setPositiveButton("", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                EditText txt = findViewById(R.id.Edit_text_2);
                RadioButton radio1 = findViewById(R.id.radio1);
                RadioButton radio2 = findViewById(R.id.radio2);

                Intent i = new Intent();

                String s = txt.getText().toString();
                i.putExtra("qwe1",s);
                i.putExtra("qwe2",radio1.isChecked());
                i.putExtra("qwe3",radio2.isChecked());

                setResult(RESULT_OK,i);
                finish();
            }
        });
        dialog.setNegativeButton("", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        dialog.setIcon(R.drawable.logo1);
        dialog.show();
    }
}