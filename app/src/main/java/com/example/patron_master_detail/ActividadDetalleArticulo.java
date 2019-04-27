package com.example.patron_master_detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;



public class ActividadDetalleArticulo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_detalle_articulo);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detalle);
        setSupportActionBar(toolbar);


        if (!getResources().getBoolean(R.bool.esTablet)) {

            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }

        if (savedInstanceState == null) {

            Bundle arguments = new Bundle();
            arguments.putString(FragmentoDetalleArticulo.ID_ARTICULO,
                    getIntent().getStringExtra(FragmentoDetalleArticulo.ID_ARTICULO));
            FragmentoDetalleArticulo fragment = new FragmentoDetalleArticulo();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contenedor_detalle_articulo, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalle_articulo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, ActividadListaArticulos.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
