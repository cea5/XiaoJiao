package cea.xiaojiao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import fragment.SchduleFragment;

/**
 * Created by Administrator on 2016/5/15 0015.
 */
public class SchduleActivity extends AppCompatActivity {

    private String TAG = "SchduleActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schdule_activity);
        getSupportActionBar().setTitle("课表");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar));
        SchduleFragment schduleFragment = SchduleFragment.instance();
        getSupportFragmentManager().beginTransaction().add(R.id.schdule_container, schduleFragment).commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}
