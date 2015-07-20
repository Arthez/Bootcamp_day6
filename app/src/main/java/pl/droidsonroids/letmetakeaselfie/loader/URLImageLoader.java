package pl.droidsonroids.letmetakeaselfie.loader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class URLImageLoader implements ImageLoader {

    @Override
    public void loadImage(@NonNull final ImageView imageView, @NonNull final String imageUrl) {
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(imageUrl);
                    InputStream inputStream = url.openStream();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 16;
                    final Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, options);
                    inputStream.close();
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}