package com.example.shoesapp.ui.zapato;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.shoesapp.R;
import com.example.shoesapp.modelo.Zapato;
import com.example.shoesapp.ui.inicio.Principal;

import java.util.List;

public class ZapatoFragment extends Fragment {
    private ZapatoViewModel zapatoViewModel;
    private Zapato zapatoF = null;
    private ListView lvZapatos;
    private ArrayAdapter<Zapato> adapter;
    private Button btnVender;
    private Button btnNuevo;
    private Button btnModificar;
    private Button btnGuardar;
    private Button btnBorrar;
    private Button btnVaciarCarrito;
    private Button btnRefrescar;
    private EditText etNuevoId;
    private EditText etMarca;
    private EditText etModelo;
    private EditText etTalle;
    private EditText etStock;
    private EditText etPrecio;
    private EditText etEstado;
    private SharedPreferences sp;


    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.zapato_fragment, container, false);
        ((Principal) getActivity()).setActionBarTitle("Zapatos");
        //definir elementos
        btnVender = root.findViewById(R.id.btnVender);
        btnNuevo = root.findViewById(R.id.btnNuevo);
        btnModificar = root.findViewById(R.id.btnModificar);
        btnGuardar = root.findViewById(R.id.btnGuardar);
        btnBorrar = root.findViewById(R.id.btnBorrar);
        btnVaciarCarrito = root.findViewById(R.id.btnVaciarCarrito);
        btnRefrescar = root.findViewById(R.id.btnRefrescar);
        lvZapatos = root.findViewById(R.id.listadoZapatos);
        etNuevoId = root.findViewById(R.id.etNuevoId);
        etMarca = root.findViewById(R.id.etNuevaMarca);
        etModelo = root.findViewById(R.id.etNuevoModelo);
        etTalle = root.findViewById(R.id.etNuevoTalle);
        etStock = root.findViewById(R.id.etNuevoStock);
        etPrecio = root.findViewById(R.id.etNuevoPrecio);
        etEstado = root.findViewById(R.id.etNuevoEstado);

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Principal) getActivity()).setActionBarTitle("Nuevo Modelo Zapato");

                btnNuevo.setVisibility(v.GONE);
                btnGuardar.setVisibility(v.VISIBLE);
                lvZapatos.setVisibility(v.GONE);

                etMarca.setVisibility(v.VISIBLE);
                etModelo.setVisibility(v.VISIBLE);
                etTalle.setVisibility(v.VISIBLE);
                etStock.setVisibility(v.VISIBLE);
                etPrecio.setVisibility(v.VISIBLE);
                etNuevoId.setText("");
                etMarca.setText("");
                etModelo.setText("");
                etPrecio.setText("");
                etTalle.setText("");
                etStock.setText("");

            }
        });
        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNuevo.setVisibility(v.GONE);
                btnGuardar.setVisibility(v.VISIBLE);
                lvZapatos.setVisibility(v.GONE);
                ((Principal) getActivity()).setActionBarTitle("Editar Zapato");
                sp = getContext().getSharedPreferences("editZap",0);
                int id = sp.getInt("id",-1);
                String marca = sp.getString("marca","-1");
                String modelo = sp.getString("modelo","-1");
                int talle = sp.getInt("talle",-1);
                int stock = sp.getInt("stock",-1);
                double precio =(double) sp.getFloat("precio",-1);

                etMarca.setVisibility(v.VISIBLE);
                etModelo.setVisibility(v.VISIBLE);
                etTalle.setVisibility(v.VISIBLE);
                etStock.setVisibility(v.VISIBLE);
                etPrecio.setVisibility(v.VISIBLE);

                etNuevoId.setText(id+"");
                etMarca.setText(marca);
                etModelo.setText(modelo);
                etTalle.setText(talle+"");
                etStock.setText(stock+"");
                etPrecio.setText(precio+"");

            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etMarca.getText().toString().equals("") || etModelo.getText().toString().equals("") ||
                        etTalle.getText().toString().equals("") || etStock.getText().toString().equals("") ||
                        etPrecio.getText().toString().equals("") || etEstado.getText().toString().equals("") ){
                    Toast.makeText(getContext(), "Completar", Toast.LENGTH_LONG).show();
                }else{
                    ((Principal) getActivity()).setActionBarTitle("Zapatos");
                    zapatoF = new Zapato();
                    zapatoF.setMarca(etMarca.getText().toString());
                    zapatoF.setModelo(etModelo.getText().toString());
                    zapatoF.setTalle(Integer.parseInt(etTalle.getText().toString()));
                    zapatoF.setStock(Integer.parseInt(etStock.getText().toString()));
                    zapatoF.setPrecio(Double.parseDouble(etPrecio.getText().toString()));
                    zapatoF.setEstado(Byte.parseByte("1"));
                    if(etNuevoId.getText().toString().equals("")){
                        zapatoViewModel.altaZapatoVM(zapatoF);
                    }else{
                        zapatoF.setIdZapato(Integer.parseInt(etNuevoId.getText().toString()));
                        zapatoViewModel.actualizarZapatoVM(zapatoF);
                    }

                    btnGuardar.setVisibility(v.GONE);
                    btnNuevo.setVisibility(v.VISIBLE);
                    etMarca.setVisibility(v.GONE);
                    etModelo.setVisibility(v.GONE);
                    etTalle.setVisibility(v.GONE);
                    etStock.setVisibility(v.GONE);
                    etPrecio.setVisibility(v.GONE);
                    lvZapatos.setVisibility(v.VISIBLE);
                }
            }
        });
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp = getContext().getSharedPreferences("delZap",0);
                int id = sp.getInt("id",-1);
                zapatoViewModel.bajaZapatoVM(id);
            }
        });

        btnRefrescar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zapatoViewModel.leer();
            }
        });

        zapatoViewModel = ViewModelProviders.of(this).get(ZapatoViewModel.class);
        zapatoViewModel.getListaZapatos().observe(getViewLifecycleOwner(), new Observer<List<Zapato>>() {
            @Override
            public void onChanged(List<Zapato> zapatos) {
                adapter = new ItemZapatoAdapter(getContext(), R.layout.item_zapato_fragment,zapatos, getLayoutInflater(), btnModificar, btnBorrar, btnVender, btnNuevo, btnVaciarCarrito, btnRefrescar);
                lvZapatos.setAdapter(adapter);
            }
        });
        zapatoViewModel.leer();

        return root;
    }
}
