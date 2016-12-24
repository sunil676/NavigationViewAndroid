package com.sunil.navigationviewandroid;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ItemClickChild{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    String names[] = Constant.name;
    String subNames[] = Constant.subName;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.frame)
    FrameLayout frame;

    TitleFragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        final ActionBar actionar = getSupportActionBar();
        actionar.setDisplayHomeAsUpEnabled(true);
        actionar.setHomeAsUpIndicator(R.drawable.ic_menu);

        List<TitleMenu> list = getList();
        RecyclerAdapter adapter = new RecyclerAdapter(this, list, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        setFragment();
    }

    private void setFragment() {
        fragment = new TitleFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment, "TitleFragment").commit();
    }

    private List<TitleMenu> getList() {
        List<TitleMenu> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            List<SubTitle> subTitles = new ArrayList<>();
            for (int j = 0; j < subNames.length; j++) {
                SubTitle subTitle = new SubTitle(subNames[j]);
                subTitles.add(subTitle);
            }
            TitleMenu model = new TitleMenu(names[i], subTitles, null);
            list.add(model);
        }
        return list;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onChildClick(int position) {
        String name = subNames[position];
        drawerLayout.closeDrawers();
        fragment.setTitle(name);
    }
}
