package pl.droidsonroids.letmetakeaselfie.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import pl.droidsonroids.letmetakeaselfie.model.Selfie;

public class GetSelfiesResponse {

    @SerializedName("photos") private List<Selfie> selfies;

    public List<Selfie> getSelfies() {
        return selfies;
    }
}
