package com.ryle_tech.materialdesign.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.ryle_tech.materialdesign.R;
import com.ryle_tech.materialdesign.fragment.DiscoverFragment;
import com.ryle_tech.materialdesign.fragment.RecyclerViewFragment;
import com.ryle_tech.materialdesign.fragment.ShowcaseFragment;
import com.ryle_tech.materialdesign.fragment.TicketsFragments;
import com.ryle_tech.materialdesign.fragment.YouFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
//    JSONObject response, profile_pic_data, profile_pic_url;
    TextView user_name, user_email;
    ImageView user_picture;
    NavigationView navigationview;
    private MaterialViewPager mViewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        setTitle("");

        assignViews();

        toolbar = mViewPager.getToolbar();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 4) {
                    case 0:
                        return new ShowcaseFragment();
                    case 1:
                        return new TicketsFragments();
                    case 2:
                        return new YouFragment();
                    case 3:
                        return new DiscoverFragment();
                    default:
                        return RecyclerViewFragment.newInstance();
                }

            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {
                    case 0:
                        return "SHOWCASE";
                    case 1:
                        return "TICKETS";
                    case 2:
                        return "YOU";
                    case 3:
                        return "DISCOVER";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.green,
                               "https://fs01.androidpit.info/a/63/0e/android-l-wallpapers-630ea6-h900.jpg");
//                                "https://192.168.56.1/material/cod.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2014/06/wallpaper_51.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,
                                "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        Intent data = getIntent();
        GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);


         // call setNavigationHeader Method.
        setUserProfile(result); // call setUserProfile Method.







        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hope You are Enjoying the App", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        assert drawer != null;
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);




    }

    private void setUserProfile(GoogleSignInResult result) {


        try {
//            LoginActivity googleprofile = new LoginActivity();
            GoogleSignInAccount acct = result.getSignInAccount();
//            response = new JSONObject(jsondata);
//            user_email.setText(response.get("email").toString());
            user_email.setText(acct.getEmail());
            user_name.setText(acct.getDisplayName());

//            user_name.setText(response.get("name").toString());
//            profile_pic_data = new JSONObject(response.get("picture").toString());
//            profile_pic_url = new JSONObject(profile_pic_data.getString("data"));

//            Picasso.with(this).load(profile_pic_url.getString("url"))
//                    .into(user_picture);

        } catch (Exception e){
            e.printStackTrace();
        }
    }


    private void assignViews() {
        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

            startActivity(new Intent(getBaseContext(),SettingsActivity.class));


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
//Login
            startActivity(new Intent(getBaseContext(), LoginActivity.class));

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(getBaseContext(), RegisterActivity.class));

//        } else if (id == R.id.nav_slideshow) {


        } else if (id == R.id.nav_manage) {
            startActivity(new Intent(getBaseContext(), SettingsActivity.class));
        } else if (id == R.id.nav_share) {
            Toast.makeText( getBaseContext(), "Shares the details on social media",  Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_send) {
            Toast.makeText( getBaseContext(), "Sends details anywhere",  Toast.LENGTH_SHORT).show();
        }

        user_name = (TextView)findViewById(R.id.username);
        user_email = (TextView)findViewById(R.id.email);

        LoginActivity data = new LoginActivity();
        String userGoogle = data.googleUsername;
        user_name.setText(userGoogle);
        String emailGoogle = data.googleEmail;
        user_email.setText(emailGoogle);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
