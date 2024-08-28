package com.prodigy.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class players extends AppCompatActivity {

    EditText first,second;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        start = findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getFirst = first.getText().toString();
                String getSecond = second.getText().toString();

                if (getFirst.isEmpty() || getSecond.isEmpty() )
                {
                    Toast.makeText(players.this,"Enter Player's Name",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(players.this, MainActivity.class);
                    intent.putExtra("first",getFirst);
                    intent.putExtra("second",getSecond);
                    startActivity(intent);
                }
                }
        });

    }
}