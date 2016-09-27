package com.batuta.traillogger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by user on 9/6/2016.
 */
public class LogFragment extends Fragment{

    private ImageView mMapImageView;
    private Button mLogDetailsButton;
    private Button mStartButton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_log_new_trail,container,false);
        mMapImageView = (ImageView) rootView.findViewById(R.id.fragment_log_new_trail_ivw_map);
        mLogDetailsButton = (Button) rootView.findViewById(R.id.fragment_log_new_trail_btn_log_details);
        mStartButton = (Button) rootView.findViewById(R.id.fragment_log_new_trail_btn_start);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        mLogDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogFragment.this.showDetailsFragment();
            // not sure why using .this
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    public void showDetailsFragment() {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_drawer_container, new DetailsFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack("DetailsFragment")
                .commit();

        }
}

