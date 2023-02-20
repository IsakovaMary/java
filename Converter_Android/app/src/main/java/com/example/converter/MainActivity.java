package com.example.converter;

import static com.example.converter.R.id.ton_value;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private EditText value;
    private TextView ton_value;
    private TextView kg_value;
    private TextView gram_value;
    private Spinner dropdown;
    private ImageButton musicPlay;
    private MediaPlayer mediaPlayer;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musicPlay = findViewById(R.id.musicPlay);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.fordboyard);
        mediaPlayer.start();

        dropdown = findViewById(R.id.dropDown);
        String[] items = new String[]{"Тонны", "Килограммы", "Граммы"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, items);

        dropdown.setAdapter(adapter);
        dropdown.setSelection(0);

        ton_value = findViewById(R.id.ton_value);
        kg_value = findViewById(R.id.kg_value);
        gram_value = findViewById(R.id.gram_value);

        value = findViewById(R.id.value);

        value.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String selected = dropdown.getSelectedItem().toString();
                if(selected.equals("Тонны")){

                    float value1 = Float.parseFloat(ton_value.getText().toString());
                    ton_value.setText(s);
                    kg_value.setText(String.valueOf(Float.parseFloat(String.valueOf(s)) * 1000));
                    gram_value.setText(String.valueOf(Float.parseFloat(String.valueOf(s)) * 1000000));
                }
                else if (selected.equals("Килограммы")){
                    kg_value.setText(s);
                    ton_value.setText(String.valueOf(Float.parseFloat(String.valueOf(s)) /1000));
                    gram_value.setText(String.valueOf(Float.parseFloat(String.valueOf(s)) *1000));
                }
                else if (selected.equals("Граммы")){
                    gram_value.setText(s);
                    ton_value.setText(String.valueOf(Float.parseFloat(String.valueOf(s)) /1000000));
                    kg_value.setText(String.valueOf(Float.parseFloat(String.valueOf(s)) /1000));
                }

                dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> adapter, View v,int position, long id) {
                        String selected_item = adapter.getItemAtPosition(position).toString();

                        if(selected_item.matches("Тонны")){
                            ton_value.setText(s);
                            kg_value.setText(String.valueOf(Float.parseFloat(String.valueOf(s)) * 1000));
                            gram_value.setText(String.valueOf(Float.parseFloat(String.valueOf(s)) * 1000000));
                        }
                        else if (selected_item.matches("Килограммы")){
                            kg_value.setText(s);
                            ton_value.setText(String.valueOf(Float.parseFloat(String.valueOf(s)) /1000));
                            gram_value.setText(String.valueOf(Float.parseFloat(String.valueOf(s)) *1000));
                        }
                        else if (selected_item.matches("Граммы")){
                            gram_value.setText(s);
                            ton_value.setText(String.valueOf(Float.parseFloat(String.valueOf(s)) /1000000));
                            kg_value.setText(String.valueOf(Float.parseFloat(String.valueOf(s)) /1000));
                        }
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
                }
        });
}
    public void MusicButtons(View view){
        switch (view.getId()){
            case R.id.musicPlay:
                if(!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    musicPlay.setImageResource(R.drawable.volume_icon);
                }else {
                    mediaPlayer.pause();
                    musicPlay.setImageResource(R.drawable.mute_icon);
                }
                break;}}
}