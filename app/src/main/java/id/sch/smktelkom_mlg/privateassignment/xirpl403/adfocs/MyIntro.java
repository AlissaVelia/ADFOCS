package id.sch.smktelkom_mlg.privateassignment.xirpl403.adfocs;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;


public class MyIntro extends AppIntro {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.newInstance("1",
                "Top Film In the World",
                R.drawable.s1,
                Color.parseColor("#2c5c69")));

        addSlide(AppIntroFragment.newInstance("2",
                "Recomended",
                R.drawable.s1,
                Color.parseColor("#183b45")));


        addSlide(AppIntroFragment.newInstance("4",
                "Mudah dan fleksibel, dapat dilihat di HP dan bisa dibawa kemana saja",
                R.drawable.s1,
                Color.parseColor("#2c5c69")));

        showStatusBar(false);
        setBarColor(Color.parseColor("#2c5c69"));
        setSeparatorColor(Color.parseColor("#2c5c69"));
    }

    @Override
    public void onDonePressed(){
        startActivity(new Intent(MyIntro.this, MainActivity.class));
        finish();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment){
        startActivity(new Intent(MyIntro.this, MainActivity.class));
        Toast.makeText(MyIntro.this, "On Skip Clicked", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onSlideChanged(){
        Toast.makeText(MyIntro.this, "On Slide Clicked", Toast.LENGTH_SHORT).show();

    }

}
