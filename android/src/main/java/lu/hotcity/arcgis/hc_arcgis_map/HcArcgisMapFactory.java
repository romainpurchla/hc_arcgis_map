package lu.hotcity.arcgis.hc_arcgis_map;

import android.content.Context;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class HcArcgisMapFactory extends PlatformViewFactory {

    private final BinaryMessenger mPluginBinaryMessenger;

    public HcArcgisMapFactory(BinaryMessenger messenger) {
        super(StandardMessageCodec.INSTANCE);
        mPluginBinaryMessenger = messenger;
    }

    @Override
    public PlatformView create(Context context, int i, Object o) {
        return new HcArcgisMap(context, mPluginBinaryMessenger, i);
    }

}