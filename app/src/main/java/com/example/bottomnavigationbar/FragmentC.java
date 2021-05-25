package com.example.bottomnavigationbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FragmentC extends Fragment {
    View view;

    //View inflation/instantiation
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container,false);
    }
    // Setup requiring access to View starts here
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;

        //setup here
        TextView textView = view.findViewById(R.id.b_textview);
        textView.setText("I'm A");
        Button button = view.findViewById(R.id.b_button);
        String count = "My Number is 1";
        button.setText(count);
    }

}
