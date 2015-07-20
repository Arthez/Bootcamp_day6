package pl.droidsonroids.letmetakeaselfie.loader;

import android.support.annotation.NonNull;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public class PicassoImageLoader implements ImageLoader {

    @Override
    public void loadImage(@NonNull ImageView imageView, @NonNull String imageUrl) {
        Picasso.with(imageView.getContext()).load(imageUrl).fit().centerCrop().into(imageView);
//        Picasso.with(imageView.getContext()).load(imageUrl).into(imageView);
    }
}
