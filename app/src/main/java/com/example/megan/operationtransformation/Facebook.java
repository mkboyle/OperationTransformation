package com.example.megan.operationtransformation;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.util.List;

/**
 * Created by Megan on 24/04/2016.
 */
public class Facebook extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facebook);
        //launchFacebook();
    }

    //Would only Bring you to your own page and not the
    //operation transformation page

  /*  public final void launchFacebook() {
        final String urlFb = "fb://page/OpTranRTE";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlFb));

        // If a Facebook app is installed, use it. Otherwise, launch
        // a browser
        final PackageManager packageManager = getPackageManager();
        List<ResolveInfo> list =
                packageManager.queryIntentActivities(intent,
                        PackageManager.MATCH_DEFAULT_ONLY);
        if (list.size() == 0) {
            final String urlBrowser = "https://www.facebook.com/pages/OpTranRTE";
            intent.setData(Uri.parse(urlBrowser));
        }

        startActivity(intent);
    } */

}
