package com.ers.runes.utilities;

/**
 * Created by Benjamin on 2014-12-12.
 */
public class JsonRune implements RuneWrapper {

    private String name;
    private String resourceName;
    private String textureName;

    public JsonRune(String name) {
        this(name, name.toLowerCase());
    }

    public JsonRune(String name, String resourceName) {
        this(name, resourceName, resourceName);
    }

    public JsonRune(String name, String resourceName, String textureName) {
        this.name = name;
        this.resourceName = resourceName;
        this.textureName = textureName;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getResourceName() {
        return resourceName;
    }

    @Override
    public String getTextureName() {
        return textureName;
    }
}
