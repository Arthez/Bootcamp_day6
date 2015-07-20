package pl.droidsonroids.letmetakeaselfie.loader;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import pl.droidsonroids.letmetakeaselfie.R;

public class PlaceholderImageLoader implements ImageLoader  {

    @Override
    public void loadImage(@NonNull ImageView imageView, @NonNull String imageUrl) {
        imageView.setImageResource(R.drawable.ic_face_black_36dp);
    }
}
