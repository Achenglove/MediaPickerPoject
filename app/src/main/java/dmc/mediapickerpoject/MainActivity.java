package dmc.mediapickerpoject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dmcbig.mediapicker.PickerActivity;
import com.dmcbig.mediapicker.PickerConfig;
import com.dmcbig.mediapicker.entity.Media;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Media> select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(com.dmcbig.mediapicker.R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go();
            }
        });
    }

    void go(){
        Intent intent =new Intent(MainActivity.this, PickerActivity.class);
        intent.putExtra(PickerConfig.SELECT_MODE,PickerConfig.PICKER_IMAGE_VIDEO);
        long maxSize=188743680l;//long long long
        intent.putExtra(PickerConfig.MAX_SELECT_SIZE,maxSize);
        intent.putExtra(PickerConfig.MAX_SELECT_COUNT,15);
        intent.putExtra(PickerConfig.DEFAULT_SELECTED_LIST,select);
        MainActivity.this.startActivityForResult(intent,200);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==200&&resultCode==PickerConfig.RESULT_CODE){
            select=data.getParcelableArrayListExtra(PickerConfig.EXTRA_RESULT);
        }
    }
}