package com.example.bottomnavigationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActionBar toolbar;
    FragmentA fragmentA, fragmentApart2;
    FragmentB fragmentB;
    FragmentC fragmentC;
    int count =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        BottomNavigationView navigationView = findViewById(R.id.navigation_bar);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        toolbar.setTitle("My Title is Lit");
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        fragmentC = new FragmentC();
        fragmentApart2 = new FragmentA();
        loadFragment(fragmentC);
        loadFragment(fragmentB);
    }
    //standard fragment replacement
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_a:
                    toolbar.setTitle("A");
                    loadFragment(fragmentA);
                    return true;
                case R.id.navigation_b:
                    toolbar.setTitle("BmoreFun");
                    loadFragment(fragmentB);
                    return true;
                case R.id.navigation_c:
                    toolbar.setTitle("C");
                    loadFragment(fragmentC);
                    return true;
                case R.id.navigation_ap2:
                    toolbar.setTitle("Apart2");
                    loadFragment(fragmentApart2);
                    return true;
            }
            return false;
        }
    };
    public void fragment_button_onclick(View view) {
        //problem:  First click displays original fragmentB, subsequent clicks displays
        //  updated fragmentB
        //  If menu to B after 1 button click on any other menu, will display original fragmentB
        View v = fragmentB.view;
        View vv = fragmentC.view;
        //setup here
        TextView textView = v.findViewById(R.id.b_textview);
        textView.setText("I'm being messed with"+((TextView)(vv.findViewById(R.id.b_textview))).getText());
        Button button = v.findViewById(R.id.b_button);
        String count = "My Number is "+ ++this.count;
        button.setText(count);
        button.invalidate();
        System.out.println("test "+this.count);
        loadFragment(fragmentB);
    }
}