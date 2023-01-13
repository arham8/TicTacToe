package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean gameover;
    int turnno;
    int data[][] = new int[3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameover = false;
        Button b[] = new Button[9];
        Button reset;
        turnno=0;


        b[0] = findViewById(R.id.b0);
        b[1] = findViewById(R.id.b1);
        b[2] = findViewById(R.id.b2);
        b[3] = findViewById(R.id.b3);
        b[4] = findViewById(R.id.b4);
        b[5] = findViewById(R.id.b5);
        b[6] = findViewById(R.id.b6);
        b[7] = findViewById(R.id.b7);
        b[8] = findViewById(R.id.b8);

        reset = findViewById(R.id.reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0; i<9;i++)
                {
                    b[i].setText("-");
                }

                for(int a=0; a<3; a++)
                {
                    for(int b=0; b<3; b++)
                    {
                        data[a][b]=0;
                    }
                }
                gameover = false;
                turnno = 0;
            }
        });
        for(int i=0 ; i<9; i++)
        {
            Button currentButton = b[i];
            int x = i/3;
            int y = i%3;
            currentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(gameover)
                    {
                        return;
                    }
                    if(!currentButton.getText().equals("-"))
                    {
                        Toast.makeText(getApplicationContext(), "Invalid move.", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    if(turnno %2==0) {
                        currentButton.setText("X");
                        data[x][y] = 2;
                    }
                    else
                    {
                        currentButton.setText("O");
                        data[x][y] = 1;
                    }

                    if(data[0][0]==data[1][1] && data[1][1]==data[2][2] && data[2][2] == 2)
                    {
                        Toast.makeText(getApplicationContext(), "X wins!", Toast.LENGTH_LONG).show();
                        gameover = true;
                    }
                    if(data[0][0]==data[1][1] && data[1][1]==data[2][2] && data[2][2] == 1)
                    {
                        Toast.makeText(getApplicationContext(), "O wins!", Toast.LENGTH_LONG).show();
                        gameover = true;
                    }



                    if(data[2][0]==data[1][1] && data[1][1]==data[0][2] && data[0][2] == 2)
                    {
                        Toast.makeText(getApplicationContext(), "X wins!", Toast.LENGTH_LONG).show();
                        gameover = true;
                    }
                    if(data[2][0]==data[1][1] && data[1][1]==data[0][2] && data[0][2] == 1)
                    {
                        Toast.makeText(getApplicationContext(), "O wins!", Toast.LENGTH_LONG).show();
                        gameover = true;
                    }


                    for(int k=0; k<3; k++)
                    {
                        if(data[k][0]+data[k][1]+data[k][2]==6)
                        {
                            Toast.makeText(getApplicationContext(), "X wins!", Toast.LENGTH_LONG).show();
                            gameover = true;
                        }
                        if(data[k][0]==1 && data[k][1]==1 && data[k][2]==1)
                        {
                            Toast.makeText(getApplicationContext(), "O wins!", Toast.LENGTH_LONG).show();
                            gameover = true;
                        }

                        if(data[0][k] + data[1][k] + data[2][k]==6)
                        {
                            Toast.makeText(getApplicationContext(), "X wins!", Toast.LENGTH_LONG).show();gameover = true;
                        }

                        if(data[0][k]==1 && data[1][k]==1 && data[2][k]==1)
                        {
                            Toast.makeText(getApplicationContext(), "O wins!", Toast.LENGTH_LONG).show();
                            gameover = true;
                        }



                    }


                    turnno++;
                }
            });
        }



    }
}