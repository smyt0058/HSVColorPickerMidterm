package com.algonquincollege.smyt0058.hsvcolorpicker;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

import model.HSVModel;

/**
 * HSV Color Picker
 *
 * GUI color picker using HSV
 *
 * Main Controller
 *
 * @author Jason Smyth (smyt0058@algonquinlive.com)
 * @version 1.0
 */

public class MainActivity extends Activity implements Observer, SeekBar.OnSeekBarChangeListener {

    private AboutDialogFragment mAboutDialog;
    private HSVModel mHSVModel;
    private TextView mColorSwatch;

    private SeekBar mHueSB;
    private SeekBar mSatSB;
    private SeekBar mValSB;

    private TextView mHueTV;
    private TextView mSatTV;
    private TextView mValTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAboutDialog = new AboutDialogFragment();


        mHSVModel = new HSVModel();
        mHSVModel.addObserver(this);


        mColorSwatch = findViewById(R.id.colorSwatch);
        mHueSB = findViewById(R.id.hueSB);
        mSatSB = findViewById(R.id.saturationSB);
        mValSB = findViewById(R.id.valueSB);
        mHueTV = findViewById(R.id.hue);
        mSatTV = findViewById(R.id.saturation);
        mValTV = findViewById(R.id.value);


        mHueSB.setOnSeekBarChangeListener(this);
        mSatSB.setOnSeekBarChangeListener(this);
        mValSB.setOnSeekBarChangeListener(this);

        mColorSwatch.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), ValuesMessage(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        this.updateView();
    }

    private String ValuesMessage() {
        return getResources().getString(
                R.string.hsv_values, mHSVModel.getHue(),
                mHSVModel.getSaturation(),
                mHSVModel.getValue());
    }


    private void updateColorSwatch() {
        float[] hsvColor = {mHSVModel.getHue(), mHSVModel.getSaturation() / 100.f, mHSVModel.getValue() / 100.f};
        mColorSwatch.setBackgroundColor(Color.HSVToColor(hsvColor));
    }

    private void updateHueSB() {
        mHueSB.setProgress(mHSVModel.getHue());
    }

    private void updateSaturationSB() {
        mSatSB.setProgress(mHSVModel.getSaturation());
    }


    private void updateValueSB() {
        mValSB.setProgress(mHSVModel.getValue());
    }

    public void updateView() {
        this.updateColorSwatch();
        this.updateHueSB();
        this.updateSaturationSB();
        this.updateValueSB();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            mAboutDialog.show(getFragmentManager(), "About");
            return true;
        }

        return false;
    }

    @Override
    public void update(Observable observable, Object o) {
        this.updateView();
    }

    /**
     * updates values on SeekBar
     *
     * @param seekBar
     * @param i
     * @param b
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {


        if (!b) {
            return;
        }

        switch (seekBar.getId()) {
            case R.id.hueSB:
                mHSVModel.setHue(mHueSB.getProgress());
                mHueTV.setText(getResources().getString(R.string.hue_progress, i).toUpperCase());
                break;

            case R.id.saturationSB:
                mHSVModel.setSaturation(mSatSB.getProgress());
                mSatTV.setText(getResources().getString(R.string.saturation_progress, i).toUpperCase());
                break;

            case R.id.valueSB:
                mHSVModel.setValue(mValSB.getProgress());
                mValTV.setText(getResources().getString(R.string.value_progress, i).toUpperCase());
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        switch (seekBar.getId()) {
            case R.id.hueSB:
                mHueTV.setText(getResources().getString(R.string.hue));
                break;
            case R.id.saturationSB:
                mSatTV.setText(getResources().getString(R.string.saturation));
                break;
            case R.id.valueSB:
                mValTV.setText(getResources().getString(R.string.value));
                break;
        }
    }

    /**
     * sets color swatch background as per button click
     *
     * @param view
     */
    public void onColorButtonClick(View view) {
        switch (view.getId()) {
            case R.id.blackBtn:
                mHSVModel.setAsBlack();
                break;
            case R.id.redBtn:
                mHSVModel.setAsRed();
                break;
            case R.id.limeBtn:
                mHSVModel.setAsLime();
                break;
            case R.id.blueBtn:
                mHSVModel.setAsBlue();
                break;
            case R.id.yellowBtn:
                mHSVModel.setAsYellow();
                break;
            case R.id.cyanBtn:
                mHSVModel.setAsCyan();
                break;
            case R.id.magentaBtn:
                mHSVModel.setAsMagenta();
                break;
            case R.id.silverBtn:
                mHSVModel.setAsSilver();
                break;
            case R.id.grayBtn:
                mHSVModel.setAsGray();
                break;
            case R.id.maroonBtn:
                mHSVModel.setAsMaroon();
                break;
            case R.id.oliveBtn:
                mHSVModel.setAsOlive();
                break;
            case R.id.greenBtn:
                mHSVModel.setAsGreen();
                break;
            case R.id.purpleBtn:
                mHSVModel.setAsPurple();
                break;
            case R.id.tealBtn:
                mHSVModel.setAsTeal();
                break;
            case R.id.navyBtn:
                mHSVModel.setAsNavy();
                break;
        }

        Toast.makeText(getApplicationContext(), ValuesMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        int[] hsvColor = {mHSVModel.getHue(), mHSVModel.getSaturation(), mHSVModel.getValue()};
        savedInstanceState.putIntArray("HSV_COLOR", hsvColor);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.containsKey("HSV_COLOR")) {
            int[] hsvColor = savedInstanceState.getIntArray("HSV_COLOR");

            if (hsvColor != null && hsvColor.length == 3) {
                mHSVModel.setHSV(hsvColor[0], hsvColor[1], hsvColor[2]);
            }
        }
    }
}
