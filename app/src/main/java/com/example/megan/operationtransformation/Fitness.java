package com.example.megan.operationtransformation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

//import java.security.Provider;

/**
 * Created by Megan on 24/04/2016.
 */
public class Fitness extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{

    private YouTubePlayerView youTubeView;
    private static final int RECOVERY_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fitness);


        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(Config.DEVELOPER_KEY, this);

    }

    //If initialization is successful - play video
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored)
    {
        if(!wasRestored)
        {
            //player.cuePlaylist("PLCIEFUFTSqW44Rszr_Ft28C5zN3HBQnoS"); //plays playlist - https://www.youtube.com/watch?v=ENiLOSC4eoc&list=PLCIEFUFTSqW44Rszr_Ft28C5zN3HBQnoS
            player.cueVideo("oKFcAS7EV2g"); //plays first video

        }
    }

    // if failed - check if the user can recover
    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult errorReason)
    {
        if (errorReason.isUserRecoverableError())
        {
            //allows user to recover from error
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        }
        else {
            //error message shown
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == RECOVERY_REQUEST)
        {
            //
            getYouTubePlayerProvider().initialize(Config.DEVELOPER_KEY, this);
        }
    }

    protected Provider getYouTubePlayerProvider()
    {
        return youTubeView;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
