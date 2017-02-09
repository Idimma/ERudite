package erudite.maotronics.com.erudite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class YearPicker extends Activity {
    NumberPicker yearPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.year_picker);
        Bundle previousClass = getIntent().getExtras();
        final String subject = previousClass.getString("subject");
        yearPicker = (NumberPicker) findViewById(R.id.numberPicker);
        yearPicker.setValue(2016);
        yearPicker.setMinValue(1989);
        yearPicker.setMaxValue(2016);
        final Button numberPicker_Button = (Button) findViewById(R.id.numberPicker_button);
        numberPicker_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int year = yearPicker.getValue();
                Intent nextActivity = new Intent(getApplicationContext(), Exam.class);
                nextActivity.putExtra("subject", subject);
                nextActivity.putExtra("year", year);
                startActivity(nextActivity);

            }
        });
    }
}
