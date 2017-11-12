package cn.edu.gdmec.android.mobileguard;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import cn.edu.gdmec.android.mobileguard.m1home.utils.MyUtils;
import cn.edu.gdmec.android.mobileguard.m1home.utils.VersionUpdateUtils;
import android.R;
public class SplashActivity extends AppCompatActivity {
    private TextView mTvVersion;
    private String mVersion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        mVersion = MyUtils.getVersion(getApplication());
        mTvVersion = (TextView)findViewById(R.id.accessibilityActionScrollRight);
        mTvVersion.setText("版本号:"+mVersion);
        final VersionUpdateUtils versionUpdateUtils = new VersionUpdateUtils(mVersion,SplashActivity.this);
        new Thread(){
            @Override
            public void run() {
                super.run();
                versionUpdateUtils.getCloudVersion();
            }
        }.start();
    }
}


