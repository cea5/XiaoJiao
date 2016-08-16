package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import adapter.LZJTUListAdapter;
import cea.xiaojiao.R;
import module.News;

/**
 * Created by Administrator on 2016/5/23 0023.
 */
public class LZJTUFragment extends Fragment{

    private ListView listView;
    private TextView hint;
    private RequestQueue queue;
    private JsonArrayRequest jsonRequest;
    private LZJTUListAdapter listAdapter;
    private Map<Integer, News> newsMap = new HashMap<Integer, News>();
    private String TAG = "LZJTUFragment";
    private LZJTUFragment lzjtuFragment = this;

    public static LZJTUFragment instance() {
        return new LZJTUFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        View view = inflater.inflate(R.layout.lzjtu_fragment, null);
        listView = (ListView) view.findViewById(R.id.listView);
        listAdapter = new LZJTUListAdapter(getActivity(), newsMap);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                WebFragment webFragment = new WebFragment(getActivity(), newsMap.get(i).getLink());
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.news_layout, webFragment)
                        .addToBackStack("WebFragment").commit();
            }
        });
        hint = (TextView) view.findViewById(R.id.hint);
        String url = "http://115.28.231.190/lzjtu_news.php";
        queue = Volley.newRequestQueue(getActivity());
        jsonRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                try {
                    newsMap.clear();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        News news = new News();
                        news.setTitle(jsonArray.getJSONArray(i).get(0).toString());
                        news.setDate(jsonArray.getJSONArray(i).get(1).toString());
                        news.setLink(jsonArray.getJSONArray(i).get(2).toString());
                        newsMap.put(i, news);
                    }
                    hint.setVisibility(View.GONE);
                    listAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(TAG, "onErrorResponse: "+volleyError.getMessage());
            }
        });
        queue.add(jsonRequest);
        return view;//返回的view在之后的操作中为空？只有在onCreateView里才能操作view里的控件
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
    }
}
