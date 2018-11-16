package com.mdikkii.fancytogglebuttonexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mdikkii.fancytogglebutton.FancyToggleButton;
import com.mdikkii.fancytogglebutton.State;
import com.nightonke.jellytogglebuttonexample.R;

public class MainActivity extends AppCompatActivity
        implements
        FancyToggleButton.OnStateChangeListener,
        View.OnClickListener {

    private static final int[] JTB_ID = new int[]{
            R.id.jtb_21,
    };

    private Toast lastToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(R.string.app_title);

        for (int id : JTB_ID) ((FancyToggleButton)findViewById(id)).setOnStateChangeListener(this);

        findView(R.id.change_all).setOnClickListener(this);
        findView(R.id.settings_button).setOnClickListener(this);
    }

    @Override
    public void onStateChange(float process, State state, FancyToggleButton jbt) {
        if (state.equals(State.LEFT)) {
            if (lastToast != null) lastToast.cancel();
            lastToast = Toast.makeText(this, "Left!", Toast.LENGTH_SHORT);
            lastToast.show();
        }
        if (state.equals(State.RIGHT)) {
            if (lastToast != null) lastToast.cancel();
            lastToast = Toast.makeText(this, "Right!", Toast.LENGTH_SHORT);
            lastToast.show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_all:
                for (int id : JTB_ID) ((FancyToggleButton)findViewById(id)).toggle(false);
                break;
            case R.id.settings_button:
                startActivity(new Intent(this, SettingsActivity.class));
                break;
        }
    }

    private <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_github:
                goWeb("https://github.com/Nightonke/FaceOffToggleButton");
                return true;
            case R.id.action_developer:
                goWeb("https://github.com/Nightonke");
                return true;
            case R.id.action_wowo:
                goWeb("https://github.com/Nightonke/WoWoViewPager");
                return true;
            case R.id.action_boom:
                goWeb("https://github.com/Nightonke/BoomMenu");
                return true;
            case R.id.action_cocoin:
                goWeb("https://github.com/Nightonke/CoCoin");
                return true;
            case R.id.action_blur:
                goWeb("https://github.com/Nightonke/BlurLockView");
                return true;
            case R.id.action_leeco:
                goWeb("https://github.com/Nightonke/LeeCo");
                return true;
            case R.id.action_gw:
                goWeb("https://github.com/Nightonke/GithubWidget");
                return true;
            case R.id.action_face:
                goWeb("https://github.com/Nightonke/FaceOffToggleButton");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void goWeb(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }
}
