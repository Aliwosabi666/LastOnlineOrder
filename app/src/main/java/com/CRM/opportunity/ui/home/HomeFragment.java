package com.CRM.opportunity.ui.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.CRM.opportunity.client.AddClient;
import com.CRM.opportunity.oppertunites.OpportunitiesStatus;
import com.CRM.opportunity.userAcounts.UserActivity;
import com.CRM.opportunity.AddOppertunite;
import com.CRM.opportunity.ClientsMain;
import com.CRM.opportunity.R;

public class HomeFragment extends Fragment  {
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = view.findViewById(R.id.text_home);

        LinearLayout id_chek =view.findViewById(R.id.id_chek);

        SharedPreferences test_name = getContext().getSharedPreferences("admin", 0);
        int checkId =test_name.getInt("adminId",0);
        if (checkId==1){

            id_chek.setVisibility(View.VISIBLE);
        }else
            id_chek.setVisibility(View.VISIBLE);


        LinearLayout opprentity = view.findViewById(R.id.opprentity);
        LinearLayout all_clients = view.findViewById(R.id.all_clients);
        LinearLayout user_profile = view.findViewById(R.id.user_profile);
        LinearLayout add_clients = view.findViewById(R.id.add_clients);
        LinearLayout add_opp = view.findViewById(R.id.add_opp);

        user_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), UserActivity.class));
            }
        });
        all_clients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ClientsMain.class));
            }
        });

        add_clients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), AddClient.class));
            }
        });

        add_opp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), AddOppertunite.class));
            }
        });
        opprentity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), OpportunitiesStatus.class));
            }
        });


        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return view;
    }
}