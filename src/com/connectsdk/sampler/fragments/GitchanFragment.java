package com.connectsdk.sampler.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;


import com.connectsdk.sampler.R;
import com.connectsdk.sampler.util.TestResponseObject;

public class GitchanFragment extends BaseFragment {

    public Button youtubeButton;
    public Button netflixButton;
    public Button playButton;
    public Button pauseButton;
    public Button stopButton;
    public SeekBar mVolumeBar;
    public Handler mHandler;
    public TestResponseObject testResponse;

    public GitchanFragment() {
    }

    public GitchanFragment(Context context) {
        super(context);
        testResponse = new TestResponseObject();
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        setRetainInstance(true);
        View rootView = inflater.inflate(
                R.layout.fragment_gitchan, container, false);

        youtubeButton = (Button) rootView.findViewById(R.id.youtubeButton);
        netflixButton = (Button) rootView.findViewById(R.id.netflixButton);
        playButton = (Button) rootView.findViewById(R.id.playButton);
        pauseButton = (Button) rootView.findViewById(R.id.pauseButton);
        stopButton = (Button) rootView.findViewById(R.id.stopButton);
        mVolumeBar = (SeekBar) rootView.findViewById(R.id.volume_seek_bar);

        buttons = new Button[5];
        buttons[0] = youtubeButton;
        buttons[1] = netflixButton;
        buttons[2] = playButton;
        buttons[3] = pauseButton;
        buttons[4] = stopButton;

        mHandler = new Handler();

        return rootView;
    }
}
