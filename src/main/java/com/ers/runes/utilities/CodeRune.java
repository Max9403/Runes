package com.ers.runes.utilities;

/**
 * Created by Benjamin on 2014-12-12.
 */
public class CodeRune implements RuneWrapper {

    private String name;
    private String resourceName;
    private String textureName;

    public CodeRune(String name) {
        this(name, name.toLowerCase());
    }

    public CodeRune(String name, String resourceName) {
        this(name, resourceName, resourceName);
    }

    public CodeRune(String name, String resourceName, String textureName) {
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

    @Override
    public int getRenderColour() {
        return 0x000000;
    }
}
