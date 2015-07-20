package pl.droidsonroids.letmetakeaselfie.loader;

import android.support.annotation.NonNull;
import android.widget.ImageView;

public interface ImageLoader {

    void loadImage(@NonNull final ImageView imageView, @NonNull final String imageUrl);
}
