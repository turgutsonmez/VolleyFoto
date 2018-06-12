package turgutsonmez.com.volleyfoto;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class ResimAl extends AppCompatActivity {

  String url = "http://www.oyuncax.com/ProductImages/138387/middle/art-puzzle-siyah-beyaz--500-parca-12.jpg";
  ImageView imageView;
  Button veriAl;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    imageView = findViewById(R.id.imageview);
    veriAl = findViewById(R.id.buton);

    veriAl.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        resmiCek();
      }
    });
  }

  private void resmiCek() {
    ImageRequest ımageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
      @Override
      public void onResponse(Bitmap response) {
        imageView.setImageBitmap(response);
      }
    }, 0, 0, imageView.getScaleType().CENTER, null, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        Toast.makeText(ResimAl.this,"İşlem gerçekleştirilemedi",Toast.LENGTH_SHORT).show();
      }
    });

    MySingleton.getInstance(ResimAl.this).addToRequest(ımageRequest);

  }
}
