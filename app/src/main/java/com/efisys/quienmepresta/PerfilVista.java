package com.efisys.quienmepresta;

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
import android.widget.ImageButton;
import android.widget.Spinner;

import com.efisys.quienmepresta.Librerias.DialogCalendar;
import com.efisys.quienmepresta.fragment.SolicitaCreditoVista;

import java.util.Calendar;

public class PerfilVista extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private ImageButton botonFechaInicial;
    private EditText editTextFechaInicial;

    private int mYearInicial;
    private int mMonthInicial;
    private int mDayInicial;
    private int mYear;
    private int mMonth;
    private int mDay;
    private int mYearFinal;
    private int mMonthFinal;
    private int mDayFinal;
    private DialogCalendar dialogCalendar;
    private boolean calendarioInicialBandera=true;
    private Spinner municipio;
    private Spinner estado;
    private Spinner ide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextFechaInicial = (EditText) findViewById(R.id.fechaPromesaPago);
        botonFechaInicial = (ImageButton) findViewById(R.id.boton_fecha);
        botonFechaInicial.setOnClickListener(this);
        obtenerFechaActual();
        updateDisplay(mYear, mMonth, mDay);
        editTextFechaInicial.setText(mYear + "-" + mMonth + "-" + mDay);
        //editTextFechaFinal.setText(mYear + "-" + mMonth + "-" + mDay);
        dialogCalendar = new DialogCalendar(this, mYear, mMonth, mDay);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //SPINNER
        municipio = (Spinner) findViewById(R.id.id);
        ArrayAdapter<CharSequence> munp = ArrayAdapter.createFromResource
                (this, R.array.Identificacion, android.R.layout.simple_spinner_item);
        municipio.setAdapter(munp);

        estado = (Spinner) findViewById(R.id.estado);
        ArrayAdapter<CharSequence> est = ArrayAdapter.createFromResource
                (this, R.array.estados, android.R.layout.simple_spinner_item);
        estado.setAdapter(est);

        ide = (Spinner) findViewById(R.id.municipio);
        ArrayAdapter<CharSequence> id = ArrayAdapter.createFromResource
                (this, R.array.municipio, android.R.layout.simple_spinner_item);
        ide.setAdapter(id);

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

    public void obtenerFechaActual(){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH)+1;
        mDay = c.get(Calendar.DAY_OF_MONTH);

        mYearInicial = mYear;
        mMonthInicial = mMonth;
        mDayInicial = mDay;

        mYearFinal  = mYear;
        mMonthFinal = mMonth;
        mDayFinal   = mDay;
    }

    public void updateDisplay(int mYear, int mMonth, int mDay) {
        if (calendarioInicialBandera) {
            mYearInicial = mYear;
            mMonthInicial = mMonth;
            mDayInicial = mDay;
            editTextFechaInicial.setText(mYear + "-" + mMonth + "-" + mDay);
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
        switch (view.getId()) {
            case R.id.boton_fecha:
                calendarioInicialBandera = true;
                dialogCalendar.showDialog();
                break;
        }

    }
}
