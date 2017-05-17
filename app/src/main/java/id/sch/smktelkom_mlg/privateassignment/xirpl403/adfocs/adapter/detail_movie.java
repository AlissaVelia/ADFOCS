package id.sch.smktelkom_mlg.privateassignment.xirpl403.adfocs.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import id.sch.smktelkom_mlg.privateassignment.xirpl403.adfocs.R;

public class detail_movie extends AppCompatActivity {
    public String url = "http://image.tmdb.org/t/p/w500";
    public String title, desc, pic, gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Intent intent = getIntent();
        title = intent.getStringExtra("movie_title");
        pic = intent.getStringExtra("poster_path");
        desc = intent.getStringExtra("overview");
        setTitle(title);
        gambar = url + pic;
        ImageView detail = (ImageView) findViewById(R.id.imageViewPoster);
        TextView deskripsi = (TextView) findViewById(R.id.textViewName);
        Glide.with(this).load(gambar)
                .crossFade()
                .centerCrop()
                .placeholder(R.drawable.ic_arrow_downward_black_24dp)
                .error(R.drawable.ic_arrow_downward_black_24dp)
                .into(detail);
        deskripsi.setText(desc);
    }
}
