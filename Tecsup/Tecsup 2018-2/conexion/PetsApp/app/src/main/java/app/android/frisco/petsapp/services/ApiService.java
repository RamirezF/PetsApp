package app.android.frisco.petsapp.services;

import java.util.List;

import app.android.frisco.petsapp.clases.Pet;
import app.android.frisco.petsapp.clases.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    String API_BASE_URL = "http://10.0.2.2:9090";

    @GET("/pet")
    Call<List<Pet>> getPet();

    @GET("/api/user/")
    Call<List<User>> getUser(@Field("correo") String correo);

    @FormUrlEncoded
    @POST("/auth/login")
    Call<User> login(@Field("correo") String correo,
                         @Field("password") String password);

}
