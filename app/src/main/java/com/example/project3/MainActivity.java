package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Avoid auto-hiding digits/number displayed
        // EditTexts only shows digits in keyboard, since the user can only input number for these questions
        EditText question1EditTextId = findViewById(R.id.question1EditTextId);
        EditText question8EditTextId = findViewById(R.id.question8EditTextId);
        question1EditTextId.setTransformationMethod(null);
        question8EditTextId.setTransformationMethod(null);

    }

    /**
     * Show score in app, after calculating the score.
     *
     * @param view the view
     */
    public void showScore(View view) {

        int numberOfQuestions = 10;
        int numberOfCorrectQuestions = calculateScore();

        Toast.makeText(this, getString(R.string.score, numberOfCorrectQuestions, numberOfQuestions), Toast.LENGTH_LONG).show();
    }

    /**
     * Send results by mail, after calculating the score.
     *
     * @param view the view
     */
    public void sendResults(View view) {
        int numberOfQuestions = 10;
        int numberOfCorrectQuestions = calculateScore();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.results));
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.score, numberOfCorrectQuestions, numberOfQuestions));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Calculates the score checking the answers for each question.
     *
     *
     */
    private int calculateScore() {

        int numberOfCorrectQuestions = 0;

        // Verify Question1
        // Correct Answer -> 5

        EditText question1EditTextId = findViewById(R.id.question1EditTextId);

        int question1Value;
        try {
            question1Value = Integer.parseInt(question1EditTextId.getText().toString());
        } catch (Exception e) {
            question1Value = 0;
        }

        if (question1Value == 5) {
            numberOfCorrectQuestions += 1;
        }


        // Verify Question2
        // Correct Answer -> Argentina

        RadioButton question2RadioButtonOption1Id = findViewById(R.id.question2RadioButtonOption1Id);
        boolean isQuestion2RadioButtonOption1Checked = question2RadioButtonOption1Id.isChecked();

        if (isQuestion2RadioButtonOption1Checked) {
            numberOfCorrectQuestions += 1;
        }


        // Verify Question3
        // Correct Answer -> Madeira

        RadioButton question3RadioButtonOption3Id = findViewById(R.id.question3RadioButtonOption3Id);
        boolean isQuestion3RadioButtonOption3Checked = question3RadioButtonOption3Id.isChecked();

        if (isQuestion3RadioButtonOption3Checked) {
            numberOfCorrectQuestions += 1;
        }


        // Verify Question4
        // Correct Answers -> Juventus, Real Madrid, Sporting, Manchester United
        // Only and all correct answers must be checked in order to the answer be correct

        CheckBox question4CheckBoxOption1Id = findViewById(R.id.question4CheckBoxOption1Id);
        CheckBox question4CheckBoxOption2Id = findViewById(R.id.question4CheckBoxOption2Id);
        CheckBox question4CheckBoxOption3Id = findViewById(R.id.question4CheckBoxOption3Id);
        CheckBox question4CheckBoxOption4Id = findViewById(R.id.question4CheckBoxOption4Id);
        CheckBox question4CheckBoxOption5Id = findViewById(R.id.question4CheckBoxOption5Id);

        boolean isQuestion4CheckBoxOption1Checked = question4CheckBoxOption1Id.isChecked();
        boolean isQuestion4CheckBoxOption2Checked = question4CheckBoxOption2Id.isChecked();
        boolean isQuestion4CheckBoxOption3Checked = question4CheckBoxOption3Id.isChecked();
        boolean isQuestion4CheckBoxOption4Checked = question4CheckBoxOption4Id.isChecked();
        boolean isQuestion4CheckBoxOption5Checked = question4CheckBoxOption5Id.isChecked();

        if (isQuestion4CheckBoxOption1Checked
                && isQuestion4CheckBoxOption2Checked
                && isQuestion4CheckBoxOption3Checked
                && isQuestion4CheckBoxOption4Checked
                && !isQuestion4CheckBoxOption5Checked) {
            numberOfCorrectQuestions += 1;
        }


        // Verify Question5
        // Correct Answers -> Barcelona
        // Only and all correct answers must be checked in order to the answer be correct

        CheckBox question5CheckBoxOption1Id = findViewById(R.id.question5CheckBoxOption1Id);
        CheckBox question5CheckBoxOption2Id = findViewById(R.id.question5CheckBoxOption2Id);
        CheckBox question5CheckBoxOption3Id = findViewById(R.id.question5CheckBoxOption3Id);
        CheckBox question5CheckBoxOption4Id = findViewById(R.id.question5CheckBoxOption4Id);
        CheckBox question5CheckBoxOption5Id = findViewById(R.id.question5CheckBoxOption5Id);

        boolean isQuestion5CheckBoxOption1Checked = question5CheckBoxOption1Id.isChecked();
        boolean isQuestion5CheckBoxOption2Checked = question5CheckBoxOption2Id.isChecked();
        boolean isQuestion5CheckBoxOption3Checked = question5CheckBoxOption3Id.isChecked();
        boolean isQuestion5CheckBoxOption4Checked = question5CheckBoxOption4Id.isChecked();
        boolean isQuestion5CheckBoxOption5Checked = question5CheckBoxOption5Id.isChecked();

        if (isQuestion5CheckBoxOption1Checked
                && isQuestion5CheckBoxOption2Checked
                && isQuestion5CheckBoxOption3Checked
                && isQuestion5CheckBoxOption4Checked
                && !isQuestion5CheckBoxOption5Checked) {
            numberOfCorrectQuestions += 1;
        }


        // Verify Question6
        // Correct Answer -> 18

        RadioButton question6RadioButtonOption2Id = findViewById(R.id.question6RadioButtonOption2Id);
        boolean isQuestion6RadioButtonOption2Checked = question6RadioButtonOption2Id.isChecked();

        if (isQuestion6RadioButtonOption2Checked) {
            numberOfCorrectQuestions += 1;
        }

        // Verify Question7
        // Correct Answer -> 22

        RadioButton question7RadioButtonOption3Id = findViewById(R.id.question7RadioButtonOption3Id);
        boolean isQuestion7RadioButtonOption3Checked = question7RadioButtonOption3Id.isChecked();

        if (isQuestion7RadioButtonOption3Checked) {
            numberOfCorrectQuestions += 1;
        }


        // Verify Question8
        // Correct Answer -> 2008

        EditText question8EditTextId = findViewById(R.id.question8EditTextId);

        int question8Value;
        try {
            question8Value = Integer.parseInt(question8EditTextId.getText().toString());
        } catch (Exception e) {
            question8Value = 0;
        }

        if (question8Value == 2008) {
            numberOfCorrectQuestions += 1;
        }


        // Verify Question9
        // Correct Answers -> 2005-2006,2010-2011
        // Only and all correct answers must be checked in order to the answer be correct

        CheckBox question9CheckBoxOption1Id = findViewById(R.id.question9CheckBoxOption1Id);
        CheckBox question9CheckBoxOption2Id = findViewById(R.id.question9CheckBoxOption2Id);
        CheckBox question9CheckBoxOption3Id = findViewById(R.id.question9CheckBoxOption3Id);
        CheckBox question9CheckBoxOption4Id = findViewById(R.id.question9CheckBoxOption4Id);

        boolean isQuestion9CheckBoxOption1Checked = question9CheckBoxOption1Id.isChecked();
        boolean isQuestion9CheckBoxOption2Checked = question9CheckBoxOption2Id.isChecked();
        boolean isQuestion9CheckBoxOption3Checked = question9CheckBoxOption3Id.isChecked();
        boolean isQuestion9CheckBoxOption4Checked = question9CheckBoxOption4Id.isChecked();

        if (!isQuestion9CheckBoxOption1Checked
                && isQuestion9CheckBoxOption2Checked
                && isQuestion9CheckBoxOption3Checked
                && !isQuestion9CheckBoxOption4Checked
        ) {
            numberOfCorrectQuestions += 1;
        }


        // Verify Question10
        // Correct Answer -> Lionel Messi

        RadioButton question10RadioButtonOption2Id = findViewById(R.id.question10RadioButtonOption2Id);
        boolean isQuestion10RadioButtonOption2Checked = question10RadioButtonOption2Id.isChecked();

        if (isQuestion10RadioButtonOption2Checked) {
            numberOfCorrectQuestions += 1;
        }

        return numberOfCorrectQuestions;
    }
}
