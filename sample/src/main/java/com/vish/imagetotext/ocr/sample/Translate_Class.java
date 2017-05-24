package com.vish.imagetotext.ocr.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.api.GoogleAPI;
import com.google.api.translate.Language;
import com.google.api.translate.Translate;

import com.example.croppersample.R;

public class Translate_Class extends AppCompatActivity {

    private Button btnTranslate;
    private TextView tv_Transtext;
    private EditText txt_Input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        btnTranslate = (Button)findViewById(R.id.button);
        tv_Transtext = (TextView)findViewById(R.id.tvtranslate);
        txt_Input = (EditText)findViewById(R.id.input);

        GoogleAPI.setKey("AIzaSyC3bRzwRNC1EM1cKzDioaaZ1a3wikeU58o");
        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String text = tranlsate_text("Hello");
                    tv_Transtext.setText(text);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        });

    }

    String tranlsate_text(String txt) throws Exception
    {
        return(Translate.DEFAULT.execute("Bonjour le monde", Language.FRENCH, Language.ENGLISH));
    }
}
