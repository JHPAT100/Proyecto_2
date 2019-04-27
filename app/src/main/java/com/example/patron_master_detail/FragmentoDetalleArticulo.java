package com.example.patron_master_detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.patron_master_detail.modelo.ModeloArticulos;



public class FragmentoDetalleArticulo extends Fragment {


    public static final String ID_ARTICULO = "extra.idArticulo";


    private ModeloArticulos.Articulo itemDetallado;

    public FragmentoDetalleArticulo() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ID_ARTICULO)) {

            itemDetallado = ModeloArticulos.MAPA_ITEMS.get(getArguments().getString(ID_ARTICULO));

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmento_detalle_articulo, container, false);

        if (itemDetallado != null) {

            Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar_detalle);
            if (toolbar != null)
                toolbar.inflateMenu(R.menu.menu_detalle_articulo);

            ((TextView) v.findViewById(R.id.titulo)).setText(itemDetallado.titulo);
            ((TextView) v.findViewById(R.id.fecha)).setText(itemDetallado.fecha);
            ((TextView) v.findViewById(R.id.contenido)).setText(getText(R.string.lorem));
            Glide.with(this)
                    .load(itemDetallado.urlMiniatura)
                    .into((ImageView) v.findViewById(R.id.imagen));
        }

        return v;
    }
}
