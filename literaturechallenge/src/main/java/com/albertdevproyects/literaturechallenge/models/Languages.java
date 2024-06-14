package com.albertdevproyects.literaturechallenge.models;

public enum Languages {
    ES("es"),
    FR("fr"),
    EN("en"),
    PT("pt");

    private String languages;

    Languages(String language){
        this.languages = language;
    }
    public String getLanguage(){
        return this.languages;
    }
    public static Languages fromString(String text){
        for(Languages language : Languages.values()){
            if(language.languages.equalsIgnoreCase(text)){
                return language;
            }
        }
        throw new IllegalArgumentException("No constant with text" + text+ "found");
    }
}
