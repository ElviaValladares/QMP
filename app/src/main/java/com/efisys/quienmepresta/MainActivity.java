package com.efisys.quienmepresta;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;

import com.efisys.quienmepresta.fragment.ConfiguracionFragment;
import com.efisys.quienmepresta.fragment.CreditoSwiperFragment;
import com.efisys.quienmepresta.fragment.MiPerfilFragment;
import com.efisys.quienmepresta.fragment.MiScoreFragment;
import com.efisys.quienmepresta.fragment.MisCreditosFragment;
import com.efisys.quienmepresta.fragment.SolicitaCreditoVista;
import com.efisys.quienmepresta.fragment.SolicitarCredFragment;

import static com.efisys.quienmepresta.R.id.drawer_layout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        showFragment(CreditoSwiperFragment.newInstance(), CreditoSwiperFragment.TAG);
        navigationView.setCheckedItem(R.id.inicio);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent i;
        Bundle contenedor = new Bundle();
        switch(id){
            case R.id.inicio: {
                showFragment(CreditoSwiperFragment.newInstance(), CreditoSwiperFragment.TAG);
                getSupportActionBar().setTitle(R.string.app_name);
                break;
            }
            case R.id.solicitaCred: {
                showFragment(SolicitarCredFragment.newInstance(), SolicitarCredFragment.TAG);
                getSupportActionBar().setTitle(R.string.solicitarCredito);
                break;
            }
            case R.id.misCreditos:{
                showFragment(MisCreditosFragment.newInstance(),MisCreditosFragment.TAG);
                getSupportActionBar().setTitle(R.string.misCreditos);
                break;
            }
            case R.id.miPerfil: {
                showFragment(MiPerfilFragment.newInstance(),MiPerfilFragment.TAG);
                getSupportActionBar().setTitle(R.string.miPerfil);
                break;
            }
            case R.id.miScore:{
                showFragment(MiScoreFragment.newInstance(),MiScoreFragment.TAG);
                getSupportActionBar().setTitle(R.string.miScore);
                break;
            }
            case R.id.configuracion:{
                showFragment(ConfiguracionFragment.newInstance(),ConfiguracionFragment.TAG);
                getSupportActionBar().setTitle(R.string.configuracion);
                break;
            }
            case R.id.cerrarSesion:{
                i = new Intent(this, InicioActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP  && Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                    Slide slide = new Slide(Gravity.LEFT);
                    slide.setDuration(500);
                    getWindow().setExitTransition(slide);
                    getWindow().setEnterTransition(slide);
                    startActivity(i, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
                } else {
                    startActivity(i);
                }
                finish();
                break;
            }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragment(Fragment fragment, String tag) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment prevFragment = fm.findFragmentByTag(tag);
        if (prevFragment != null) {
            return;
        }
        FragmentTransaction tr = fm.beginTransaction();
        tr.replace(R.id.fragment_container, fragment, tag)
                .commit();
    }
    private void launchSharer() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hi, I found on google play that awesome swipe library at https://github.com/xenione/SwipeLayout. Have a look !!! ");
        sendIntent.setType("text/html");
        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));
    }
}
