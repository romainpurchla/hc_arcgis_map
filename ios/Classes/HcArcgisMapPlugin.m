#import "HcArcgisMapPlugin.h"
#if __has_include(<hc_arcgis_map/hc_arcgis_map-Swift.h>)
#import <hc_arcgis_map/hc_arcgis_map-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "hc_arcgis_map-Swift.h"
#endif

@implementation HcArcgisMapPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftHcArcgisMapPlugin registerWithRegistrar:registrar];
}
@end
