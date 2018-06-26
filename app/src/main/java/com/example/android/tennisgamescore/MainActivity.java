package com.example.android.tennisgamescore;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Variables to store current service score and Set Score for Player 1
    Button player1_AddPoint;
    Button player2_AddPoint;
    Boolean matchFlag = false;

    TextView currentScorePlayer1;
    TextView currentScorePlayer2;
    TextView player1Set1;
    TextView player1Set2;
    TextView player1Set3;

    TextView player2Set1;
    TextView player2Set2;
    TextView player2Set3;

    TextView player1_ServeScore;
    TextView player2_ServeScore;
    TextView player1_Set_1_textview;
    TextView player2_Set_1_textview;
    TextView player1_Set_2_textview;
    TextView player2_Set_2_textview;
    TextView player1_Set_3_textview;
    TextView player2_Set_3_textview;

    TextView player1_Name;
    TextView player2_Name;

    Player player1;
    Player player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1 = new Player();
        player2 = new Player();

        player1_Name = findViewById(R.id.player1_name_textview);
        player2_Name = findViewById(R.id.player2_name_textview);

        player1_AddPoint = findViewById(R.id.player1_AddPoint);
        player2_AddPoint = findViewById(R.id.player2_AddPoint);

        player1.setM_PlayerName("Nadal");
        player2.setM_PlayerName("Federer");

        player1_Name.setText(player1.getM_PlayerName());
        player2_Name.setText(player2.getM_PlayerName());

        player1_AddPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPoint_player_1();
            }
        });

        player2_AddPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPoint_player_2();
            }
        });

    }

    public void changeColor() {

         currentScorePlayer1 = findViewById(R.id.player1_serve_score);
         currentScorePlayer2 = findViewById(R.id.player2_serve_score);
         player1Set1 = findViewById(R.id.player1_set_1_score);
         player1Set2 = findViewById(R.id.player1_set_2_score);
         player1Set3 = findViewById(R.id.player1_set_3_score);
         player2Set1 = findViewById(R.id.player2_set_1_score);
         player2Set2 = findViewById(R.id.player2_set_2_score);
         player2Set3 = findViewById(R.id.player2_set_3_score);

        if (player1.getM_CurrentScore() > player2.getM_CurrentScore()) {
            currentScorePlayer1.setTextColor(Color.parseColor("#558B2F"));
            currentScorePlayer2.setTextColor(Color.parseColor("#FFFFFF"));
        } else if (player2.getM_CurrentScore() > player1.getM_CurrentScore()) {

            currentScorePlayer2.setTextColor(Color.parseColor("#558B2F"));
            currentScorePlayer1.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            currentScorePlayer2.setTextColor(Color.parseColor("#FFFFFF"));
            currentScorePlayer1.setTextColor(Color.parseColor("#FFFFFF"));
        }

        if (player1.getM_Set1() > player2.getM_Set1()) {
            player1Set1.setTextColor(Color.parseColor("#558B2F"));
            player2Set1.setTextColor(Color.parseColor("#FFFFFF"));
        } else if (player2.getM_Set1() > player1.getM_Set1()) {
            player2Set1.setTextColor(Color.parseColor("#558B2F"));
            player1Set1.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            player1Set1.setTextColor(Color.parseColor("#FFFFFF"));
            player2Set1.setTextColor(Color.parseColor("#FFFFFF"));
        }

        if (player1.getM_Set2() > player2.getM_Set2()) {
            player1Set2.setTextColor(Color.parseColor("#558B2F"));
            player2Set2.setTextColor(Color.parseColor("#FFFFFF"));
        } else if (player2.getM_Set2() > player1.getM_Set2()) {
            player2Set2.setTextColor(Color.parseColor("#558B2F"));
            player1Set2.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            player1Set2.setTextColor(Color.parseColor("#FFFFFF"));
            player2Set2.setTextColor(Color.parseColor("#FFFFFF"));
        }

        if (player1.getM_Set3() > player2.getM_Set3()) {
            player1Set3.setTextColor(Color.parseColor("#558B2F"));
            player2Set3.setTextColor(Color.parseColor("#FFFFFF"));
        } else if (player2.getM_Set3() > player1.getM_Set3()) {
            player2Set3.setTextColor(Color.parseColor("#558B2F"));
            player1Set3.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            player1Set3.setTextColor(Color.parseColor("#FFFFFF"));
            player2Set3.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }


    public void checkScore() {
        if ((player1.getSet1Flag().equals("C") && player1.getSet2Flag().equals("C") && player1.getSet3Flag().equals("C")) && (player2.getSet1Flag().equals("C") && player2.getSet2Flag().equals("C") && player2.getSet3Flag().equals("C"))) {

            player1_AddPoint.setEnabled(false);
            player2_AddPoint.setEnabled(false);

            player1_AddPoint.setVisibility(View.INVISIBLE);
            player2_AddPoint.setVisibility(View.INVISIBLE);
        }
    }

    // Function to add points for player 1
    public void addPoint_player_1() {

        // 1. Add 15 point if score is 0 or 15  & Add 10 point if score is equal to or more than 30
        checkScore();

        if (!matchFlag) {

                if (player1.getM_CurrentScore() == 0 || player1.getM_CurrentScore() == 15) {
                    player1.setM_CurrentScore(player1.getM_CurrentScore() + 15);
                } else if (player1.getM_CurrentScore() >= 30) {
                    player1.setM_CurrentScore(player1.getM_CurrentScore() + 10);
                }
        }

        changeColor();

        // 2. Check if the player 1 has won the game and increment the set if the game is won by player 1
        if (player1.getM_CurrentScore() > 40 && (player1.getM_CurrentScore() - player2.getM_CurrentScore()) > 10) {
            if (!player1.getSet1Flag().equals("C")) {
                if (player1.getM_Set1() > 5) {
                    if (
                            ((player1.getM_Set1() == 6) && (player1.getM_Set1() - player2.getM_Set1()) > 1) ||
                                    ((player1.getM_Set1() == 7) && (player1.getM_Set1() - player2.getM_Set1()) == 1)
                            ) {
                        player1.setSet1Flag("C");
                        player2.setSet1Flag("C");
                    }
                    if ((player1.getM_Set1() >= 6) && (player1.getM_Set1() - player2.getM_Set1()) > 1) {
                        player1.setSet1Flag("C");
                        player2.setSet1Flag("C");
                    } else {
                        player1.setM_Set1(player1.getM_Set1() + 1);
                    }

                } else if (!player1.getSet1Flag().equals("C") && !player2.getSet1Flag().equals("C")) {
                    player1.setM_Set1(player1.getM_Set1() + 1);
                }

            }else if (!player1.getSet2Flag().equals("C")) {

                if (player1.getM_Set2() > 5) {
                    if (
                            ((player1.getM_Set2() == 6) && (player1.getM_Set2() - player2.getM_Set2()) > 1) ||
                                    ((player1.getM_Set2() == 7) && (player1.getM_Set2() - player2.getM_Set2()) == 1)
                            ) {
                        player1.setSet2Flag("C");
                        player2.setSet2Flag("C");
                    }
                    if ((player1.getM_Set2() >= 6) && (player1.getM_Set2() - player2.getM_Set2()) > 1) {
                        player1.setSet2Flag("C");
                        player2.setSet2Flag("C");
                    } else {
                        player1.setM_Set2(player1.getM_Set2() + 1);
                    }

                } else if (!player1.getSet2Flag().equals("C") && !player2.getSet2Flag().equals("C")) {
                    player1.setM_Set2(player1.getM_Set2() + 1);
                }

            }else if (!player1.getSet3Flag().equals("C") && player1.getSet1Flag().equals("C") && player1.getSet2Flag().equals("C")) {

                if (player1.getM_Set3() > 5) {
                    if (
                            ((player1.getM_Set3() == 6) && (player1.getM_Set3() - player2.getM_Set3()) > 1) ||
                                    ((player1.getM_Set3() == 7) && (player1.getM_Set3() - player2.getM_Set3()) == 1)

                            ) {
                        player1.setSet2Flag("C");
                        player2.setSet2Flag("C");

                        matchFlag = true;
                        player1_AddPoint.setVisibility(View.INVISIBLE);
                        player2_AddPoint.setVisibility(View.INVISIBLE);

                    }
                    if ((player1.getM_Set3() >= 6) && (player1.getM_Set3() - player2.getM_Set3()) > 1) {
                        player1.setSet2Flag("C");
                        player2.setSet2Flag("C");

                        matchFlag = true;
                        player1_AddPoint.setVisibility(View.INVISIBLE);
                        player2_AddPoint.setVisibility(View.INVISIBLE);

                    } else {
                        player1.setM_Set3(player1.getM_Set3() + 1);
                    }

                } else if (!player1.getSet3Flag().equals("C") && !player2.getSet3Flag().equals("C")) {
                    player1.setM_Set3(player1.getM_Set3() + 1);
                }
            }
            player1.setM_CurrentScore(0);
            player2.setM_CurrentScore(0);
        }
        // 3. Show score of Players by calling showScorePlayer function
        showScorePlayer();
    }

    // Function to add points for player 2
    public void addPoint_player_2() {

        // 1. Add 15 point if score is 0 or 15  & Add 10 point if score is equal to or more than 30
        checkScore();

        if (!matchFlag) {

            if (player2.getM_CurrentScore() == 0 || player2.getM_CurrentScore() == 15) {

                player2.setM_CurrentScore(player2.getM_CurrentScore() + 15);

            } else if (player2.getM_CurrentScore() >= 30) {

                player2.setM_CurrentScore(player2.getM_CurrentScore() + 10);
            }
        }

        changeColor();

        // 2. Check if the player 1 has won the game and increment the set if the game is won by player 1
        if (player2.getM_CurrentScore() > 40 && (player2.getM_CurrentScore() - player1.getM_CurrentScore()) > 10) {
            if (!player2.getSet1Flag().equals("C")) {
                if (player2.getM_Set1() > 5) {
                    if (
                            ((player2.getM_Set1() == 6) && (player2.getM_Set1() - player1.getM_Set1()) > 1) ||
                                    ((player2.getM_Set1() == 7) && (player2.getM_Set1() - player1.getM_Set1()) == 1)
                            ) {
                        player1.setSet1Flag("C");
                        player2.setSet1Flag("C");
                    }
                    if ((player2.getM_Set1() >= 6) && (player2.getM_Set1() - player1.getM_Set1()) > 1) {
                        player1.setSet1Flag("C");
                        player2.setSet1Flag("C");
                    } else {
                        player2.setM_Set1(player2.getM_Set1() + 1);
                    }

                } else if (!player2.getSet1Flag().equals("C") && !player1.getSet1Flag().equals("C")) {
                    player2.setM_Set1(player2.getM_Set1() + 1);
                }

            }else if (!player2.getSet2Flag().equals("C")) {

                if (player2.getM_Set2() > 5) {

                    if (
                            ((player2.getM_Set2() == 6) && (player2.getM_Set2() - player1.getM_Set2()) > 1) ||
                                    ((player2.getM_Set2() == 7) && (player2.getM_Set2() - player1.getM_Set2()) == 1)
                            ) {
                        player1.setSet2Flag("C");
                        player2.setSet2Flag("C");
                    }
                    if ((player2.getM_Set2() >= 6) && (player2.getM_Set2() - player1.getM_Set2()) > 1) {
                        player1.setSet2Flag("C");
                        player2.setSet2Flag("C");
                    } else {
                        player2.setM_Set2(player2.getM_Set2() + 1);
                    }

                } else if (!player2.getSet2Flag().equals("C") && !player1.getSet2Flag().equals("C")) {
                    player2.setM_Set2(player2.getM_Set2() + 1);
                }

            }else if (!player2.getSet3Flag().equals("C") && player2.getSet1Flag().equals("C") && player2.getSet2Flag().equals("C")) {

                if (player2.getM_Set3() > 5) {

                    if (
                            ((player2.getM_Set3() == 6) && (player2.getM_Set3() - player1.getM_Set3()) > 1) ||
                                    ((player2.getM_Set3() == 7) && (player2.getM_Set3() - player1.getM_Set3()) == 1)

                            ) {
                        player1.setSet2Flag("C");
                        player2.setSet2Flag("C");

                        matchFlag = true;
                        player1_AddPoint.setVisibility(View.INVISIBLE);
                        player2_AddPoint.setVisibility(View.INVISIBLE);

                    }

                    if ((player2.getM_Set3() >= 6) && (player2.getM_Set3() - player1.getM_Set3()) > 1) {
                        player1.setSet2Flag("C");
                        player2.setSet2Flag("C");

                        matchFlag = true;
                        player1_AddPoint.setVisibility(View.INVISIBLE);
                        player2_AddPoint.setVisibility(View.INVISIBLE);

                    } else {
                        player2.setM_Set3(player2.getM_Set3() + 1);
                    }

                } else if (!player2.getSet3Flag().equals("C") && !player1.getSet3Flag().equals("C")) {
                    player2.setM_Set3(player2.getM_Set3() + 1);
                }
            }
            player1.setM_CurrentScore(0);
            player2.setM_CurrentScore(0);
        }

        // 3. Show score of Players by calling showScorePlayer function
        showScorePlayer();
    }

    // Function to show points for players in the view
    public void showScorePlayer() {

        // Declare TextViews to show the Player 1 and player 2 current serve score and setscore
         player1_ServeScore =  findViewById(R.id.player1_serve_score);
         player2_ServeScore =  findViewById(R.id.player2_serve_score);

         player1_Set_1_textview =  findViewById(R.id.player1_set_1_score);
         player2_Set_1_textview =  findViewById(R.id.player2_set_1_score);

         player1_Set_2_textview =  findViewById(R.id.player1_set_2_score);
         player2_Set_2_textview =  findViewById(R.id.player2_set_2_score);

         player1_Set_3_textview =  findViewById(R.id.player1_set_3_score);
         player2_Set_3_textview =  findViewById(R.id.player2_set_3_score);

        // Check if the player one score is more than 40
        if (player1.getM_CurrentScore() > 40) {
            /* Check if the player 1 and player 2 both have equal score and greater then or equal to 40.
            -- If TRUE then both score should read 40
            -- If Player 1 has 10 points more than player 2 show AD for Player 1 and change the score of player 2 to 40
            -- If Player 1 has more than 10 points more than player 2 then player 1 has won and we will set the score for both player back to 0
            */
            if ((player1.getM_CurrentScore() - player2.getM_CurrentScore()) == 0) {

                player1.setM_CurrentScore(40);
                player2.setM_CurrentScore(40);

                player1_ServeScore.setText(player1.getM_CurrentScore());
                player2_ServeScore.setText(player2.getM_CurrentScore());

            } else if ((player1.getM_CurrentScore() - player2.getM_CurrentScore()) == 10) {
                player1_ServeScore.setText("AD");
                player2.setM_CurrentScore(40);
            } else if ((player1.getM_CurrentScore() - player2.getM_CurrentScore()) >= 10) {
                player1.setM_CurrentScore(0);
                player2.setM_CurrentScore(0);
            }
        } else if (!player1.getSet3Flag().equals("C")) {
            player1_ServeScore.setText(String.valueOf(player1.getM_CurrentScore()));
        }

           /* Check if the player 1 and player 2 both have equal score and greater then or equal to 40.
            -- If TRUE then both score should read 40
            -- If Player 2 has 10 points more than player 1 show AD for Player 1 and change the score of player 1 to 40
            -- If Player 2 has more than 10 points more than player 1 then player 2 has won and we will set the score for both player back to 0
            */

        if (player2.getM_CurrentScore() > 40) {
            if ((player2.getM_CurrentScore() - player1.getM_CurrentScore()) == 0) {

                player1.setM_CurrentScore(40);
                player2.setM_CurrentScore(40);

                player1_ServeScore.setText(player1.getM_CurrentScore());
                player2_ServeScore.setText(player2.getM_CurrentScore());

            } else if ((player2.getM_CurrentScore() - player1.getM_CurrentScore()) == 10) {
                player2_ServeScore.setText("AD");
                player1.setM_CurrentScore(40);
            } else if ((player2.getM_CurrentScore() - player1.getM_CurrentScore()) >= 10) {
                player1.setM_CurrentScore(0);
                player2.setM_CurrentScore(0);
            }
        } else {
            player2_ServeScore.setText(String.valueOf(player2.getM_CurrentScore()));
        }

        if ((!player1.getSet1Flag().equals("C")) && (!player2.getSet1Flag().equals("C"))) {
            player1_Set_1_textview.setText(String.valueOf(player1.getM_Set1()));
            player2_Set_1_textview.setText(String.valueOf(player2.getM_Set1()));
        }

        if ((!player1.getSet2Flag().equals("C")) && (!player2.getSet2Flag().equals("C"))) {
            player1_Set_2_textview.setText(String.valueOf(player1.getM_Set2()));
            player2_Set_2_textview.setText(String.valueOf(player2.getM_Set2()));
        }

        if ((!player1.getSet3Flag().equals("C")) && (!player2.getSet3Flag().equals("C"))) {
            player1_Set_3_textview.setText(String.valueOf(player1.getM_Set3()));
            player2_Set_3_textview.setText(String.valueOf(player2.getM_Set3()));
        }
    }

    // Function to reset the score in Entire Match back to 0
    public void resetScore(View view) {

        player1.setM_CurrentScore(0);
        player1.setM_Set1(0);
        player1.setM_Set2(0);
        player1.setM_Set3(0);
        player1.setSet1Flag("I");
        player1.setSet2Flag("I");
        player1.setSet3Flag("I");

        player2.setM_CurrentScore(0);
        player2.setM_Set1(0);
        player2.setM_Set2(0);
        player2.setM_Set3(0);
        player2.setSet1Flag("I");
        player2.setSet2Flag("I");
        player2.setSet3Flag("I");

        matchFlag = false;

        player1_AddPoint.setEnabled(true);
        player2_AddPoint.setEnabled(true);

        player1_AddPoint.setVisibility(View.VISIBLE);
        player2_AddPoint.setVisibility(View.VISIBLE);

        showScorePlayer();

    }
}
