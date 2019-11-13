package app.android.frisco.almacenapp.services;

import java.util.List;

import app.android.frisco.almacenapp.models.Producto;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    String API_BASE_URL = "http://10.0.2.2:8080";

    @GET("/productos")
    Call<List<Producto>> findAll();

}

