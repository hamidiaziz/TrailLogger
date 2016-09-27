package com.batuta.traillogger;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by user on 9/8/2016.
 */
public class CameraFragment extends Fragment {
    private ImageView mCameraImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_camera, container, false);
        mCameraImageView = (ImageView) rootView.findViewById(R.id.fragment_camera_iv_camera);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        mCameraImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), getActivity().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

}

