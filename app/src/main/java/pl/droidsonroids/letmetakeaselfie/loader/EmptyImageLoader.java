package pl.droidsonroids.letmetakeaselfie.loader;

import android.support.annotation.NonNull;
import android.widget.ImageView;

public class EmptyImageLoader implements ImageLoader {

    @Override
    public void loadImage(@NonNull final ImageView imageView, @NonNull final String imageUrl) {
        // no-op
    }
}
