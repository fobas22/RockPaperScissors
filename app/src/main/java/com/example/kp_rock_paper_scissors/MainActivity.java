package com.example.kp_rock_paper_scissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {
    private GameFun game;
    public BigInteger choose_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button createGameButton = findViewById(R.id.button_create_game_id);
        Button joinGameButton = findViewById(R.id.button_join_game_id);
        RadioGroup radioGroup = findViewById(R.id.RadioGroup_id);

        EditText editTextCreateGame = findViewById(R.id.editText1_create_game_id);
        EditText editTextCreateGame2 = findViewById(R.id.editText2_create_game_id);
        EditText editText3 = findViewById(R.id.editText3_id);


        createGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // получаем приватный ключ
                String inputValueKey = editTextCreateGame.getText().toString();
                game =  GameFun.getInstance(inputValueKey);
                //
                if(game.isValidPrivateKey(inputValueKey)){
                    game =  GameFun.getInstance(inputValueKey);
                    game.deploy_contract();
                    editText3.setText(game.get_add_con());

                };


            }
        });

        joinGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // добавьте вашу логику для присоединения к игре
                // например contract.joinGame();
                String inputValueKey = editTextCreateGame.getText().toString();
                String inputbetAmount =  editTextCreateGame2.getText().toString();

                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);

                String selectedValue = selectedRadioButton.getText().toString();
                game =  GameFun.getInstance();
                game.load(inputValueKey);

                if ("Камень".equals(selectedValue)){
                    choose_value = BigInteger.valueOf(1);
                };
                if ("Ножницы".equals(selectedValue)){
                    choose_value = BigInteger.valueOf(2);
                };
                if ("Бумага".equals(selectedValue)){
                    choose_value = BigInteger.valueOf(3);
                };

                if ( !"".equals(inputbetAmount) &&  game.isBigInteger(inputbetAmount)){
                    if(game.isValidPrivateKey(inputValueKey)){
                        if (!"".equals(editText3.getText().toString())){
                            game.load(editText3.getText().toString());
                            game.register(new BigInteger(inputbetAmount));
                            game.make_Choice(choose_value);

                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                            startActivity(intent);
                            finish();
                        };

                    };
                };



            }
        });


    }

}