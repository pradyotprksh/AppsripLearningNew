package com.example.a3embed.learning;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
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

    private Button asyncTask;
    private ImageView asyncTaskImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        asyncTask = findViewById(R.id.btn_run);
        asyncTaskImage = findViewById(R.id.asyncTaskImage);

        final String URL1 = "http://www.google.com/logos/2013/estonia_independence_day_2013-1057005.3-hp.jpg";

        asyncTaskImage.setTag(URL1);

        asyncTask.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                DownloadImagesTask runner = new DownloadImagesTask();
                runner.execute(URL1);

                new Thread(new Runnable(){
                    @Override
                    public void run(){
                        Bitmap bmp =null;
                        try{
                            URL ulrn = new URL(Constants.urlImage);
                            HttpURLConnection con = (HttpURLConnection)ulrn.openConnection();
                            InputStream is = con.getInputStream();
                            bmp = BitmapFactory.decodeStream(is);
                            if (null != bmp) {
                                asyncTaskImage.setImageBitmap(bmp);
                            }
                        }catch(Exception e){}
                    }
                }).start();
            }
        });
    }

    public class DownloadImagesTask extends AsyncTask<String, Void, Bitmap> {

        String url1 = null;

        @Override
        protected Bitmap doInBackground(String... url) {
            this.url1 = url[0];
            return download_Image(url1);
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
            OutputStream fOutputStream = null;
            File dir = new File(path + "/Captures/");
            if(!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(path + "/Captures/", "screen.jpg");
            try {
                fOutputStream = new FileOutputStream(file);
                result.compress(Bitmap.CompressFormat.JPEG, 100, fOutputStream);
                fOutputStream.flush();
                fOutputStream.close();
                MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(), file.getName());
                Toast.makeText(AsyncActivity.this, "Save Successful", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(AsyncActivity.this, "Save Failed", Toast.LENGTH_SHORT).show();
                return;
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(AsyncActivity.this, "Save Failed", Toast.LENGTH_SHORT).show();
                return;
            }
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