package com.mxy.hearthstone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void findByHero(View view) {
        Intent intent = new Intent();
        intent.setClass(this, HeroSelect.class);
        startActivity(intent);
    }

    public void findByCosts(View view) {
        Intent intent = new Intent();
        intent.setClass(this, CostsSelect.class);
        startActivity(intent);
    }

    public void findByQuality(View view) {
        Intent intent = new Intent();
        intent.setClass(this, QualitySelect.class);
        startActivity(intent);
    }

    public void findByType(View view) {
        Intent intent = new Intent();
        intent.setClass(this, TypeSelect.class);
        startActivity(intent);
    }
}
