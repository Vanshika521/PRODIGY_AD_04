package com.prodigy.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;

public class result extends Dialog {

    private final String msg;
    private final MainActivity mainActivity;

    public result(@NonNull Context context,String msg, MainActivity mainActivity) {
        super(context);
        this.msg = msg;
        this.mainActivity = mainActivity;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView message = findViewById(R.id.msg);
        Button again = findViewById(R.id.btn);

        message.setText(msg);

        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.restart();
                dismiss();
            }
        });


    }
}