package com.scanlibrary;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by jhansi on 05/04/15.
 */
public class Utils {

    private Utils() {

    }

    public static Uri getUri(Context context, Bitmap bitmap) {
        final String FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS";
        var name = new SimpleDateFormat(FILENAME_FORMAT, Locale.US).format(System.currentTimeMillis());
        var folder = new File(context.getFilesDir(), "scan_images");
        if (!folder.exists()) {
            folder.mkdir();
        }
        final String path = folder.getPath() + "/" + name + ".jpg";

        try {
            FileOutputStream fos = new FileOutputStream(path);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.close();
            return Uri.parse(path);
        } catch (Exception e) {
            return null;
        }
       /* ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, "Title", null);*/

    }

    public static Bitmap getBitmap(Context context, Uri uri) throws IOException {
        return BitmapFactory.decodeFile(uri.getPath());
        //Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
        //return bitmap;
    }
}