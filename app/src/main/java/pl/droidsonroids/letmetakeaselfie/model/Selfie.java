package pl.droidsonroids.letmetakeaselfie.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.File;

public class Selfie {

    @Expose private File photoFile;

    @SerializedName("photo_url") private String photoUrl;
    @SerializedName("user_name") private String userName;

    public File getPhotoFile() {
        return photoFile;
    }

    public void setPhotoFile(final File photoFile) {
        this.photoFile = photoFile;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }
}
