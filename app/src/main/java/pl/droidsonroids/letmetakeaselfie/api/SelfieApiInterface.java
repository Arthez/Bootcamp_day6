package pl.droidsonroids.letmetakeaselfie.api;

import android.support.annotation.NonNull;

import pl.droidsonroids.letmetakeaselfie.api.response.GetSelfiesResponse;
import pl.droidsonroids.letmetakeaselfie.api.response.PostSelfieResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;

public interface SelfieApiInterface {

    @GET("/api/photos")
    void selfieList(final Callback<GetSelfiesResponse> responseCallback);

    @Multipart
    @POST("/api/photos")
    void createSelfie(
            @NonNull @Part("user_name") final TypedString userName,
            @NonNull @Part("photo") final TypedFile photo,
            final Callback<PostSelfieResponse> responseCallback);

}
