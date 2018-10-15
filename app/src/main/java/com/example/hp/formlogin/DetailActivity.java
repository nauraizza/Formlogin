package com.example.hp.formlogin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    private TextView textView2;
    private TextView textViewdesign;
    private TextView textViewpcd;
    // private Button button2;
    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textView2 = (TextView) findViewById(R.id.textView2);
        textViewdesign = (TextView) findViewById(R.id.textViewdesign);
        textViewpcd = (TextView) findViewById(R.id.textViewpcd);
// button2 = (Button) findViewById(R.id.button2);
        Intent mainIntent = getIntent();
        String username = mainIntent.getStringExtra(Intent.EXTRA_TEXT);
        textView2.setText("Welcome, " + username);
        textViewdesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage("http://bse.kemdikbud.go.id/index.php/buku/filters?kategori=buku_judul&cari=desain");
            }
        });
        textViewpcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openWebPage("http://bse.kemdikbud.go.id/index.php/buku/filters?kategori=buku_judul&cari=pengolahan+citra+");
            }
        });
        Toast.makeText(this, "You are logged in",
                Toast.LENGTH_LONG).show();
/**
 * *Tampilkan aktifitas di sini
 **/
/*button2.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
Intent logoutintent = new Intent(DetailActivity.this,
MainActivity.class);
startActivity(logoutintent);
}
});*/
    }
    private void openWebPage(String url) {
// Toast.makeText(MainActivity.this, "opening Dev Doc",
       // Toast.LENGTH_LONG).show();
        Uri webpage = Uri.parse(url);
        Intent broserintent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(broserintent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_siswa,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.share:
// Toast.makeText(DetailActivity.this, "Share This",
               // Toast.LENGTH_LONG).show();
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "My First App");
                shareIntent.setType("text/plain");
                startActivity(shareIntent);

                break;
            case R.id.signout:
// Toast.makeText(DetailActivity.this, "Sign Out",
               // Toast.LENGTH_LONG).show();
                Intent signoutIntent = new Intent(DetailActivity.this,
                        MainActivity.class);
                startActivity(signoutIntent);

                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}