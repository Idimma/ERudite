package erudite.maotronics.com;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Main_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Button SciHome_Button, ArtHome_Button, CommHome_Button, General_Button;
    DrawerLayout drawer;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final VideoView mVideoView= (VideoView) findViewById(R.id.video1);
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.erudite));
        mVideoView.start();
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        SciHome_Button = (Button) findViewById(R.id.sci_btn);
        SciHome_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationView.getMenu().clear();
                navigationView.inflateMenu(R.menu.science);
                drawer.openDrawer(GravityCompat.START);

            }
        });

        ArtHome_Button = (Button) findViewById(R.id.art_btn);
        ArtHome_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationView.getMenu().clear();
                navigationView.inflateMenu(R.menu.art);

                drawer.openDrawer(GravityCompat.START);

            }
        });
        CommHome_Button = (Button) findViewById(R.id.comm_btn);
        CommHome_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationView.getMenu().clear();
                navigationView.inflateMenu(R.menu.commercial);
                drawer.openDrawer(GravityCompat.START);

            }
        });

        General_Button = (Button) findViewById(R.id.gen_btn);
        General_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationView.getMenu().clear();
                navigationView.inflateMenu(R.menu.general);
                drawer.openDrawer(GravityCompat.START);

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int selectedItem
                = item.getItemId();
        if (selectedItem == R.id.bio) {
            Intent nextActivity = new Intent(getApplicationContext(), YearPicker.class);
            nextActivity.putExtra("subject", "Biology");
            startActivity(nextActivity);

        } if (selectedItem == R.id.chemistry) {
            Intent nextActivity = new Intent(getApplicationContext(), YearPicker.class);
            nextActivity.putExtra("subject", "Chemistry");
            startActivity(nextActivity);

        } if (selectedItem == R.id.phs) {
            Intent nextActivity = new Intent(getApplicationContext(), YearPicker.class);
            nextActivity.putExtra("subject", "Physics");
            startActivity(nextActivity);

        } if (selectedItem == R.id.geography) {
            Intent nextActivity = new Intent(getApplicationContext(), YearPicker.class);
            nextActivity.putExtra("subject", "Geography");
            startActivity(nextActivity);

        } if (selectedItem == R.id.commerce) {
            Intent nextActivity = new Intent(getApplicationContext(), YearPicker.class);
            nextActivity.putExtra("subject", "Commerce");
            startActivity(nextActivity);

        } if (selectedItem == R.id.accounting) {
            Intent nextActivity = new Intent(getApplicationContext(), YearPicker.class);
            nextActivity.putExtra("subject", "Accounting");
            startActivity(nextActivity);

        } if (selectedItem == R.id.bookKeeping) {
            Intent nextActivity = new Intent(getApplicationContext(), YearPicker.class);
            nextActivity.putExtra("subject", "Book Keeping");
            startActivity(nextActivity);

        } if (selectedItem == R.id.mathematics) {
            Intent nextActivity = new Intent(getApplicationContext(), YearPicker.class);
            nextActivity.putExtra("subject", "Mathematics");
            startActivity(nextActivity);

        } if (selectedItem == R.id.fMath) {
            Intent nextActivity = new Intent(getApplicationContext(), YearPicker.class);
            nextActivity.putExtra("subject", "Further Mathematics");
            startActivity(nextActivity);

        } if (selectedItem == R.id.literature) {
            Intent nextActivity = new Intent(getApplicationContext(), YearPicker.class);
            nextActivity.putExtra("subject", "Literature");
            startActivity(nextActivity);

        } if (selectedItem == R.id.history) {
            Intent nextActivity = new Intent(getApplicationContext(), YearPicker.class);
            nextActivity.putExtra("subject", "History");
            startActivity(nextActivity);

        } if (selectedItem == R.id.crs) {
            Intent nextActivity = new Intent(getApplicationContext(), YearPicker.class);
            nextActivity.putExtra("subject", "C.R.S");
            startActivity(nextActivity);

        } if (selectedItem == R.id.economics) {
            Intent nextActivity = new Intent(getApplicationContext(), YearPicker.class);
            nextActivity.putExtra("subject", "Economics");
            startActivity(nextActivity);

        } if (selectedItem == R.id.eng) {
            Intent nextActivity = new Intent(getApplicationContext(), YearPicker.class);
            nextActivity.putExtra("subject", "English Language");
            startActivity(nextActivity);

        } if (selectedItem == R.id.agric_sci) {
            Intent nextActivity = new Intent(getApplicationContext(), YearPicker.class);
            nextActivity.putExtra("subject", "Agriculture Science");
            startActivity(nextActivity);

        } if (selectedItem == R.id.government) {
            Intent nextActivity = new Intent(getApplicationContext(), YearPicker.class);
            nextActivity.putExtra("subject", "Government");
            startActivity(nextActivity);

        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
