package com;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
        URLClassLoader pluginClassLoader = new URLClassLoader(new URL[]{new URL("file://home/jarik/myjar.jar")});
        Class cl = pluginClassLoader.loadClass("MyClassName");


    }
}
class MyLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[]bytes= new byte[0];
        try{bytes=Files.readAllBytes(Paths.get("FileName"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class<?>cl=defineClass(name,bytes,0,bytes.length);
        return cl;
    }
}





















































