package cea.xiaojiao;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lhh.apst.library.AdvancedPagerSlidingTabStrip;

import adapter.BootReceiver;
import fragment.FirstFragment;
import fragment.FourthFragment;
import fragment.SecondFragment;
import fragment.ThirdFragment;
import service.InformService;

public class MainActivity extends AppCompatActivity {

    private static final int VIEW_SIZE = 4;
    private AdvancedPagerSlidingTabStrip tabs;
    private ViewPager viewPager;
    private FirstFragment mFirstFragment = null;
    private SecondFragment mSecondFragment = null;
    private ThirdFragment mThirdFragment = null;
    private FourthFragment mFourthFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, InformService.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startService(intent);

        ComponentName receiver = new ComponentName(this, BootReceiver.class);
        PackageManager pm = this.getPackageManager();
        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,  //COMPONENT_ENABLED_STATE_DISABLED关闭receiver
                PackageManager.DONT_KILL_APP);

        getSupportActionBar().hide();
        tabs = (AdvancedPagerSlidingTabStrip) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(VIEW_SIZE);
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        adapter.notifyDataSetChanged();
        tabs.setViewPager(viewPager);
        tabs.setTextSize(15);
        viewPager.setCurrentItem(0);
    }

    public class FragmentAdapter extends FragmentStatePagerAdapter implements AdvancedPagerSlidingTabStrip.IconTabProvider {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0 :
                    return "小交";
                case 1 :
                    return "交流";
                case 2 :
                    return "更多";
                case 3 :
                    return "个人";
            }
            return null;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0 :
                    if(null == mFirstFragment)
                        mFirstFragment = FirstFragment.instance();
                return mFirstFragment;
                case 1 :
                    if(null == mSecondFragment)
                        mSecondFragment = SecondFragment.instance();
                    return mSecondFragment;
                case 2 :
                    if(null == mThirdFragment)
                        mThirdFragment = ThirdFragment.instance();
                    return mThirdFragment;
                case 3 :
                    if(null == mFourthFragment)
                        mFourthFragment = FourthFragment.instance();
                    return mFourthFragment;
                default:break;
            }
            return null;
        }

        @Override
        public Integer getPageIcon(int position) {
            return R.mipmap.home_mine_icon_n;
        }

        @Override
        public Integer getPageSelectIcon(int position) {
            return null;
        }

        @Override
        public Rect getPageIconBounds(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
