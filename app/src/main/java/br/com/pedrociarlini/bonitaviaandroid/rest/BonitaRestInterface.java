package br.com.pedrociarlini.bonitaviaandroid.rest;

import com.example.pedrociarlini.projetodaaula.rest.entity.BonitaUser;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by pedrociarlini on 1/26/17.
 */

public interface BonitaRestInterface {

    @FormUrlEncoded
    @POST("loginservice")
    public Call<ResponseBody> loginservice(@Field("username") String bonitaUser, @Field("password") String pass);

    @GET("API/bpm/humanTask")
    public Call<ResponseBody> getOpenTasks(@Query("f") String filtros);
}