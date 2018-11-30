package com.example.a3embed.learning;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncActivity extends AppCompatActivity {

    private Button asyncTask, dwnImage;
    final String URL1 = "http://www.google.com/logos/2013/estonia_independence_day_2013-1057005.3-hp.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        asyncTask = findViewById(R.id.btn_run);
        dwnImage = findViewById(R.id.dwnImage);

        dwnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if ((ContextCompat.
                            checkSelfPermission(AsyncActivity.this,
                                    android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) &&
                            (ContextCompat.
                                    checkSelfPermission(AsyncActivity.this,
                                            android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)) {
                        ActivityCompat.requestPermissions(AsyncActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                        ActivityCompat.requestPermissions(AsyncActivity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                    } else {
                        runThread();
                    }
                } else {
                    runThread();
                }
            }
        });

        asyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadImagesTask runner = new DownloadImagesTask();
                runner.execute(Constants.urlImage);
            }
        });
    }

    public void runThread() {
        new Thread(new Runnable(){
            @Override
            public void run(){
                Bitmap bmp = null;
                try{
                    URL ulrn = new URL(URL1);
                    HttpURLConnection con = (HttpURLConnection)ulrn.openConnection();
                    InputStream is = con.getInputStream();
                    bmp = BitmapFactory.decodeStream(is);
                    if (null != bmp) {
                        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
                        OutputStream fOutputStream = null;
                        File dir = new File(path + "/Captures/");
                        if(!dir.exists()) {
                            dir.mkdirs();
                        }
                        File file = new File(path + "/Captures/", "screen.jpg");
                        try {
                            fOutputStream = new FileOutputStream(file);
                            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fOutputStream);
                            fOutputStream.flush();
                            fOutputStream.close();
                            MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(), file.getName());
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(AsyncActivity.this, "Save Successful", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(AsyncActivity.this, "File Not Found Successful", Toast.LENGTH_SHORT).show();
                                }
                            });
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(AsyncActivity.this, "Save Unsuccessful", Toast.LENGTH_SHORT).show();
                                }
                            });
                            return;
                        }
                    } else {
                        Toast.makeText(AsyncActivity.this, "Bitmap Null", Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception e){}
            }
        }).start();
    }

    public class DownloadImagesTask extends AsyncTask<String, String, Bitmap> {

        String url1 = null;

        @Override
        protected Bitmap doInBackground(String... url) {
            this.url1 = url[0];
            return download_Image(url1);
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            Intent intent = new Intent(AsyncActivity.this, DownloadImageActivity.class);
            intent.putExtra("image", result);
            startActivity(intent);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        private Bitmap download_Image(String url) {
            Bitmap bmp =null;
            try{
                URL ulrn = new URL(url);
                HttpURLConnection con = (HttpURLConnection)ulrn.openConnection();
                InputStream is = con.getInputStream();
                bmp = BitmapFactory.decodeStream(is);
                if (null != bmp)
                    return bmp;
            }catch(Exception e){}
            return bmp;
        }
    }
}