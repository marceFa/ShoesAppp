package com.example.shoesapp.ui.zapato;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shoesapp.modelo.Zapato;
import com.example.shoesapp.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ZapatoViewModel extends AndroidViewModel {
    private MutableLiveData<List<Zapato>> listaZapatos;
    private Context context;

    public ZapatoViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public LiveData<List<Zapato>> getListaZapatos() {
        if (listaZapatos == null) {
            listaZapatos = new MutableLiveData<>();
        }
        return listaZapatos;
    }

    public void leer() {
        SharedPreferences sp = context.getSharedPreferences("token", 0);
        String accessToken = sp.getString("token", "");
        Call<List<Zapato>> zapatoCall = ApiClient.getMyApiClient().getZapatos(accessToken);
        zapatoCall.enqueue(new Callback<List<Zapato>>() {
            @Override
            public void onResponse(Call<List<Zapato>> call, Response<List<Zapato>> response) {
                if (response.isSuccessful()) {
                    List<Zapato> zapato = response.body();
                    ArrayList<Zapato> misZapatos = new ArrayList<>();

                    for (Zapato zap : zapato) {
                        if(zap.getEstado()==1){
                            misZapatos.add(zap);
                        }
                    }
                    listaZapatos.postValue(misZapatos);
                }
            }

            @Override
            public void onFailure(Call<List<Zapato>> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
        }

    public void altaZapatoVM(Zapato zapato) {
        SharedPreferences sp = context.getSharedPreferences("token", 0);
        String accessToken = sp.getString("token", "");

        Call<Zapato> altaZapato = ApiClient.getMyApiClient().altaZapato(accessToken, zapato);
        altaZapato.enqueue(new Callback<Zapato>() {
            @Override
            public void onResponse(Call<Zapato> call, Response<Zapato> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(context, "Se dio de alta el Zapato", Toast.LENGTH_LONG).show();
                    leer();
                }
            }

            @Override
            public void onFailure(Call<Zapato> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    public void actualizarZapatoVM(Zapato zapato){
        SharedPreferences sp = context.getSharedPreferences("token", 0);
        String accessToken = sp.getString("token", "");

        Call<Zapato> actualizarZapato = ApiClient.getMyApiClient().putZapato(accessToken, zapato.getIdZapato(), zapato);
        actualizarZapato.enqueue(new Callback<Zapato>() {
            @Override
            public void onResponse(Call<Zapato> call, Response<Zapato> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(context, "Actualizo el zapato :) correctamente", Toast.LENGTH_LONG).show();
                    leer();
                }
            }

            @Override
            public void onFailure(Call<Zapato> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void bajaZapatoVM(int id){
        SharedPreferences sp = context.getSharedPreferences("token", 0);
        String accessToken = sp.getString("token", "");

        Call<Zapato> eliminarZapato = ApiClient.getMyApiClient().deleteZapato(accessToken, id);
        eliminarZapato.enqueue(new Callback<Zapato>() {
            @Override
            public void onResponse(Call<Zapato> call, Response<Zapato> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(context, "Se dio de baja el zapato", Toast.LENGTH_LONG).show();
                    leer();
                }
            }

            @Override
            public void onFailure(Call<Zapato> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}





