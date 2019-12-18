package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.Profil;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v4.content.ContextCompat.startActivity;

public class MyNeighbourRecyclerViewAdapter extends RecyclerView.Adapter<MyNeighbourRecyclerViewAdapter.ViewHolder> {

    private final List<Neighbour> mNeighbours;
    private Context context;

    public MyNeighbourRecyclerViewAdapter(List<Neighbour> items, Context context) {
        mNeighbours = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_neighbour, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Neighbour neighbour = mNeighbours.get(position);
        holder.mNeighbourName.setText(neighbour.getName());
        Glide.with(holder.mNeighbourAvatar.getContext())
                .load(neighbour.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mNeighbourAvatar);

        holder.mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new DeleteNeighbourEvent(neighbour));
            }
        });

        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Profil.class);
                intent.putExtra(Profil.EXTRA_NEIGHBOUR, mNeighbours.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNeighbours.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_list_avatar)
        public ImageView mNeighbourAvatar;
        @BindView(R.id.item_list_name)
        public TextView mNeighbourName;
        @BindView(R.id.item_list_delete_button)
        public ImageButton mDeleteButton;
        @BindView(R.id.constraintLayout)
        public ConstraintLayout mLayout;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
