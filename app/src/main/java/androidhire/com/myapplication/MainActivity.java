package androidhire.com.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText assestvalue;
    EditText percentage;
    EditText year;

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    private TableLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assestvalue = findViewById(R.id.editText);
        percentage = findViewById(R.id.editText2);
        year = findViewById(R.id.editText3);


        textView1 = findViewById(R.id.t1);
        textView2 = findViewById(R.id.t2);
        textView3 = findViewById(R.id.t3);
        tl = findViewById(R.id.tl1);


    }


    public void depcheck(View view) {


        if (assestvalue.getText().toString().isEmpty()) {
            assestvalue.setError("Value not given!");
            assestvalue.requestFocus();
        } else if (percentage.getText().toString().isEmpty()) {
            percentage.setError("Value not given!");
            percentage.requestFocus();
        } else if (year.getText().toString().isEmpty()) {
            year.setError("Value not given!");
            year.requestFocus();

        } else {


            long A = Long.parseLong(assestvalue.getText().toString());
            long P = Long.parseLong(percentage.getText().toString());
            long Y = Long.parseLong(year.getText().toString());

            long temp = A;


            for (int i = 0; i < Y; i++) {

                long dep = temp * P / 100;
                temp = temp - dep;

                addRow(i + 1, temp, dep);
            }
        }

    }

    private void addRow(int month, long temp, float dep) {

        TableRow tr1 = new TableRow(this);
        tr1.setBackgroundColor(Color.parseColor("#ed8404"));


        tr1.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));
        tr1.setPadding(5, 5, 0, 5);


        //TextView 1
        textView1 = new TextView(this);
        textView1.setTextColor(Color.parseColor("#ffffff"));
        textView1.setTextSize(18);
        textView1.setGravity(1);
        textView1.setText(String.valueOf(month));


        //TextView 2
        textView2 = new TextView(this);
        textView2.setTextColor(Color.parseColor("#ffffff"));
        textView2.setTextSize(16);
        textView2.setGravity(1);
        textView2.setText(String.valueOf(temp));

        //TextView 3
        textView3 = new TextView(this);
        textView3.setTextColor(Color.parseColor("#ffffff"));
        textView3.setTextSize(16);
        textView3.setGravity(1);
        textView3.setText(String.valueOf(dep));


        tr1.addView(textView1);
        tr1.addView(textView2);
        tr1.addView(textView3);
        tl.addView(tr1);

    }

}