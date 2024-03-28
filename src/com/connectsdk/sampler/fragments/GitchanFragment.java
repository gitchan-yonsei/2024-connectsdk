package com.connectsdk.sampler.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;


import com.connectsdk.sampler.R;
import com.connectsdk.sampler.util.TestResponseObject;
import com.connectsdk.sampler.widget.AppAdapter;
import com.connectsdk.service.capability.VolumeControl;

public class GitchanFragment extends BaseFragment {

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

        playButton = (Button) rootView.findViewById(R.id.playButton);
        pauseButton = (Button) rootView.findViewById(R.id.pauseButton);
        stopButton = (Button) rootView.findViewById(R.id.stopButton);
        mVolumeBar = (SeekBar) rootView.findViewById(R.id.volume_seek_bar);

        buttons = new Button[3];
        buttons[0] = playButton;
        buttons[1] = pauseButton;
        buttons[2] = stopButton;

        mHandler = new Handler();

        return rootView;
    }

    @Override
    public void enableButtons() {
        playButton.setOnClickListener(playClickListener);
        pauseButton.setOnClickListener(pauseClickListener);
        stopButton.setOnClickListener(stopClickListener);
        mVolumeBar.setEnabled(getTv().hasCapability(VolumeControl.Volume_Set));
        mVolumeBar.setOnSeekBarChangeListener(volumeSeekListener);
        super.enableButtons();
    }

    private View.OnClickListener playClickListener = view -> getMediaControl().play(null);

    private View.OnClickListener pauseClickListener = view -> getMediaControl().pause(null);

    private View.OnClickListener stopClickListener = view -> getMediaControl().stop(null);

    private SeekBar.OnSeekBarChangeListener volumeSeekListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                float fVol = (float) (progress / 100.0);
                getVolumeControl().setVolume(fVol, null);
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };

    @Override
    public void disableButtons() {
        mVolumeBar.setEnabled(false);
        mVolumeBar.setOnSeekBarChangeListener(null);

        super.disableButtons();
    }
}
