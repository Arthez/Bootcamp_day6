package pl.droidsonroids.letmetakeaselfie.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.droidsonroids.letmetakeaselfie.R;
import pl.droidsonroids.letmetakeaselfie.loader.EmptyImageLoader;
import pl.droidsonroids.letmetakeaselfie.loader.ImageLoader;
import pl.droidsonroids.letmetakeaselfie.loader.PicassoImageLoader;
import pl.droidsonroids.letmetakeaselfie.loader.PlaceholderImageLoader;
import pl.droidsonroids.letmetakeaselfie.loader.URLImageLoader;
import pl.droidsonroids.letmetakeaselfie.model.Selfie;

public class SelfieView extends LinearLayout {

    @Bind(R.id.text_user) TextView userNameText;
    @Bind(R.id.image_photo) ImageView photoImage;

//    private final ImageLoader imageLoader = new PlaceholderImageLoader();
    private final ImageLoader imageLoader = new PicassoImageLoader();
//    private final ImageLoader imageLoader = new URLImageLoader();

    public SelfieView(final Context context) {
        this(context, null);
    }

    public SelfieView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public SelfieView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SelfieView(final Context context, final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void displaySelfie(@NonNull final Selfie selfie) {
        displayUserName(selfie.getUserName());
        displayPhoto(selfie.getPhotoUrl());
    }

    private void displayUserName(final @NonNull String userName) {
        userNameText.setText(userNameText.getContext().getString(R.string.selfie_by, userName));
    }

    private void displayPhoto(@NonNull final String photoUrl) {
        imageLoader.loadImage(photoImage, photoUrl);
    }
}
