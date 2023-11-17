package com.scanlibrary;

import androidx.core.content.FileProvider;

public class ScanFileProvider extends FileProvider {
   //extend fileprovider to stop collision with camera gps timestamp library file provider
   //this class is empty and used in manifest
    //public ScanFileProvider() {}
}
