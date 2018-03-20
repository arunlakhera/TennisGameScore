package com.example.android.tennisgamescore;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Variables to store current service score and Set Score for Player 1

    int player1_currentScore = 0;
    int player1_Set_1_Score = 0;
    int player1_Set_2_Score = 0;
    int player1_Set_3_Score = 0;

    String player1_Set1_flag = "I";
    String player1_Set2_flag = "I";
    String player1_Set3_flag = "I";
    // Variables to store current service score and Set Score for Player 2

    int player2_currentScore = 0;
    int player2_Set_1_Score = 0;
    int player2_Set_2_Score = 0;
    int player2_Set_3_Score = 0;

    String player2_Set1_flag = "I";
    String player2_Set2_flag = "I";
    String player2_Set3_flag = "I";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeColor(){


        TextView currentScorePlayer1 = (TextView) findViewById(R.id.player1_serve_score);
        TextView currentScorePlayer2 = (TextView) findViewById(R.id.player2_serve_score);

        TextView player1Set1 = (TextView) findViewById(R.id.player1_set_1_score);
        TextView player1Set2 = (TextView) findViewById(R.id.player1_set_2_score);
        TextView player1Set3 = (TextView) findViewById(R.id.player1_set_3_score);


        TextView player2Set1 = (TextView) findViewById(R.id.player2_set_1_score);
        TextView player2Set2 = (TextView) findViewById(R.id.player2_set_2_score);
        TextView player2Set3 = (TextView) findViewById(R.id.player2_set_3_score);

        if (player1_currentScore > player2_currentScore) {
            currentScorePlayer1.setTextColor(Color.parseColor("#558B2F"));
            currentScorePlayer2.setTextColor(Color.parseColor("#FFFFFF"));
        }else if (player2_currentScore > player1_currentScore){

            currentScorePlayer2.setTextColor(Color.parseColor("#558B2F"));
            currentScorePlayer1.setTextColor(Color.parseColor("#FFFFFF"));
        }else {
            currentScorePlayer2.setTextColor(Color.parseColor("#FFFFFF"));
            currentScorePlayer1.setTextColor(Color.parseColor("#FFFFFF"));

        }


        if (player1_Set_1_Score > player2_Set_1_Score) {
            player1Set1.setTextColor(Color.parseColor("#558B2F"));
            player2Set1.setTextColor(Color.parseColor("#FFFFFF"));
        }else if (player2_Set_1_Score > player1_Set_1_Score) {
            player2Set1.setTextColor(Color.parseColor("#558B2F"));
            player1Set1.setTextColor(Color.parseColor("#FFFFFF"));
        }else{
            player1Set1.setTextColor(Color.parseColor("#FFFFFF"));
            player2Set1.setTextColor(Color.parseColor("#FFFFFF"));
        }

        if (player1_Set_2_Score > player2_Set_2_Score) {
            player1Set2.setTextColor(Color.parseColor("#558B2F"));
            player2Set2.setTextColor(Color.parseColor("#FFFFFF"));
        }else if (player2_Set_2_Score > player1_Set_2_Score) {
            player2Set2.setTextColor(Color.parseColor("#558B2F"));
            player1Set2.setTextColor(Color.parseColor("#FFFFFF"));
        }else{
            player1Set2.setTextColor(Color.parseColor("#FFFFFF"));
            player2Set2.setTextColor(Color.parseColor("#FFFFFF"));
        }

        if (player1_Set_3_Score > player2_Set_3_Score) {
            player1Set3.setTextColor(Color.parseColor("#558B2F"));
            player2Set3.setTextColor(Color.parseColor("#FFFFFF"));
        }else if (player2_Set_3_Score > player1_Set_3_Score) {
            player2Set3.setTextColor(Color.parseColor("#558B2F"));
            player1Set3.setTextColor(Color.parseColor("#FFFFFF"));
        }else{
            player1Set3.setTextColor(Color.parseColor("#FFFFFF"));
            player2Set3.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }

    // Function to add points for player 1
    public void addPoint_player_1(View view) {


        // 1. Add 15 point if score is 0 or 15  & Add 10 point if score is equal to or more than 30

        if (player1_Set1_flag != "C" || player1_Set2_flag != "C" || player1_Set3_flag != "C") {

            if (player1_currentScore == 0 || player1_currentScore == 15) {

                player1_currentScore = player1_currentScore + 15;

            } else if (player1_currentScore >= 30) {

                player1_currentScore = player1_currentScore + 10;

            }

        }

        changeColor();

        // 2. Check if the player 1 has won the game and increment the set if the game is won by player 1
        if (player1_currentScore > 40 && (player1_currentScore - player2_currentScore) > 10) {

            if (player1_Set1_flag != "C") {

                if (player1_Set_1_Score > 5) {

                    if (
                            ((player1_Set_1_Score == 6) && (player1_Set_1_Score - player2_Set_1_Score) > 1) ||
                                    ((player1_Set_1_Score == 7) && (player1_Set_1_Score - player2_Set_1_Score) == 1)

                            ) {
                        player1_Set1_flag = "C";
                        player2_Set1_flag = "C";
                    }

                    if ((player1_Set_1_Score >= 6) && (player1_Set_1_Score - player2_Set_1_Score) > 1) {
                        player1_Set1_flag = "C";
                        player2_Set1_flag = "C";
                    } else {
                        player1_Set_1_Score++;
                    }


                } else if(player1_Set1_flag != "C"){
                    player1_Set_1_Score++;
                }

            }

            if (player1_Set2_flag != "C" && player1_Set1_flag == "C") {

                if (player1_Set_2_Score > 5) {

                    if (
                            ((player1_Set_2_Score == 6) && (player1_Set_2_Score - player2_Set_2_Score) > 1) ||
                                    ((player1_Set_2_Score == 7) && (player1_Set_2_Score - player2_Set_2_Score) == 1)

                            ) {
                        player1_Set2_flag = "C";
                        player2_Set2_flag = "C";
                    }

                    if ((player1_Set_2_Score >= 6) && (player1_Set_2_Score - player2_Set_2_Score) > 1) {
                        player1_Set2_flag = "C";
                        player2_Set2_flag = "C";
                    } else {
                        player1_Set_2_Score++;
                    }


                } else if(player1_Set2_flag != "C"){
                    player1_Set_2_Score++;
                }


            }

            if (player1_Set3_flag != "C" && player1_Set1_flag == "C" && player1_Set2_flag == "C") {

                if (player1_Set_3_Score > 5) {

                    if (
                            ((player1_Set_3_Score == 6) && (player1_Set_3_Score - player2_Set_3_Score) > 1) ||
                                    ((player1_Set_3_Score == 7) && (player1_Set_3_Score - player2_Set_3_Score) == 1)

                            ) {
                        player1_Set3_flag = "C";
                        player2_Set3_flag = "C";
                    }

                    if ((player1_Set_3_Score >= 6) && (player1_Set_3_Score - player2_Set_3_Score) > 1) {
                        player1_Set3_flag = "C";
                        player2_Set3_flag = "C";
                    } else {
                        player1_Set_3_Score++;
                    }

                } else if(player1_Set3_flag != "C"){
                    player1_Set_3_Score++;
                }

            }

            player1_currentScore = 0;
            player2_currentScore = 0;

        }


        // 3. Show score of Players by calling showScorePlayer function
        showScorePlayer();
    }


    // Function to add points for player 2
    public void addPoint_player_2(View view) {

        // 1. Add 15 point if score is 0 or 15  & Add 10 point if score is equal to or more than 30

        if (player2_Set1_flag != "C" || player2_Set2_flag != "C" || player2_Set3_flag != "C") {
            if (player2_currentScore == 0 || player2_currentScore == 15) {

                player2_currentScore = player2_currentScore + 15;

            } else if (player2_currentScore >= 30) {

                player2_currentScore = player2_currentScore + 10;

            }
        }


        changeColor();

        // 2. Check if the player 1 has won the game and increment the set if the game is won by player 1
        if (player2_currentScore > 40 && (player2_currentScore - player1_currentScore) > 10) {

            if (player2_Set1_flag != "C") {

                if (player2_Set_1_Score > 5) {

                    if (
                            ((player2_Set_1_Score == 6) && (player2_Set_1_Score - player1_Set_1_Score) > 1) ||
                            ((player2_Set_1_Score == 7) && (player2_Set_1_Score - player1_Set_1_Score) == 1)
                            ) {
                        player2_Set1_flag = "C";
                        player1_Set1_flag = "C";
                    }

                    if ((player2_Set_1_Score >= 6) && (player2_Set_1_Score - player1_Set_1_Score) > 1) {
                        player1_Set1_flag = "C";
                        player2_Set1_flag = "C";
                    } else {
                        player2_Set_1_Score++;
                    }

                } else if(player2_Set1_flag != "C") {
                    player2_Set_1_Score++;
                }

            }

            if (player2_Set2_flag != "C" && player2_Set1_flag == "C") {

                if (player2_Set_2_Score > 5) {

                    if (
                            ((player2_Set_2_Score == 6) && (player2_Set_2_Score - player1_Set_2_Score) > 1) ||
                    ((player2_Set_2_Score == 7) && (player2_Set_2_Score - player1_Set_2_Score) == 1)
                            ) {
                        player2_Set2_flag = "C";
                        player1_Set2_flag = "C";
                    }

                    if ((player2_Set_2_Score >= 6) && (player2_Set_2_Score - player1_Set_2_Score) > 1) {
                        player1_Set2_flag = "C";
                        player2_Set2_flag = "C";
                    } else {
                        player2_Set_2_Score++;
                    }

                } else if(player2_Set2_flag != "C"){
                    player2_Set_2_Score++;
                }


            }

            if (player2_Set3_flag != "C" && player2_Set1_flag == "C" && player2_Set2_flag == "C") {

                if (player2_Set_3_Score > 5) {

                    if (((player2_Set_3_Score == 6) && (player2_Set_3_Score - player1_Set_3_Score) > 1) ||
                    ((player2_Set_3_Score == 7) && (player2_Set_3_Score - player1_Set_3_Score) == 1)
                            ){
                        player2_Set3_flag = "C";
                        player1_Set3_flag = "C";
                    }

                    if ((player2_Set_3_Score >= 6) && (player2_Set_3_Score - player1_Set_3_Score) > 1) {
                        player1_Set3_flag = "C";
                        player2_Set3_flag = "C";
                    } else {
                        player2_Set_3_Score++;
                    }

                } else if(player2_Set3_flag != "C"){
                    player2_Set_3_Score++;
                }

            }

            player1_currentScore = 0;
            player2_currentScore = 0;

        }

        // 3. Show score of Players by calling showScorePlayer function
        showScorePlayer();
    }


    // Function to show points for players in the view

    public void showScorePlayer() {

        // Declare TextViews to show the Player 1 and player 2 current serve score and setscore
        TextView player1_ServeScore = (TextView) findViewById(R.id.player1_serve_score);
        TextView player2_ServeScore = (TextView) findViewById(R.id.player2_serve_score);

        TextView player1_Set_1_textview = (TextView) findViewById(R.id.player1_set_1_score);
        TextView player2_Set_1_textview = (TextView) findViewById(R.id.player2_set_1_score);

        TextView player1_Set_2_textview = (TextView) findViewById(R.id.player1_set_2_score);
        TextView player2_Set_2_textview = (TextView) findViewById(R.id.player2_set_2_score);

        TextView player1_Set_3_textview = (TextView) findViewById(R.id.player1_set_3_score);
        TextView player2_Set_3_textview = (TextView) findViewById(R.id.player2_set_3_score);


        // Check if the player one score is more than 40
        if (player1_currentScore > 40) {
            /* Check if the player 1 and player 2 both have equal score and greater then or equal to 40.
            -- If TRUE then both score should read 40
            -- If Player 1 has 10 points more than player 2 show AD for Player 1 and change the score of player 2 to 40
            -- If Player 1 has more than 10 points more than player 2 then player 1 has won and we will set the score for both player back to 0
            */
            if ((player1_currentScore - player2_currentScore) == 0) {
                player1_ServeScore.setText("40");
                player2_ServeScore.setText("40");

                player1_currentScore = 40;
                player2_currentScore = 40;
            } else if ((player1_currentScore - player2_currentScore) == 10) {
                player1_ServeScore.setText("AD");
                player2_currentScore = 40;
            } else if ((player1_currentScore - player2_currentScore) >= 10) {
                player1_currentScore = 0;
                player2_currentScore = 0;
            }
        } else {
            player1_ServeScore.setText(String.valueOf(player1_currentScore));
        }

           /* Check if the player 1 and player 2 both have equal score and greater then or equal to 40.
            -- If TRUE then both score should read 40
            -- If Player 2 has 10 points more than player 1 show AD for Player 1 and change the score of player 1 to 40
            -- If Player 2 has more than 10 points more than player 1 then player 2 has won and we will set the score for both player back to 0
            */

        if (player2_currentScore > 40) {
            if ((player2_currentScore - player1_currentScore) == 0) {
                player1_ServeScore.setText("40");
                player2_ServeScore.setText("40");

                player1_currentScore = 40;
                player2_currentScore = 40;
            } else if ((player2_currentScore - player1_currentScore) == 10) {

                player2_ServeScore.setText("AD");
                player1_currentScore = 40;
            } else if ((player2_currentScore - player1_currentScore) >= 10) {
                player1_currentScore = 0;
                player2_currentScore = 0;
            }
        } else {
            player2_ServeScore.setText(String.valueOf(player2_currentScore));
        }

        if ((player1_Set1_flag != "C") && (player2_Set1_flag != "C")) {
            player1_Set_1_textview.setText(String.valueOf(player1_Set_1_Score));
            player2_Set_1_textview.setText(String.valueOf(player2_Set_1_Score));
        }

        if ((player1_Set2_flag != "C") && (player2_Set2_flag != "C")) {
            player1_Set_2_textview.setText(String.valueOf(player1_Set_2_Score));
            player2_Set_2_textview.setText(String.valueOf(player2_Set_2_Score));
        }

        if ((player1_Set3_flag != "C") && (player2_Set3_flag != "C")) {
            player1_Set_3_textview.setText(String.valueOf(player1_Set_3_Score));
            player2_Set_3_textview.setText(String.valueOf(player2_Set_3_Score));
        }


    }


    // Function to reset the score in Entire Match back to 0
    public void resetScore(View view) {

         player1_currentScore = 0;
         player1_Set_1_Score = 0;
         player1_Set_2_Score = 0;
         player1_Set_3_Score = 0;

         player1_Set1_flag = "I";
         player1_Set2_flag = "I";
         player1_Set3_flag = "I";
        // Variables to store current service score and Set Score for Player 2

         player2_currentScore = 0;
         player2_Set_1_Score = 0;
         player2_Set_2_Score = 0;
         player2_Set_3_Score = 0;

         player2_Set1_flag = "I";
         player2_Set2_flag = "I";
         player2_Set3_flag = "I";

    }


}
