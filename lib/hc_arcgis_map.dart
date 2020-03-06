import 'dart:async';

import 'package:flutter/services.dart';

class HcArcgisMap {
  static const MethodChannel _channel =
      const MethodChannel('hc_arcgis_map');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
}
