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
    WebView webView;
    String url = "";
    MethodChannel channel;


    @SuppressLint("SetJavaScriptEnabled")
    HcArcgisMap(Context context, BinaryMessenger messenger, int id) {
        this.context = context;
        this.messenger = messenger;
        this.id = id;
        webView = this.getWebView(context);
        channel = new MethodChannel(messenger, "hc_arcgis_map");
        channel.setMethodCallHandler(this);
    }

    @Override
    public View getView() {
        return webView;
    }

    @Override
    public void dispose() {

    }

    private WebView getWebView(Context context) {
        WebView webView = new WebView(context);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
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