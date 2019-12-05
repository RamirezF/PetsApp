package app.android.frisco.petsapp.interfaces;

import java.util.List;

import app.android.frisco.petsapp.clases.Pet;
import app.android.frisco.petsapp.clases.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    String API_BASE_URL = "http://10.0.2.2:9090";

    @GET("/pet")
    Call<List<Pet>> getPet();

    @GET("/user/{correo}")
    Call<User> getUser(@Path("correo") String correo);

}
