package com.example.book_store.pakage_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book_store.Fragment.fragment_layout;
import com.example.book_store.Fragment.fragment_search;
import com.example.book_store.Fragment.profie_pragment;
import com.example.book_store.R;
import com.example.book_store.adabters.adabter_books;
import com.example.book_store.adabters.adabter_vertical_bl;
import com.example.book_store.classes.cls_bookinfo;
import com.example.book_store.databinding.ActivityLayoutActivity2Binding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

public class layout_activity2 extends AppCompatActivity {
    ActivityLayoutActivity2Binding binding;
    Fragment fragment = null;




    ArrayList<cls_bookinfo> ALB;
    FirebaseDatabase database;
    FirebaseStorage storage;
    FirebaseAuth auth;
    AutoCompleteTextView txt1;
    DatabaseReference database1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLayoutActivity2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        ALB = new ArrayList<>();

//        getSupportActionBar().hide();

        fragment = new fragment_layout();
        loadfragment(fragment);


//











        binding.nbSettings.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.btn_orders:
                        fragment = new fragment_search();
                        loadfragment(fragment);
                        break;

                    case R.id.btn_Profile:
                        fragment = new profie_pragment();
                        loadfragment(fragment);
                        break;

                    case R.id.btn_layout:
                        fragment = new fragment_layout();
                        loadfragment(fragment);
                        break;

                    case R.id.btn_seting:
                        Intent intent = new Intent(layout_activity2.this,setting_activity.class);
                        startActivity(intent);
                        break;

                }
            }
        });



    }
    public void loadfragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout,fragment).commit();
    }
}