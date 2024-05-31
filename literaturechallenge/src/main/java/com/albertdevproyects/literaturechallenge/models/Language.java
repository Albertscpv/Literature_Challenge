package com.albertdevproyects.literaturechallenge.models;

public enum Language {
    ES("es"),
    FR("fr"),
    EN("en"),
    PT("pt");

    private String language;

    Language(String language){
        this.language = language;
    }
    public String getLanguage(){
        return this.language;
    }
    public static Language fromString(String text){
        for(Language language : Language.values()){
            if(language.language.equalsIgnoreCase(text)){
                return language;
            }
        }
        throw new IllegalArgumentException("No constant with text" + text+ "found");
    }
}
