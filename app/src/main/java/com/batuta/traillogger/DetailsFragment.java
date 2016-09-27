package com.batuta.traillogger;

import android.hardware.camera2.CameraCaptureSession;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by user on 9/7/2016.
 */
public class DetailsFragment extends Fragment {

    private FrameLayout mCameraLauncher;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        mCameraLauncher = (FrameLayout) rootView.findViewById(R.id.fragment_details_fl_photo);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        mCameraLauncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCameraFragment();
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    public void showCameraFragment() {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_log_new_trail_container , new CameraFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack("DetailsFragment")
                .commit();

    }
}
