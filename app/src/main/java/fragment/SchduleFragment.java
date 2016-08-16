package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import cea.xiaojiao.R;

/**
 * Created by Administrator on 2016/5/14 0014.
 */
public class SchduleFragment extends Fragment{

    private static String TAG = "SchduleFragment";
    private TextView z11;
    private TextView z21;
    private TextView z31;
    private TextView z41;
    private TextView z51;
    private TextView z61;
    private TextView z71;
    private TextView z13;
    private TextView z23;
    private TextView z33;
    private TextView z43;
    private TextView z53;
    private TextView z63;
    private TextView z73;
    private TextView z15;
    private TextView z25;
    private TextView z35;
    private TextView z45;
    private TextView z55;
    private TextView z65;
    private TextView z75;
    private TextView z17;
    private TextView z27;
    private TextView z37;
    private TextView z47;
    private TextView z57;
    private TextView z67;
    private TextView z77;
    private TextView z19;
    private TextView z29;
    private TextView z39;
    private TextView z49;
    private TextView z59;
    private TextView z69;
    private TextView z79;
    private RequestQueue queue;
    private StringRequest stringRequest;

    public static SchduleFragment instance(){
        return new SchduleFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.schdule_fragment, null);
        initView(view);
        queue = Volley.newRequestQueue(getActivity());
        String url = "http://115.28.231.190/lzjtu_kb.php";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONArray jsonArray = new JSONArray(s);
                    setText(jsonArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(TAG, "onErrorResponse: " + volleyError.getCause());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("xuehao", "201304753");
                map.put("pwd", "a781128");
                return map;
            }
        };
        queue.add(stringRequest);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setText(JSONArray jsonArray) throws JSONException {
        if(jsonArray.getJSONArray(0).getJSONArray(0).getString(0).isEmpty()==false){
            z11.setText(jsonArray.getJSONArray(0).getJSONArray(0).getString(0)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(0).getString(1)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(0).getString(2)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(0).getString(3));
        }
        if(jsonArray.getJSONArray(0).getJSONArray(1).getString(0).isEmpty()==false){
            z21.setText(jsonArray.getJSONArray(0).getJSONArray(1).getString(0)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(1).getString(1)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(1).getString(2)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(1).getString(3));
        }
        if(jsonArray.getJSONArray(0).getJSONArray(2).getString(0).isEmpty()==false){
            z31.setText(jsonArray.getJSONArray(0).getJSONArray(2).getString(0)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(2).getString(1)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(2).getString(2)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(2).getString(3));
        }
        if(jsonArray.getJSONArray(0).getJSONArray(3).getString(0).isEmpty()==false){
            z41.setText(jsonArray.getJSONArray(0).getJSONArray(3).getString(0)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(3).getString(1)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(3).getString(2)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(3).getString(3));
        }
        if(jsonArray.getJSONArray(0).getJSONArray(4).getString(0).isEmpty()==false){
            z51.setText(jsonArray.getJSONArray(0).getJSONArray(4).getString(0)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(4).getString(1)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(4).getString(2)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(4).getString(3));
        }
        if(jsonArray.getJSONArray(0).getJSONArray(5).getString(0).isEmpty()==false){
            z61.setText(jsonArray.getJSONArray(0).getJSONArray(5).getString(0)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(5).getString(1)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(5).getString(2)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(5).getString(3));
        }
        if(jsonArray.getJSONArray(0).getJSONArray(6).getString(0).isEmpty()==false){
            z71.setText(jsonArray.getJSONArray(0).getJSONArray(6).getString(0)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(6).getString(1)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(6).getString(2)+'\n'
                    +jsonArray.getJSONArray(0).getJSONArray(6).getString(3));
        }
        if(jsonArray.getJSONArray(1).getJSONArray(0).getString(0).isEmpty()==false){
            z13.setText(jsonArray.getJSONArray(1).getJSONArray(0).getString(0)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(0).getString(1)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(0).getString(2)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(0).getString(3));
        }
        if(jsonArray.getJSONArray(1).getJSONArray(1).getString(0).isEmpty()==false){
            z23.setText(jsonArray.getJSONArray(1).getJSONArray(1).getString(0)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(1).getString(1)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(1).getString(2)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(1).getString(3));
        }
        if(jsonArray.getJSONArray(1).getJSONArray(2).getString(0).isEmpty()==false){
            z33.setText(jsonArray.getJSONArray(1).getJSONArray(2).getString(0)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(2).getString(1)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(2).getString(2)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(2).getString(3));
        }
        if(jsonArray.getJSONArray(1).getJSONArray(3).getString(0).isEmpty()==false){
            z43.setText(jsonArray.getJSONArray(1).getJSONArray(3).getString(0)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(3).getString(1)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(3).getString(2)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(3).getString(3));
        }
        if(jsonArray.getJSONArray(1).getJSONArray(4).getString(0).isEmpty()==false){
            z53.setText(jsonArray.getJSONArray(1).getJSONArray(4).getString(0)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(4).getString(1)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(4).getString(2)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(4).getString(3));
        }
        if(jsonArray.getJSONArray(1).getJSONArray(5).getString(0).isEmpty()==false){
            z63.setText(jsonArray.getJSONArray(1).getJSONArray(5).getString(0)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(5).getString(1)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(5).getString(2)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(5).getString(3));
        }
        if(jsonArray.getJSONArray(1).getJSONArray(6).getString(0).isEmpty()==false){
            z73.setText(jsonArray.getJSONArray(1).getJSONArray(6).getString(0)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(6).getString(1)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(6).getString(2)+'\n'
                    +jsonArray.getJSONArray(1).getJSONArray(6).getString(3));
        }
        if(jsonArray.getJSONArray(2).getJSONArray(0).getString(0).isEmpty()==false){
            z15.setText(jsonArray.getJSONArray(2).getJSONArray(0).getString(0)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(0).getString(1)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(0).getString(2)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(0).getString(3));
        }
        if(jsonArray.getJSONArray(2).getJSONArray(1).getString(0).isEmpty()==false){
            z25.setText(jsonArray.getJSONArray(2).getJSONArray(1).getString(0)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(1).getString(1)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(1).getString(2)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(1).getString(3));
        }
        if(jsonArray.getJSONArray(2).getJSONArray(2).getString(0).isEmpty()==false){
            z35.setText(jsonArray.getJSONArray(2).getJSONArray(2).getString(0)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(2).getString(1)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(2).getString(2)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(2).getString(3));
        }
        if(jsonArray.getJSONArray(2).getJSONArray(3).getString(0).isEmpty()==false){
            z45.setText(jsonArray.getJSONArray(2).getJSONArray(3).getString(0)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(3).getString(1)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(3).getString(2)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(3).getString(3));
        }
        if(jsonArray.getJSONArray(2).getJSONArray(4).getString(0).isEmpty()==false){
            z55.setText(jsonArray.getJSONArray(2).getJSONArray(4).getString(0)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(4).getString(1)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(4).getString(2)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(4).getString(3));
        }
        if(jsonArray.getJSONArray(2).getJSONArray(5).getString(0).isEmpty()==false){
            z65.setText(jsonArray.getJSONArray(2).getJSONArray(5).getString(0)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(5).getString(1)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(5).getString(2)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(5).getString(3));
        }
        if(jsonArray.getJSONArray(2).getJSONArray(6).getString(0).isEmpty()==false){
            z75.setText(jsonArray.getJSONArray(2).getJSONArray(6).getString(0)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(6).getString(1)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(6).getString(2)+'\n'
                    +jsonArray.getJSONArray(2).getJSONArray(6).getString(3));
        }
        if(jsonArray.getJSONArray(3).getJSONArray(0).getString(0).isEmpty()==false){
            z17.setText(jsonArray.getJSONArray(3).getJSONArray(0).getString(0)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(0).getString(1)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(0).getString(2)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(0).getString(3));
        }
        if(jsonArray.getJSONArray(3).getJSONArray(1).getString(0).isEmpty()==false){
            z27.setText(jsonArray.getJSONArray(3).getJSONArray(1).getString(0)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(1).getString(1)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(1).getString(2)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(1).getString(3));
        }
        if(jsonArray.getJSONArray(3).getJSONArray(2).getString(0).isEmpty()==false){
            z37.setText(jsonArray.getJSONArray(3).getJSONArray(2).getString(0)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(2).getString(1)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(2).getString(2)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(2).getString(3));
        }
        if(jsonArray.getJSONArray(3).getJSONArray(3).getString(0).isEmpty()==false){
            z47.setText(jsonArray.getJSONArray(3).getJSONArray(3).getString(0)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(3).getString(1)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(3).getString(2)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(3).getString(3));
        }
        if(jsonArray.getJSONArray(3).getJSONArray(4).getString(0).isEmpty()==false){
            z57.setText(jsonArray.getJSONArray(3).getJSONArray(4).getString(0)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(4).getString(1)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(4).getString(2)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(4).getString(3));
        }
        if(jsonArray.getJSONArray(3).getJSONArray(5).getString(0).isEmpty()==false){
            z67.setText(jsonArray.getJSONArray(3).getJSONArray(5).getString(0)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(5).getString(1)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(5).getString(2)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(5).getString(3));
        }
        if(jsonArray.getJSONArray(3).getJSONArray(6).getString(0).isEmpty()==false){
            z77.setText(jsonArray.getJSONArray(3).getJSONArray(6).getString(0)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(6).getString(1)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(6).getString(2)+'\n'
                    +jsonArray.getJSONArray(3).getJSONArray(6).getString(3));
        }
        if(jsonArray.getJSONArray(4).getJSONArray(0).getString(0).isEmpty()==false){
            z19.setText(jsonArray.getJSONArray(4).getJSONArray(0).getString(0)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(0).getString(1)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(0).getString(2)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(0).getString(3));
        }
        if(jsonArray.getJSONArray(4).getJSONArray(1).getString(0).isEmpty()==false){
            z29.setText(jsonArray.getJSONArray(4).getJSONArray(1).getString(0)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(1).getString(1)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(1).getString(2)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(1).getString(3));
        }
        if(jsonArray.getJSONArray(4).getJSONArray(2).getString(0).isEmpty()==false){
            z39.setText(jsonArray.getJSONArray(4).getJSONArray(2).getString(0)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(2).getString(1)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(2).getString(2)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(2).getString(3));
        }
        if(jsonArray.getJSONArray(4).getJSONArray(3).getString(0).isEmpty()==false){
            z49.setText(jsonArray.getJSONArray(4).getJSONArray(3).getString(0)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(3).getString(1)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(3).getString(2)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(3).getString(3));
        }
        if(jsonArray.getJSONArray(4).getJSONArray(4).getString(0).isEmpty()==false){
            z59.setText(jsonArray.getJSONArray(4).getJSONArray(4).getString(0)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(4).getString(1)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(4).getString(2)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(4).getString(3));
        }
        if(jsonArray.getJSONArray(4).getJSONArray(5).getString(0).isEmpty()==false){
            z69.setText(jsonArray.getJSONArray(4).getJSONArray(5).getString(0)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(5).getString(1)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(5).getString(2)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(5).getString(3));
        }
        if(jsonArray.getJSONArray(4).getJSONArray(6).getString(0).isEmpty()==false){
            z79.setText(jsonArray.getJSONArray(4).getJSONArray(6).getString(0)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(6).getString(1)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(6).getString(2)+'\n'
                    +jsonArray.getJSONArray(4).getJSONArray(6).getString(3));
        }

    }

    private void initView(View view) {
//        String id = "";
//        for (int i=1;i<11;i++){
//            id=i+"";
//        }
        z11 = (TextView) view.findViewById(R.id.z11);
        z21 = (TextView) view.findViewById(R.id.z21);
        z31 = (TextView) view.findViewById(R.id.z31);
        z41 = (TextView) view.findViewById(R.id.z41);
        z51 = (TextView) view.findViewById(R.id.z51);
        z61 = (TextView) view.findViewById(R.id.z61);
        z71 = (TextView) view.findViewById(R.id.z71);
        z13 = (TextView) view.findViewById(R.id.z13);
        z23 = (TextView) view.findViewById(R.id.z23);
        z33 = (TextView) view.findViewById(R.id.z33);
        z43 = (TextView) view.findViewById(R.id.z43);
        z53 = (TextView) view.findViewById(R.id.z53);
        z63 = (TextView) view.findViewById(R.id.z63);
        z73 = (TextView) view.findViewById(R.id.z73);
        z15 = (TextView) view.findViewById(R.id.z15);
        z25 = (TextView) view.findViewById(R.id.z25);
        z35 = (TextView) view.findViewById(R.id.z35);
        z45 = (TextView) view.findViewById(R.id.z45);
        z55 = (TextView) view.findViewById(R.id.z55);
        z65 = (TextView) view.findViewById(R.id.z65);
        z75 = (TextView) view.findViewById(R.id.z75);
        z17 = (TextView) view.findViewById(R.id.z17);
        z27 = (TextView) view.findViewById(R.id.z27);
        z37 = (TextView) view.findViewById(R.id.z37);
        z47 = (TextView) view.findViewById(R.id.z47);
        z57 = (TextView) view.findViewById(R.id.z57);
        z67 = (TextView) view.findViewById(R.id.z67);
        z77 = (TextView) view.findViewById(R.id.z77);
        z19 = (TextView) view.findViewById(R.id.z19);
        z29 = (TextView) view.findViewById(R.id.z29);
        z39 = (TextView) view.findViewById(R.id.z39);
        z49 = (TextView) view.findViewById(R.id.z49);
        z59 = (TextView) view.findViewById(R.id.z59);
        z69 = (TextView) view.findViewById(R.id.z69);
        z79 = (TextView) view.findViewById(R.id.z79);
    }
}
