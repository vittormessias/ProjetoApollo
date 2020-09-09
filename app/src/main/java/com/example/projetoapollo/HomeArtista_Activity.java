package com.example.projetoapollo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class HomeArtista_Activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    SmartTabLayout smartTabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_artista_layout);

        bottomNavigationView = findViewById(R.id.idBottomNavBar);

        if (savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.idframeLayout,new PerfilArtistaFragment()).commit();
        }


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //instanciando a classe Fragment
                Fragment fragment = null;
                Activity activity = null;

                switch (menuItem.getItemId()) {
                    case R.id.mExplorar:
                        fragment = new ExplorarArtistaFragment();
                        break;
                    case R.id.mInscricoes:
                        fragment = new InscricaoArtistaFragment();
                        break;
                    case R.id.mFeed:
                        fragment = new FeedArtistaFragment();
                        break;
                    case R.id.mNotificacoes:
                        fragment = new NotificacoesArtistaFragment();
                        break;
                    case R.id.mPerfil:
                        fragment = new PerfilArtistaFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.idframeLayout, fragment).commit();

                return true;
            }
        });


        //retira a elevação do appBar
        getSupportActionBar().setElevation(0);

        smartTabLayout = findViewById(R.id.viewPagerTab);
        viewPager = findViewById(R.id.viewPager);

        FragmentPagerAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Post", PostFragment.class)
                        .add("Músicas", MusicasFragment.class)
                        .add("Shows", ShowsFragment.class)
                        .create()
        );
        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);


    }
}