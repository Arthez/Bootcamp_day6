package pl.droidsonroids.letmetakeaselfie.api;

import pl.droidsonroids.letmetakeaselfie.api.response.GetSelfiesResponse;
import pl.droidsonroids.letmetakeaselfie.api.response.PostSelfieResponse;
import pl.droidsonroids.letmetakeaselfie.model.Selfie;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;

public final class SelfieApiManager {

    private static final SelfieApiManager INSTANCE = new SelfieApiManager();

    private static final String ENDPOINT = "https://dor-selfie.herokuapp.com";
    private static final String MIME_TYPE = "image/jpeg";

    private final SelfieApiInterface selfieApiInterface;

    public static SelfieApiManager getInstance() {
        return INSTANCE;
    }

    private SelfieApiManager() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        selfieApiInterface = restAdapter.create(SelfieApiInterface.class);
    }

    public void getSelfies(Callback<GetSelfiesResponse> responseCallback) {
        selfieApiInterface.selfieList(responseCallback);
    }

    public void postSelfie(Selfie selfie, Callback<PostSelfieResponse> responseCallback) {
        selfieApiInterface.createSelfie(
                new TypedString(selfie.getUserName()),
                new TypedFile(MIME_TYPE, selfie.getPhotoFile()),
                responseCallback);
    }
}
