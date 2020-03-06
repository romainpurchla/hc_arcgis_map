package lu.hotcity.arcgis.hc_arcgis_map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugin.platform.PlatformView;

import static io.flutter.plugin.common.MethodChannel.MethodCallHandler;


public class HcArcgisMap implements PlatformView, MethodCallHandler {

    Context context;
    BinaryMessenger messenger;
    int id;
    MapView mMapView;
    String url = "";
    MethodChannel channel;


    @SuppressLint("SetJavaScriptEnabled")
    HcArcgisMap(Context context, BinaryMessenger messenger, int id) {
        this.context = context;
        this.messenger = messenger;
        this.id = id;
        mMapView = this.setupMap();
        channel = new MethodChannel(messenger, "hc_arcgis_map");
        channel.setMethodCallHandler(this);
    }

    @Override
    public View getView() {
        return mMapView;
    }

    @Override
    public void dispose() {

    }

    private void setupMap() {
        if (mMapView != null) {
            Basemap.Type basemapType = Basemap.Type.STREETS_VECTOR;
            double latitude = 34.0270;
            double longitude = -118.8050;
            int levelOfDetail = 13;
            ArcGISMap map = new ArcGISMap(basemapType, latitude, longitude, levelOfDetail);
            mMapView.setMap(map);
        }
      }

    @Override
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        switch (call.method) {
            case "loadUrl":
                String url = call.arguments.toString();
                webView.loadUrl(url);
                break;
            default:
                String url2 = "https://www.google.com/";
                webView.loadUrl(url2);
        }

    }

}