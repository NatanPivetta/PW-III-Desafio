package com.example.instatrip;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView arrowImageView;
    private ImageView imageView; // ImageView that will change
    private ScrollView scrollView;

    private final int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3}; // Add your image resources here
    private int currentImageIndex = 0; // To track the current image

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrowImageView = findViewById(R.id.arrowImageView);
        imageView = findViewById(R.id.imageView);
        scrollView = findViewById(R.id.scrollView);

        // Set a scroll listener
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY < oldScrollY) { // User scrolled up
                    changeImage();
                }
            }
        });
    }

    private void changeImage() {
        currentImageIndex = (currentImageIndex + 1) % images.length; // Cycle through images
        imageView.setImageResource(images[currentImageIndex]); // Change image
    }
}
