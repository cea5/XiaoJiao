package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Map;

import cea.xiaojiao.R;
import module.News;

/**
 * Created by Administrator on 2016/5/23 0023.
 */
public class LZJTUListAdapter extends BaseAdapter{

    private Map<Integer, News> mNewsMap;
    private Context mContext;
    private LayoutInflater mInflater;
    private TextView news_title;
    private TextView news_date;

    public LZJTUListAdapter(Context context,Map<Integer, News> newsMap) {
        this.mContext = context;
        this.mNewsMap = newsMap;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mNewsMap.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = mInflater.inflate(R.layout.news_list, null);
        news_title = (TextView) view.findViewById(R.id.news_title);
        news_date = (TextView) view.findViewById(R.id.news_date);
        news_title.setText(mNewsMap.get(i).getTitle());
        news_date.setText(mNewsMap.get(i).getDate());
        return view;
    }
}
