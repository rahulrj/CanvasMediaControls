package controld.android.com.customcontrols;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.BLACK);
        }

        LinearLayout playLayout = (LinearLayout) findViewById(R.id.play);
        LinearLayout pauseLayout = (LinearLayout) findViewById(R.id.pause);
        LinearLayout muteLayout = (LinearLayout) findViewById(R.id.mute);
        LinearLayout unmuteLayout = (LinearLayout) findViewById(R.id.unmute);
        LinearLayout forwardLayout = (LinearLayout) findViewById(R.id.forward);
        LinearLayout backwardLayout = (LinearLayout) findViewById(R.id.backward);
        LinearLayout toggleFsLayout = (LinearLayout) findViewById(R.id.toggle_fs);
        LinearLayout closeLayout = (LinearLayout) findViewById(R.id.close);

        //params.addRule(RelativeLayout.CENTER_IN_PARENT,RelativeLayout.TRUE);
        CustomControlView playView = new CustomControlView(this, 60, getDensity(), IconType.PLAY_BUTTON);
        CustomControlView pauseView = new CustomControlView(this, 60, getDensity(), IconType.PAUSE_BUTTON);
        CustomControlView muteView = new CustomControlView(this, 50, getDensity(), IconType.MUTE_BUTTON);
        CustomControlView unmuteView = new CustomControlView(this, 50, getDensity(), IconType.UNMUTE_BUTTON);
        CustomControlView forwardView = new CustomControlView(this, 50, getDensity(), IconType.FORWARD_BUTTON);
        CustomControlView backwardView = new CustomControlView(this, 50, getDensity(), IconType.BACKWARD_BUTTON);
        CustomControlView toggleFsView = new CustomControlView(this, 60, getDensity(), IconType.MINIMIZE_BUTTON);
        CustomControlView closeView = new CustomControlView(this, 50, getDensity(), IconType.CLOSE_BUTTON);


        RelativeLayout.LayoutParams playButtonLayoutParams = new RelativeLayout.LayoutParams((int) (60 * getDensity()), (int) (60 * getDensity()));
        RelativeLayout.LayoutParams pauseButtonLayoutParams = new RelativeLayout.LayoutParams((int) (60 * getDensity()), (int) (60 * getDensity()));
        RelativeLayout.LayoutParams muteButtonLayoutParams = new RelativeLayout.LayoutParams((int) (60 * getDensity()), (int) (60 * getDensity()));
        RelativeLayout.LayoutParams unmuteButtonLayoutParams = new RelativeLayout.LayoutParams((int) (60 * getDensity()), (int) (60 * getDensity()));
        RelativeLayout.LayoutParams forwardButtonLayoutParams = new RelativeLayout.LayoutParams((int) (60 * getDensity()), (int) (60 * getDensity()));
        RelativeLayout.LayoutParams backwardButtonLayoutParams = new RelativeLayout.LayoutParams((int) (60 * getDensity()), (int) (60 * getDensity()));
        RelativeLayout.LayoutParams togglefsButtonLayoutParams = new RelativeLayout.LayoutParams((int) (60 * getDensity()), (int) (60 * getDensity()));
        RelativeLayout.LayoutParams closeButtonLayoutParams = new RelativeLayout.LayoutParams((int) (60 * getDensity()), (int) (60 * getDensity()));


        playLayout.addView(playView, playButtonLayoutParams);
        pauseLayout.addView(pauseView, pauseButtonLayoutParams);
        muteLayout.addView(muteView, muteButtonLayoutParams);
        unmuteLayout.addView(unmuteView, unmuteButtonLayoutParams);
        forwardLayout.addView(forwardView, forwardButtonLayoutParams);
        backwardLayout.addView(backwardView, backwardButtonLayoutParams);
        toggleFsLayout.addView(toggleFsView, togglefsButtonLayoutParams);
        closeLayout.addView(closeView, closeButtonLayoutParams);


    }

    public float getDensity() {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        display.getMetrics(dm);

        float density = dm.density;
        return density;
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
