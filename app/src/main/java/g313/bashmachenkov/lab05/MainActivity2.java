package g313.bashmachenkov.lab05;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText txt;
    RadioButton radio1,radio2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt = findViewById(R.id.Edit_text_2);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);


        Intent i = getIntent();
        String s = i.getStringExtra("text");
        txt.setText(s);
        boolean b = i.getBooleanExtra("box1",false);
        radio1.setChecked(b);
        boolean a = i.getBooleanExtra("box2",false);
        radio2.setChecked(a);

    }



    public void on_cancel_click(View v)
    {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void on_ok_click(View v)
    {
        Intent i = new Intent();

        String s = txt.getText().toString();
        i.putExtra("qwe1",s);
        i.putExtra("qwe2",radio1.isChecked());
        i.putExtra("qwe3",radio2.isChecked());

        setResult(RESULT_OK,i);
        finish();
    }
}