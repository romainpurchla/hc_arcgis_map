package lu.hotcity.arcgis.hc_arcgis_map;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** HcArcgisMapPlugin */
public class HcArcgisMapPlugin implements FlutterPlugin, MethodCallHandler {
  @Override
  public void onAttachedToEngine(FlutterPluginBinding flutterPluginBinding) {
    flutterPluginBinding.getPlatformViewRegistry().registerViewFactory("hc_arcgis_map", new HcArcgisMapFactory(flutterPluginBinding.getBinaryMessenger()));
  }



  // This static function is optional and equivalent to onAttachedToEngine. It supports the old
  // pre-Flutter-1.12 Android projects. You are encouraged to continue supporting
  // plugin registration via this function while apps migrate to use the new Android APIs
  // post-flutter-1.12 via https://flutter.dev/go/android-project-migration.
  //
  // It is encouraged to share logic between onAttachedToEngine and registerWith to keep
  // them functionally equivalent. Only one of onAttachedToEngine or registerWith will be called
  // depending on the user's project. onAttachedToEngine or registerWith must both be defined
  // in the same class.
  public static void registerWith(Registrar registrar) {
    registrar.platformViewRegistry().registerViewFactory("hc_arcgis_map", new HcArcgisMapFactory(registrar.messenger()));
  }

  @Override
  public void onDetachedFromEngine(FlutterPluginBinding flutterPluginBinding) {

  }

  @Override
  public void onMethodCall(MethodCall methodCall, Result result) {

  }
}
