package com.desno365.minecraftbuttontest;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends ActionBarActivity {

    private Button tinyB;
    private Button bigB;

    private NinePatchDrawable mcNormalNineDrawable;
    private NinePatchDrawable mcPressedNineDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("MinecraftButtonTest", "APP LAUNCHED!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tinyB = (Button) findViewById(R.id.tiny);
        bigB = (Button)  findViewById(R.id.big);

        Bitmap mcButtonNormalBitmap = getMinecraftButtonBitmap(getApplicationContext());
        Bitmap mcButtonPressedBitmap = getMinecraftButtonPressedBitmap(getApplicationContext());

        NinePatch mcNormalNinePatch = new NinePatch(mcButtonNormalBitmap, mcButtonNormalBitmap.getNinePatchChunk(), null);
        NinePatch mcPressedNinePatch = new NinePatch(mcButtonPressedBitmap, mcButtonPressedBitmap.getNinePatchChunk(), null);

        // we used a deprecated method that doesn't deals with density
        //noinspection deprecation
        mcNormalNineDrawable = new NinePatchDrawable(mcNormalNinePatch);
        mcNormalNineDrawable.setFilterBitmap(false);
        //noinspection deprecation
        mcPressedNineDrawable = new NinePatchDrawable(mcPressedNinePatch);
        mcPressedNineDrawable.setFilterBitmap(false);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/minecraft.ttf");
        
        

        // FIRST BUTTON
        tinyB.setTextSize(15);
        tinyB.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getActionMasked();
                if (action == android.view.MotionEvent.ACTION_CANCEL || action == android.view.MotionEvent.ACTION_UP) {
                    setButtonBackground(tinyB, mcNormalNineDrawable);
                    tinyB.setTextColor(android.graphics.Color.parseColor("#FFDDDDDD"));
                    // reset pressed padding
                    tinyB.setPadding(convertDpToPixel(8, getApplicationContext()), convertDpToPixel(8, getApplicationContext()), convertDpToPixel(8, getApplicationContext()), convertDpToPixel(8, getApplicationContext()));
                } else {
                    setButtonBackground(tinyB, mcPressedNineDrawable);
                    tinyB.setTextColor(android.graphics.Color.parseColor("#FFFBFF97"));
                    // make the effect of a pressed button
                    tinyB.setPadding(convertDpToPixel(8, getApplicationContext()), convertDpToPixel(8, getApplicationContext()) + convertDpToPixel(2, getApplicationContext()), convertDpToPixel(8, getApplicationContext()), convertDpToPixel(8, getApplicationContext()) - convertDpToPixel(2, getApplicationContext()));
                }

                return false;
            }
        });
        if (Build.VERSION.SDK_INT >= 14) {
            tinyB.setAllCaps(false);
        }
        setButtonBackground(tinyB, mcNormalNineDrawable);
        tinyB.setTextColor(android.graphics.Color.parseColor("#FFDDDDDD"));
        tinyB.setPadding(convertDpToPixel(8, getApplicationContext()), convertDpToPixel(8, getApplicationContext()), convertDpToPixel(8, getApplicationContext()), convertDpToPixel(8, getApplicationContext()));
        tinyB.setLineSpacing(convertDpToPixel(4, getApplicationContext()), 1);
        // apply custom font with shadow
        tinyB.setTypeface(font);
        tinyB.setPaintFlags(tinyB.getPaintFlags() | android.graphics.Paint.SUBPIXEL_TEXT_FLAG);
        if (Build.VERSION.SDK_INT >= 19)
            tinyB.setShadowLayer(1, Math.round((tinyB.getLineHeight() - convertDpToPixel(4, getApplicationContext())) / 8), Math.round((tinyB.getLineHeight() - convertDpToPixel(4, getApplicationContext())) / 8), android.graphics.Color.parseColor("#FF292929"));
        else
            tinyB.setShadowLayer(0.0001F, Math.round((tinyB.getLineHeight() - convertDpToPixel(4, getApplicationContext())) / 8), Math.round((tinyB.getLineHeight() - convertDpToPixel(4, getApplicationContext())) / 8), android.graphics.Color.parseColor("#FF292929"));



        // SECOND BUTTON
        bigB.setTextSize(15);
        bigB.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getActionMasked();
                if (action == android.view.MotionEvent.ACTION_CANCEL || action == android.view.MotionEvent.ACTION_UP) {
                    setButtonBackground(bigB, mcNormalNineDrawable);
                    bigB.setTextColor(android.graphics.Color.parseColor("#FFDDDDDD"));
                    // reset pressed padding
                    bigB.setPadding(convertDpToPixel(8, getApplicationContext()), convertDpToPixel(8, getApplicationContext()), convertDpToPixel(8, getApplicationContext()), convertDpToPixel(8, getApplicationContext()));
                } else {
                    setButtonBackground(bigB, mcPressedNineDrawable);
                    bigB.setTextColor(android.graphics.Color.parseColor("#FFFBFF97"));
                    // make the effect of a pressed button
                    bigB.setPadding(convertDpToPixel(8, getApplicationContext()), convertDpToPixel(8, getApplicationContext()) + convertDpToPixel(2, getApplicationContext()), convertDpToPixel(8, getApplicationContext()), convertDpToPixel(8, getApplicationContext()) - convertDpToPixel(2, getApplicationContext()));

                }

                return false;
            }
        });
        if (Build.VERSION.SDK_INT >= 14) {
            bigB.setAllCaps(false);
        }
        setButtonBackground(bigB, mcNormalNineDrawable);
        bigB.setTextColor(android.graphics.Color.parseColor("#FFDDDDDD"));
        bigB.setPadding(convertDpToPixel(8, getApplicationContext()), convertDpToPixel(8, getApplicationContext()), convertDpToPixel(8, getApplicationContext()), convertDpToPixel(8, getApplicationContext()));
        bigB.setLineSpacing(convertDpToPixel(4, getApplicationContext()), 1);
        // apply custom font with shadow
        bigB.setTypeface(font);
        bigB.setPaintFlags(bigB.getPaintFlags() | android.graphics.Paint.SUBPIXEL_TEXT_FLAG);
        if (Build.VERSION.SDK_INT >= 19)
            bigB.setShadowLayer(1, Math.round((bigB.getLineHeight() - convertDpToPixel(4, getApplicationContext())) / 8), Math.round((bigB.getLineHeight() - convertDpToPixel(4, getApplicationContext())) / 8), android.graphics.Color.parseColor("#FF292929"));
        else
            bigB.setShadowLayer(0.0001F, Math.round((bigB.getLineHeight() - convertDpToPixel(4, getApplicationContext())) / 8), Math.round((bigB.getLineHeight() - convertDpToPixel(4, getApplicationContext())) / 8), android.graphics.Color.parseColor("#FF292929"));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static int convertDpToPixel(int dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int px;
        px = (int) (dp * metrics.density);
        return px;
    }

    public static Bitmap getBitmapFromAsset(Context context, String filePath) {
        AssetManager assetManager = context.getAssets();

        InputStream istr;
        Bitmap bitmap = null;
        try {
            istr = assetManager.open(filePath);
            bitmap = BitmapFactory.decodeStream(istr);
        } catch (IOException e) {
            Log.e("Minecraft Button Tes", "Bitmap Not Found", e);
        }

        return bitmap;
    }

    private Bitmap getMinecraftButtonPressedBitmap(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float density = metrics.density;

        if(density < 1) {
            return getBitmapFromAsset(context, "bitmaps/minecraft_button_state_pressed_ldpi.9.png");
        }
        if(density >= 1 && density < 1.5) {
            return getBitmapFromAsset(context, "bitmaps/minecraft_button_state_pressed_mdpi.9.png");
        }
        if(density >= 1.5 && density < 2) {
            return getBitmapFromAsset(context, "bitmaps/minecraft_button_state_pressed_hdpi.9.png");
        }
        if(density >= 2 && density < 2.5) {
            return getBitmapFromAsset(context, "bitmaps/minecraft_button_state_pressed_xhdpi.9.png");
        }
        if(density >= 2.5) {
            return getBitmapFromAsset(context, "bitmaps/minecraft_button_state_pressed_xxhdpi.9.png");
        }

        return getBitmapFromAsset(context, "bitmaps/minecraft_button_state_pressed_xhdpi.9.png");
    }

    private Bitmap getMinecraftButtonBitmap(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float density = metrics.density;

        if(density < 1) {
            Toast.makeText(context, "Density: " + density + ", ldpi", Toast.LENGTH_SHORT).show();
            return getBitmapFromAsset(context, "bitmaps/minecraft_button_state_normal_ldpi.9.png");
        }
        if(density >= 1 && density < 1.5) {
            Toast.makeText(context, "Density: " + density + ", mdpi", Toast.LENGTH_SHORT).show();
            return getBitmapFromAsset(context, "bitmaps/minecraft_button_state_normal_mdpi.9.png");
        }
        if(density >= 1.5 && density < 2) {
            Toast.makeText(context, "Density: " + density + ", hdpi", Toast.LENGTH_SHORT).show();
            return getBitmapFromAsset(context, "bitmaps/minecraft_button_state_normal_hdpi.9.png");
        }
        if(density >= 2 && density < 2.5) {
            Toast.makeText(context, "Density: " + density + ", xhdpi", Toast.LENGTH_SHORT).show();
            return getBitmapFromAsset(context, "bitmaps/minecraft_button_state_normal_xhdpi.9.png");
        }
        if(density >= 2.5) {
            Toast.makeText(context, "Density: " + density + ", xxhdpi", Toast.LENGTH_SHORT).show();
            return getBitmapFromAsset(context, "bitmaps/minecraft_button_state_normal_xxhdpi.9.png");
        }

        Toast.makeText(context, "Error: " + density + ", xhdpi", Toast.LENGTH_SHORT).show();
        return getBitmapFromAsset(context, "bitmaps/minecraft_button_state_normal_xhdpi.9.png");
    }

    private void setButtonBackground(Button button, Drawable background) {
        if (Build.VERSION.SDK_INT >= 16) {
            button.setBackground(background);
        } else {
            button.setBackgroundDrawable(background);
        }
    }
}
