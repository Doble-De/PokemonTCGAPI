package com.elpuig.pokemontgcapi.view;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.elpuig.pokemontgcapi.R;
import com.elpuig.pokemontgcapi.ViewModel;

public class TabbedActivity extends AppCompatActivity {

    private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewPager;
    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);
        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

        viewModel = ViewModelProviders.of(TabbedActivity.this).get(ViewModel.class);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm){super(fm);}

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new BasicosFragment();
                case 1:
                    return new Evo1Fragment();
                case 2:
                    return new Evo2Fragment();
                default:
                    return new BasicosFragment();
            }
        }

        @Override
        public int getCount(){return 3;}

    }

}

