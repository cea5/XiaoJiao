package cea.xiaojiao;

import android.app.Instrumentation;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;

import fragment.LZJTUFragment;

/**
 * Created by Administrator on 2016/5/21 0021.
 */
public class NewsActivity extends AppCompatActivity{
    private android.support.v7.app.ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);
        actionBar = getSupportActionBar();
        actionBar.setTitle("信息推送");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar));
        actionBar.setElevation(0);
        String s = "LZJTUFragment";
        getSupportFragmentManager().beginTransaction()
                .add(R.id.news_layout, LZJTUFragment.instance(), "LZJTUFragment").commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //模拟返回键
                        Instrumentation inst = new Instrumentation();
                        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                    }
                });
                thread.start();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
