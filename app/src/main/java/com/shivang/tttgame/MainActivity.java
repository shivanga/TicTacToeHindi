package com.shivang.tttgame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    int activeplayer=0;
    int f=2,f2;
    int[] arr={2,2,2,2,2,2,2,2,2};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.iseefire);
        mediaPlayer.start();
    }

    public  void dropIn(View view)
    {
        ImageView Counter=(ImageView)view;
        TextView tv=(TextView)findViewById(R.id.textView);
        TextView tv2=(TextView)findViewById(R.id.textView2);
        RelativeLayout rl=(RelativeLayout)findViewById(R.id.rellay);
        GridLayout gl=(GridLayout)findViewById(R.id.gridlay);


        if(arr[Integer.parseInt(Counter.getTag().toString())]==2) {

            if (activeplayer == 0) {
                tv2.setText("Player 2 chal na re");
                arr[Integer.parseInt(Counter.getTag().toString())]=1;
                Counter.setImageResource(R.drawable.cross);
                activeplayer = 1;


            } else {

                tv2.setText("Player 1 chal na re");
                arr[Integer.parseInt(Counter.getTag().toString())]=0;
                activeplayer = 0;
                Counter.setImageResource(R.drawable.zero);
            }
        }
        if(     (arr[0]==0&&arr[1]==0&&arr[2]==0)||
                (arr[3]==0&&arr[4]==0&&arr[5]==0)||
                (arr[6]==0&&arr[7]==0&&arr[8]==0)||

                (arr[0]==0&&arr[3]==0&&arr[6]==0)||
                (arr[1]==0&&arr[4]==0&&arr[7]==0)||
                (arr[2]==0&&arr[5]==0&&arr[8]==0)||

                (arr[0]==0&&arr[4]==0&&arr[8]==0)||
                (arr[2]==0&&arr[4]==0&&arr[6]==0)) {
            Toast.makeText(this, "Zero jeet gaya", Toast.LENGTH_SHORT).show();
            f=0;
            //0 wins;
        }

        else if((arr[0]==1&&arr[1]==1&&arr[2]==1)||
                (arr[3]==1&&arr[4]==1&&arr[5]==1)||
                (arr[6]==1&&arr[7]==1&&arr[8]==1)||

                (arr[0]==1&&arr[3]==1&&arr[6]==1)||
                (arr[1]==1&&arr[4]==1&&arr[7]==1)||
                (arr[2]==1&&arr[5]==1&&arr[8]==1)||

                (arr[0]==1&&arr[4]==1&&arr[8]==1)||
                (arr[2]==1&&arr[4]==1&&arr[6]==1))
        {
            f=1;
            Toast.makeText(this, "Cross jeet gaya", Toast.LENGTH_SHORT).show();
        }


        if(f==1)
        {
            tv.setText("Cross jeet gaya");
            rl.setVisibility(View.VISIBLE);
            tv2.setVisibility(View.INVISIBLE);
            gl.setVisibility(View.INVISIBLE);
        }
        if(f==0)
        {
            tv.setText("Zero jeet gaya");
            rl.setVisibility(View.VISIBLE);

            tv2.setVisibility(View.INVISIBLE);
            gl.setVisibility(View.INVISIBLE);
        }
        if(f==2)
        {
            f2=1;
            for(int i=0;i<9;i++)
            {
                if(arr[i]==2)
                    f2=0;
            }
            if(f2==1) {
                tv.setText("Koi nahi jeeta");
                rl.setVisibility(View.VISIBLE);

                tv2.setVisibility(View.INVISIBLE);
                gl.setVisibility(View.INVISIBLE);
            }
        }

    }
    public void restart(View view)
    {
        for(int i=0;i<9;i++)
        {
            arr[i]=2;
        }
        Intent intent = getIntent();
        mediaPlayer.release();
        mediaPlayer = null;
        finish();
        startActivity(intent);
    }
}
