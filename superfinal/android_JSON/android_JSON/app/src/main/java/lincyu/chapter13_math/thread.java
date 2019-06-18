package lincyu.chapter13_math;
import android.app.Activity;
import android.widget.Toast;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.StringBuilder;
/**
 * Created by Edward on 2017/7/2.
 */

public class thread extends Thread{
    Activity activity;
    GoogleMap mMap;
    Bundle bundle;
    thread(Activity activity,GoogleMap mMap,Bundle bundle){
        this.activity=activity;
        this.mMap=mMap;
        this.bundle=bundle;
    }
    public void run() {

        StringBuilder url = new StringBuilder(bundle.getString("URL"));  //接收從main傳來的url

        HttpGet request = new HttpGet(url.toString());
        String result = "";
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            HttpResponse response = client.execute(request);
            int code = response.getStatusLine().getStatusCode();
            if (code == 200) {
                result = EntityUtils.toString(	response.getEntity(),"UTF-8");
                //因php檔案多加了一行檢查用的 所以要把它分離出來
                String[] testing = result.split("\\[");
                String real="[".concat(testing[1]);

                JSONArray jo = new JSONArray(real);
                int i;

                for(i=0;i<jo.length();i++){
                    JSONObject x=jo.getJSONObject(i);
                    String place=x.getString("\u7de8\u865f");
                    String xx= x.getString("latlng");
                    showHttpResult(xx,place);
                }
            } else {
                connerror();
            }
        } catch (Exception e) {
            connerror();
        }
    }

    void connerror() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, "連線失敗",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    void showHttpResult(final String x,final String place){
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String[] tokens= x.split(",");
                tokens[0]=tokens[0].replace("(","");
                tokens[1]=tokens[1].replace(")","");
                LatLng newplace = new LatLng(Double.parseDouble(tokens[0]),Double.parseDouble(tokens[1]));
                mMap.addMarker(new MarkerOptions().position(newplace).title(place));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newplace, 18));
            }
        });
    }

}
