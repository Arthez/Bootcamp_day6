package pl.droidsonroids.letmetakeaselfie.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pl.droidsonroids.letmetakeaselfie.R;
import pl.droidsonroids.letmetakeaselfie.model.Selfie;
import pl.droidsonroids.letmetakeaselfie.ui.widget.SelfieView;

public class SelfieAdapter extends RecyclerView.Adapter<SelfieAdapter.SelfieViewHolder> {

    private final List<Selfie> selfies = new ArrayList<>();

    @Override
    public SelfieViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        SelfieView view = (SelfieView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selfie, parent, false);
        return new SelfieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SelfieViewHolder holder, final int position) {
        holder.displaySelfie(selfies.get(position));
    }

    @Override
    public int getItemCount() {
        return selfies.size();
    }

    public void setSelfies(@NonNull final List<Selfie> selfies) {
        this.selfies.clear();
        this.selfies.addAll(selfies);

        Collections.reverse(this.selfies);

        notifyDataSetChanged();
    }

    class SelfieViewHolder extends RecyclerView.ViewHolder {

        public SelfieViewHolder(@NonNull final SelfieView itemView) {
            super(itemView);
        }

        public void displaySelfie(@NonNull final Selfie selfie) {
            ((SelfieView) itemView).displaySelfie(selfie);
        }
    }
}
