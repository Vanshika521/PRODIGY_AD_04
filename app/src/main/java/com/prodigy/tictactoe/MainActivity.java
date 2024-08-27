package com.prodigy.tictactoe;

import android.os.Bundle;
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
    }

    private void perform(ImageView img , int selected)
    {
        box[selected] = turn;

        if (turn == 1)
        {
            img.setImageResource(R.drawable.cross);
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
        boolean result = false;
        for (int i =0;i<a.size();i++)
        {
            final int[] c = a.get(i);

            if(box[c[0]] == turn && box[c[1]] == turn && box[c[2]] == turn )
            {
                result = true;
            }

        }
        return result;

    }

    private boolean selected (int boxposition)
    {
        boolean result = false;
        if(box[boxposition] == 0)
        {
            result = true;
        }
        return result;
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