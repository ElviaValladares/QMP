package com.efisys.quienmepresta.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.efisys.quienmepresta.MainActivity;
import com.efisys.quienmepresta.PerfilVista;
import com.efisys.quienmepresta.R;

public class SolicitaCreditoVista extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private Spinner motivoPrestamo;
    private Spinner pagos;
    private Spinner tiempoPagos;
    private EditText cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solicita_credito_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        cantidad = (EditText) findViewById(R.id.cantidad);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //SPINNER
        motivoPrestamo = (Spinner) findViewById(R.id.spinnerCuantoDinero);
        ArrayAdapter<CharSequence> cuantoDinero = ArrayAdapter.createFromResource
                (this, R.array.MotivoPrestamo, android.R.layout.simple_spinner_item);
        motivoPrestamo.setAdapter(cuantoDinero);

        pagos = (Spinner) findViewById(R.id.spinnerPagos);
        ArrayAdapter<CharSequence> tiposPagos = ArrayAdapter.createFromResource
                (this, R.array.Pagos, android.R.layout.simple_spinner_item);
        pagos.setAdapter(tiposPagos);

        tiempoPagos = (Spinner) findViewById(R.id.spinnerTiempoPagos);
        ArrayAdapter<CharSequence> precomendacion = ArrayAdapter.createFromResource
                (this, R.array.TiempoPagos, android.R.layout.simple_spinner_item);
        tiempoPagos.setAdapter(precomendacion);

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
        int id = item.getItemId();

        switch(id){
            case R.id.inicio: {
                Bundle contenedor = new Bundle();
                Intent i = new Intent(this, MainActivity.class);
                i.putExtras(contenedor);
                startActivity(i);
                break;
            }
            case R.id.solicitaCred: {
                Bundle contenedor = new Bundle();
                Intent i = new Intent(this, SolicitaCreditoVista.class);
                i.putExtras(contenedor);
                startActivity(i);
               // showFragment(HalfRightSwipeFragment.newInstance(), HalfRightSwipeFragment.TAG);
                break;
            }
            case R.id.miPerfil: {
                Bundle contenedor = new Bundle();
                Intent i = new Intent(this, PerfilVista.class);
                i.putExtras(contenedor);
                startActivity(i);

                //showFragment(CreditoSwiperFragment.newInstance(), CreditoSwiperFragment.TAG);
                break;
            }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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

    @Override
    public void onClick(View view) {

    }
}
