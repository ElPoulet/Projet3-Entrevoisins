package com.openclassrooms.entrevoisins;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;

import java.util.List;

import butterknife.BindDrawable;
import butterknife.BindView;

import static com.openclassrooms.entrevoisins.R.drawable.ic_star_border_white_24dp;

public class Profil extends AppCompatActivity {


    @BindView(R.id.imageFavori)
    public android.support.design.widget.FloatingActionButton buttonFavorite;

    public static final String EXTRA_NEIGHBOUR = "extra_neighbour";
    ImageButton buttonBack;


    private NeighbourApiService mFavoriteApiService;
    private Neighbour neighbourRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        mFavoriteApiService = DI.getNeighbourApiService();

        ImageView imageProfil = findViewById(R.id.photoProfil);
        TextView nameProfil = findViewById(R.id.prenomMain);
        TextView nameProfil2 = findViewById(R.id.prenomSecond);
        TextView address = findViewById(R.id.address);
        TextView phoneNumber = findViewById(R.id.phoneNumber);
        TextView socialNetwork = findViewById(R.id.network);
        buttonBack  = findViewById(R.id.imageButtonBack);
        buttonFavorite = findViewById(R.id.imageFavori);

        neighbourRetour = getIntent().getParcelableExtra(EXTRA_NEIGHBOUR);



        Glide.with(this).asBitmap().load(neighbourRetour.getAvatarUrl()).into(imageProfil);
        nameProfil.setText(neighbourRetour.getName());
        nameProfil2.setText(neighbourRetour.getName());
        address.setText(neighbourRetour.getAddress());
        phoneNumber.setText(neighbourRetour.getPhoneNumber());
        socialNetwork.setText(neighbourRetour.getSocialNetwork());
        ChangeStar();

        buttonFavorite.setOnClickListener(view -> {

            mFavoriteApiService.changeFavoriteNeighbour(neighbourRetour);
            neighbourRetour.setFavorite(!neighbourRetour.getFavorite());
            ChangeStar();
        });


        buttonBack.setOnClickListener(view -> {
            Intent i = new Intent(Profil.this, ListNeighbourActivity.class);
            startActivity(i);
        });


    }

    private void ChangeStar(){
        if(neighbourRetour.getFavorite() == true)
            buttonFavorite.setImageResource(R.drawable.ic_star_white_24dp);
        else
            buttonFavorite.setImageResource(ic_star_border_white_24dp);
    }

}
