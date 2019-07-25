package sg.edu.rp.c346.p11_mydatabook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class AboutActivity extends AppCompatActivity {

    ImageView iv;
    ActionBar ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        iv = findViewById(R.id.iv);
        int permissionCheck_Internet = ContextCompat.checkSelfPermission(AboutActivity.this, Manifest.permission.INTERNET);

        if (permissionCheck_Internet == PermissionChecker.PERMISSION_GRANTED){
            String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg";
            Picasso.with(this).load(imageUrl).placeholder(R.drawable.ajax_loader).error(R.drawable.error).into(iv);
        }else{
            ActivityCompat.requestPermissions(AboutActivity.this, new String[]{Manifest.permission.INTERNET}, 0);

        }

    }
}
