package com.example.appsell;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;

public class MainActivity extends AppCompatActivity {
    private AHBottomNavigationViewPager ahBottomNavigationViewPager;
    private AHBottomNavigation ahBottomNavigation;
    private ViewPagerAdapter adapter;

    private View viewEndAnimation;
    private ImageView vimgAnimation;

    private int mCountProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        ahBottomNavigationViewPager.setAdapter(adapter);
        ahBottomNavigationViewPager.setPagingEnabled(true);

    // Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.drawable.ic_product, R.color.color_tab_1);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.drawable.ic_cart, R.color.color_tab_2);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.ic_notice, R.color.color_tab_3);

    // Add items
        ahBottomNavigation.addItem(item1);
        ahBottomNavigation.addItem(item2);
        ahBottomNavigation.addItem(item3);

        ahBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                ahBottomNavigationViewPager.setCurrentItem(position);
                return true;
            }
        });

        ahBottomNavigationViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                ahBottomNavigation.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void mapping() {
        ahBottomNavigationViewPager = findViewById(R.id.AHBNavigationViewPager);
        ahBottomNavigation = findViewById(R.id.AHBottomNavigation);
        viewEndAnimation =  findViewById(R.id.view_end_animation);
        vimgAnimation = findViewById(R.id.view_animation);

    }

    public View getViewEndAnimation() {
        return viewEndAnimation;
    }

    public void setViewEndAnimation(View viewEndAnimation) {
        this.viewEndAnimation = viewEndAnimation;
    }

    public ImageView getVimgAnimation() {
        return vimgAnimation;
    }

    public void setVimgAnimation(ImageView vimgAnimation) {
        this.vimgAnimation = vimgAnimation;
    }

    public void setCountProductInCart(int count){
        mCountProduct = count;
        AHNotification notification = new AHNotification.Builder()
                .setText(String.valueOf(count))
                .setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.color_tab))
                .setTextColor(ContextCompat.getColor(MainActivity.this, R.color.write))
                .build();
        ahBottomNavigation.setNotification(notification, 1);
    }

    public int getmCountProduct() {
        return mCountProduct;
    }

    public void setmCountProduct(int mCountProduct) {
        this.mCountProduct = mCountProduct;
    }
}