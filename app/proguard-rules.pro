# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#noinspection ShrinkerUnresolvedReference
-keepattributes LineNumberTable,SourceFile
-keep class com.newrelic.** { *; }
-dontwarn com.newrelic.**
-dontwarn okio.**
-dontwarn com.squareup.okhttp.**
-dontwarn retrofit.client.Client**
-dontwarn  retrofit.mime.TypedInput**
-dontwarn  com.newrelic.agent.android.instrumentation.retrofit**
-dontwarn okhttp3.**
-dontwarn retrofit2.**
-dontwarn javax.annotation.**
-dontwarn com.android.volley.toolbox.**
-dontobfuscate
-keepattributes Exceptions, Signature, InnerClasses, LineNumberTable
# Retrofit
-dontwarn retrofit2.**
-dontwarn org.codehaus.mojo.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions
-keepattributes *Annotation*

-keepattributes RuntimeVisibleAnnotations
-keepattributes RuntimeInvisibleAnnotations
-keepattributes RuntimeVisibleParameterAnnotations
-keepattributes RuntimeInvisibleParameterAnnotations

-keepattributes EnclosingMethod

-keepclasseswithmembers class * {
    @retrofit2.* <methods>;
}

-keepclasseswithmembers interface * {
  @retrofit2.* <methods>;
}



