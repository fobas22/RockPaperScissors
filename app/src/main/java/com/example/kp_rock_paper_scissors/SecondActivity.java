package com.example.kp_rock_paper_scissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private GameFun game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        game = GameFun.getInstance();


        Button finish_game = findViewById(R.id.button_finish_game_id);
        TextView add_game = findViewById(R.id.textView_adr_game_result_id);
        TextView bet_amount = findViewById(R.id.textView_bet_amount_result_id);
        TextView choice = findViewById(R.id.textView_choice_result_str);

        add_game.setText(game.get_add_con());
        String aaa = game.get_weiValue_full();
        Integer bbb = Integer.parseInt(aaa) * 2 ;

        bet_amount.setText(bbb.toString());

        if("1".equals(game.get_Choice().toString())){
            choice.setText("Камень");
        };
        if("2".equals(game.get_Choice().toString())){
            choice.setText("Ножницы");
        };
        if("3".equals(game.get_Choice().toString())){
            choice.setText("Бумага");
        };


        finish_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p1 = game.get_player1();
                String p2 = game.get_player2();
                String c1 = String.valueOf(game.get_player1_Choice());
                String c2 = String.valueOf(game.get_player2_Choice());
                if(!"".equals(p1) && !"".equals(p2) && !"".equals(c1)&& !"".equals(c2)){
                    game.fin_g();
                    game.destroy();
                    Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }
            }
        });



    }
}