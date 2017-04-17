package erudite.maotronics.com;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Exam extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    int year;
    String subject;
    Backend DATABASE;
    TextView questionView;
    RadioGroup optionGroup;
    RadioButton option1, option2, option3, option4;
    Button next, previous, gotoQuestion;
    NumberPicker questionSelector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exams);


        // Get passed parameter from previous classes e.g subject and year.
        Bundle previousClass = getIntent().getExtras();
        subject = previousClass.getString("subject");
        year = previousClass.getInt("year");

        // use database
        callDatabase(subject, year);

        // integrate xml view with activity
        initializeView();

        //display from database
        displayToViews();
    }

    private void displayToViews() {
        questionView.setText(DATABASE.getQuestion());
        option1.setText(DATABASE.getOption1());
        option2.setText(DATABASE.getOption2());
        option3.setText(DATABASE.getOption3());
        option4.setText(DATABASE.getOption4());
    }

    private void initializeView() {
        //Define View
        questionView = (TextView) findViewById(R.id.questionView);
        questionView = (TextView) findViewById(R.id.timerView);
        questionView = (TextView) findViewById(R.id.questionView);
        option1 = (RadioButton) findViewById(R.id.option1);
        option2 = (RadioButton) findViewById(R.id.option2);
        option3 = (RadioButton) findViewById(R.id.option3);
        option4 = (RadioButton) findViewById(R.id.option4);
        questionSelector = (NumberPicker) findViewById(R.id.questionpicker);
        questionSelector.setMinValue(1);
        questionSelector.setMaxValue(50);
        gotoQuestion = (Button) findViewById(R.id.gotoQuestion);
        next = (Button) findViewById(R.id.next);
        previous = (Button) findViewById(R.id.previous);
        optionGroup = (RadioGroup) findViewById(R.id.optionGroup);

        //Attach onClickListener to buttons
        gotoQuestion.setOnClickListener(this);
        previous.setOnClickListener(this);
        next.setOnClickListener(this);
        optionGroup.setOnCheckedChangeListener(this);


    }

    private void callDatabase(String subject, int year) {
        // Call the Database
        DATABASE = new Backend(subject, year);
    }

    @Override
    public void onClick(View view) {
        // get id value of view clicked
        int viewId = view.getId();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        // get id value of radio checked
        int viewId = radioGroup.getId();
    }
}
