package com.prodigy.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.prodigy.tictactoe.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private final List<int[]> a = new ArrayList<>();
    private int[] box = {0,0,0,0,0,0,0,0,0};
    private int turn = 1;
    private int totalSelected = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        a.add(new int[] {0,1,2});
        a.add(new int[] {3,4,5});
        a.add(new int[] {6,7,8});
        a.add(new int[] {0,3,6});
        a.add(new int[] {1,4,7});
        a.add(new int[] {2,5,8});
        a.add(new int[] {0,1,2});
        a.add(new int[] {0,4,8});
        a.add(new int[] {2,4,6});

        String player_first = getIntent().getStringExtra("Player One");
        String player_second = getIntent().getStringExtra("Player Two");

        binding.first.setText(player_first);
        binding.second.setText(player_second);

        binding.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected(0)){
                    perform((ImageView) view, 0);
                }
            }
        });
        binding.img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected(1)){
                    perform((ImageView) view, 1);
                }
            }
        });
        binding.img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected(2)){
                    perform((ImageView) view, 2);
                }
            }
        });
        binding.img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected(3)){
                    perform((ImageView) view, 3);
                }
            }
        });
        binding.img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected(4)){
                    perform((ImageView) view, 4);
                }
            }
        });
        binding.img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected(5)){
                    perform((ImageView) view, 5);
                }
            }
        });
        binding.img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected(6)){
                    perform((ImageView) view, 6);
                }
            }
        });
        binding.img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected(7)){
                    perform((ImageView) view, 7);
                }
            }
        });
        binding.img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected(8)){
                    perform((ImageView) view, 8);
                }
            }
        });



    }

    private void perform(ImageView img , int selected)
    {
        box[selected] = turn;

        if (turn == 1)
        {
            img.setImageResource(R.drawable.cross);
            if(check()){
                result result = new result (MainActivity.this,binding.first.getText().toString()+"is Winner!!!",MainActivity.this);
                result.setCancelable(false);
                result.show();
            }
            else if (totalSelected == 9)
            {
                result result = new result (MainActivity.this,"Match Draw...",MainActivity.this);
                result.setCancelable(false);
                result.show();
            }
            else
            {
                changeTurn(2);
                totalSelected++;
            }
        }
        else
        {
            img.setImageResource(R.drawable.zero);
            if(check()){
                result result = new result (MainActivity.this,binding.second.getText().toString()+"is Winner!!!",MainActivity.this);
                result.setCancelable(false);
                result.show();
            }
            else if (totalSelected == 9)
            {
                result result = new result (MainActivity.this,"Match Draw...",MainActivity.this);
                result.setCancelable(false);
                result.show();
            }
            else
            {
                changeTurn(1);
                totalSelected++;
            }
        }
    }

    private void changeTurn(int currentPlayerTurn)
    {
        turn = currentPlayerTurn;

        if(turn ==1 )
        {
            binding.first.setBackgroundResource(R.drawable.bborder);
            binding.first.setBackgroundResource(R.drawable.wbox);
        }
        else
        {
            binding.second.setBackgroundResource(R.drawable.bborder);
            binding.second.setBackgroundResource(R.drawable.wbox);
        }

    }

    private boolean check()
    {
        boolean output = false;
        for (int i =0;i<a.size();i++)
        {
            final int[] c = a.get(i);

            if(box[c[0]] == turn && box[c[1]] == turn && box[c[2]] == turn )
            {
                output = true;
            }

        }
        return output;

    }

    private boolean selected (int boxposition)
    {
        boolean output = false;
        if(box[boxposition] == 0)
        {
            output = true;
        }
        return output;
    }

    public void restart()
    {
        box = new int[] {0,0,0,0,0,0,0,0,0};
        turn = 1;
        totalSelected = 1;

        binding.img1.setImageResource(R.drawable.wbox);
        binding.img2.setImageResource(R.drawable.wbox);
        binding.img3.setImageResource(R.drawable.wbox);
        binding.img4.setImageResource(R.drawable.wbox);
        binding.img5.setImageResource(R.drawable.wbox);
        binding.img6.setImageResource(R.drawable.wbox);
        binding.img7.setImageResource(R.drawable.wbox);
        binding.img8.setImageResource(R.drawable.wbox);
        binding.img9.setImageResource(R.drawable.wbox);

    }

}